package awesome.pawg;

import awesome.pawg.events.AsyncEventListener;
import awesome.pawg.events.CacheExample;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableCaching
@EnableAsync
class MainConfig {

    @Bean
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("spring");
    }

    @Bean
    Executor taskExecutor() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
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

    @Bean
    CacheExample cacheExample(ApplicationContext applicationContext) {
        return new CacheExample(applicationContext);
    }

}
