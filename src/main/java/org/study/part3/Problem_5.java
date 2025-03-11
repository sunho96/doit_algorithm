package org.study.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem_5 {
    public static void main(String[] args) throws IOException {

        // 빠른 입력을 위한 BufferedReader 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 배열 크기 N과 나누는 수 M을 입력받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 숫자 배열 A를 입력받기 위해서 다시 초기화
        st = new StringTokenizer(br.readLine());

        // modCount 배열:
        // modCount[i]: 누적합을 M으로 나눈 나머지가 i인 경우가 지금까지 몇 번 나왔는지 세는 배열
        // m 으로 범위를 설정한 이유 : 5로 나누었을 때 나머지로 나올 수 있는 수는 0,1,2,3,4
        // 4로 나누었을 때 나올 수 있는 수는 0,1,2,3 중 하나이다. 그래서 배열의 크기를 m으로 지정했다.
        long[] modCount = new long[m];

        long sum = 0; // 누적합을 저장할 변수 (계속 숫자를 더해서 사용)
        long answer = 0; // 정답을 저장할 변수 (부분합이 M의 배수인 경우의 개수)

        // 배열을 앞에서부터 순회하면서 누적합 계산
        for (int i = 0; i < n; i++){

            // 숫자를 하나 입력받아 누적합(sum)에 계속 더해줌
            sum += Long.parseLong(st.nextToken());

            // 현재 누적합을 M으로 나눈 나머지를 mod 변수에 저장
            int mod = (int)(sum % m);

            // ⭐ 만약 누적합의 나머지가 이미 0이면 (즉, 처음부터 여기까지 자체가 M의 배수라면)
            // 바로 정답을 하나 추가 (자기 자신이 조건을 만족하니까)
            // 0이면 m으로 나누어 떨어진다는 것이니깐 answer++;
            if(mod == 0) answer++;

            // ⭐ 이전까지 같은 나머지가 나왔던 횟수(modCount[mod])를 answer에 추가
            // (중요!) 이게 가능한 이유는 같은 나머지끼리 빼면 무조건 M의 배수가 되기 때문!
            answer += modCount[mod];

            // ⭐ 현재 누적합의 나머지가 등장한 횟수를 1 증가시킴
            modCount[mod]++;
        }

        // 최종적으로 구해진 경우의 수(정답)를 출력
        System.out.println(answer);
    }
}
