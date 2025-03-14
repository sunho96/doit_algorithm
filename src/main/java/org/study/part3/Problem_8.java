package org.study.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 다른 두수의 합으로 표현되는 수가 있다면 count++;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isGoodNumber(arr, i, n)) count++;
        }

        System.out.print(count);
    }

    private static boolean isGoodNumber(int[] arr, int index, int n) {
        int target = arr[index];
        int left = 0;
        int right = n-1;

        while (left < right) {
            if (left == index) {
                left ++;
                continue;
            } else if (right == index) {
                right--;
                continue;
            }
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
