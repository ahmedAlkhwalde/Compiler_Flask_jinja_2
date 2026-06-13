

package VisitorFlask;

import ASTFlask.AtomExpression.NameExpression;
import ASTFlask.SymbolTable.*;
import ASTFlask.TheMainContintOfComplexStatment.ParametarToFunction;
import antlrFlask.ProjectParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class SymbolTableBuilder extends Visitor {
    private Scope currentScope;
    private Stack<Scope> scopeStack = new Stack<>();
    private Scope globalScope;
    private Set<String> builtinFunctions = new HashSet<>();
    private Set<String> builtinConstants = new HashSet<>();
    private Map<String, List<Symbol>> symbolUsage = new HashMap<>();

    private Map<String, List<VariableSymbol>> nestedSymbols = new HashMap<>();

    private static final Set<String> COMPLEX_TYPES = new HashSet<>(Arrays.asList(
            "dict", "list", "tuple", "set", "array", "Dict", "List", "Tuple", "Set", "any"
    ));

    public SymbolTableBuilder() {
        globalScope = new Scope("global", null);
        currentScope = globalScope;
        scopeStack.push(currentScope);

        addBuiltinFunctions();
    }


    private void addBuiltinFunctions() {
        String[] builtins = {
                "len", "next", "float", "int", "str", "list", "dict",
                "tuple", "set", "bool", "type", "range", "enumerate",
                "zip", "map", "filter", "sorted", "reversed", "sum",
                "min", "max", "abs", "round", "isinstance", "issubclass",
                "hasattr", "getattr", "setattr", "delattr", "property",
                "staticmethod", "classmethod", "super", "object", "BaseException"
        };

        builtinFunctions.addAll(Arrays.asList(builtins));

        builtinConstants.add("True");
        builtinConstants.add("False");
        builtinConstants.add("None");
        builtinConstants.add("__Name__");

        VariableSymbol trueSymbol = new VariableSymbol("True", "bool", 0, globalScope, true);
        VariableSymbol falseSymbol = new VariableSymbol("False", "bool", 0, globalScope, false);
        VariableSymbol noneSymbol = new VariableSymbol("None", "NoneType", 0, globalScope, null);
        VariableSymbol nameSymbol = new VariableSymbol("__name__", "str", 0, globalScope, "__main__");

        globalScope.addSymbol(trueSymbol);
        globalScope.addSymbol(falseSymbol);
        globalScope.addSymbol(noneSymbol);
        globalScope.addSymbol(nameSymbol);
    }


    private void exitScope() {
        scopeStack.pop();
        if (!scopeStack.isEmpty()) {
            currentScope = scopeStack.peek();
        } else {
            currentScope = globalScope;
        }
    }

    private void enterScope(String name) {
        Scope newScope = new Scope(name, currentScope);
        currentScope = newScope;
        scopeStack.push(newScope);
    }

    private void addSymbolToProperScope(Symbol symbol) {
        boolean isGlobal = false;

        if (currentScope == globalScope || currentScope.name.equals("program")) {
            isGlobal = true;
        }

        if (symbol instanceof FunctionSymbol && isDecoratedFunction()) {
            isGlobal = true;
        }

        Scope targetScope = isGlobal ? globalScope : currentScope;

        Symbol existing = targetScope.lookupCurrent(symbol.name);
        if (existing == null) {
            targetScope.addSymbol(symbol);
            String scopeType = targetScope == globalScope ? "global" : "local";
            recordSymbolUsage(symbol);

            if (symbol instanceof VariableSymbol) {
                VariableSymbol var = (VariableSymbol) symbol;
                if (COMPLEX_TYPES.contains(var.type)) {
                }
            }
        }
    }

    private boolean isDecoratedFunction() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i).name.contains("decorated")) {
                return true;
            }
        }
        return false;
    }

    private void recordSymbolUsage(Symbol symbol) {
        symbolUsage.computeIfAbsent(symbol.name, k -> new ArrayList<>()).add(symbol);
    }


    @Override
    public Object visitSuite(ProjectParser.SuiteContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override
    public Object visitProgeRoot(ProjectParser.ProgeRootContext ctx) {
        enterScope("program");
        visitChildren(ctx);
        exitScope();
        return null;
    }

    @Override
    public Object visitFuncdef(ProjectParser.FuncdefContext ctx) {
        String funcName = ctx.NAME().getText();
        int line = ctx.getStart().getLine();

        FunctionSymbol funcSymbol = new FunctionSymbol(funcName, "unknown", line, currentScope);
        addSymbolToProperScope(funcSymbol);

        enterScope("function:" + funcName);
        funcSymbol.functionScope = currentScope;

        if (ctx.parameters() != null) {
            Object params = visit(ctx.parameters());
            if (params instanceof List<?>) {
                for (Object param : (List<?>) params) {
                    if (param instanceof ParametarToFunction) {
                        ParametarToFunction p = (ParametarToFunction) param;
                        VariableSymbol paramSymbol = new VariableSymbol(
                                p.name,
                                p.type != null ? p.type.toString() : "any",
                                line,
                                currentScope
                        );
                        addSymbolToProperScope(paramSymbol);
                        funcSymbol.addParameter(paramSymbol);
                    }
                }
            }
        }

        if (ctx.suite() != null) {
            visit(ctx.suite());
        }

        exitScope();
        return null;
    }

    @Override
    public Object visitClassdef(ProjectParser.ClassdefContext ctx) {
        String className = ctx.NAME().getText();
        int line = ctx.getStart().getLine();

        ClassSymbol classSymbol = new ClassSymbol(className, line, currentScope);
        addSymbolToProperScope(classSymbol);

        enterScope("Class:" + className);

        if (ctx.suite() != null) {
            visit(ctx.suite());
        }

        exitScope();
        return null;
    }

    @Override
    public Object visitExprStmt(ProjectParser.ExprStmtContext ctx) {
        int line = ctx.getStart().getLine();

        String exprText = ctx.getText();
        extractVariableAndNestedFieldsFromText(exprText, line);

        Object result = super.visitExprStmt(ctx);

        detectAndProcessAssignmentsFromAST(ctx);

        return result;
    }


    private void extractVariableAndNestedFieldsFromText(String exprText, int line) {
        if (exprText.contains("=")) {
            String[] parts = exprText.split("=", 2);
            if (parts.length >= 2) {
                String leftSide = parts[0].trim();
                String rightSide = parts[1].trim();

                String varName = extractMainVariableName(leftSide);

                if (varName != null && !varName.isEmpty()) {
                    addVariableFromText(varName, line);

                    analyzeRightSideForNestedStructures(varName, rightSide, line);
                }
            }
        }
    }

    private String extractMainVariableName(String leftSide) {
        leftSide = leftSide.replace("[", "").replace("]", "").trim();

        if (leftSide.contains(",")) {
            String[] vars = leftSide.split(",");
            if (vars.length > 0) {
                return vars[0].trim();
            }
        }

        return leftSide.trim();
    }

    private void analyzeRightSideForNestedStructures(String parentVar, String rightSide, int line) {
        if (rightSide.startsWith("[") && rightSide.contains("{")) {
            extractDictFieldsFromList(parentVar, rightSide, line);
        }
        else if (rightSide.startsWith("{")) {
            extractFieldsFromDict(parentVar, rightSide, line);
        }
        else if (rightSide.startsWith("[") && !rightSide.contains("{")) {

        }
    }
    private void extractFieldsFromDict(String parentVar, String dictText, int line) {
        Set<String> fields = extractFieldsFromDictText(parentVar, dictText, line);
        if (!fields.isEmpty()) {
        }
    }
    private void extractDictFieldsFromList(String parentVar, String listText, int line) {
        try {
            int start = listText.indexOf("{");
            Set<String> uniqueFields = new HashSet<>();

            while (start != -1) {
                int end = findMatchingBrace(listText, start);
                if (end != -1) {
                    String dictText = listText.substring(start, end + 1);
                    Set<String> fields = extractFieldsFromDictText(parentVar, dictText, line);
                    uniqueFields.addAll(fields);
                    start = listText.indexOf("{", end + 1);
                } else {
                    break;
                }
            }

            if (!uniqueFields.isEmpty()) {
            }
        } catch (Exception e) {
        }
    }

    private int findMatchingBrace(String text, int start) {
        int depth = 0;
        for (int i = start; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '{') depth++;
            if (c == '}') {
                depth--;
                if (depth == 0) return i;
            }
        }
        return -1;
    }

    private Set<String> extractFieldsFromDictText(String parentVar, String dictText, int line) {
        Set<String> fields = new HashSet<>();

        try {
            dictText = dictText.substring(1, dictText.length() - 1);

            String[] pairs = splitDictPairs(dictText);

            for (String pair : pairs) {
                if (pair.contains(":")) {
                    String[] keyValue = pair.split(":", 2);
                    if (keyValue.length >= 1) {
                        String key = keyValue[0].trim();

                        key = removeQuotes(key);

                        if (!key.isEmpty()) {
                            addNestedSymbol(parentVar, key, "dict_field", line);
                            fields.add(key);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }

        return fields;
    }

    private String[] splitDictPairs(String dictText) {
        List<String> pairs = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int braceDepth = 0;

        for (char c : dictText.toCharArray()) {
            if (c == '{') braceDepth++;
            if (c == '}') braceDepth--;

            if (c == ',' && braceDepth == 0) {
                if (current.length() > 0) {
                    pairs.add(current.toString());
                    current = new StringBuilder();
                }
            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            pairs.add(current.toString());
        }

        return pairs.toArray(new String[0]);
    }

    private String removeQuotes(String str) {
        if ((str.startsWith("\"") && str.endsWith("\"")) ||
                (str.startsWith("'") && str.endsWith("'"))) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    private void addNestedSymbol(String parentName, String fieldName, String type, int line) {
        String fullName = parentName + "." + fieldName;

        List<VariableSymbol> existing = nestedSymbols.get(parentName);
        if (existing != null) {
            for (VariableSymbol sym : existing) {
                if (sym.name.equals(fullName)) {
                    return;
                }
            }
        }

        VariableSymbol nestedSymbol = new VariableSymbol(
                fullName,
                type,
                line,
                currentScope
        );

        nestedSymbols.computeIfAbsent(parentName, k -> new ArrayList<>())
                .add(nestedSymbol);

    }


    private void detectAndProcessAssignmentsFromAST(ProjectParser.ExprStmtContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.EQ() != null && ctx.testlist_star_expr() != null && ctx.testlist_star_expr().size() >= 2) {
            try {
                Object target = super.visit(ctx.testlist_star_expr(0));
                if (target instanceof NameExpression) {
                    String varName = ((NameExpression) target).name;
                    addVariable(varName, line);
                }
            } catch (Exception e) {
                String varName = extractVariableNameFromContext(ctx);
                if (varName != null) {
                    addVariable(varName, line);
                }
            }
        }
    }

    private String extractVariableNameFromContext(ProjectParser.ExprStmtContext ctx) {
        try {
            if (ctx.testlist_star_expr() != null && !ctx.testlist_star_expr().isEmpty()) {
                ProjectParser.Testlist_star_exprContext targetCtx = ctx.testlist_star_expr(0);
                String text = targetCtx.getText();
                return extractMainVariableName(text);
            }
        } catch (Exception e) {
        }
        return null;
    }

    private void addVariableFromText(String varName, int line) {
        if (builtinFunctions.contains(varName) || builtinConstants.contains(varName)) {
            return;
        }

        Symbol existing = currentScope.lookupCurrent(varName);
        if (existing == null) {
            VariableSymbol varSymbol = new VariableSymbol(varName, "any", line, currentScope);
            addSymbolToProperScope(varSymbol);
        }
    }

    private void addVariable(String varName, int line) {
        addVariableFromText(varName, line);
    }

    @Override
    public Object visitFor_stmt(ProjectParser.For_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.exprlist() != null) {
            Object exprlistResult = super.visit(ctx.exprlist());

            String scopeName = "for_loop_" + line;
            if (exprlistResult instanceof NameExpression) {
                String varName = ((NameExpression) exprlistResult).name;
                scopeName = "for_loop_" + varName + "_" + line;

                enterScope(scopeName);
                VariableSymbol loopVar = new VariableSymbol(varName, "iteration", line, currentScope);
                addSymbolToProperScope(loopVar);
            } else if (exprlistResult instanceof List<?>) {
                List<?> items = (List<?>) exprlistResult;
                for (Object item : items) {
                    if (item instanceof NameExpression) {
                        String varName = ((NameExpression) item).name;
                        scopeName = "for_loop_" + varName + "_" + line;

                        enterScope(scopeName);
                        VariableSymbol loopVar = new VariableSymbol(varName, "iteration", line, currentScope);
                        addSymbolToProperScope(loopVar);
                        break;
                    }
                }
            } else {
                enterScope(scopeName);
            }
        } else {
            enterScope("for_loop_" + line);
        }

        if (ctx.suite() != null) {
            visit(ctx.suite(0));
        }

        exitScope();

        if (ctx.ELSE() != null && ctx.suite().size() > 1) {
            enterScope("for_else_" + line);
            visit(ctx.suite(1));
            exitScope();
        }
        return null;
    }

    @Override
    public Object visitAtomName(ProjectParser.AtomNameContext ctx) {
        String name = ctx.getText();
        int line = ctx.getStart().getLine();

        if (builtinFunctions.contains(name) || builtinConstants.contains(name)) {
            return new NameExpression(name, line);
        }

        Symbol symbol = currentScope.lookup(name);

        if (symbol == null) {
            boolean isImported = false;
            for (Symbol s : globalScope.symbols.values()) {
                if (s instanceof VariableSymbol) {
                    VariableSymbol var = (VariableSymbol) s;
                    if ((var.type.equals("Module") || var.type.equals("Imported")) &&
                            var.name.equals(name)) {
                        isImported = true;
                        break;
                    }
                }
            }

            if (!isImported) {
            }
        } else {
            recordSymbolUsage(symbol);
        }

        return new NameExpression(name, line);
    }

    @Override
    public Object visitImport_stmt(ProjectParser.Import_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        if (ctx.dotted_as_names() != null) {
            for (ProjectParser.Dotted_as_nameContext nctx : ctx.dotted_as_names().dotted_as_name()) {
                String moduleName = nctx.dotted_name().getText();
                String alias = (nctx.AS() != null) ? nctx.NAME().getText() : null;

                VariableSymbol moduleSymbol = new VariableSymbol(
                        alias != null ? alias : moduleName,
                        "Module",
                        line,
                        globalScope
                );
                globalScope.addSymbol(moduleSymbol);
                recordSymbolUsage(moduleSymbol);
            }
        }

        if (ctx.FROM() != null) {
            String moduleName = ctx.dotted_name().getText();

            if (ctx.STAR() != null) {
                VariableSymbol starSymbol = new VariableSymbol("*", "star_import", line, globalScope);
                globalScope.addSymbol(starSymbol);
                recordSymbolUsage(starSymbol);
            } else if (ctx.import_as_names() != null) {
                for (ProjectParser.Import_as_nameContext ictx : ctx.import_as_names().import_as_name()) {
                    String itemName = ictx.NAME(0).getText();
                    String alias = (ictx.AS() != null) ? ictx.NAME(1).getText() : null;

                    VariableSymbol importSymbol = new VariableSymbol(
                            alias != null ? alias : itemName,
                            "imported",
                            line,
                            globalScope
                    );
                    globalScope.addSymbol(importSymbol);
                    recordSymbolUsage(importSymbol);
                }
            }
        }

        return super.visitImport_stmt(ctx);
    }

    @Override
    public Object visitGlobal_stmt(ProjectParser.Global_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        for (TerminalNode nameNode : ctx.NAME()) {
            String name = nameNode.getText();

            Symbol existing = currentScope.lookupCurrent(name);
            if (existing instanceof VariableSymbol) {
                ((VariableSymbol) existing).scope = globalScope;
                currentScope.symbols.remove(name);
                globalScope.addSymbol(existing);
            } else {
                VariableSymbol globalVar = new VariableSymbol(name, "any", line, globalScope);
                globalScope.addSymbol(globalVar);
                recordSymbolUsage(globalVar);
            }
        }

        return super.visitGlobal_stmt(ctx);
    }

    @Override
    public Object visitExprlist(ProjectParser.ExprlistContext ctx) {
        List<Object> results = new ArrayList<>();

        for (ProjectParser.TestContext testCtx : ctx.test()) {
            Object result = visit(testCtx);
            results.add(result);
        }

        if (results.size() == 1) {
            return results.get(0);
        }
        return results;
    }

    @Override
    public Object visitTestlist_star_expr(ProjectParser.Testlist_star_exprContext ctx) {
        List<Object> results = new ArrayList<>();

        for (ProjectParser.TestContext testCtx : ctx.test()) {
            Object result = visit(testCtx);
            results.add(result);
        }

        if (results.size() == 1) {
            return results.get(0);
        }
        return results;
    }

    @Override
    public Object visitTest(ProjectParser.TestContext ctx) {
        if (ctx.or_test() != null) {
            return visit(ctx.or_test(0));
        }
        return null;
    }

    @Override
    public Object visitDecorated(ProjectParser.DecoratedContext ctx) {
        enterScope("decorated_" + ctx.getStart().getLine());

        for (ProjectParser.DecoratorContext decCtx : ctx.decorator()) {
            visit(decCtx);
        }

        if (ctx.funcdef() != null) {
            visit(ctx.funcdef());
        } else if (ctx.classdef() != null) {
            visit(ctx.classdef());
        }

        exitScope();
        return null;
    }

    @Override
    public Object visitFuncDefStmt(ProjectParser.FuncDefStmtContext ctx) {
        return visit(ctx.funcdef());
    }

    @Override
    public Object visitClassDefinition(ProjectParser.ClassDefinitionContext ctx) {
        return visit(ctx.classdef());
    }

    @Override
    public Object visitImportStatement(ProjectParser.ImportStatementContext ctx) {
        return visit(ctx.import_stmt());
    }

    @Override
    public Object visitGlobalStatement(ProjectParser.GlobalStatementContext ctx) {
        return visit(ctx.global_stmt());
    }

    @Override
    public Object visitWhile_stmt(ProjectParser.While_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        enterScope("while_loop_" + line);

        if (ctx.test() != null) {
            visit(ctx.test());
        }

        if (ctx.suite() != null) {
            visit(ctx.suite(0));
        }

        exitScope();

        if (ctx.ELSE() != null && ctx.suite().size() > 1) {
            enterScope("while_else_" + line);
            visit(ctx.suite(1));
            exitScope();
        }
        return null;
    }

    @Override
    public Object visitIf_stmt(ProjectParser.If_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        enterScope("if_" + line);

        if (ctx.test(0) != null) {
            visit(ctx.test(0));
        }

        if (ctx.suite(0) != null) {
            visit(ctx.suite(0));
        }

        exitScope();

        for (int i = 0; i < ctx.ELIF().size(); i++) {
            enterScope("elif_" + line + "_" + i);

            if (i + 1 < ctx.test().size()) {
                visit(ctx.test(i + 1));
            }

            if (i + 1 < ctx.suite().size()) {
                visit(ctx.suite(i + 1));
            }

            exitScope();
        }

        if (ctx.ELSE() != null) {
            enterScope("else_" + line);

            int elseSuiteIndex = ctx.suite().size() - 1;
            if (elseSuiteIndex >= 0) {
                visit(ctx.suite(elseSuiteIndex));
            }

            exitScope();
        }
        return null;
    }

    @Override
    public Object visitWith_stmt(ProjectParser.With_stmtContext ctx) {
        int line = ctx.getStart().getLine();

        enterScope("with_" + line);

        for (ProjectParser.With_itemContext itemCtx : ctx.with_item()) {
            visit(itemCtx);

            if (itemCtx.test().size() > 1) {
                Object varObj = super.visit(itemCtx.test(1));
                if (varObj instanceof NameExpression) {
                    String varName = ((NameExpression) varObj).name;
                    VariableSymbol withVar = new VariableSymbol(varName, "context", line, currentScope);
                    addSymbolToProperScope(withVar);
                }
            }
        }

        if (ctx.suite() != null) {
            visit(ctx.suite());
        }

        exitScope();
        return null;
    }


    public List<VariableSymbol> getNestedSymbols(String parentName) {
        return nestedSymbols.getOrDefault(parentName, new ArrayList<>());
    }

    public Map<String, List<VariableSymbol>> getAllNestedSymbols() {
        return nestedSymbols;
    }

    public void printNestedSymbols() {
        System.out.println("\n=== NESTED SYMBOLS ANALYSIS ===");
        System.out.println("=".repeat(60));

        if (nestedSymbols.isEmpty()) {
            System.out.println("No nested symbols found.");
            return;
        }

        for (Map.Entry<String, List<VariableSymbol>> entry : nestedSymbols.entrySet()) {
            System.out.println("Variable: " + entry.getKey());
            System.out.println("Nested Fields:");

            Set<String> uniqueFields = new HashSet<>();
            for (VariableSymbol nested : entry.getValue()) {
                String fullName = nested.name;
                String fieldName = fullName.substring(fullName.indexOf(".") + 1);
                uniqueFields.add(fieldName);
            }

            for (String field : uniqueFields) {
                System.out.println("  • " + field);
            }

            System.out.println("  Total unique fields: " + uniqueFields.size());
            System.out.println();
        }
    }


    public Symbol advancedLookup(String name, LookupOptions options) {
        Scope startingScope = options.startFromCurrent ? currentScope : globalScope;
        boolean recursive = options.recursive;
        String typeFilter = options.typeFilter;
        boolean caseSensitive = options.caseSensitive;

        String searchName = caseSensitive ? name : name.toLowerCase();

        if (recursive) {
            Set<Scope> visitedScopes = new HashSet<>();
            return lookupRecursive(startingScope, searchName, typeFilter, caseSensitive, visitedScopes);
        } else {
            return lookupInCurrentScopeOnly(startingScope, searchName, typeFilter, caseSensitive);
        }
    }

    private Symbol lookupRecursive(Scope scope, String name, String typeFilter, boolean caseSensitive, Set<Scope> visitedScopes) {
        if (scope == null || visitedScopes.contains(scope)) {
            return null;
        }

        visitedScopes.add(scope);

        for (Symbol symbol : scope.symbols.values()) {
            String symbolName = caseSensitive ? symbol.name : symbol.name.toLowerCase();
            if (symbolName.equals(name)) {
                if (typeFilter == null || symbol.type.equals(typeFilter)) {
                    return symbol;
                }
            }

            if (symbol instanceof VariableSymbol) {
                VariableSymbol var = (VariableSymbol) symbol;
                List<VariableSymbol> nested = getNestedSymbols(var.name);
                for (VariableSymbol nestedSym : nested) {
                    String nestedName = caseSensitive ? nestedSym.name : nestedSym.name.toLowerCase();
                    if (nestedName.equals(name)) {
                        if (typeFilter == null || nestedSym.type.equals(typeFilter)) {
                            return nestedSym;
                        }
                    }
                }
            }
        }

        if (scope.parent != null) {
            return lookupRecursive(scope.parent, name, typeFilter, caseSensitive, visitedScopes);
        }
        return null;
    }

    private Symbol lookupInCurrentScopeOnly(Scope scope, String name, String typeFilter, boolean caseSensitive) {
        for (Symbol symbol : scope.symbols.values()) {
            String symbolName = caseSensitive ? symbol.name : symbol.name.toLowerCase();
            if (symbolName.equals(name)) {
                if (typeFilter == null || symbol.type.equals(typeFilter)) {
                    return symbol;
                }
            }
        }
        return null;
    }

    public List<Symbol> findAllSymbolsByType(String type) {
        List<Symbol> result = new ArrayList<>();
        Set<Scope> visitedScopes = new HashSet<>();
        findAllSymbolsByTypeRecursive(globalScope, type, result, visitedScopes);
        return result;
    }

    private void findAllSymbolsByTypeRecursive(Scope scope, String type, List<Symbol> result, Set<Scope> visitedScopes) {
        if (scope == null || visitedScopes.contains(scope)) {
            return;
        }

        visitedScopes.add(scope);

        for (Symbol symbol : scope.symbols.values()) {
            if (symbol.type.equals(type)) {
                result.add(symbol);
            }

            if (symbol instanceof FunctionSymbol) {
                FunctionSymbol func = (FunctionSymbol) symbol;
                if (func.functionScope != null) {
                    findAllSymbolsByTypeRecursive(func.functionScope, type, result, visitedScopes);
                }
            } else if (symbol instanceof ClassSymbol) {
                ClassSymbol cls = (ClassSymbol) symbol;
                for (Scope s : scopeStack) {
                    if (s.name.equals("class:" + cls.name) && !visitedScopes.contains(s)) {
                        findAllSymbolsByTypeRecursive(s, type, result, visitedScopes);
                        break;
                    }
                }
            }
        }
    }

    public List<Symbol> searchSymbolsByNamePattern(String pattern) {
        List<Symbol> result = new ArrayList<>();
        Set<Scope> visitedScopes = new HashSet<>();
        searchSymbolsByNamePatternRecursive(globalScope, pattern, result, visitedScopes);
        return result;
    }

    private void searchSymbolsByNamePatternRecursive(Scope scope, String pattern, List<Symbol> result, Set<Scope> visitedScopes) {
        if (scope == null || visitedScopes.contains(scope)) {
            return;
        }

        visitedScopes.add(scope);

        for (Symbol symbol : scope.symbols.values()) {
            if (symbol.name.contains(pattern) || symbol.name.matches(".*" + pattern + ".*")) {
                result.add(symbol);
            }

            List<VariableSymbol> nested = getNestedSymbols(symbol.name);
            for (VariableSymbol nestedSym : nested) {
                if (nestedSym.name.contains(pattern)) {
                    result.add(nestedSym);
                }
            }

            if (symbol instanceof FunctionSymbol) {
                FunctionSymbol func = (FunctionSymbol) symbol;
                if (func.functionScope != null) {
                    searchSymbolsByNamePatternRecursive(func.functionScope, pattern, result, visitedScopes);
                }
            } else if (symbol instanceof ClassSymbol) {
                ClassSymbol cls = (ClassSymbol) symbol;
                for (Scope s : scopeStack) {
                    if (s.name.equals("class:" + cls.name) && !visitedScopes.contains(s)) {
                        searchSymbolsByNamePatternRecursive(s, pattern, result, visitedScopes);
                        break;
                    }
                }
            }
        }
    }

    public SymbolLookupResult lookupWithScope(String name) {
        Set<Scope> visitedScopes = new HashSet<>();
        return lookupWithScopeRecursive(globalScope, name, visitedScopes);
    }

    private SymbolLookupResult lookupWithScopeRecursive(Scope scope, String name, Set<Scope> visitedScopes) {
        if (scope == null || visitedScopes.contains(scope)) {
            return null;
        }

        visitedScopes.add(scope);

        Symbol symbol = scope.lookupCurrent(name);
        if (symbol != null) {
            return new SymbolLookupResult(symbol, scope);
        }

        for (Symbol s : scope.symbols.values()) {
            if (s instanceof VariableSymbol) {
                List<VariableSymbol> nested = getNestedSymbols(s.name);
                for (VariableSymbol nestedSym : nested) {
                    if (nestedSym.name.equals(name)) {
                        return new SymbolLookupResult(nestedSym, scope);
                    }
                }
            }
        }

        for (Symbol s : scope.symbols.values()) {
            if (s instanceof FunctionSymbol) {
                FunctionSymbol func = (FunctionSymbol) s;
                if (func.functionScope != null && !visitedScopes.contains(func.functionScope)) {
                    SymbolLookupResult result = lookupWithScopeRecursive(func.functionScope, name, visitedScopes);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }

        if (scope.parent != null && !visitedScopes.contains(scope.parent)) {
            return lookupWithScopeRecursive(scope.parent, name, visitedScopes);
        }

        return null;
    }

    public boolean addSymbol(Symbol symbol) {
        if (symbol == null || symbol.name == null || symbol.name.isEmpty()) {
            return false;
        }

        Symbol existing = currentScope.lookupCurrent(symbol.name);
        if (existing != null) {
            return false;
        }

        Scope targetScope = determineTargetScope(symbol);

        boolean success = targetScope.addSymbol(symbol);
        if (success) {
            recordSymbolUsage(symbol);
        }

        return success;
    }


    public boolean updateSymbol(String name, Symbol newSymbol) {
        SymbolLookupResult lookupResult = lookupWithScope(name);
        if (lookupResult == null) {
            return false;
        }

        lookupResult.scope.removeSymbol(name);

        boolean success = lookupResult.scope.addSymbol(newSymbol);
        if (success) {
            recordSymbolUsage(newSymbol);
        }

        return success;
    }

    public boolean deleteSymbol(String name) {
        SymbolLookupResult lookupResult = lookupWithScope(name);
        if (lookupResult == null) {
            return false;
        }

        boolean success = lookupResult.scope.removeSymbol(name);
        if (success) {
            symbolUsage.remove(name);

            nestedSymbols.remove(name);
        }

        return success;
    }


    public int deleteAllSymbolsByType(String type) {
        List<Symbol> symbolsToDelete = findAllSymbolsByType(type);
        int deletedCount = 0;

        for (Symbol symbol : symbolsToDelete) {
            SymbolLookupResult lookupResult = lookupWithScope(symbol.name);
            if (lookupResult != null) {
                if (lookupResult.scope.removeSymbol(symbol.name)) {
                    deletedCount++;
                    symbolUsage.remove(symbol.name);
                    nestedSymbols.remove(symbol.name);
                }
            }
        }

        return deletedCount;
    }

    public boolean deleteSymbolFromScope(String name, String scopeName) {
        Scope targetScope = findScopeByName(scopeName);
        if (targetScope == null) {
            return false;
        }

        boolean success = targetScope.removeSymbol(name);
        if (success) {
            symbolUsage.remove(name);
            nestedSymbols.remove(name);
        } else {
        }

        return success;
    }

    public boolean renameSymbol(String oldName, String newName) {
        SymbolLookupResult lookupResult = lookupWithScope(oldName);
        if (lookupResult == null) {

            return false;
        }

        Symbol existingNewName = lookupResult.scope.lookupCurrent(newName);
        if (existingNewName != null) {

            return false;
        }

        Symbol symbol = lookupResult.symbol;
        lookupResult.scope.removeSymbol(oldName);
        symbol.name = newName;
        lookupResult.scope.addSymbol(symbol);

        List<Symbol> usageList = symbolUsage.remove(oldName);
        if (usageList != null) {
            symbolUsage.put(newName, usageList);
        }

        List<VariableSymbol> nested = nestedSymbols.remove(oldName);
        if (nested != null) {
            List<VariableSymbol> updatedNested = new ArrayList<>();
            for (VariableSymbol var : nested) {
                String newNestedName = var.name.replaceFirst(oldName, newName);
                var.name = newNestedName;
                updatedNested.add(var);
            }
            nestedSymbols.put(newName, updatedNested);
        }

        return true;
    }

    public SymbolStatistics getStatistics() {
        SymbolStatistics stats = new SymbolStatistics();
        Set<Scope> visitedScopes = new HashSet<>();
        collectStatistics(globalScope, stats, visitedScopes);
        return stats;
    }

    private void collectStatistics(Scope scope, SymbolStatistics stats, Set<Scope> visitedScopes) {
        if (scope == null || visitedScopes.contains(scope)) {
            return;
        }

        visitedScopes.add(scope);

        for (Symbol symbol : scope.symbols.values()) {
            stats.totalSymbols++;

            if (symbol instanceof VariableSymbol) {
                VariableSymbol var = (VariableSymbol) symbol;
                if (var.type.equals("module") || var.type.equals("imported") || var.type.equals("star_import")) {
                    stats.imports++;
                } else {
                    stats.variables++;

                    List<VariableSymbol> nested = getNestedSymbols(var.name);
                    stats.totalAttributes += nested.size();
                }
            } else if (symbol instanceof FunctionSymbol) {
                stats.functions++;
                FunctionSymbol func = (FunctionSymbol) symbol;
                stats.totalParameters += func.parameters.size();

                if (func.functionScope != null) {
                    collectStatistics(func.functionScope, stats, visitedScopes);
                }
            } else if (symbol instanceof ClassSymbol) {
                stats.classes++;
                ClassSymbol cls = (ClassSymbol) symbol;
                stats.totalMethods += cls.methods.size();
                stats.totalAttributes += cls.attributes.size();

                for (Scope s : scopeStack) {
                    if (s.name.equals("class:" + cls.name) && !visitedScopes.contains(s)) {
                        collectStatistics(s, stats, visitedScopes);
                        break;
                    }
                }
            }
        }
    }

    public List<Symbol> getUnusedSymbols() {
        List<Symbol> unused = new ArrayList<>();

        Set<Scope> visitedScopes = new HashSet<>();
        List<Symbol> allSymbols = getAllSymbolsRecursive(globalScope, visitedScopes);

        for (Symbol symbol : allSymbols) {
            List<Symbol> usage = symbolUsage.get(symbol.name);
            if (usage == null || usage.size() <= 1) {
                unused.add(symbol);
            }
        }

        return unused;
    }

    private List<Symbol> getAllSymbolsRecursive(Scope scope, Set<Scope> visitedScopes) {
        List<Symbol> symbols = new ArrayList<>();

        if (scope == null || visitedScopes.contains(scope)) {
            return symbols;
        }

        visitedScopes.add(scope);
        symbols.addAll(scope.symbols.values());

        for (Symbol symbol : scope.symbols.values()) {
            if (symbol instanceof VariableSymbol) {
                List<VariableSymbol> nested = getNestedSymbols(symbol.name);
                symbols.addAll(nested);
            }

            if (symbol instanceof FunctionSymbol) {
                FunctionSymbol func = (FunctionSymbol) symbol;
                if (func.functionScope != null) {
                    symbols.addAll(getAllSymbolsRecursive(func.functionScope, visitedScopes));
                }
            } else if (symbol instanceof ClassSymbol) {
                for (Scope s : scopeStack) {
                    if (s.name.equals("class:" + symbol.name) && !visitedScopes.contains(s)) {
                        symbols.addAll(getAllSymbolsRecursive(s, visitedScopes));
                        break;
                    }
                }
            }
        }

        return symbols;
    }

    public String exportSymbolTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SYMBOL TABLE EXPORT ===\n\n");
        Set<Scope> visitedScopes = new HashSet<>();
        exportScope(globalScope, sb, 0, visitedScopes);

        if (!nestedSymbols.isEmpty()) {
            sb.append("\n=== NESTED SYMBOLS ===\n\n");
            for (Map.Entry<String, List<VariableSymbol>> entry : nestedSymbols.entrySet()) {
                sb.append("Parent: ").append(entry.getKey()).append("\n");
                Set<String> uniqueFields = new HashSet<>();
                for (VariableSymbol nested : entry.getValue()) {
                    String fullName = nested.name;
                    String fieldName = fullName.substring(fullName.indexOf(".") + 1);
                    uniqueFields.add(fieldName);
                }
                for (String field : uniqueFields) {
                    sb.append("  • ").append(field).append("\n");
                }
                sb.append("  Total: ").append(uniqueFields.size()).append(" unique fields\n\n");
            }
        }

        return sb.toString();
    }

    private void exportScope(Scope scope, StringBuilder sb, int depth, Set<Scope> visitedScopes) {
        if (scope == null || visitedScopes.contains(scope)) {
            return;
        }

        visitedScopes.add(scope);

        String indent = "  ".repeat(depth);
        sb.append(indent).append("[").append(scope.name.toUpperCase()).append("]\n");

        if (scope.symbols.isEmpty()) {
            sb.append(indent).append("  (No Symbols)\n");
        } else {
            for (Symbol symbol : scope.symbols.values()) {
                sb.append(indent).append("  • ").append(symbol.toString()).append("\n");

                if (symbol instanceof VariableSymbol) {
                    VariableSymbol var = (VariableSymbol) symbol;
                    List<VariableSymbol> nested = getNestedSymbols(var.name);
                    if (!nested.isEmpty()) {
                        Set<String> uniqueFields = new HashSet<>();
                        for (VariableSymbol nestedSym : nested) {
                            String fullName = nestedSym.name;
                            String fieldName = fullName.substring(fullName.indexOf(".") + 1);
                            uniqueFields.add(fieldName);
                        }
                        if (!uniqueFields.isEmpty()) {
                            sb.append(indent).append("    └─ Fields: ").append(uniqueFields).append("\n");
                        }
                    }
                }
            }
        }

        sb.append("\n");

        for (Symbol symbol : scope.symbols.values()) {
            if (symbol instanceof FunctionSymbol) {
                FunctionSymbol func = (FunctionSymbol) symbol;
                if (func.functionScope != null) {
                    exportScope(func.functionScope, sb, depth + 1, visitedScopes);
                }
            } else if (symbol instanceof ClassSymbol) {
                for (Scope s : scopeStack) {
                    if (s.name.equals("class:" + symbol.name) && !visitedScopes.contains(s)) {
                        exportScope(s, sb, depth + 1, visitedScopes);
                        break;
                    }
                }
            }
        }
    }


    private Scope determineTargetScope(Symbol symbol) {
        if (symbol instanceof FunctionSymbol || symbol instanceof ClassSymbol) {
            return globalScope;
        }

        if (currentScope == globalScope || currentScope.name.equals("Program")) {
            return globalScope;
        }

        return currentScope;
    }



    public void printSymbolTable() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SYMBOL TABLE");
        System.out.println("=".repeat(60));

        Set<Scope> visitedScopes = new HashSet<>();
        printScopeHierarchy(globalScope, 0, visitedScopes);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("SUMMARY");
        System.out.println("=".repeat(60));
        printSummary();

        printNestedSymbols();
    }


    private Scope findScopeByName(String scopeName) {
        if (scopeName.equals("global")) {
            return globalScope;
        }

        for (Scope scope : scopeStack) {
            if (scope.name.equals(scopeName)) {
                return scope;
            }
        }

        for (Scope scope : scopeStack) {
            for (Symbol symbol : scope.symbols.values()) {
                if (symbol instanceof FunctionSymbol) {
                    FunctionSymbol func = (FunctionSymbol) symbol;
                    if (func.functionScope != null && func.functionScope.name.equals(scopeName)) {
                        return func.functionScope;
                    }
                }
            }
        }

        return null;
    }



    private void printScopeHierarchy(Scope scope, int depth, Set<Scope> visitedScopes) {
        if (scope == null || visitedScopes.contains(scope)) {
            return;
        }

        visitedScopes.add(scope);

        String indent = "  ".repeat(depth);
        System.out.println(indent + "[" + scope.name.toUpperCase() + "]");

        if (scope.symbols.isEmpty()) {
            System.out.println(indent + "  (Empty)");
            return;
        }

        List<Symbol> variables = new ArrayList<>();
        List<Symbol> functions = new ArrayList<>();
        List<Symbol> classes = new ArrayList<>();
        List<Symbol> imports = new ArrayList<>();

        for (Symbol symbol : scope.symbols.values()) {
            if (symbol instanceof VariableSymbol) {
                VariableSymbol var = (VariableSymbol) symbol;
                if (var.type.equals("Module") || var.type.equals("Imported") || var.type.equals("Star_Import")) {
                    imports.add(symbol);
                } else if (!builtinConstants.contains(var.name)) {
                    variables.add(symbol);
                }
            } else if (symbol instanceof FunctionSymbol) {
                functions.add(symbol);
            } else if (symbol instanceof ClassSymbol) {
                classes.add(symbol);
            }
        }

        if (!variables.isEmpty()) {
            System.out.println(indent + "  Variables (" + variables.size() + "):");
            for (Symbol var : variables) {
                VariableSymbol v = (VariableSymbol) var;
                String typeStr = v.type.equals("iteration") ? "loop var" :
                        v.type.equals("Context") ? "Context var" :
                                v.type.equals("any") ? "Variable" : v.type;

                System.out.println(indent + "    • " + v.name + " (" + typeStr + ") at line " + v.line);

                List<VariableSymbol> nested = getNestedSymbols(v.name);
                if (!nested.isEmpty()) {
                    Set<String> uniqueFields = new HashSet<>();
                    for (VariableSymbol nestedSym : nested) {
                        String fullName = nestedSym.name;
                        String fieldName = fullName.substring(fullName.indexOf(".") + 1);
                        uniqueFields.add(fieldName);
                    }
                    System.out.println(indent + "      └─ Fields: " + uniqueFields);
                }
            }
        }

        if (!functions.isEmpty()) {
            System.out.println(indent + "  Functions (" + functions.size() + "):");
            for (Symbol func : functions) {
                FunctionSymbol f = (FunctionSymbol) func;
                System.out.println(indent + "    • " + f.name +
                        " (params: " + f.parameters.size() + ") at line " + f.line);

                if (f.functionScope != null) {
                    printScopeHierarchy(f.functionScope, depth + 2, visitedScopes);
                }
            }
        }

        if (!classes.isEmpty()) {
            System.out.println(indent + "  Classes (" + classes.size() + "):");
            for (Symbol cls : classes) {
                ClassSymbol c = (ClassSymbol) cls;
                System.out.println(indent + "    • " + c.name + " at line " + c.line);

                for (Scope s : scopeStack) {
                    if (s.name.equals("Class:" + c.name) && !visitedScopes.contains(s)) {
                        printScopeHierarchy(s, depth + 2, visitedScopes);
                        break;
                    }
                }
            }
        }

        if (!imports.isEmpty() && scope == globalScope) {
            System.out.println(indent + "  Imports (" + imports.size() + "):");
            for (Symbol imp : imports) {
                VariableSymbol i = (VariableSymbol) imp;
                System.out.println(indent + "    • " + i.name + " (" + i.type + ") at line " + i.line);
            }
        }
    }

    private void printSummary() {
        SymbolStatistics stats = getStatistics();
        System.out.println("Global Scope Summary:");
        System.out.println("  • Classes: " + stats.classes);
        System.out.println("  • Functions: " + stats.functions);
        System.out.println("  • Variables: " + stats.variables);
        System.out.println("  • Imports: " + stats.imports);
        System.out.println("  • Nested Fields: " + stats.totalAttributes);
        System.out.println("  • Total symbols: " + stats.totalSymbols);

        System.out.println("\nScope Hierarchy:");
        for (Scope scope : scopeStack) {
            if (scope != globalScope) {
                int symbolCount = scope.symbols.size();
                System.out.println("  • " + scope.name + ": " + symbolCount + " Symbols");
            }
        }

        System.out.println("\nNested Symbols Statistics:");
        int totalNested = 0;
        Set<String> uniqueFields = new HashSet<>();
        for (List<VariableSymbol> nestedList : nestedSymbols.values()) {
            totalNested += nestedList.size();
            for (VariableSymbol sym : nestedList) {
                String fullName = sym.name;
                String fieldName = fullName.substring(fullName.indexOf(".") + 1);
                uniqueFields.add(fieldName);
            }
        }
        System.out.println("  • Total Nested Fields: " + totalNested);
        System.out.println("  • Unique Fields: " + uniqueFields.size());
        System.out.println("  • Variables With Nested Fields: " + nestedSymbols.size());
    }


    public static class LookupOptions {
        public boolean startFromCurrent = false;
        public boolean recursive = true;
        public String typeFilter = null;
        public boolean caseSensitive = true;

        public LookupOptions() {}

        public LookupOptions startFromCurrent(boolean value) {
            this.startFromCurrent = value;
            return this;
        }


        public LookupOptions typeFilter(String type) {
            this.typeFilter = type;
            return this;
        }

        public LookupOptions recursive(boolean value) {
            this.recursive = value;
            return this;
        }

        public LookupOptions caseSensitive(boolean value) {
            this.caseSensitive = value;
            return this;
        }
    }

    public static class SymbolLookupResult {
        public final Symbol symbol;
        public final Scope scope;

        public SymbolLookupResult(Symbol symbol, Scope scope) {
            this.symbol = symbol;
            this.scope = scope;
        }
    }

    public static class SymbolStatistics {
        public int totalSymbols = 0;
        public int variables = 0;
        public int functions = 0;
        public int classes = 0;
        public int imports = 0;
        public int totalParameters = 0;
        public int totalMethods = 0;
        public int totalAttributes = 0;

        @Override
        public String toString() {
            return String.format(
                    "Symbol Statistics:\n" +
                            "  Total Symbols: %d\n" +
                            "  Variables: %d\n" +
                            "  Functions: %d\n" +
                            "  Classes: %d\n" +
                            "  Imports: %d\n" +
                            "  Total Parameters: %d\n" +
                            "  Total Methods: %d\n" +
                            "  Total Attributes: %d",
                    totalSymbols, variables, functions, classes, imports,
                    totalParameters, totalMethods, totalAttributes
            );
        }
    }

    public Scope getCurrentScope() {
        return currentScope;
    }

}


