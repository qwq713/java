package designpattern.day01.adapterwithdelegate;

public class Main {
    public static void main(String[] args) {
        Banner banner = new Banner("hello");
        PrintBanner printBanner = new PrintBanner(banner);
        printBanner.printWeak();
        printBanner.printStrong();
    }
}
