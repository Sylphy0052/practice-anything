package parser;

import framework.MyFileReaderInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

abstract public class MyFileReader implements MyFileReaderInterface {
    protected int currentIndex = 0;
    private Map<String, String> tagMap = new HashMap<String, String>();

    protected MyFileReader() {
    }

    protected String readAll(Path path) throws IOException {
        return Files.lines(path).collect(Collectors.joining(System.getProperty("line.separator")));
    }

    abstract public void readFile(Path path);

    @Override
    public String getElement(String key) {
        return (String) tagMap.get(key);
    }

    @Override
    public void setPath(String path) {
        readFile(Paths.get(path));
    }

}
