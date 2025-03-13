package org.study.review.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_6 {
    public static void main(String[] args) throws IOException {
        // 자연수 N 입력받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int count = 0;
        int start_num = 1;
        int end_num = 1;
        int sum = 1;

        while (end_num <= N) {
            // 투포인터 원리
            if (sum == N) {
                count++;
                sum-=start_num;
                start_num++;
            } else if (sum < N) {
                end_num++;
                sum+=end_num;
            } else {
                sum-=start_num;
                start_num++;
            }
        }

        System.out.print(count);
    }
}
