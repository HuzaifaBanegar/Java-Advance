package IntegerVsAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafetyDemo {
    // Shared normal integer (non-thread-safe)
    private static int normalCounter = 0;
    // Shared AtomicInteger (thread-safe)
    private static AtomicInteger atomicCounter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        // Number of threads and iterations
        int threadCount = 2;
        int iterations = 1000;
        // Demonstrating with normal integer
        runThreads(() -> normalCounter++, threadCount, iterations);
        System.out.println("Final value of normalCounter: " + normalCounter); // May vary
        // Demonstrating with AtomicInteger
        runThreads(() -> atomicCounter.incrementAndGet(), threadCount, iterations);
        System.out.println("Final value of atomicCounter: " + atomicCounter.get()); // Always correct
    }
    private static void runThreads(Runnable task, int threadCount, int iterations) throws InterruptedException {
        Thread[] threads = new Thread[threadCount];
        // create the threads as per threadCount and store in threads array
        for (int i = 0; i < threadCount; i++) {
            Runnable r = new MyRunnable(task, iterations);
            threads[i] = new Thread(r);
        }
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join(); // Wait for all threads to finish
    }
    static class MyRunnable implements Runnable {
        Runnable task;
        int iterations;
        public MyRunnable(Runnable task, int iterations) {
            this.task = task;
            this.iterations = iterations;
        }
        @Override
        public void run() {
            for (int j = 0; j < iterations; j++) {
                task.run();
            }
        }
    }
}