package algorithm.part01.day01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        int scoreCount = Integer.parseInt(scanner.nextLine());
        List<Double> scores = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        // 입력 검증: 점수 개수 확인
        if (scores.size() != scoreCount) {
            throw new IllegalArgumentException("입력된 점수 개수가 일치하지 않습니다.");
        }

        // 최대값 찾기
        double maxScore = scores.stream()
                .max(Double::compare)
                .orElseThrow(() -> new IllegalArgumentException("점수 목록이 비어 있습니다."));

        // 평균 계산
        double normalizedSum = scores.stream()
                .mapToDouble(score -> (score / maxScore) * 100.0)
                .sum();

        double average = normalizedSum / scoreCount;

        // 결과 출력
        System.out.println(average);
    }
}
