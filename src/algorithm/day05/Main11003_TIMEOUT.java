package algorithm.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main11003_TIMEOUT {

    public static void main(String[] args) throws IOException {
        /*
         * heap 은 Comparator에 따라 최소 or 최대 값을 O(1)의 연산으로 찾는것을 지원한다.
         * - 삭제 / 삽입 : 평균 : logN , 최악 : N
         * 따라서 구간별 최소값을 구하기 위해 Heap을 이용하여 슬라이딩 윈도우를 구성한다.
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 주어지는 숫자 개수
        int N = Integer.parseInt(stk.nextToken());

        // 슬라이딩 윈도우 길이
        int L = Integer.parseInt(stk.nextToken());

        // 숫자 배열
        stk = new StringTokenizer(br.readLine());
        int[] numList = new int[N];
        for (int i = 0; i < N; i++) {
            numList[i] = Integer.parseInt(stk.nextToken());
        }

        // 최소 힙으로 슬라이딩 윈도우 구성
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int[] result = new int[N];

        for (int i = 0; i < L; i++) {
            int num = numList[i];
            heap.add(num);
            result[i] = heap.peek();
        }

        for (int i = L; i < N; i++) {
            int removeNum = numList[i-L];
            int addNum = numList[i];
            heap.remove(removeNum);
            heap.add(addNum);
            result[i] = heap.peek();
        }

        String resultValue = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(resultValue);
    }
}
