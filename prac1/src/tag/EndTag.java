package tag;

public class EndTag extends TagClass {

    public EndTag() {
    }

    public EndTag(String element, int depth) {
        super(element, depth);
    }

    @Override
    public String toString() {
        return "";
    }

}
