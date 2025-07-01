package awesome.pawg;

import awesome.pawg.cache.CacheExample;
import awesome.pawg.events.LogErrorEvent;
import awesome.pawg.events.LogEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

        eventCasting(ctx);

        cacheExample(ctx);

        System.exit(0);
    }

    //TODO: 11. Async processing vs event casting
    private static void eventCasting(AnnotationConfigApplicationContext ctx) {
        LogEvent log = new LogEvent(Main.class.getName(), "Hello Async event!");
        LogErrorEvent error = new LogErrorEvent(Main.class.getName(), "Error Async event!");

        ApplicationEventMulticaster caster = ctx.getBean(ApplicationEventMulticaster.class);
        caster.multicastEvent(log); // == ctx.getBean(AsyncEventListener.class).asyncLog(log);
        caster.multicastEvent(error); // == ctx.getBean(AsyncEventListener.class).asyncLog(error);
    }

    //TODO: 7. Cache mistake
    private static void cacheExample(ApplicationContext ctx) throws InterruptedException {
        CacheExample cacheExample = ctx.getBean(CacheExample.class);
        int counter = 0;
        System.out.printf("counter %d returned %d value%n", counter, cacheExample.getCounter(counter));
        do {
            Thread.sleep(1000);
            counter++;
            System.out.printf("waited %d seconds%n", counter);
            System.out.printf("counter %d returned %d value%n", counter, cacheExample.getCounter(counter));
        } while (counter < 5);

        System.out.println("Cache validation");
        for (int i = 0; i <= counter; i++) {
            System.out.printf("counter %d returned %d value%n", i, cacheExample.getCounter(i));
        }

        System.out.println("Here is typical mistake");
        cacheExample.typicalMistake();

        System.out.println("Here is proper way");
        cacheExample.properWay();
    }

}