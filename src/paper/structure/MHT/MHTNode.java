package paper.structure.MHT;

public class MHTNode {
    private int HashVal;
    private int Index;
    private MHTNode LNode;
    private MHTNode RNode;

    public MHTNode() {
    }

    public MHTNode(int hashVal, int index, MHTNode LNode, MHTNode RNode) {
        HashVal = hashVal;
        Index = index;
        this.LNode = LNode;
        this.RNode = RNode;
    }

    public int getHashVal() {
        return HashVal;
    }

    public void setHashVal(int hashVal) {
        HashVal = hashVal;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public MHTNode getLNode() {
        return LNode;
    }

    public void setLNode(MHTNode LNode) {
        this.LNode = LNode;
    }

    public MHTNode getRNode() {
        return RNode;
    }

    public void setRNode(MHTNode RNode) {
        this.RNode = RNode;
    }
}
