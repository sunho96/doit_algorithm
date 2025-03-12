package org.study.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름 차순 정렬
        Arrays.sort(arr);
        int i = 0;
        int j = N - 1;

        int count = 0;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == M) {
                count++;
                i++;
                j--;
            } else if (sum < M) {
                i++;
            } else {
                j--;
            }
        }
        System.out.print(count);
    }
}
