package algorithm.part02.day12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main11724 {
    /**
     * 연결 요소의 개수
     * https://www.acmicpc.net/problem/11724
     * */
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        List<Integer> visit = new ArrayList<>(Collections.nCopies(N + 1, 0));

        // Node & Edge 구성 ( 무방향 그래프이므로 양쪽에 넣어주어야 함 )
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
        /**
         * [로직]
         * - dfs를 호출하면 해당 노드와 연결된 모든 노드를 방문한다. ( visit )
         * - 따라서 연결된 요소의 개수는 dfs의 호출 횟수와 동일하다.
         * */
        int searchCount = 0;
        for (int startNode = 1; startNode <= N; startNode++) {
            if (visit.get(startNode) == 0) {
                dfs(visit, edgeMap, startNode);
                searchCount += 1;
            }
        }
        System.out.println(searchCount);
    }

    private static void dfs(List<Integer> visit, Map<Integer, List<Integer>> edgeMap, int nowNode) {
        visit.set(nowNode, 1);

        if (edgeMap.containsKey(nowNode)) {
            List<Integer> connectedNodeList = edgeMap.get(nowNode);
            for (int nextNode : connectedNodeList) {
                if (visit.get(nextNode) == 0) {
                    dfs(visit, edgeMap, nextNode);
                }
            }
        }
    }
}
