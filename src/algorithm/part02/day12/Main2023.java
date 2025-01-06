package algorithm.part02.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2023 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        List<Integer> result = new ArrayList<>();
        search(2, 1, N, result);
        search(3, 1, N, result);
        search(5, 1, N, result);
        search(7, 1, N, result);
        result.forEach(System.out::println);
    }

    /**
     * DFS 이용하여 자리수를 추가하며 모든 자리수가 소수인 수를 찾기.
     * [로직]
     * - 자리수를 추가한 뒤 소수인 경우만 search (dfs) 대상
     * - 만약 자리수가 원하는 자리수인 N과 동일한 경우
     * - 이미 소수임을 검증받음
     * - 따라서 해당 소수는 정답의 후보가 됨.
     * - 이제 자리수를 더이상 추가하는건 의미가 없으므로 ( 정답의 후보가 될 수 없음 )  search를 멈춤  (return)
     */
    private static void search(int num, int nowDigit, int targetDigit, List<Integer> result) {
        if (nowDigit == targetDigit) {
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            int nextNum = num * 10 + i;
            if (isPrime(nextNum)) {
                search(nextNum, nowDigit + 1, targetDigit, result);
            }
        }
    }

    /**
     * 소수 확인
     */
    private static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
