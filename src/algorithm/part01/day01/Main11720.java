package algorithm.part01.day01;

import java.util.Scanner;

public class Main11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputCount = Integer.parseInt(scanner.nextLine());

        int result = 0;

        String numberString = scanner.nextLine();

        for (int i = 0; i < inputCount; i++) {
            result += Character.getNumericValue(numberString.charAt(i));
        }

        System.out.println(result);
    }
}
