package org.study.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 표 크기 N, 질의 개수 M 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        // 2. 표 데이터 입력 받기
        int[][] table = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N ; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 2차원 누적 합 배열 만들기
        int[][] prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                prefixSum[i][j] = prefixSum[i][j-1] + prefixSum[i-1][j] - prefixSum[i-1][j-1] + table[i][j];
            }
        }

        // 5. 질의 처리 및 결과 저장 (출력 최적화)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 6, 부분 합 계산 (O(1)로 빠르게 구하기)
            int result = prefixSum[x2][y2] - prefixSum[x1 -1][y2] - prefixSum[x2][y1-1] + prefixSum[x1 -1][y1-1];

            System.out.println(result);
        }

    }
}
