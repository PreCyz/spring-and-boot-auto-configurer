package pawg.cmd.beans;

import jakarta.annotation.PostConstruct;

public class FactoryService implements Factory {

    @Override
    public void produce() {
        System.out.printf("%s produced something.%n", getClass().getSimpleName());
    }

    /**
     * Why isn't it working?
     * */
    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct method has been called.");
    }

}
