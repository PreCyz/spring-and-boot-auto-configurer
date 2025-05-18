package pawg.cmd.beans;

public class FactoryService implements Factory {

    @Override
    public void produce() {
        System.out.printf("%s produced something.%n", getClass().getSimpleName());
    }

}
