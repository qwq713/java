package designpattern.day01.adapterwithdelegate;

public class PrintBanner extends Print {

    /**
     * 규격 함수를 내부에서 호출하며
     * 기존에 존재하던 인스턴스를 어뎁터 클래스인 PrintBanner 안에 소유
     * */
    private Banner banner;

    public PrintBanner(Banner banner) {
        this.banner = banner;
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
