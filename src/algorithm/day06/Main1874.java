package algorithm.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스택 수열
 */
public class Main1874 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int[] numList = new int[N];
        for (int i = 0; i < N; i++) {
            numList[i] = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        }

        /*
         * [제약사항]
         * - push 는 1 부터 N 까지 순차적으로 가능
         * -> push 대상인 insertNumber는 최대 N
         *
         * [로직]
         * - Stack 이 비어있을 경우
         * -> insertNumber를 Stk 에 push
         *
         * - Stack 내부에 elt가 존재할 경우
         * -> 최상단 elt가 sequence와 동일하면 pop
         * -> 동일하지 않은 경우 push
         *
         * - insertNumber가 N까지 push된 케이스 ( 무조건 도달함 )
         * -> 순차적으로 pop을 수행하여 sequence 를 생성할 수 있는지 확인.
         * -> 만약 생성할 수 없는 경우 Stk이 모두 소진되지 않음.
         * */

        List<String> result = new ArrayList<>();
        Deque<Integer> dequeue = new ArrayDeque<>();

        int sequenseIdx = 0;
        int insertNumber = 1;

        while (insertNumber <= N) {
            if (dequeue.isEmpty()) {
                result.add("+");
                dequeue.push(insertNumber++);
            } else {
                Integer lastElement = dequeue.peek();
                if (lastElement == numList[sequenseIdx]) {
                    result.add("-");
                    dequeue.pop();
                    sequenseIdx++;
                } else {
                    result.add("+");
                    dequeue.push(insertNumber++);
                }
            }
        }
        /**
         * - Case01 . Stk에서 순차적으로 pop을 이용하여 sequence를 생성할 수 있는 경우
         * -> !dequeue.isEmpty() 에서 멈추게됨. ( 모두 소진 )
         *
         * - Case02. sequence 생성 불가한 경우
         * -> dequeue.pop() == numList[sequenseIdx++] 조건에 위배됨
         * */
        while (!dequeue.isEmpty() && dequeue.pop() == numList[sequenseIdx++]) {
            result.add("-");
        }

        if (dequeue.isEmpty()) {
            // Case01
            result.forEach(System.out::println);
        } else {
            // Case02
            System.out.println("NO");
        }

    }
}
