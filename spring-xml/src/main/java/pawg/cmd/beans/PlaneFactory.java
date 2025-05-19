package pawg.cmd.beans;

public class PlaneFactory implements Factory {

    private static final Factory INSTANCE = new PlaneFactory();

    public static Factory getInstance() {
        return INSTANCE;
    }

    private PlaneFactory() {}

    @Override
    public void produce() {
        System.out.printf("%s produced plane.%n", getClass().getSimpleName());
    }
}
