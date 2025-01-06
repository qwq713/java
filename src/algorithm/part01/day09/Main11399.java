package algorithm.part01.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main11399 {
    /**
     * 돈을 뽑는데 걸리는 시간 : sum(p1 ~ pi)
     * 총 돈을 뽑는데 걸리는 시간 : i=1 ~ N : sum((p1 ~ pi))
     *
     * [로직]
     * 총 돈을 뽑는데 걸리는 시간을 최소로 하기 위해서는 sum(p1 ~ pi)를 최소화 해야한다.
     * 따라서 가장 작은 수부터 오름차순으로 정렬 후 sum(p1 ~ pi)를 순서대로 구해야만
     * sum(p1~pi)를 최소화 할 수 있다.
     * -> 글로 풀어서 설명한다면 다음과 같다.
     * -> 한번 대기시간에 포함된 수는 마지막 대기하는 사람의 시간에도 포함된다. ( 누적된다 )
     * -> 따라서 대기시간이 적은 사람을 먼저 인출 / 긴사람은 뒤에 위치시켜야
     * -> 짧은 대기시간이 오래 누적되고 긴 대기시간은 조금 누적된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        List<Integer> numList = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numList.add(Integer.parseInt(stk.nextToken()));
        }

        numList.sort((Comparator.comparingInt(o -> o)));

        int result = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += numList.get(i);
            result += sum;
        }
        System.out.println(result);
    }
}
