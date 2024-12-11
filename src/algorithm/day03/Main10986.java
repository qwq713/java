package algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10986 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        long[] sumAndModMList = new long[N];
        stk = new StringTokenizer(br.readLine());

        sumAndModMList[0] = Long.parseLong(stk.nextToken()) % M;
        for (int idx = 1; idx < N; idx++) {
            sumAndModMList[idx] = (sumAndModMList[idx - 1] + Long.parseLong(stk.nextToken())) % M;
        }

        /*
         * 연속된 부분 합이 M으로 나누어 떨어지는 구간의 개수 구하기
         * Case01 : 1부터 i까지 연속된 부분합이 M으로 나누어 떨어지는 경우
         *   - sumAndModMList[i] == 0
         *
         * Case02 : i,j가 자연수이면서  i < j 를 만족할 때
         *          A(1 ~ i-1) 와 A(1 ~ j) 의 나머지가 동일하면 A(i ~ j)를 M으로 나눈 나머지는 0이다. ( 나누어 떨어진다 )
         *          - mod 연산 (나머지 연산) 은 덧셈 / 뺄셈 / 곱셈에 대해 equivalent 함.
         *          - 따라서 A(i ~ j) % M := A(1 ~ j) % M - A(1 ~ i-1) % M := 같은값 - 같은값 = 0
         *          - 나머지가 같은 두개의 연속합을 선택하여 개수 산정. 단 순서를 지켜야하므로 Combination 연산 필요. -> C(n,2)
         */

        long result = 0L;
        long[] remainderCountList = new long[M];

        for (long sumAndModM : sumAndModMList) {
            // M 은 int 범위이므로 mod M 이후에는 (int) 변환해도 무관하다.
            remainderCountList[(int) sumAndModM % M]++;
        }

        // Case01
        result += remainderCountList[0];

        // Case02
        for (long cnt : remainderCountList) {
            if (cnt >= 2) {
                result += (cnt * (cnt - 1)) / 2;
            }
        }

        System.out.println(result);
    }
}
