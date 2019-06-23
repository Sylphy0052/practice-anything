package parser;

import tag.ContentTag;
import tag.StartTag;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyJsonParser extends MyFileParser {

    public MyJsonParser() {
    }

    private void addTags(String[] words) {
        tags.addTag(new StartTag(words[0], currentDepth));
        tags.addTag(new ContentTag(words[1], currentDepth + 1));
    }

    @Override
    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("{")) {
                    currentDepth += 1;
                    continue;
                } else if (line.startsWith("}")) {
                    currentDepth -= 1;
                    continue;
                }

                String[] words = line.replaceAll("[\r\n\t \",]", "").split(":");
                addTags(words);
            }

        } catch (IOException e) {
            System.err.println("IOException");
            System.exit(-1);
        }
    }

    @Override
    public void show() {
        System.out.println(tags.toString());
    }
}
