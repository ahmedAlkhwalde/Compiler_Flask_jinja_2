package ASTFlask.TheMainContintOfSimpleStatment;

import ASTFlask.Statment;

import java.util.ArrayList;
import java.util.List;

public class GlobalStatment extends Statment {
    public List<String> names;

    public GlobalStatment(List<String> names, int line) {
        super("GlobalStmt", line);
        this.names = names;
    }


    @Override
    public String toString() {
        return "GlobalStmt(line=" + line + ", names=" + names + ")";
    }
}
