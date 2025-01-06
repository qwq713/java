package algorithm.part01.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main11286 {
    /*
     * heap의 comparator를 구현하여 목적에 맞게 custom하는 내용이다.
     *
     * [비교 조건] - Comparator 구현.
     * 1. 절대값이 작은것을 우선적으로 heap의 최상위 노드에 위치한다.
     * 2. 절대값이 같다면 음수를 우선적으로 heap의 최상위 노드에 위치한다. ( 그냥 숫자 비교 )
     * */

    public static void main(String[] args) throws IOException {
        // 입력값 받기 ( N )
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());

        // 우선순위 큐 구현 ( Heap )
        PriorityQueue<Integer> absoluteMinHeap = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        // 입력값 받기 ( 숫자 N번 )
        while (N-- > 0) {
            stk = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(stk.nextToken());

            // input == 0 이면 출력.
            if (input == 0) {
                if (absoluteMinHeap.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(absoluteMinHeap.poll());
                }
            } else { // input 0 이외에는 heap 에 추가
                absoluteMinHeap.add(input);
            }
        }
    }
}
