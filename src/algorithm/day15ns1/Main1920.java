package algorithm.day15ns1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        Set<Integer> nSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nSet.add(Integer.parseInt(stk.nextToken()));
        }

        stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stk.nextToken());
            if(nSet.contains(num)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }
}
