package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2751 {
    /**
     * 수 정렬하기2
     * https://www.acmicpc.net/problem/2751
     */

    public static void main(String[] args) throws IOException {
        // 입력값 받기
        int len = 1000000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        /**
         * [로직]
         * - 특이한 조건이 있기에 해당 조건을 이용하여 작성했다.
         * - 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
         * 즉 정리하면 아래와 같다.
         * 1. 절댓값이 1000000 보다 작다.
         * 2. 수는 중복되지 않는다.
         *
         * 이 두가지 조건을 이용하여 조금은 특이하게 문제를 해결해보았다.
         * 1. 2*100000 + 1 의 배열을 생성한다. ( 0보다 작은 수끼지 대응하기 위해 )
         * 2. 특정 수가 존재하면 위 숫자에서 배열의 idx에 해당하는 값에 true를 기입한다. ( n 인 경우 n+1000000에 true 넣기 )
         * 3. 2*100000 의 배열을 탐색하여 true인 경우 idx-1000000를 출력한다.
         *
         * 위 로직의 시간복잡도는 주어진 숫자에 상관없이 O(2000000) 이다.
         * 따라서 주어진 조건 내에서는 무조건 2백만번의 연산만 수행한다. ( 0.02초 )
         * */
        boolean[] numList = new boolean[len * 2 + 1];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            numList[num + len] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numList.length; i++) {
            if (numList[i]) {
                sb.append(i - len);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
