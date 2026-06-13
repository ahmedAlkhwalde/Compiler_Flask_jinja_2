package AST_HTMLCSSJINJA;

import java.util.ArrayList;
import java.util.List;

public class JinjaNode extends ASTNode {
    private JinjaType jinjaType;
    private String content;


    public enum JinjaType {
        EXPRESSION,
        STATEMENT,
        IF,
        FOR,
        SET,
        BLOCK,
        WITH,
        MACRO,
        INCLUDE,
        EXTENDS
    }

    public JinjaNode(int lineNumber, JinjaType jinjaType, String content) {
        super(lineNumber);
        this.jinjaType = jinjaType;
        this.content = content;
    }


    public String getContent() {
        return content;
    }


    @Override
    public String getNodeName() {
        return "JinjaNode[" + jinjaType + "]";
    }

    @Override
    public String getAdditionalInfo() {
         if (jinjaType == JinjaType.EXPRESSION) {
            return "{{ " + content + " }}";
        } else if (jinjaType == JinjaType.STATEMENT) {
            return "{% " + content + " %}";
        }
        return content;
    }
}