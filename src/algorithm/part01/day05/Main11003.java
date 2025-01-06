package algorithm.part01.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main11003 {
    static class Elem {
        public Elem(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int idx;
        public int value;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 주어지는 숫자 개수
        int N = Integer.parseInt(stk.nextToken());

        // 슬라이딩 윈도우 길이
        int L = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        /*
        * [제약 조건]
        * N이 10^6 이므로 O(N) 에 가까운 시간복잡도를 수행해야한다. ( N^9 이 1초임 )
        *
        * [로직]
        * Deque를 이용하여 맨앞에 최소값을 유지하는 슬라이딩 윈도우를 구성한다.
        * 가장 중요한 값은 현재 슬라이딩 윈도우에 idx : i-L+1 ~ i 인 값을 유지하며
        * 이중 최소값이 될수 있는 후보를 O(1) * 상수 에 가까운 복잡도로 찾을 수 있어야한다.
        *
        * 1. 새로운 Elt 를 추가할 때 최소값이 아닌 슬라이딩 윈도우 후보로부터 새로운 Elt보다 큰 값은 최소값 후보에서 제거한다.
        * -> 뒤에서부터 확인하여 새로운 Elt 보다 큰 Elt는 슬라이딩 윈도우에서 제거한다.
        * -> 이미 슬라이딩 윈도우에 포함되어있는 값은 idx가 현재 값보다 당연하게 작다.
        * -> idx가 작은 수가 value 까지 작다면 해당 값은 최소값 후보로써의 가치가 없으므로 제거한다.
        *
        * 2. 만약 기존에 존재하던 최소값 후보가 현재값보다 크다면 (1) 로직에 의해 이미 제거된 상태이다.
        *
        * 3. 최소값 후보가 현재 슬라이딩 윈도우 범위의 밖이라면 사용할 수 없다.
        *
        * [추가적으로 고려해야할 문제]
        * 로직은 그대로이나 입출력 자체가 매우 많은 케이스이다.
        * 입력을 배열로 한번에 받아. 결과를 배열로 만들어서 정제하여 출력할 경우 TimeOut이 발생한다.
        * 따라서 입/출력도 효율화를 해야만 시간초과가 발생하지 않는다. ( 스읍.. 애매하다. )
        *
        * */
        Deque<Elem> dequeue = new LinkedList<>();
        for (int idx = 0; idx < N; idx++) {
            int value = Integer.parseInt(stk.nextToken());

            // 최소값이 아닌 값중 현재 값보다 큰 수 후보에서 제거
            while (!dequeue.isEmpty() && dequeue.peekLast().value > value) {
                dequeue.pollLast();
            }

            dequeue.offerLast(new Elem(idx, value));

            // 최소값 후보 중 슬라이딩 윈도우 밖의 값을 삭제
            while (!dequeue.isEmpty() && dequeue.peekFirst().idx <= idx - L) {
                dequeue.pollFirst();
            }

            sb.append(dequeue.peekFirst().value).append(" ");
        }
        System.out.println(sb);
    }
}
