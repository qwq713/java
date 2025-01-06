package algorithm.part01.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12891 {
    private static int TYPE_COUNT = 4;
    private static int A = 0;
    private static int C = 1;
    private static int G = 2;
    private static int T = 3;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        // 임의로 만든 문자열 길이
        int S = Integer.parseInt(stk.nextToken());

        // 비밀번호로 사용할 문자열 길이
        int P = Integer.parseInt(stk.nextToken());

        String dnaString = new StringTokenizer(br.readLine()).nextToken();

        stk = new StringTokenizer(br.readLine());
        int[] minACGT = new int[TYPE_COUNT];
        minACGT[A] = Integer.parseInt(stk.nextToken());
        minACGT[C] = Integer.parseInt(stk.nextToken());
        minACGT[G] = Integer.parseInt(stk.nextToken());
        minACGT[T] = Integer.parseInt(stk.nextToken());

        int result = 0;
        int[] countACGT = new int[TYPE_COUNT];
        for (int i = 0; i < P; i++) {
            addOrRemoveChar(countACGT, dnaString.charAt(i), true);
        }
        if (isVaildDNA(countACGT, minACGT)) {
            result++;
        }

        for (int i = P; i < S; i++) {
            addOrRemoveChar(countACGT, dnaString.charAt(i), true);
            addOrRemoveChar(countACGT, dnaString.charAt(i - P), false);
            if (isVaildDNA(countACGT, minACGT)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static void addOrRemoveChar(int[] ACGT, char c, boolean add) {
        int addnum = add ? 1 : -1;
        switch (c) {
            case 'A':
                ACGT[A] += addnum;
                break;
            case 'C':
                ACGT[C] += addnum;
                break;
            case 'G':
                ACGT[G] += addnum;
                break;
            case 'T':
                ACGT[T] += addnum;
                break;
            default:
                break;
        }
    }

    private static boolean isVaildDNA(int[] countACGT, int[] minACGT) {
        for (int i = A; i <= T; i++) {
            if (countACGT[i] < minACGT[i]) {
                return false;
            }
        }
        return true;
    }
}