package algorithm.part02.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main1260 {
    /**
     * DFS와 BFS
     * https://www.acmicpc.net/problem/13023
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 정점의 개수
        int N = Integer.parseInt(stk.nextToken());
        // 간선의 개수
        int M = Integer.parseInt(stk.nextToken());
        // 탐색 시작 정점
        int V = Integer.parseInt(stk.nextToken());

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
        for (Integer key : edgeMap.keySet()) {
            Collections.sort(edgeMap.get(key));
        }

        List<Boolean> dfsVisit = new ArrayList<>(Collections.nCopies(N + 1, false));
        List<Boolean> bfsVisit = new ArrayList<>(Collections.nCopies(N + 1, false));

        /**
         * [로직]
         * -  주어진 수대로 DFS , BFS 를 구현한다.
         * */
        dfs(edgeMap, dfsVisit, V);
        System.out.println();
        bfs(edgeMap, bfsVisit, V);
    }

    private static void dfs(Map<Integer, List<Integer>> edgeMap, List<Boolean> visit, int nowEdge) {

        if (visit.get(nowEdge)) {
            return;
        }

        visit.set(nowEdge, true);
        System.out.print(nowEdge + " ");

        List<Integer> nextEdgeList = edgeMap.getOrDefault(nowEdge, new ArrayList<>());
        if (!nextEdgeList.isEmpty()) {
            for (int nextEdge : nextEdgeList) {
                if (!visit.get(nextEdge)) {
                    dfs(edgeMap, visit, nextEdge);
                }
            }
        }
    }

    private static void bfs(Map<Integer, List<Integer>> edgeMap, List<Boolean> visit, int startEdge) {

        if (visit.get(startEdge)) {
            return;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        visit.set(startEdge, true);
        System.out.print(startEdge + " ");
        queue.add(startEdge);

        while (!queue.isEmpty()) {
            Integer nowEdge = queue.poll();
            List<Integer> nextEdgeList = edgeMap.getOrDefault(nowEdge, new ArrayList<>());
            if (!nextEdgeList.isEmpty()) {
                for (int nextEdge : nextEdgeList) {
                    if (!visit.get(nextEdge)) {
                        visit.set(nextEdge, true);
                        System.out.print(nextEdge + " ");
                        queue.add(nextEdge);
                    }
                }
            }
        }
    }
}
