package parser;

public class MyParserFactory {
    // Singleton
    private MyXMLParser xmlParser = new MyXMLParser();
    private MyJsonParser jsonParser = new MyJsonParser();

    public MyParserFactory() {
    }

    public MyFileParser getParser(String path) {
        MyFileParser retParser = null;
        if (path.contains(".json")) {
            retParser = getJsonParser(path);
        } else if (path.contains(".xml")) {
            retParser = getXmlParser(path);
        } else {
            System.err.println("Not Support the file...");
            System.exit(-1);
        }
        return retParser;
    }

    public MyXMLParser getXmlParser(String path) {
        xmlParser.setPath(path);
        return xmlParser;
    }

    public MyJsonParser getJsonParser(String path) {
        jsonParser.setPath(path);
        return jsonParser;
    }
}
