package org.study.review.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int left = 0;
        int right = n-1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == m) {
                count++;
                left++;
                right--;
            } else if (sum < m) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(count);
    }
}
