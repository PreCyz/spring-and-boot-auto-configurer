import awesome.pawg.*;
import awesome.pawg.circular.CircularServiceA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        System.out.printf("%nInstantiation and assemble phase started ...%n%n");

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigA.class);
        ctx.setDisplayName("mainContext");
        // TODO: 5. Circular dependency
//        ctx.scan("awesome.pawg.circular");
//        ctx.getBean(CircularServiceA.class);

        // TODO: 4. NoUniqueBeanDefinitionException:
        ctx.getBean(ServiceA.class);
        ctx.getBean(ServiceB.class);
        ctx.getBean(ServiceC.class);

        ctx.getBean(RepoA.class);
        ctx.getBean(RepoB.class);
        ctx.getBean(RepoC.class);
    }
}
