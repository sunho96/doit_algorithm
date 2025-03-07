package org.study.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_3 {
    public static void main(String[] args) throws IOException {
        // BufferedReader : 키보드에서 입력을 받을 때 사용하는 클래스
        // System.in 을 이용해서 키보드 입력을 받음
        // InputStreamReader 를 이용해 바이트 스트림을 문지 스트림으로 변환 (역직렬화)
        // BufferedReader 는 Scanner 보다 속도가 빠르고 한 줄 단위로 읽을 수 있다.
        // 받는 데이터가 많을 경우 Scanner 보다 BufferedReader 를 쓰는 것이 좋다 더 빠르다.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // bufferedReader.readLine() : 한줄을 입력 받음
        // StringTokenizer : 입력된 문자열을 공백 단위로 나누는 클래스
        // 한줄에 길게 데이터를 받을 때는 int로 받기 어려워서 StringTokenizer 사용해서 값을 분리해서 사용한다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());
        // 습관적으로 숫자형 데이터를 다룰 때는 Long으로 다루는 것이 좋다.
        // 문제에서 1부터 세기 때문에 0번째 인덱스를 무시하고 질의를 바로 받아서 쓰고자 +1 을 했다.
        long[] S = new long[suNo + 1];

        // 한줄로 받을 때 StringTokenizer 사용
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 합 배열 저장 로직
        // 0번째 index 는 신경 안쓰고 진행하고 싶어서 1 부터 진행
        for (int i = 1; i <= suNo; i++) {
            // 구간합 저장
            S[i] = S[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            // 합배열에서 구간합을 구하는 공식
            System.out.println(S[j] - S[i-1]);
        }
    }

    // me
    public static void main2(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int length = Integer.parseInt(stringTokenizer.nextToken());
        int quNo = Integer.parseInt(stringTokenizer.nextToken());

        long[] array = new long[length +1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= length; i++) {
            array[i] = array[i - 1] + Integer.parseInt(stringTokenizer.nextToken());
        }


        for (int n = 0; n < quNo; n++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());

            System.out.println(array[j] - array[i -1]);
        }

    }

}
