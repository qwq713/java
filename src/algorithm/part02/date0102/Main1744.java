package algorithm.part02.date0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());

        List<Integer> negativeNumList = new ArrayList<>();
        List<Integer> positiveNumList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(stk.nextToken());
            if (num > 0) {
                positiveNumList.add(num);
            } else {
                negativeNumList.add(num);
            }
        }

        int result = mulSum(positiveNumList, true) + mulSum(negativeNumList, false);
        System.out.println(result);


    }

    public static int mulSum(List<Integer> numList, boolean positive) {

        int result = 0;
        if (positive) {
            Collections.sort(numList, (n1, n2) -> n2 - n1);
        } else {
            Collections.sort(numList);
        }

        while (!numList.isEmpty() && numList.get(numList.size() - 1) == 1) {
            result += 1;
            numList.remove(numList.size() - 1);
        }

        int len = numList.size();

        if (len % 2 == 1) {
            int remove = numList.remove(len - 1);
            result += remove;
        }

        int idx = 0;
        len = numList.size();
        while (idx < len) {
            result += (numList.get(idx) * numList.get(idx + 1));
            idx += 2;
        }
        return result;
    }
}
