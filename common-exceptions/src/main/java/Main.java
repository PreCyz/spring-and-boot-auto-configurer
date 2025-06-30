import awesome.pawg.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public final static AtomicInteger COUNTER = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.printf("%nInstantiation and assemble phase started ...%n%n");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigA.class);
        // TODO: 6. Circular dependency
//        ctx.scan("awesome.pawg.circular");
//        ctx.getBean(CircularServiceA.class);

        // TODO: 5. NoUniqueBeanDefinitionException:
        ctx.getBean(ServiceA.class);
        ctx.getBean(ServiceB.class);
        ctx.getBean(ServiceC.class);

        ctx.getBean(RepoA.class);
        ctx.getBean(RepoB.class);
        ctx.getBean(RepoC.class);

        // TODO: 4 NoSuchBeanDefinitionException: No bean named 'iron-mordulec' available
//        ConfigA configA = ctx.getBean("iron-mordulec", ConfigA.class);
    }
}
