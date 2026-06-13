package ASTFlask;


public abstract class Statment extends StatmentRoot {
    public Statment(String nodeName, int line) {
        super(nodeName, line);
    }

    public String getDetails() {
        return toString();
    }



}