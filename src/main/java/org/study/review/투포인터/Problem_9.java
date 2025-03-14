package org.study.review.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 전체 DNA 배열 길이 수
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        char[] dna = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());
        int[] minCount = new int[4];
        for (int i = 0; i < 4 ; i++) {
            minCount[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(getCount(S, P, dna, minCount));

    }

    private static int getCount(int S, int P, char[] dna, int[] minCount) {
        int result = 0;
        int[] currentCount = new int[4];

        for (int i = 0; i < P; i++) {
            addCount(currentCount, dna[i]);
        }

        if (isValid(currentCount, minCount)) result++;

        // 스라이팅 윈도우 하나씩 옮기기
        for (int i = P; i < S; i++) {
            addCount(currentCount, dna[i]);
            removeCount(currentCount, dna[i-P]);

            if (isValid(currentCount, minCount)) result++;
        }

        return result;
    }

    private static void addCount(int[] currentCount, char i) {
        switch (i) {
            case 'A' : currentCount[0]++;break;
            case 'C' : currentCount[1]++;break;
            case 'G' : currentCount[2]++;break;
            case 'T' : currentCount[3]++;break;
        }
    }

    private static boolean isValid(int[] currentCount, int[] minCount) {
        for (int i = 0; i < 4 ; i++) {
            if (currentCount[i] < minCount[i]) return false;
        }

        return true;
    }
    private static void removeCount(int[] currentCount, char i) {
        switch (i) {
            case 'A' : currentCount[0]--;break;
            case 'C' : currentCount[1]--;break;
            case 'G' : currentCount[2]--;break;
            case 'T' : currentCount[3]--;break;
        }
    }
}
