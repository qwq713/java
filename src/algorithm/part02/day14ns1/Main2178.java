package algorithm.part02.day14ns1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int goalY = -1;
    static int goalX = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        goalY = Integer.parseInt(stk.nextToken());
        goalX = Integer.parseInt(stk.nextToken());

        int[][] map = new int[goalY][goalX];
        int[][] visit = new int[goalY][goalX];

        for (int y = 0; y < goalY; y++) {
            String line = new StringTokenizer(br.readLine()).nextToken();
            for (int x = 0; x < goalX; x++) {
                map[y][x] = Integer.parseInt(line.charAt(x) + "");
            }
        }

        goalY -= 1;
        goalX -= 1;


        Queue<Pair> queue = new ArrayDeque<>();

        Pair start = new Pair(0, 0, 1);
        visit[0][0] = 1;

        queue.add(start);

        while (!queue.isEmpty()) {
            Pair now = queue.poll();

            if (now.y == goalY && now.x == goalX) {
                System.out.println(now.step);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];
                int nextStep = now.step + 1;

                if (nextY < 0 || nextX < 0 || nextY > goalY || nextX > goalX) {
                    continue;
                }

                if(map[nextY][nextX] == 0 ){
                    continue;
                }

                if (visit[nextY][nextX] == 0) {
                    visit[nextY][nextX] = 1;
                    Pair next = new Pair(nextY, nextX, nextStep);
                    queue.add(next);
                }
            }

        }
    }
}

class Pair {
    int y;
    int x;
    int step;

    public Pair(int y, int x, int step) {
        this.y = y;
        this.x = x;
        this.step = step;
    }
}
