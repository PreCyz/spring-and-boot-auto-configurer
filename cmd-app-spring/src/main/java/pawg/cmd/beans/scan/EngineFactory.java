package pawg.cmd.beans.scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pawg.cmd.beans.Factory;
import pawg.cmd.beans.Print;

@Service("zelaznyMordulec")
@Lazy
public class EngineFactory implements Factory {

/**
 * What is the difference between autowiring through field and through constructor?
 * What is the difference between above autowiring and through setter?
 * */

    private final Factory factoryService;
    private Print printService;
    @Autowired
    private Factory planeFactory;

    @Autowired
    public EngineFactory(Factory factoryService) {
        this.factoryService = factoryService;
    }

    @Override
    public void produce() {
        System.out.printf("%s produced engine and more.%n", getClass().getSimpleName());
        factoryService.produce();
        printService.print();
        planeFactory.produce();
    }

    @Autowired
    public void setPrintService(Print printService) {
        this.printService = printService;
    }
}
