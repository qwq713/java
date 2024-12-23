package algorithm.common.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /**
     * list[left ... mid] 와 list[mid+1 ... right] 가 merge 되는 알고리즘
     * <p>
     * 핵심 포인트
     * -> left , mid , right
     */
    public static void merge(List<Integer> list, int left, int mid, int right) {
        List<Integer> sortedList = new ArrayList<>();
        int leftPointer = left;
        int rightPointer = mid + 1;

        while (leftPointer <= mid && rightPointer <= right) {
            int leftNum = list.get(leftPointer);
            int rightNum = list.get(rightPointer);
            if (leftNum < rightNum) {
                sortedList.add(leftNum);
                leftPointer++;
            } else { // leftNum >= rightNum
                sortedList.add(rightNum);
                rightPointer++;
            }
        }

        while (leftPointer <= mid) {
            sortedList.add(list.get(leftPointer++));
        }

        while (rightPointer <= right) {
            list.add(list.get(rightPointer++));
        }

        for (int idx = left; idx <= right; idx++) {
            list.set(idx, sortedList.get(idx - left));
        }
    }

    public static void mergeSort(List<Integer> list, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 4, 3, 2, 1));
        System.out.println(list);

        int left = 0;
        int right = list.size() - 1;
        mergeSort(list, left, right);

        System.out.println(list);
    }
}
