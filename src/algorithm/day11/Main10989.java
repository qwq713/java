package algorithm.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10989 {
    /**
     * 수 정렬하기3
     * https://www.acmicpc.net/problem/10989
     *
     * [로직]
     * 수 정렬하기2 와 동일하게 접근.
     * https://gist.github.com/qwq713/6c1aab484ba37bd55a9ff6069b0bc43d#file-2_2751.
     *
     */

    static short MAX_NUM = 10000;
    static int[] numMap = new int[MAX_NUM + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < N; i++) {
            short num = Short.parseShort(new StringTokenizer(br.readLine()).nextToken());
            numMap[num] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int num = 0; num <= MAX_NUM; num++) {
            int count = numMap[num];
            for (int i = 0; i < count; i++) {
                sb.append(num).append("\n");
            }
        }
        System.out.println(sb);
    }
}
