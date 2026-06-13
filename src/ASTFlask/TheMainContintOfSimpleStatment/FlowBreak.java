package ASTFlask.TheMainContintOfSimpleStatment;

public class FlowBreak extends FlowStatment{
    public FlowBreak(int line) {
        super("BreakStmt", line);
    }

    @Override
    public String toString() {
        return "BreakStmt(line=" + line + ")";
    }
}
