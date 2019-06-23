package parser;

public class MyReaderFactory {
    private MyXMLParser xmlReader = new MyXMLParser();
    private MyJsonParser jsonReader = new MyJsonParser();

    public MyReaderFactory() {
    }

    public MyXMLParser getXmlReader(String path) {
        xmlReader.setPath(path);
        return xmlReader;
    }

    public MyJsonParser getJsonReader(String path) {
        jsonReader.setPath(path);
        return jsonReader;
    }
}
