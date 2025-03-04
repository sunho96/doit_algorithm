package org.godOfJava;

public class SyncBlockingExample {
    public static void main(String[] args) {
        System.out.println("작업 시작...");

        // fetchData()가 실행 완료될 때까지 대기 (Blocking)
        // 즉, 이 함수가 완료되기 전까지 다음 줄의 코드는 실행되지 않는다.
        // => 동기(Synchronous)
        String result = fetchData();

        // fetchData()가 완료된 후 실행됨
        System.out.println("받은 데이터: " + result);

        System.out.println("작업 완료!");
    }

    public static String fetchData() {
        try {
            // 현재 스레드가 2초 동안 멈춤 (Blocking 발생)
            // 즉, CPU가 다른 작업을 수행하지 못하고 2초 동안 아무 일도 하지 않는 상태가 된다.
            // => 블로킹(Blocking)
            System.out.println("데이터를 가져오는 중...(2초 대기)");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 2초 대기 후 반환됨
        return "동기 + 블로킹 작업 완료";
    }
}