package pawg.is.awesome.concurrency;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;

public class ConcurrentMain {

    private static Runnable newRunnable(int limit) {
        return () -> {
            for (int i = 1; i <= limit; ++i) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                }
            }
            System.out.printf("Runnable [%s] with limit [%d] done.%n", Thread.currentThread().getName(), limit);
        };
    }

    private static <T> Callable<T> newRunnable(int limit, T object) {
        return  () -> {
            newRunnable(limit).run();
            System.out.println(object.toString());
            return object;
        };
    }

    public static void main(String[] args) throws InterruptedException {
        Set<Thread> threadSet = new HashSet<>();

        Thread platform = Thread.ofPlatform().start(newRunnable(10));
        threadSet.add(platform);

        Thread virtual = Thread.ofVirtual().start(newRunnable(11));
        threadSet.add(virtual);

        ThreadFactory factory = Thread.ofPlatform().name("pawg-", 1).factory();
        Thread threadF = factory.newThread(newRunnable(5));
        threadF.start();
        threadSet.add(threadF);

        while (threadSet.stream().anyMatch(Thread::isAlive)) {
            Thread.sleep(10);
        }
    }
}
