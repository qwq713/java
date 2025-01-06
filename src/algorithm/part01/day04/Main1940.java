package algorithm.part01.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1940 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        List<Integer> numList = new ArrayList<>();
        while (stk.hasMoreTokens()) {
            numList.add(Integer.parseInt(stk.nextToken()));
        }

        /*
        * [로직]
        * 1. "정렬된 수"에서 용이하게 사용할 수 있는 기법인 two pointer를 활용한다.
        * -> 이중 Loop 의 경우 N^2 의 복잡도를 갖는 상황을 위 기법을 이용하여 복잡도를 N으로 낮출 수 있다.
        * -> 단 two pointer를 사용하기 위해서는 배열에 대한 sort가 사전에 필요하다.
        *
        * [제약사항]
        * - Two Pointer의 특성상  ( 현재 상황에 따라 start or end 를 증감 ) 특정 기준에 따라 정렬된 상황에서 사용할 수 있다.
        * */
        Collections.sort(numList);

        int result = 0;
        int start = 0;
        int end = N - 1;
        while (start < end) {
            int sum = numList.get(start) + numList.get(end);
            if (sum == M) {
                result++;
                start++;
            } else if (sum < M) {
                start++;
            } else {
                // sum > M
                end--;
            }
        }

        System.out.println(result);
    }
}
