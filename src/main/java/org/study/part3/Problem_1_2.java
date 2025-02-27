package org.study.part3;

import java.util.Scanner;

public class Problem_1_2 {
    // 나의 풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int length = sc.nextInt();

        int[] scores = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            scores[i] = sc.nextInt();
            if (scores[i] > max) max = scores[i];
        }

        //
        double sum = 0.0;

        for (int i = 0; i < length; i++) {
            //  소수점으로 나누어 지기 때문에 소수 자료형 사용이 중요하다.
            sum += ((double) scores[i] / max) * 100.0;
        }
        System.out.println(sum/length);
    }

    // 책의 풀이
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] > max) max = A[i];
            sum = sum + A[i];
        }
        System.out.println(sum * 100.0 / max / N);
    }
}
