package awesome.pawg;

import awesome.pawg.events.LogErrorEvent;
import awesome.pawg.events.LogEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LogEvent log = new LogEvent(Main.class.getName(), "Hello Async event!");
        LogErrorEvent error = new LogErrorEvent(Main.class.getName(), "Error Async event!");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        ApplicationEventMulticaster caster = ctx.getBean(ApplicationEventMulticaster.class);

        caster.multicastEvent(log); // == ctx.getBean(AsyncEventListener.class).asyncLog(log);
        caster.multicastEvent(error); // == ctx.getBean(AsyncEventListener.class).asyncLog(error);

        int counter = 0;
        do {
            Thread.sleep(1000);
            counter++;
            System.out.printf("waited %d seconds\n", counter);
        } while (counter < 5);

        System.exit(0);
    }

}