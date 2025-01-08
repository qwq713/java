package algorithm.part02.date0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1934 {
    /**
     * 최소공배수
     * https://www.acmicpc.net/problem/1934
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int firstNum = Integer.parseInt(stk.nextToken());
            int secondNum = Integer.parseInt(stk.nextToken());

            int gcd = calculateGcd(firstNum,secondNum);
            int lcm = firstNum * secondNum / gcd;
            System.out.println(lcm);
        }
    }

    public static int calculateGcd(int firstNum, int secondNum) {
        if (firstNum > secondNum) {
            int temp = firstNum;
            firstNum = secondNum;
            secondNum = temp;
        }

        int remainder = -1;

        while(remainder != 0){
            remainder = secondNum % firstNum;
            secondNum = firstNum;
            firstNum = remainder;
        }

        return secondNum;
    }
}
