package awesome.pawg.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.context.ApplicationEvent;

public class LogErrorEvent extends ApplicationEvent {

    private final String message;

    public LogErrorEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    String getErr() {
        return "%s - ERROR - %s - %s".formatted(
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), source, message
        );
    }

    public void printMsg() {
        System.out.println(getErr());
    }
}
