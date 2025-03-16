package org.study.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 배열의 길이
        int N = Integer.parseInt(st.nextToken());
        // 부분 배열 길이
        int L =  Integer.parseInt(st.nextToken());

        // 전체 배열
        int[] array = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Deque<int[]> deque = new LinkedList<>(); // {값, 인덱스} 저장

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            // 1️⃣ 범위를 벗어난 값 제거 (윈도우 크기 `L` 유지)
            while (!deque.isEmpty() && deque.peekFirst()[1] < i - L + 1) {
                // 첫번째꺼 제거
                deque.pollFirst();
            }
            // 2️⃣ 현재 값보다 큰 값들은 제거 (작은 값만 유지)
            // deque.peekLast()[0] -> 덱 내 가장 마지막의 값이 현재 array의 값보다 크면 제거
            while (!deque.isEmpty() && deque.peekLast()[0] > array[i]) {
                // 마지막 제거
                deque.pollLast();
            }

            // 3️⃣ 현재 값 삽입 - 덱의 끝에 원소를 추가
            deque.offerLast(new int[]{array[i], i});
            // 4️⃣ 덱의 첫 번째 원소가 현재 윈도우의 최솟값
            sb.append(deque.peekFirst()[0]).append(" ");

        }

    }

}
