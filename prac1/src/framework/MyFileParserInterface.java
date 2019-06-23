package framework;

import java.nio.file.Path;

public interface MyFileParserInterface {

    public void readFile(Path path);

    public void setPath(String path);

    public void show();
}
