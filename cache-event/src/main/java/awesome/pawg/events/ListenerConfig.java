package awesome.pawg.events;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
public class ListenerConfig {

    @Bean
    public PawgPropertyListener pawgPropertyListener(@Value("${pawg.custom}") String custom) {
        System.out.println("My custom resolver " +  custom);
        return new PawgPropertyListener();
    }

    @Bean(name = "applicationEventMulticaster")
    ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        eventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return eventMulticaster;
    }

    @Bean
    AsyncEventListener asyncEventListener() {
        return new AsyncEventListener();
    }
}
