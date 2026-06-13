package ASTFlask;

public abstract class StatmentRoot {
    protected String nodeName;
    protected int line;

    public StatmentRoot(String nodeName, int line) {
        this.nodeName = nodeName;
        this.line = line;
    }

    public String getNodeName() {
        return nodeName;
    }

    public int getLine() {
        return line;
    }
}
