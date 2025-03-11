package org.study.review.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 누적합과 답의 범위가 int를 벗어나기 때문에 long으로 선언해야한다.
        long sum = 0;
        long answer = 0;
        int[] modArray = new int[m];

        st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            sum += Long.parseLong(st.nextToken());

            int mod = (int)(sum % m);

            if (mod < 0) mod += m;

            if(mod == 0) answer++;

            answer+= modArray[mod];

            modArray[mod]++;
        }
        System.out.println(answer);
    }
}
