package ASTFlask.TheMainContintOfSimpleStatment;

import ASTFlask.Statment;

public class PassStatment extends Statment {
    public PassStatment(int line) {
        super("PassStmt", line);
    }

    @Override
    public String toString() {
        return "PassStmt(line=" + line + ")";
    }
}
