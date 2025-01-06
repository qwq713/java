package algorithm.part02.date0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        int[] num = new int[end + 1];

        num[0] = -1;
        num[1] = -1;

        for (int n = 2; n <= end; n++) {
            if (num[n] == 0) {
                num[n] = 1;
                for (int k = 2; n * k <= end; k++) {
                    num[n * k] = -1;
                }
            }
        }

        for (int i = start; i <= end; i++) {
            if (num[i] == 1) {
                System.out.println(i);
            }
        }
    }
}
