package designpattern.day01.exerciseadapter;

import java.io.IOException;

public class Main {
    /**
     * 기존에 존재 : Properties ( 상속 )
     * 규격 : FileIO ( 구현 )
     * 어뎁터 : FileProperties
     */
    public static void main(String[] args) {
        FileIO f = new FileProperties();
        String filename = "file.txt";
        String newFilename = "newfile.txt";

        try {
            f.readFromFile(filename);
            f.setValue("width", "1024");
            f.setValue("height", "512");
            f.setValue("depth", "32");
            f.writeToFile(newFilename);
            System.out.println(newFilename + " is created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
