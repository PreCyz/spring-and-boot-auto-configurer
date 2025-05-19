package pawg.cmd.beans;

public class EngineFactory implements Factory {

    private final Factory factoryService;
    private final Factory planeFactory;
    private Print printService;

    public EngineFactory(Factory factoryService, Factory planeFactory) {
        this.factoryService = factoryService;
        this.planeFactory = planeFactory;
    }

    @Override
    public void produce() {
        System.out.printf("%s produced engine and more.%n", getClass().getSimpleName());
        factoryService.produce();
        printService.print();
        planeFactory.produce();
    }

    public void setPrintService(Print printService) {
        this.printService = printService;
    }
}
