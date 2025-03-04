package org.godOfJava;

public class SyncNonBlockingExample {
    public static void main(String[] args) {
        System.out.println("📢 요청을 보냄: 데이터 준비 시작 (하지만 기다리지 않음)");

        prepareData(); // 즉시 반환되기 때문에 메인 스레드는 아래 출력 코드 실행

        System.out.println("📢 메인 스레드는 계속 실행됨: 다른 작업 수행 중...");

        // 데이터를 기다리지 않고 바로 다음 코드 실행 (Non-Blocking)
        System.out.println("📢 메인 스레드 종료!");
    }

    // 데이터를 비동기적으로 준비 (메인 스레드를 블로킹하지 않음)
    public static void prepareData() {
        new Thread(() -> {
            try {
                Thread.sleep(3000); // 3초 동안 데이터 준비 (Blocking 작업)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("✅ 데이터 준비 완료! 이제 사용 가능.");
        }).start();
    }
}
