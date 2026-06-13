package AST_HTMLCSSJINJA;

import java.util.ArrayList;
import java.util.List;

public class JinjaBlockNode extends ASTNode {
    private BlockType blockType;
    private List<ConditionBlock> conditionBlocks;
    private List<ASTNode> elseContent;

    public enum BlockType {
        IF,
        FOR,
        WITH,
        MACRO,
        BLOCK
    }

    public static class ConditionBlock {
        private String condition;
        private List<ASTNode> content;

        public ConditionBlock(String condition) {
            this.condition = condition;
            this.content = new ArrayList<>();
        }

        public String getCondition() {
            return condition;
        }

        public List<ASTNode> getContent() {
            return content;
        }
    }

    public JinjaBlockNode(int lineNumber, BlockType blockType) {
        super(lineNumber);
        this.blockType = blockType;
        this.conditionBlocks = new ArrayList<>();
        this.elseContent = new ArrayList<>();
    }

    public BlockType getBlockType() {
        return blockType;
    }

    public void addConditionBlock(String condition) {
        conditionBlocks.add(new ConditionBlock(condition));
    }

    public void addContentToLastCondition(ASTNode node) {
        if (!conditionBlocks.isEmpty()) {
            ConditionBlock lastCondition = conditionBlocks.get(conditionBlocks.size() - 1);
            lastCondition.getContent().add(node);
        }
    }


    public void finalizeBlock() {
        children.clear();

        for (ConditionBlock conditionBlock : conditionBlocks) {
            for (ASTNode node : conditionBlock.getContent()) {
                super.addChild(node);
            }
        }

        for (ASTNode node : elseContent) {
            super.addChild(node);
        }
    }

    @Override
    public String getNodeName() {
        return "JinjaBlockNode[" + blockType + "]";
    }

    @Override
    public String getAdditionalInfo() {
        if (blockType == BlockType.IF && !conditionBlocks.isEmpty()) {
            return "{% if " + conditionBlocks.get(0).getCondition() + " %}";
        } else if (blockType == BlockType.FOR && !conditionBlocks.isEmpty()) {
            return "{% for " + conditionBlocks.get(0).getCondition() + " %}";
        }
        return "{% " + blockType.toString().toLowerCase() + " ... %}";
    }
}