package org.godOfJava;

import java.util.concurrent.CompletableFuture;

public class AsyncNonBlockingExample {
    public static void main(String[] args) {
        System.out.println("📢 데이터 처리 요청 (비동기 실행)");

        // ✅ 1. 논블로킹 방식으로 데이터 처리
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("[작업 스레드] 데이터 요청 중... (논블로킹)");
            fakeNonBlockingIO();
            System.out.println("[작업 스레드] 데이터 요청 완료! (다른 작업 가능)");
        });

        // ✅ 2. 메인 스레드는 논블로킹으로 즉시 반환됨 (다른 작업 수행 가능)
        for (int i = 0; i < 10; i++) {
            System.out.println("💼 메인 스레드는 계속 실행 중... " + i);
            try {
                Thread.sleep(500); // 메인 스레드는 멈추지 않음
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // ✅ 3. 논블로킹 작업 완료 후 결과 처리
        future.thenRun(() -> {
            System.out.println("✅ 비동기 작업 완료! 결과 처리 중...");
        });

        System.out.println("🎉 메인 스레드 작업 종료!");
    }

    // ✅ 논블로킹 I/O 작업을 흉내내는 함수
    private static void fakeNonBlockingIO() {
        new Thread(() -> {
            System.out.println("[네트워크 스레드] 서버에서 데이터 가져오는 중... (5초)");
            try {
                Thread.sleep(5000); // 비동기적으로 실행 (메인 스레드에 영향 없음)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[네트워크 스레드] 데이터 준비 완료!");
        }).start();
    }
}