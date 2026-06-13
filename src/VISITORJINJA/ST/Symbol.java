package VISITORJINJA.ST;


public abstract class Symbol {
    protected String name;
    protected String type;
    protected int line;
    protected int column;
    protected String filePath;

    public Symbol(String name, String type, int line, int column) {
        this.name = name;
        this.type = type;
        this.line = line;
        this.column = column;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }


    public int getColumn() {
        return column;
    }





    public abstract String getDetailedInfo();


    @Override
    public String toString() {
        return String.format("%s [%s] at line %d", name, type, line);
    }
}