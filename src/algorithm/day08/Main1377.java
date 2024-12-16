package algorithm.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 버블소트
 * https://www.acmicpc.net/problem/1377
 */
class Elem {

    public Elem(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    public int idx;
    public int value;
}

public class Main1377 {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        List<Elem> numList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            numList.add(new Elem(i, value));
        }

        /**
         * [로직]
         * - 버블소트는 다음의 특징을 갖는다.
         * 1. 버블이 한번 수행될때 가장 큰 수가 가장 오른쪽으로 간다.
         * 2. 가장 큰 수를 제외하고 나머지 수는 본인의 자리를 찾기 위해 왼쪽으로 **1회** 만 이동 가능하다.
         *
         * 즉 본인의 자리를 찾기 위해 왼쪽으로 K번 이동이 필요한 경우 버블은 K번 수행되어야 한다.
         * 따라서 본인의 자리를 찾기 위해 최대 K번 이동이 필요한 경우 K+1 이 정답이다. ( 정렬이 완료되면 검증을 위해 한번 더 수행하므로 )
         *
         * 그러면 K번이 최대로 이동이 필요한 수일 때. K번보다 더 많은 버블이 수행해야될 경우는 없는가 ?
         * -> K번을 이동하면 본인의 자리를 찾는다는 의미이다. 따라서 K번 보다 더 많이 수행되야 할 이유가 없다.
         *
         * */
        numList.sort(Comparator.comparingInt(o -> o.value));
        int result = 0;
        for (int i = 0; i < N; i++) {
            int originIdx = numList.get(i).idx;
            result = Math.max(result, originIdx - i);
        }
        System.out.println(result + 1);
    }
}
