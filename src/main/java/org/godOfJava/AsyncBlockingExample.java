package org.godOfJava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncBlockingExample {
    public static void main(String[] args) {
        // ✅ 1. ExecutorService : 스레드 풀을 관리하는 객체 (단일 스레드 생성)
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // ✅ 2. 메인 스레드에서 비동기 작업을 요청
        System.out.println("📢 데이터 처리 요청 (비동기 실행)");

        // ✅ 3. 비동기적으로 데이터 처리 실행 (새로운 스레드에서 실행됨)
        Future<String> future = executor.submit(() -> {
            System.out.println("[작업 스레드] 데이터 처리 중... (5초 소요)");
            Thread.sleep(5000); // 5초 동안 Blocking 상태 (작업 진행 중)
            System.out.println("[작업 스레드] 데이터 처리 완료!");
            return "📊 데이터 처리 결과 반환!";
        });

        // ✅ 4. 메인 스레드는 비동기 요청 후 계속 실행됨
        System.out.println("⏳ 다른 작업 수행 중... (메인 스레드는 멈추지 않음)");

        try {
            // ✅ 5. future.get() 호출 시, 메인 스레드는 결과가 나올 때까지 Blocking (WAITING 상태)
            System.out.println("[메인 스레드] 데이터가 준비될 때까지 대기 중...");
            String result = future.get();  // **결과를 받아야 하는 순간 블로킹 발생**
            System.out.println("✅ 처리 완료: " + result);  // **결과를 받아서 활용 가능**
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // ✅ 6. Executor 종료 (더 이상 새로운 작업을 받지 않음)
        executor.shutdown();
    }
}