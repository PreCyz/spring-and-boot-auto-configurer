package pawg.cmd;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pawg.cmd.beans.Factory;
import pawg.cmd.beans.Print;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//        ctx.refresh();

        List.of(
                ctx.getBean(Print.class),
                ctx.getBean("printer", Print.class),
                ctx.getBean("printService", Print.class)
        ).forEach(Print::print);

        //change scope to singleton to see the difference ;)
        System.out.println(ctx.getBean(Print.class).equals(ctx.getBean("printer", Print.class)));
        System.out.println(ctx.getBean(Print.class).equals(ctx.getBean("printService", Print.class)));

        List.of(
                ctx.getBean("factoryService", Factory.class),
                ctx.getBean("zelaznyMordulec", Factory.class),
                ctx.getBean("planeFactory", Factory.class)
        ).forEach(Factory::produce);
    }
}
