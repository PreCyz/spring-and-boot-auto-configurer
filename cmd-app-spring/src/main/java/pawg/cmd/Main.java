package pawg.cmd;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pawg.cmd.beans.Factory;
import pawg.cmd.beans.Print;
import pawg.cmd.beans.scan.EngineFactory;
import pawg.cmd.configs.MainConfig;
import pawg.cmd.configs.SecondConfig;
import pawg.cmd.configs.ThirdConfig;

public class Main {

    // TODO: 0. Basics @Import, scan, @Lazy
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
//        ctx.register(SecondConfig.class, ThirdConfig.class);
        ctx.scan("pawg.cmd.beans.scan"); //what will happen when no scan?

        // TODO: 1. When context refresh is mandatory?
//        ctx.register(EngineFactory.class);
//        ctx.refresh();

        List.of(
                ctx.getBean(Print.class),
                ctx.getBean("printService", Print.class),
                ctx.getBean("nestedPrintService", Print.class),
                ctx.getBean("inlinePrintService", Print.class)
        ).forEach(Print::print);

        List.of(
                ctx.getBean("factoryService", Factory.class),
                ctx.getBean("zelaznyMordulec", Factory.class),
                ctx.getBean("planeFactory", Factory.class)
        ).forEach(Factory::produce);
    }
}
