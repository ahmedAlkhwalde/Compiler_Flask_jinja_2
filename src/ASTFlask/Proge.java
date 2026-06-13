package ASTFlask;

import java.util.List;

public class Proge extends StatmentRoot {
    public List<Statment> statements;

    public Proge(List<Statment> statements, int line) {
        super("Program", line);
        this.statements = statements;
    }


        @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Statment child : this.statements){
            stringBuilder.append(child);
            stringBuilder.append("\n");
            System.out.println();
        }
        return stringBuilder.toString();
    }

}