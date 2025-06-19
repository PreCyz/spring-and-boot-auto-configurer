package pawg.cmd.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.FactoryBean;
import pawg.cmd.Main;

public class FactoryService implements Factory, FactoryBean<Factory> {

    private FactoryService() {
        System.out.printf("[%d]. %s instantiation.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
    }

    @Override
    public void produce() {
        System.out.printf("[%d]. %s produced something.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
    }

    @Override
    public Factory getObject() throws Exception {
        return new FactoryService();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.printf("[%d]. %s instantiation get type.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
        return Factory.class;
    }

    @Override
    public boolean isSingleton() {
        System.out.printf("[%d]. %s get scope.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
        return FactoryBean.super.isSingleton();
    }

    /**
     * Why isn't it working?
     * */
    @PostConstruct
    public void postConstruct() {
        System.out.printf("[%d]. postConstruct method has been called.%n", Main.COUNTER.incrementAndGet());
    }
}
