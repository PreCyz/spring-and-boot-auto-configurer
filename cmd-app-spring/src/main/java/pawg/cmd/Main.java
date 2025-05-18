package pawg.cmd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pawg.cmd.beans.Factory;
import pawg.cmd.beans.Print;
import pawg.cmd.configs.MainConfig;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(MainConfig.class, SecondConfig.class);
//        ctx.register(ThirdConfig.class);
        ctx.register(MainConfig.class);
        ctx.scan("pawg.cmd.beans.scan");
        ctx.refresh();

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
