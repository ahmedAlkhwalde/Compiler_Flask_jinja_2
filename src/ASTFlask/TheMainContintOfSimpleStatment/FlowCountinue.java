package ASTFlask.TheMainContintOfSimpleStatment;

public class FlowCountinue extends FlowStatment{
    public FlowCountinue(int line) {
        super("ContinueStmt", line);
    }

    @Override
    public String toString() {
        return "ContinueStmt(line=" + line + ")";
    }
}
