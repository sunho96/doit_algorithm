package org.study.review.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2차원 배열 선언
       /* long[][] S = new long[N+1][N+1];
        for (int i =1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
*/
        // 2차원 합배열 생성
        long[][] table = new long[N+1][N+1];
        for (int i =1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= N; j++) {
                // S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j]
                int value = Integer.parseInt(st.nextToken());
                table[i][j] = table[i][j-1] + table[i-1][j] - table[i-1][j-1] + value;
            }
        }

        // 2차원 배열 구간합
        for (int i = 0; i < M; i++) {
            // =[x2]][y2] - [x1 -1][y2] - [x2][y1-1] -[x1-1][y1-1]
            st = new StringTokenizer(bf.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            System.out.println(table[x2][y2] - table[x1 -1][y2] - table[x2][y1-1] + table[x1-1][y1-1]);
        }
    }
}
