package ASTFlask.TheMainContintOfComplexStatment;

import ASTFlask.Statment;

import java.util.List;

public class TryStatment extends Statment {


        public List<Statment> body;
        public List<CatchStatment> handlers;
        public List<Statment> elseBody;
        public List<Statment> finallyBody;

    public TryStatment(List<Statment> body, List<CatchStatment> handlers,
                List<Statment> elseBody, List<Statment> finallyBody, int line) {
            super("TryStmt", line);
            this.body = body;
            this.handlers = handlers;
            this.elseBody = elseBody;
            this.finallyBody = finallyBody;
        }


        @Override
        public String toString() {
            return "TryStmt(line=" + line +
                    ", body=" + body +
                    ", handlers=" + handlers +
                    ", elseBody=" + elseBody +
                    ", finallyBody=" + finallyBody + ")";
        }
}
