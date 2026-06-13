package ASTFlask.TheMainContintOfSimpleStatment;

public class ImportItem extends ImportStatment{
    public String name;
    public String alias;

    public ImportItem(String name, String alias, int line) {
        super("ImportItem", line);
        this.name = name;
        this.alias = alias;
    }

    @Override
    public String toString() {
        if(alias != null) {
            return "ImportItem(name=" + name + ", alias=" + alias + ")";
        }
        return "ImportItem(name=" + name + ")";
    }
}
