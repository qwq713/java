package algorithm.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main2164 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        Deque<Integer> dequeue = IntStream.rangeClosed(1, N).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        /**
         * 쉬운 시뮬레이션 문제이므로 주어진 그대로 구현.
         * */
        while(dequeue.size() > 1){
            dequeue.pollFirst();
            dequeue.add(dequeue.pollFirst());
        }

        System.out.println(dequeue.pollFirst());
    }
}
