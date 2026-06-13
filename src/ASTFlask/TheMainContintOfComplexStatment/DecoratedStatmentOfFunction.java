package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.Statment;

import java.util.List;

public class DecoratedStatmentOfFunction extends Statment {

    public List<DecoratorOfFunction> decorators;
    public Statment statement;

    public DecoratedStatmentOfFunction(List<DecoratorOfFunction> decorators, Statment statement, int line) {
        super("DecoratedStmt", line);
        this.decorators = decorators;
        this.statement = statement;
    }

    @Override
    public String toString() {
        return nodeName + "(line=" + line + ", decorators=" + decorators + ", statement=" + statement + ")";
    }
}
