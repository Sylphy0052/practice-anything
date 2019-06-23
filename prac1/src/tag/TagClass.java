package tag;

abstract public class TagClass {
    protected String element;
    protected int depth;

    public TagClass() {
    }

    public TagClass(String element, int depth) {
        this.element = element;
        this.depth = depth;
    }

    abstract public String toString();

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
