package algorithm.day17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1715 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stk.nextToken());
            pq.add(num);
        }

        int result = 0;

        while (pq.size() > 1) {
            Integer first = pq.poll();
            Integer second = pq.poll();
            result += (first + second);

            pq.add(first + second);
        }

        System.out.println(result);
    }
}
