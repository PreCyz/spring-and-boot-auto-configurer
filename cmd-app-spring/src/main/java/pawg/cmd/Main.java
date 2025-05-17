package pawg.cmd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.register(MainConfig.class, SecondConfig.class);
//        ctx.register(ThirdConfig.class);
        ctx.register(MainConfig.class);
        ctx.refresh();

        List.of(
                ctx.getBean(Print.class),
                ctx.getBean("printService", Print.class),
                ctx.getBean("nestedPrintService", Print.class),
                ctx.getBean("inlinePrintService", Print.class)
        ).forEach(Print::print);
    }
}
