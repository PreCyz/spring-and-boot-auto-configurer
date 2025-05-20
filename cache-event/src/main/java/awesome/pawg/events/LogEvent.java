package awesome.pawg.events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.context.ApplicationEvent;

public class LogEvent extends ApplicationEvent {

    private final String message;

    public LogEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    protected String getMsg() {
        return "%s - %s - %s".formatted(
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME), source, message
        );
    }

    public void printMsg() {
        System.out.println(getMsg());
    }
}
