package awesome.pawg.events;

import java.util.Random;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;

public class CacheExample {

    private final ApplicationContext applicationContext;

    public CacheExample(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Cacheable("spring")
    public int getCounter(int counter) {
        return new Random().nextInt(1000) + counter;
    }

    public void typicalMistake() {
        for (int i = 0; i <= 5; i++) {
            System.out.printf("counter %d returned %d value%n", i, getCounter(i));
        }
    }

    public void properWay() {
        CacheExample bean = applicationContext.getBean(getClass());
        for (int i = 0; i <= 5; i++) {
            System.out.printf("counter %d returned %d value%n", i, bean.getCounter(i));
        }
    }
}
