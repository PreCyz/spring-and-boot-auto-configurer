package pawg.cmd.beans;

import pawg.cmd.Main;

public class EngineFactory implements Factory {

    private final Factory factoryService;
    private final Factory planeFactory;
    private Print printService;

    public EngineFactory(Factory factoryService, Factory planeFactory) {
        System.out.printf("[%d]. %s instantiation.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
        this.factoryService = factoryService;
        this.planeFactory = planeFactory;
    }

    @Override
    public void produce() {
        System.out.printf("[%d]. %s produced engine and more.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
        factoryService.produce();
        printService.print();
        planeFactory.produce();
    }

    public void setPrintService(Print printService) {
        this.printService = printService;
    }
}
