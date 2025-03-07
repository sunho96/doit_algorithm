package org.study.part3;

import java.util.Scanner;

public class Problem_5 {
    public static void main(String[] args) {
        // 나머지 합 구하기, 구간합
        // 연속된 숫자들의 합이 특정 숫자(M)로 나누어 떨어지는 경우를 찾는 프로그램
        // (부분합 % M == 0) 이 되는 경우의 수 찾기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 받는 숫자의 개수
        int M = sc.nextInt(); // 나누는 값
        long[] S = new long[N]; // 누적합을 저장하는 배열, 각 숫자까지의 합을 저장
        long[] C = new long[M]; // 나머지 개수를 저장하는 배열 , 니머지가 같은 개수를 저장
        long answer = 0; // 정답을 저장할 변수, 나누어 떨어지는 경우의 수 저장
        S[0] = sc.nextInt();

        for (int i = 1; i < N; i++) {
            // 누적 합 배열 생성
            S[i] = S[i -1] + sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M); // 누적합을 M 으로 나눈 나머지

            if (remainder == 0) answer++; // 나머지가 0아면 정답 개수 증가

            C[remainder]++; // 해당 나머지 개수 증가

        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] -1) / 2 );
            }
        }
        System.out.println(answer);
    }
}
