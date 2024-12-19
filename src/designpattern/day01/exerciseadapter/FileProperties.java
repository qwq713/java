package designpattern.day01.exerciseadapter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FileProperties extends Properties implements FileIO {

    @Override
    public void readFromFile(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        load(fileReader);
        fileReader.close();
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        this.store(fileWriter,"written by FileProperties");
        fileWriter.close();

    }

    @Override
    public void setValue(String key, String value) {
        this.put(key, value);
    }

    @Override
    public String getValue(String key) {
        return this.getValue(key);
    }
}
