package awesome.pawg;

import awesome.pawg.cache.CacheExample;
import awesome.pawg.events.ListenerConfig;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
@EnableCaching
@EnableAsync
@Import({ListenerConfig.class})
@PropertySource(name ="application.properties", value = "classpath:application.properties")
class MainConfig {

    @Bean
    CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("spring");
    }

    @Bean
    Executor taskExecutor() {
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Bean
    CacheExample cacheExample(ApplicationContext applicationContext) {
        return new CacheExample(applicationContext);
    }

}
