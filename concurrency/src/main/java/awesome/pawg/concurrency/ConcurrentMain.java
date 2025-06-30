package awesome.pawg.concurrency;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

public class ConcurrentMain {

    private static Runnable newRunnable(int limit, Object msg) {
        return () -> {
            LocalDateTime start = LocalDateTime.now();
            for (int i = 1; i <= limit; ++i) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
            System.out.printf("'%s' [%s] with limit [%d] done in [%ds].%n", msg,
                    Thread.currentThread().getName(), limit, Duration.between(start, LocalDateTime.now()).toSeconds());
        };
    }

    private static <T> Callable<T> newCallable(int limit, T object) {
        return  () -> {
            newRunnable(limit, object).run();
            return object;
        };
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("===================Tredy sie miesajo =============");
        threadExample();
        System.out.println("===================Fjuczery sie miesajo ==========");
        futureExample();
        System.out.println("===================Egzeqtory sie miesajo =======================");
        executorExample();
        System.exit(1);
    }

    private static void threadExample() throws InterruptedException {
        Set<Thread> threadSet = new HashSet<>();

        Thread platform = Thread.ofPlatform().start(newRunnable(10, "Runnable"));
        threadSet.add(platform);

        Thread virtual = Thread.ofVirtual().start(newRunnable(15, "Runnable"));
        threadSet.add(virtual);

        ThreadFactory factory = Thread.ofPlatform().name("pawg-", 1).factory();
        Thread threadF = factory.newThread(newRunnable(5, "Runnable"));
        threadF.start();
        threadSet.add(threadF);

        while (threadSet.stream().anyMatch(Thread::isAlive)) {
            Thread.sleep(10);
        }
    }

    private static void futureExample() throws InterruptedException {
        /// Future does not start automatically. Either get (run from FutureTask) or just submit the runnable manually.
        Thread start = Thread.ofPlatform().daemon().start(new FutureTask<>(newCallable(15, "Future callable i Jolo")));
        Thread start1 = Thread.ofPlatform().daemon().start(new FutureTask<>(newRunnable(5, "Future runnable i Jolo"), "Future runnable i Jolo"));
        while (start.isAlive() || start1.isAlive()) {
            Thread.sleep(1000);
        }
    }

    private static void executorExample() {
        Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executor.execute(newRunnable(4, "Executor"));

        try (ExecutorService executorService = Executors.newCachedThreadPool(Thread.ofPlatform().name("cached-", 1).factory())) {
            List<Future<String>> futures = executorService.invokeAll(List.of(
                    newCallable(10, "ExecutorService 10"),
                    newCallable(20, "ExecutorService 20"),
                    newCallable(30, "ExecutorService 30")
            ));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
