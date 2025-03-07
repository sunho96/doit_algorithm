package org.study.review;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_3 {
    public static void main(String[] args) throws IOException {
        // 입력을 두번 받아야함
        // N : 배열 갯수
        // M : 구간합 구할 횟수
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N+1];

        st = new StringTokenizer(bf.readLine());

        // 구간합을 바로 구하기
        for (int i = 1; i <= N; i++ ) {
            // S[i] = s[i-1] + a[i];
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }

        // 여기 위치에 있으면 한 줄만 읽는다.
        // st = new StringTokenizer(bf.readLine());
        // 구간합 질의
        for (int i =0; i < M; i++ ) {
            st = new StringTokenizer(bf.readLine());
            // = S[j] - S[i-1]
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(S[b] - S[a-1]);
        }




    }
}
