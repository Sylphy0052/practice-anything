package reader;

import tag.EndTag;
import tag.Tag;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyJsonReader extends MyFileReader {

    public MyJsonReader() {
    }

    @Override
    public void readFile(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("{") || line.startsWith("}")) {
                    continue;
                }
                String[] words = line.replaceAll("[\r\n\t \",]", "").split(":");
                Tag tag = new Tag(words[0]);
                EndTag et = new EndTag(words[1]);
                tag.setTag(et);
                System.out.println(tag);
            }

        } catch (IOException e) {
            System.err.println("IOException");
            System.exit(-1);
        }
    }
}
