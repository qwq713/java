package algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11659 {
    /**
     * 최대값
     * - 10^3 * 10^5 = 10^8 <  10^9 * 2 ( int )
     */
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        // idx 일치시키기 ( 0번째 공간에 쓰레기값 넣기 )
        int[] sumList = new int[N + 1];

        stk = new StringTokenizer(br.readLine());

        // 누적합 배열 생성 ( sumList[i] == 1번째 ~ i번째 숫자까지의 합 )
        for (int i = 1; i <= N; i++) {
            sumList[i] = sumList[i - 1] + Integer.parseInt(stk.nextToken());
        }

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            System.out.println(sumList[end] - sumList[start - 1]);
        }
    }
}
