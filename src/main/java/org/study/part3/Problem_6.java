package org.study.part3;

import java.util.Scanner;

public class Problem_6 {
    public static void main(String[] args) {
        // 자연수 N 입력 받기
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();

        long sum = 1;
        // 마지막의 자기 자신을 포함?
        int count = 1;
        long startIndex = 1;
        long endIndex = 1;
        while (endIndex != N) {
            if (sum == N) {
                endIndex++;
                sum += endIndex;
                count++;
            } else if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else {
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(count);

    }
}
