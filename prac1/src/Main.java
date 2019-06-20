import reader.MyFileReader;
import reader.MyReaderFactory;

public class Main {
    public static void main(String[] args) {
        MyReaderFactory mrf = new MyReaderFactory();
        System.out.println("---XML---");
        MyFileReader xmlReader = mrf.getXmlReader("./src/files/banana.xml");
        System.out.println("---JSON---");
        MyFileReader jsonReader = mrf.getJsonReader("./src/files/apple.json");
        System.out.println("---FIN---");
    }
}
