package tag;

public class StartTag extends TagClass {
    public StartTag() {
    }

    public StartTag(String element, int depth) {
        super(element, depth);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append(this.element + ": \n");
        return sb.toString();
    }

}
