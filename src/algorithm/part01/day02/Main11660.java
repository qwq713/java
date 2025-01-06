package algorithm.part01.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 표의 크기 ( N )
        int N = Integer.parseInt(stk.nextToken());

        // 합 구하는 개수 ( Query )
        int M = Integer.parseInt(stk.nextToken());

        // sumMap := (1,1) ~ (x,y) 직사각형 범위의 합
        int[][] sumMap = new int[N + 1][N + 1];

        for (int x = 1; x <= N; x++) {
            stk = new StringTokenizer(br.readLine());
            for (int y = 1; y <= N; y++) {
                sumMap[x][y] = sumMap[x - 1][y] + sumMap[x][y - 1] - sumMap[x - 1][y - 1] + Integer.parseInt(stk.nextToken());
            }
        }


        for (int query = 0; query < M; query++) {
            stk = new StringTokenizer(br.readLine());

            /**
             * (결과)   = (x1,y1)   ~   (x2,   y2)    직사각형 범위의 합
             * (1)      = (0,0)     ~   (x2,   y2)    직사각형 범위
             * (2)      = (0,0)     ~   (x1-1, y2)    직사각형 범위 (왼쪽 직사각형)
             * (3)      = (0,0)     ~   (x2,   y1-1)  직사각형 범위 (위 직사각형)
             * (4)      = (0,0)     ~   (x2,   y2)    직사각형 범위 (좌측 위 직사각형)
             *
             * (결과) = (1) - (2) - (3) + (4)
             *
             * */

            int x1 = Integer.parseInt(stk.nextToken());
            int y1 = Integer.parseInt(stk.nextToken());

            int x2 = Integer.parseInt(stk.nextToken());
            int y2 = Integer.parseInt(stk.nextToken());

            System.out.println(sumMap[x2][y2] - sumMap[x1 - 1][y2] - sumMap[x2][y1 - 1] + sumMap[x1 - 1][y1 - 1]);
        }
    }
}
