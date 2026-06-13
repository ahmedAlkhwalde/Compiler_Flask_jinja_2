package VISITORJINJA.ST;

import java.util.*;


public class HtmlCssJinjaSymbolTable {
    public SymbolScope globalScope;
    public SymbolScope currentScope;
    public Map<Integer, List<Symbol>> symbolsByLine;
    public Map<String, List<Symbol>> symbolsByType;

    public int htmlElementCount;
    public int htmlAttributeCount;
    public int cssRuleCount;
    public int jinjaSymbolCount;

    public HtmlCssJinjaSymbolTable() {
        this.globalScope = new SymbolScope("global", SymbolScope.ScopeType.GLOBAL, null);
        this.currentScope = globalScope;
        this.symbolsByLine = new HashMap<>();
        this.symbolsByType = new HashMap<>();
    }

    public void enterScope(String name, SymbolScope.ScopeType type) {
        SymbolScope newScope = new SymbolScope(name, type, currentScope);
        currentScope = newScope;
    }

    public void exitScope() {
        if (currentScope.parent != null) {
            currentScope = currentScope.parent;
        }
    }

    public SymbolScope getCurrentScope() {
        return currentScope;
    }


    public void addHtmlElement(HtmlElementSymbol element) {
        addSymbol(element);
        htmlElementCount++;

        enterScope("element_" + element.name, SymbolScope.ScopeType.HTML_ELEMENT);
    }

    public void closeHtmlElement() {
        exitScope();
    }

    public void addHtmlAttribute(HtmlAttributeSymbol attribute) {
        addSymbol(attribute);
        htmlAttributeCount++;
    }

    public void addCssRule(CssRuleSymbol rule) {
        addSymbol(rule);
        cssRuleCount++;
    }

    public void addJinjaSymbol(JinjaSymbol jinjaSymbol) {
        addSymbol(jinjaSymbol);
        jinjaSymbolCount++;


        if (jinjaSymbol instanceof JinjaBlockSymbol) {
            String scopeName = "jinja_" + jinjaSymbol.jinjaType.toString().toLowerCase();
            enterScope(scopeName, SymbolScope.ScopeType.JINJA_BLOCK);
        }
    }

    public void closeJinjaBlock() {
        exitScope();
    }

    public void addSymbol(Symbol symbol) {

        currentScope.addSymbol(symbol);


        symbolsByLine.computeIfAbsent(symbol.line, k -> new ArrayList<>())
                .add(symbol);


        symbolsByType.computeIfAbsent(symbol.type, k -> new ArrayList<>())
                .add(symbol);
    }


    public List<Symbol> findSymbolsByType(String type) {
        return symbolsByType.getOrDefault(type, new ArrayList<>());
    }

    public List<HtmlElementSymbol> findHtmlElementsByTag(String tagName) {
        List<HtmlElementSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolsByType.getOrDefault("HTML_ELEMENT", new ArrayList<>())) {
            if (symbol instanceof HtmlElementSymbol && symbol.name.equals(tagName)) {
                result.add((HtmlElementSymbol) symbol);
            }
        }
        return result;
    }

    public List<CssRuleSymbol> findCssRulesByProperty(String property) {
        List<CssRuleSymbol> result = new ArrayList<>();
        for (Symbol symbol : symbolsByType.getOrDefault("CSS_RULE", new ArrayList<>())) {
            if (symbol instanceof CssRuleSymbol && symbol.name.equals(property)) {
                result.add((CssRuleSymbol) symbol);
            }
        }
        return result;
    }

    public void printStatistics() {
        System.out.println("========== SYMBOL TABLE STATISTICS ==========");
        System.out.println("HTML Elements: " + htmlElementCount);
        System.out.println("HTML Attributes: " + htmlAttributeCount);
        System.out.println("CSS Rules: " + cssRuleCount);
        System.out.println("Jinja2 Symbols: " + jinjaSymbolCount);
        System.out.println("Total Symbols: " + getTotalSymbols());
        System.out.println("Scope Depth: " + getScopeDepth());
        System.out.println("============================================");
    }





    public int getTotalSymbols() {
        return htmlElementCount + htmlAttributeCount + cssRuleCount + jinjaSymbolCount;
    }

    public int getScopeDepth() {
        int depth = 0;
        SymbolScope current = currentScope;
        while (current != null) {
            depth++;
            current = current.parent;
        }
        return depth;
    }





    public void closeAllScopes() {
        while (currentScope != globalScope) {
            exitScope();
        }
        System.out.println("All scopes closed. Current scope: " + currentScope.name);
    }

}