package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main11004 {
    /**
     * K번째 수
     * https://www.acmicpc.net/problem/11004
     */

    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int K = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stk.nextToken());
            numList.add(num);
        }
        Collections.sort(numList);

        // K번째 수 출력하기.
        System.out.println(numList.get(K - 1));
    }
}
