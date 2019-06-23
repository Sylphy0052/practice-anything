package parser;

import framework.MyFileParserInterface;
import status.Status;
import tag.Tag;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

abstract public class MyFileParser implements MyFileParserInterface {
    protected int currentIndex = 0;
    protected Status currentStatus = Status.NONE;
    protected Tag tags = new Tag();
    protected int currentDepth;


    protected MyFileParser() {
    }

    protected String readAll(Path path) throws IOException {
        return Files.lines(path).collect(Collectors.joining(System.getProperty("line.separator")));
    }

    abstract public void readFile(Path path);

    @Override
    public void setPath(String path) {
        readFile(Paths.get(path));
    }

}
