package org.study.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_9 {
    // 슬라이딩 윈도우 기법(투 포인터)
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // DNA 문자열 길이
        int S = Integer.parseInt(st.nextToken());
        // 부분 문자열 길이
        int P = Integer.parseInt(st.nextToken());

        // DNA 문자열 배열
        char[] dna = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());
        // A C G T 최소 개수 조선 담는 배열
        int[] minCount = new int[4];
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(st.nextToken());
        }
        // 슬라이딩 윈도우 실행
        System.out.println(countValidSubstrings(dna, S, P, minCount));
    }

    private static int countValidSubstrings(char[] dna, int S, int P, int[] minCount) {
        int[] currentCount = new int[4]; // 현재 슬라이딩 윈도우에 등장하는 A C G T 의 개수를 저장하는 배열
        int result = 0;

        // 초기 윈도우 세팅
        // P : 부분 문자열 길이
        // 첫 P개의 문자에 대해 A C G T의 개수를 센다.
        for (int i = 0; i < P; i++) {
            addChar(currentCount, dna[i]);
        }

        // 첫번째 윈도우가 조건을 만족하는지 체크
        //currentCount : 현재 윈도우에 A C G T 개수를 저장한 배열
        // minCount : 문제에서 요구하는 A C G T 의 개수
        if (isValid(currentCount, minCount)) result++;

        // 슬라이딩 윈도우 이동 (한칸씩 업데이트)
        for (int i = P; i < S; i++) {
            // 한칸씩 오른쪽으로 이동하면서
            // 충족되는지 확인
            addChar(currentCount, dna[i]); // 새로 추가된 문자
            removeChar(currentCount, dna[i-P]); // 이전 윈도우에서 빠지는 문자

            if (isValid(currentCount, minCount)) result++;
        }

        return result;
    }

    private static void addChar(int[] count, char c) {
        switch (c) {
            case 'A' : count[0]++; break;
            case 'C' : count[1]++; break;
            case 'G' : count[2]++; break;
            case 'T' : count[3]++; break;
        }
    }

    private static void removeChar(int[] count, char c) {
        switch (c) {
            case 'A': count[0]--; break;
            case 'C': count[1]--; break;
            case 'G': count[2]--; break;
            case 'T': count[3]--; break;
        }
    }

    private static boolean isValid(int[] current, int[] min) {
        for (int i = 0; i < 4; i++) {
            // 현재 슬라이딩 윈도우에 최소 충족 수보다 작으면 false 리턴
            if (current[i] < min[i]) return false;
        }

        return true;
    }
}
