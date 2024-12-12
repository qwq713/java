package algorithm.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1253 {

    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        long N = Long.parseLong(stk.nextToken());


        stk = new StringTokenizer(br.readLine());
        List<Integer> numList = new ArrayList<>();
        while (stk.hasMoreTokens()) {
            numList.add(Integer.parseInt(stk.nextToken()));
        }

        // Two Pointer 를 사용하기 위한 정렬
        Collections.sort(numList);

        int result = 0;
        /*
        * [로직]
        * 모든 수에 대해 자기자신을 제외한 두 수의 합으로 나타낼 수 있는지 Two Pointer로 확인한다.
        *
        * 오름차순으로 정렬을 했기에 start++ 은 두 수의 합을 증가. end--는 두 수의 합이 감소하는 역할을 한다.
        *
        * [주의사항]
        * - 0 4 4 의 경우 정답은 2 이다.
        * -> 첫번째 4는 0과 두번째 4를 이용해서 나타낼 수 있다. 두번째 4도 마찬가지로 첫번째 4를 이용하면 나타낼 수 있다.
        * -> 단 첫번째 4는 0과 첫번째 4 ( 자기자신 ) 을 이용해서 나타내는건 불가하다.
        * */

        for (int i = 0; i < numList.size(); i++) {
            int goal = numList.get(i);
            int start = 0;
            int end = numList.size() - 1;

            while (start < end) {
                /*
                * 자기 자신은 제외하기 위한 로직.
                * */
                if(start == i){
                    start++;
                    continue;
                }
                if(i == end){
                    end--;
                    continue;
                }
                int sum = numList.get(start) + numList.get(end);
                if (sum == goal) {
                    /*
                    * 중복으로 찾지 않기 위한 로직.
                    * */
                    result++;
                    break;
                } else if (sum < goal) {
                    start++;
                } else {
                    // sum < goal
                    end--;
                }
            }
        }

        System.out.println(result);
    }
}

/*
 * 아래 로직은 자기 자신과 0을 더하는 케이스를 고려할 수 없음.
 * 또한 동일한 숫자인데 위치가 다른 수와 0을 더한건 고려해야하는데 아래 로직에서는 고려할 수 없음.
 * */
//        Set<Long> numSet = new HashSet<>();
//        for (int i = 0; i < N; i++) {
//            for (int j = i+1; j < N; j++) {
//                numSet.add(numList.get(i) + numList.get(j));
//            }
//        }
//
//        long result = 0;
//        for (long num : numList) {
//            result = numSet.contains(num) ? result + 1L : result;
//        }

