package algorithm.part01.day09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        String N = stk.nextToken();
        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < N.length(); i++) {
            char c = N.charAt(i);
            numList.add(Character.getNumericValue(c));
        }

        numList.sort((o1, o2) -> o2 - o1);
        numList.stream().forEach(System.out::print);
    }
}
