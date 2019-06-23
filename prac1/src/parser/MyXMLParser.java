package parser;

import status.Status;
import tag.ContentTag;
import tag.EndTag;
import tag.StartTag;

import java.io.IOException;
import java.nio.file.Path;

public class MyXMLParser extends MyFileParser {

    private String allText = null;
    private int endPoint;
    private String nextText = null;

    public MyXMLParser() {
    }

    private String formatText(String text) {
        return text.replaceAll("[\r\n\t ]", "");
    }

    private void init(Path path) {
        endPoint = currentIndex;
        try {
            // ファイルを1行のStringにする
            allText = readAll(path);
        } catch (IOException e) {
            System.err.println("IOException");
            System.exit(-1);
        }

        // 改行，タブ，スペースを取り除く
        allText = formatText(allText);
        nextText = null;
    }

    private void firstProcess() {
        // 最初に通る
        endPoint = allText.indexOf(">");
        if (allText.contains("<?xml")) {
            currentIndex = endPoint + 1;
        } else {
            System.err.println("Not Defined in None.");
            System.exit(-1);
        }
        currentStatus = Status.START;
    }

    private void parseStartTag() {
        endPoint = allText.indexOf(">");

        if (allText.startsWith("<")) {
            tags.addTag(new StartTag(allText.substring(1, endPoint), currentDepth));
        } else {
            System.err.println("Not Defined in Start.");
            System.exit(-1);
        }
        currentIndex = endPoint + 1;
        currentStatus = Status.CONTENT;
        currentDepth += 1;
    }

    private void parseContentTag() {
        // 開始タグ
        if (allText.startsWith("<")) {
            endPoint = allText.indexOf(">");
            tags.addTag(new StartTag(allText.substring(1, endPoint), currentDepth));
            currentDepth += 1;
            endPoint += 1;
        } else { // 要素
            endPoint = allText.indexOf("</");
            tags.addTag(new ContentTag(allText.substring(0, endPoint), currentDepth));
            currentStatus = Status.END;
        }
        currentIndex = endPoint;
    }

    private void parseEndTag() {
        endPoint = allText.indexOf(">");
        if (endPoint + 1 >= allText.length()) {
            tags.addTag(new EndTag(allText.substring(2, endPoint), currentDepth));
            currentDepth -= 1;
            currentStatus = Status.END;
        } else {
            nextText = allText.substring(endPoint + 1);

            if (nextText.startsWith("</")) {
                tags.addTag(new EndTag(allText.substring(2, endPoint), currentDepth));
                currentStatus = Status.END;
                currentDepth -= 1;
            } else if (nextText.startsWith("<")) {
                tags.addTag(new EndTag(allText.substring(2, endPoint), currentDepth));
                currentStatus = Status.START;
                currentDepth -= 1;
            } else { // 要素
                System.err.println("Not Defined in End.");
                System.exit(-1);
            }
            currentIndex = endPoint + 1;
        }
    }

    @Override
    public void readFile(Path path) {
        init(path);

        // ファイル終端までループする
        while (currentIndex < allText.length()) {
            allText = allText.substring(currentIndex);
            switch (currentStatus) {
                case NONE:
                    firstProcess();
                    break;
                // 開始タグ?
                case START:
                    parseStartTag();
                    break;
                // 要素 or 開始タグ
                case CONTENT:
                    parseContentTag();
                    break;
                case END:
                    parseEndTag();
                    break;
            }
        }
    }

    @Override
    public void show() {
        System.out.println(tags.toString());
    }
}
