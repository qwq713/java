package algorithm.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2018 {
    public static void main(String[] args) throws IOException {
        /*
         * [제약 조건]
         * 1 <= N <= 10^7
         * sum(1~N) ~= 10^14 / 2
         * -> sumList를 구축하기 위해서는 long 타입이 필요함.
         * -> 근데 여기에서는 메모리 제한이 32mb라 .. cache 사용 불가.
         *
         * 따라서 sumList[i] 를 바로 구하기 위해 등차수열의 합 공식 이용
         * (1) -> 1 + 2 + ... + n = n(n+1)/2
         *
         * [로직]
         * 0 ~ start : 연속으로 빼주는 idx -> start가 작아질수록 연속합은 커진다.
         * 0 ~ end : 연속으로 더해주는 idx -> end가 작아질수록 연속합은 작아진다.
         *
         * Case01 : 연속된 수의 합이 목표보다 작은 경우 or 같은 경우
         * -> 빼주는 수를 줄여준다. ( start를 줄인다. )

         * Case02 : 연속된 수의 합이 목표보다 큰 경우
         * -> 더해주는 수를 줄여준다. ( end를 줄인다. )
         *

         * [종료 조건]
         * start가 0인데도 연속합이 목표보다 작을 때는
         * 주어진 조건에 따라 연속합을 증가시키기 위해 start가 -1로 변경된다. ( 연속합을 키우기 위해 )
         *
         * 근데 start가 0에 도달한 Case는 남은 상황에서 연속합의 최대치를 의미한다.
         * 따라서 start가 0인 상황에서 연속합이 목표보다 작다면, 그 이후의 상황은 더이상 조사할 필요가 없다.
         * -> end를 줄이는 상황만 남았는데, end를 줄일 경우 연속합이 작아진다.
         * -> while start < 0 인 케이스에서 멈추는 이유.
         * */

        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        int result = 0;
        int start = N - 1;
        int end = N;

        while (start < end && start >= 0) {
            // (1)
            long sequentialSum = (end * (end + 1L)) / 2 - (start * (start + 1L)) / 2;
            result = sequentialSum == N ? result + 1 : result;

            if (sequentialSum <= N) {
                start--;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }
}
