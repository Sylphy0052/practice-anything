import parser.MyFileParser;
import parser.MyParserFactory;

public class Main {
    public static void main(String[] args) {
        MyParserFactory mrf = new MyParserFactory();
        System.out.println("---XML---");
        MyFileParser xmlReader = mrf.getParser("./src/files/banana.xml");
        xmlReader.show();
//        System.out.println("---JSON---");
//        MyFileParser jsonReader = mrf.getParser("./src/files/apple.json");
//        jsonReader.show();
        System.out.println("---FIN---");
    }
}
