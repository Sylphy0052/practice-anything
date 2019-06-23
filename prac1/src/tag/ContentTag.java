package tag;

public class ContentTag extends TagClass {

    public ContentTag() {
    }

    public ContentTag(String element, int depth) {
        super(element, depth);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append(element + "\n");
        return new String(sb);
    }

}
