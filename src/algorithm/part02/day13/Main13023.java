package algorithm.part02.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main13023 {
    /**
     * ABCDE
     * https://www.acmicpc.net/problem/13023
     */

    public static int result = 0;

    public static void main(String[] args) throws IOException {
        // 입력값 받기

        /**
         * [로직]
         * 노드의 순서에 상관없이 a1 -> a2 -> a3 -> a4 -> a5
         *
         * 이렇게 5개가 이어져있기만 하면 1 그외에 0을 출력하는 문제이다.
         *
         * 처음 접근했을때 특정 노드로부터 전체가 다 이어져있어야 하는줄 알고 삽질을 많이 했다..
         *
         * 문제에서 사용되는 depth가 N일 필요 없이 5이면 되니 참고하자. 문제 설명이 정말 개판;
         *
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();

        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());

            if (!edgeMap.containsKey(u)) {
                edgeMap.put(u, new ArrayList<>());
            }

            if (!edgeMap.containsKey(v)) {
                edgeMap.put(v, new ArrayList<>());
            }

            edgeMap.get(u).add(v);
            edgeMap.get(v).add(u);
        }


        for (int startEdge = 0; startEdge < N; startEdge++) {
            List<Boolean> visit = new ArrayList<>(Collections.nCopies(N, false));
            dfs(edgeMap, visit, startEdge, 1);
        }
        System.out.println(result);
//        System.out.println(allConnected ? 1 : 0);
    }

    private static void dfs(Map<Integer, List<Integer>> edgeMap, List<Boolean> visit, int nowEdge, int depth) {

        if (depth == 5 || result == 1) {
            result = 1;
            return;
        }

        visit.set(nowEdge, true);

        List<Integer> nextEdgeList = edgeMap.getOrDefault(nowEdge, new ArrayList<>());

        if (!nextEdgeList.isEmpty()) {
            for (int nextEdge : nextEdgeList) {
                if (!visit.get(nextEdge)) {
                    dfs(edgeMap, visit, nextEdge, depth + 1);
                }
            }
        }
        visit.set(nowEdge, false);
    }
}
