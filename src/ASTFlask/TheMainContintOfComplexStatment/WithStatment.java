package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class WithStatment extends Statment {

    public List<WithItemStatment> items;
    public List<Statment> body;

    public WithStatment(List<WithItemStatment> items, List<Statment> body, int line) {
        super("WithStmt", line);
        this.items = items;
        this.body = body;
    }


    @Override
    public String toString() {
        return "WithStmt(line=" + line +
                ", items=" + items +
                ", body=" + body + ")";
    }
}
