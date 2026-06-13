package ASTFlask.TheMainContintOfSimpleStatment;

import java.util.ArrayList;
import java.util.List;

public class ImportName extends ImportStatment{
    public List<ImportItem> items;

    public ImportName(List<ImportItem> items, int line) {
        super("ImportStmt", line);
        this.items = items;
    }


    @Override
    public String toString() {
        return "ImportStmt(line=" + line + ", items=" + items + ")";
    }
}
