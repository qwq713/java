package algorithm.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 수 정렬하기
 * https://www.acmicpc.net/problem/2750
 */
public class Main2750 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        List<Integer> numList = new ArrayList<>();
        while (N-- > 0) {
            int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            numList.add(num);
        }

        // 정렬
        Collections.sort(numList);

        // 출력
        numList.forEach(System.out::println);
    }

}
