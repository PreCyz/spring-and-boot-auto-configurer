package pawg.cmd;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pawg.cmd.beans.Factory;
import pawg.cmd.beans.Print;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public final static AtomicInteger COUNTER = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.printf("%nInstantiation and assemble phase started ...%n%n");

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

        //TODO: When context refresh is mandatory?
        // ctx.refresh();

        System.out.printf("%nManage phase started ... %n%n");


        List.of(
                ctx.getBean(Print.class),
                ctx.getBean("printer", Print.class),
                ctx.getBean("printService", Print.class)
        ).forEach(Print::print);

        //change scope to singleton to see the difference ;)
        String name = "printer";
        System.out.printf("[%d]. bean type equality check. Bean named '%s' is of type Print? [%b]%n",
                COUNTER.incrementAndGet(),
                name,
                ctx.getBean(Print.class).equals(ctx.getBean("printer", Print.class))
        );

        name = "printService";
        System.out.printf("[%d]. bean type equality check. Bean named '%s' is of type Print? [%b]%n",
                COUNTER.incrementAndGet(),
                name,
                ctx.getBean(Print.class).equals(ctx.getBean("printService", Print.class))
        );

        List.of(
                ctx.getBean("factoryService", Factory.class),
                ctx.getBean("zelaznyMordulec", Factory.class),
                ctx.getBean("planeFactory", Factory.class)
        ).forEach(Factory::produce);
    }
}
