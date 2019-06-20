package framework;

import java.nio.file.Path;

public interface MyFileReaderInterface {

    public void readFile(Path path);

    public String getElement(String key);

    public void setPath(String path);
}
