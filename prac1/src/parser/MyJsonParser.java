package parser;

import java.nio.file.Path;

public class MyJsonParser extends MyFileParser {

    public MyJsonParser() {
    }

    @Override
    public void readFile(Path path) {
//        try (BufferedReader br = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                if (line.startsWith("{") || line.startsWith("}")) {
//                    continue;
//                }
//                String[] words = line.replaceAll("[\r\n\t \",]", "").split(":");
//                StartTag tag = new StartTag(words[0]);
//                EndTag et = new EndTag(words[1]);
//                tag.setTag(et);
//                System.out.println(tag);
//            }
//
//        } catch (IOException e) {
//            System.err.println("IOException");
//            System.exit(-1);
//        }
    }

    @Override
    public void show() {
        System.out.println(tags);
    }
}
