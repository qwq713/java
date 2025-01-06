package algorithm.part02.day11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1517 {
    /**
     * 버블 소트
     * https://www.acmicpc.net/problem/1517
     */
    static long result = 0;

    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        List<Integer> numList = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numList.add(Integer.parseInt(stk.nextToken()));
        }

        /**
         * [로직]
         * - swap은 < 으로 이동한 횟수를 의미한다.
         * - 추가로 n^2의 시간복잡도에서는 시간 초과가 발생하므로 O(NlogN)의 복잡도를 갖는 로직으로 문제를 해결해야한다.
         * - 이때 NlogN의 복잡도를 갖는 MergeSort를 이용하여 Merge 과정에서 "우측의 배열의 원소가 Merge 과정에서 왼쪽으로 얼마나 이동을 했는지"가 Swap의 횟수와 동일하므로
         * - MergeSort를 구현하고 내부에서 왼쪽으로 이동한 횟수를 (swap) count하여 문제를 해결할 수 있다.
         * */
        merge_sort(numList, 0, numList.size() - 1);
        System.out.println(result);

    }

    /**
     * merge [start ... mid] , [mid+1 ... end ]
     */
    static void merge(List<Integer> list, int start, int end) {
        int mid = (start + end) / 2;
        int leftPointer = start;
        int rightPointer = mid + 1;

        List<Integer> tempList = new ArrayList<>();
        while (leftPointer <= mid && rightPointer <= end) {
            Integer left = list.get(leftPointer);
            Integer right = list.get(rightPointer);
            if (left > right) {
                result += (rightPointer - (start + tempList.size()));
                tempList.add(right);
                rightPointer++;
            } else {
                // left <= right
                tempList.add(left);
                leftPointer++;
            }
        }
        while (leftPointer <= mid) {
            tempList.add(list.get(leftPointer++));
        }

        while (rightPointer <= end) {
            tempList.add(list.get(rightPointer++));
        }

        for (int idx = start; idx <= end; idx++) {
            list.set(idx, tempList.get(idx - start));
        }
    }

    static void merge_sort(List<Integer> list, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(list, start, mid);
            merge_sort(list, mid + 1, end);
            merge(list, start, end);
        }
    }
}
