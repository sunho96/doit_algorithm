package org.study.part3;

import java.util.Scanner;

public class Problem_1 {

    public static void main(String[] args) {
        // 1. Scanner 객체를 생성해 키보드 입력을 받을 준비를 한다.
        Scanner scanner = new Scanner(System.in);
        // 2. 사용자가 입력한 값을 int 타입으로 반환하여 N에 저장한다.
        int N = scanner.nextInt();
        // 3. 사용자가 입력한 값을 String 타입으로 반환하여 sNum에 저장한다.
        // next() 메서드를 호출하면 사용자는 콘솔에 입력할 수 있다.
        // Scanner.next() : 사용자가 입력할 때까지 프로그램이 대기하면 사용자가 입력한 값 중 첫번째 뛰어쓰기, 엔터를
        // 이전의 단어를 읽는다. 즉 한단어를 입력받는데 사용된다.
        String sNum = scanner.next();
        // 4. 입력받은 문자열을 char 배열로 변환한다.
        // toCharArray() : 문자열을 구성하는 문자를 char 배열로 변환하는 메서드
        char[] cNum = sNum.toCharArray();

        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            // char 에 + '0'을 하면 int 로 변환된다.
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}
