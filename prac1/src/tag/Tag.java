package tag;

import java.util.ArrayList;
import java.util.List;

public class Tag extends TagClass {
    private List<TagClass> tagList = new ArrayList<>();

    public Tag() {
    }

    public void addTag(TagClass tag) {
        tagList.add(tag);
    }

    public List<TagClass> getTagList() {
        return tagList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        tagList.stream().forEach((tag) -> {
            sb.append(tag.toString());
        });
        return new String(sb);
    }
}
