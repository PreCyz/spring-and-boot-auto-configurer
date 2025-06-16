package pawg.cmd.beans;

import org.springframework.beans.factory.InitializingBean;

public class PlaneFactory implements Factory, InitializingBean {

    private static final Factory INSTANCE = new PlaneFactory();

    public static Factory getInstance() {
        return INSTANCE;
    }

    private PlaneFactory() {}

    @Override
    public void produce() {
        System.out.printf("%s produced plane.%n", getClass().getSimpleName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.printf("%s after properties set when implementing InitializingBean.%n", getClass().getSimpleName());
    }
}
