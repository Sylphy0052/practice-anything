package tag;

public class EndTag extends MyTag {

    public EndTag(String element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element + "\n";
    }

}
