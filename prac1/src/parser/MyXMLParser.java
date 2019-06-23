package parser;

import tag.EndTag;
import tag.Tag;

import java.io.IOException;
import java.nio.file.Path;

public class MyXMLReader extends MyFileReader {

    public MyXMLReader() {
    }

    @Override
    public void readFile(Path path) {
        try {
            int endPoint = currentIndex;
            String allText = readAll(path);
            allText = allText.replaceAll("[\r\n\t ]", "");
            Tag beforeTag = new Tag();
            while (currentIndex < allText.length()) {
                endPoint = allText.indexOf(">", currentIndex);
                String txt = allText.substring(currentIndex, endPoint);
                if (txt.contains("<?xml")) {
                    currentIndex = endPoint + 1;
                    continue;
                }
                if (txt.startsWith("<")) {
                    beforeTag = new Tag(txt.substring(1));
                } else {
                    EndTag et = new EndTag(txt.substring(0, txt.indexOf("</")));
                    beforeTag.setTag(et);
                    System.out.println(beforeTag);
                }
                currentIndex = endPoint + 1;
            }

        } catch (IOException e) {
            System.err.println("IOException");
            System.exit(-1);
        }
    }
}
