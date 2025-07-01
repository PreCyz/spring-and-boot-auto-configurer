package pawg.cmd.beans;

import org.springframework.beans.factory.InitializingBean;
import pawg.cmd.Main;

//TODO: 10. Instantiation - InitializingBean
public class PlaneFactory implements Factory, InitializingBean {

    private static final Factory INSTANCE = new PlaneFactory();

    public static Factory getInstance() {
        return INSTANCE;
    }

    private PlaneFactory() {
        System.out.printf("[%d]. %s instantiation.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
    }

    @Override
    public void produce() {
        System.out.printf("[%d]. %s produced plane.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("[%d]. %s after properties set when implementing InitializingBean.%n",
                Main.COUNTER.incrementAndGet(),
                getClass().getSimpleName()
        );
    }
}
