package awesome.pawg.events;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

public class AsyncEventListener {

    @EventListener
    @Async
    public void asyncLog(LogEvent log) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.printMsg();
    }

    @EventListener
    @Async
    public void asyncLog(LogErrorEvent log) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.printMsg();
    }
}
