package algorithm.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        int[] numList = new int[N];

        stk = new StringTokenizer(br.readLine());
        int idx = 0;
        while (stk.hasMoreTokens()) {
            numList[idx++] = Integer.parseInt(stk.nextToken());
        }

        /*
        * [로직]
        * "오른쪽에 있는 수 중 첫번째로 위치한 큰 수"의 후보를 저장하기 위해
        * 뒤에서부터 탐색하며 배열의 원소를 stack에 저장한다.
        *
        * stack의 성질에 따라 뒤에서부터 탐색하며 저장할 경우
        * -> pop을 이용하면 왼쪽에 위치하는 후보부터 검색이 가능하다.
        *
        * Case01. stack의 최상단에 존재하는 숫자가 현재 우큰수를 찾는 수보다 큰 경우
        * -> 우큰수이다.
        *
        * Case02. stack의 최상단에 존재하는 숫자가 현재 우큰수를 찾는 수보다 작거나 같은 경우
        * -> stack의 최상단에 존재하는 숫자는 우큰수가 될 수 없으므로 pop으로 버린 후 다음 후보에서 우큰수를 찾는다.
        *   -> 후보에서 찾지 못한 경우 ( stack 이 empty ) 는 오큰수가 없으므로 -1을 대입한다.
        *
        * Question 01) stack에서 pop한 대상은 아직 조사하지 못한 수들의 우큰수가 될 가능성이 전혀 없는가 ?
        * -> 없다.
        * -> stack에서 pop을 했다는 것은 현재 조사 대상보다 작다는 것을 의미한다.
        * -> 따라서 아직 조사하지 않은 대상의 우큰수는 버려진 수는 될 수 없고, 현재 조사중인 숫자는 가능성이 있다.
        *
        * Question 02) 그러면 stack 없이 단순히 우측에 위치하는 첫번째 큰 수를 찾는것과는 무슨 차이가 있는가 ?
        * -> Question 01) 에서 pop을 이용하여 우큰수가 될 수 없는 후보를 버리는 작업을 진행한다.
        * -> 따라서 worst case 의 경우 ( 숫자가 전부 내림차순으로 주어질 경우 : 5 4 3 2 1 )
        * -> O(N)의 복잡도로 문제를 해결함으로써 O(N^2) 의 시간복잡도가 나오는 것을 방지할 수 있다.
        * */
        int[] result = new int[N];
        int searchIdx = N - 1;
        Deque<Integer> dequeue = new ArrayDeque<>();

        while (searchIdx >= 0) {
            int now = numList[searchIdx];
            if (dequeue.isEmpty()) {
                result[searchIdx] = -1;
                dequeue.push(now);
                searchIdx--;
            } else {
                while (!dequeue.isEmpty()) {
                    int lastElt = dequeue.peek();
                    if (now < lastElt) {
                        // Case01
                        result[searchIdx] = lastElt;
                        dequeue.push(now);
                        searchIdx--;
                        break;
                    } else {
                        // now >= lastElt
                        // Case02
                        dequeue.pop();
                    }
                }
                if (dequeue.isEmpty()) {
                    result[searchIdx] = -1;
                    dequeue.push(now);
                    searchIdx--;
                }
            }
        }

        String resultValue = Arrays.stream(result).mapToObj(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(resultValue);
    }
}
