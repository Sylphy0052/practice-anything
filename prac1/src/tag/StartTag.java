package tag;

import java.util.HashMap;
import java.util.Map;

public class Tag extends MyTag {
    private Map<String, MyTag> next = new HashMap<>();

    public Tag() {
    }

    public Tag(String tagName) {
        this.element = tagName;
    }

    public void setTag(MyTag tag) {
        next.put(element, tag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.element + ": ");
        for (MyTag mt : next.values()) {
            sb.append(mt.getElement());
        }
        return sb.toString();
    }

}
