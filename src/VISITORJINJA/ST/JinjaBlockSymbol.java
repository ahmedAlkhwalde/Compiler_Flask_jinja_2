package VISITORJINJA.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JinjaBlockSymbol extends JinjaSymbol {

    public List<String> conditions;
    public List<JinjaSymbol> thenBlock;
    public List<JinjaSymbol> elseBlock;
    public String iterator;
    public String iterable;
    public boolean hasElseBlock;
    public Map<String, Object> blockVariables;

    public JinjaBlockSymbol(JinjaType type, String content, int line, int column) {
        super(type, content, line, column);
        this.conditions = new ArrayList<>();
        this.thenBlock = new ArrayList<>();
        this.elseBlock = new ArrayList<>();
        this.hasElseBlock = false;
        this.blockVariables = new HashMap<>();

        parseBlockContent();
    }


    public void parseBlockContent() {
        String content = getContent();
        JinjaType type = getJinjaType();

        if (content == null || content.isEmpty()) {
            return;
        }

        switch (type) {
            case IF:
                parseIfBlock(content);
                break;
            case FOR:
                parseForBlock(content);
                break;
            case WITH:
                parseWithBlock(content);
                break;
            default:
                break;
        }
    }


    public void parseIfBlock(String content) {
        String condition = content.substring(2).trim();
        conditions.add(condition);
    }


    public void parseForBlock(String content) {

        String forContent = content.substring(3).trim();

        if (forContent.contains(" in ")) {
            String[] parts = forContent.split(" in ", 2);
            if (parts.length == 2) {
                this.iterator = parts[0].trim();
                this.iterable = parts[1].trim();

                blockVariables.put(iterator, "undefined");
            }
        }
    }


    public void parseWithBlock(String content) {

        String withContent = content.substring(4).trim(); // إزالة "with"

        if (withContent.contains("=")) {
            String[] parts = withContent.split("=", 2);
            if (parts.length == 2) {
                String variable = parts[0].trim();
                String value = parts[1].trim();
                blockVariables.put(variable, value);
            }
        }
    }

    public String getIterator() {
        return iterator;
    }


    public void setIterator(String iterator) {
        this.iterator = iterator;
        if (iterator != null && !iterator.isEmpty()) {
            blockVariables.put(iterator, "undefined");
        }
    }

    public void setIterable(String iterable) {
        this.iterable = iterable;
    }

    public void addCondition(String condition) {
        if (condition != null && !condition.isEmpty()) {
            conditions.add(condition);
        }
    }

    public void addBlockVariable(String key, Object value) {
        if (key != null && !key.isEmpty()) {
            blockVariables.put(key, value);
        }
    }

    public int getTotalSymbolsInBlock() {
        return thenBlock.size() + elseBlock.size();
    }


    public boolean isIfBlock() {
        return getJinjaType() == JinjaType.IF;
    }


    public boolean isForBlock() {
        return getJinjaType() == JinjaType.FOR;
    }

    @Override
    public String getDetailedInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jinja2 Block: ").append(getJinjaType()).append("\n");
        sb.append("  Content: ").append(getContent()).append("\n");
        sb.append("  Line: ").append(getLine()).append(", Column: ").append(getColumn()).append("\n");

        if (iterator != null && iterable != null) {
            sb.append("  Iterator: ").append(iterator).append(" in ").append(iterable).append("\n");
        }

        if (!conditions.isEmpty()) {
            sb.append("  Conditions (").append(conditions.size()).append("):\n");
            for (String condition : conditions) {
                sb.append("    • ").append(condition).append("\n");
            }
        }

        sb.append("  Then block symbols: ").append(thenBlock.size()).append("\n");
        sb.append("  Else block symbols: ").append(elseBlock.size()).append("\n");
        sb.append("  Has else block: ").append(hasElseBlock).append("\n");
        sb.append("  Block variables: ").append(blockVariables.size()).append("\n");

        if (!blockVariables.isEmpty()) {
            sb.append("  Variables:\n");
            for (Map.Entry<String, Object> entry : blockVariables.entrySet()) {
                sb.append("    • ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }

        if (getParentElement() != null) {
            sb.append("  Parent element: <").append(getParentElement().getName()).append(">\n");
        }

        if (!thenBlock.isEmpty()) {
            sb.append("  Then block preview:\n");
            for (int i = 0; i < Math.min(thenBlock.size(), 3); i++) {
                JinjaSymbol symbol = thenBlock.get(i);
                sb.append("    • ").append(symbol.getContent())
                        .append(" [").append(symbol.getJinjaType()).append("]\n");
            }
            if (thenBlock.size() > 3) {
                sb.append("    ... and ").append(thenBlock.size() - 3).append(" more\n");
            }
        }

        if (!elseBlock.isEmpty()) {
            sb.append("  Else block preview:\n");
            for (int i = 0; i < Math.min(elseBlock.size(), 3); i++) {
                JinjaSymbol symbol = elseBlock.get(i);
                sb.append("    • ").append(symbol.getContent())
                        .append(" [").append(symbol.getJinjaType()).append("]\n");
            }
            if (elseBlock.size() > 3) {
                sb.append("    ... and ").append(elseBlock.size() - 3).append(" more\n");
            }
        }

        return sb.toString();
    }


    @Override
    public String toString() {
        String typeStr = getJinjaType().name();
        String contentPreview = getContent().length() > 20 ?
                getContent().substring(0, 17) + "..." : getContent();

        String blockInfo = "";
        if (isForBlock() && iterator != null && iterable != null) {
            blockInfo = " [" + iterator + " in " + iterable + "]";
        } else if (isIfBlock() && !conditions.isEmpty()) {
            blockInfo = " [conditions: " + conditions.size() + "]";
        }

        return String.format("{%s: %s}%s line:%d",
                typeStr, contentPreview, blockInfo, getLine());
    }


    public static JinjaBlockSymbol createIfBlock(String condition, int line, int column) {
        JinjaBlockSymbol block = new JinjaBlockSymbol(
                JinjaType.IF, "if " + condition, line, column
        );
        block.addCondition(condition);
        return block;
    }

    public static JinjaBlockSymbol createForBlock(String iterator, String iterable,
                                                  int line, int column) {
        String content = "for " + iterator + " in " + iterable;
        JinjaBlockSymbol block = new JinjaBlockSymbol(
                JinjaType.FOR, content, line, column
        );
        block.setIterator(iterator);
        block.setIterable(iterable);
        return block;
    }




}