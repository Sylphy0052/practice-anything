package reader;

public class MyReaderFactory {
    private MyXMLReader xmlReader = new MyXMLReader();
    private MyJsonReader jsonReader = new MyJsonReader();

    public MyReaderFactory() {
    }

    public MyXMLReader getXmlReader(String path) {
        xmlReader.setPath(path);
        return xmlReader;
    }

    public MyJsonReader getJsonReader(String path) {
        jsonReader.setPath(path);
        return jsonReader;
    }
}
