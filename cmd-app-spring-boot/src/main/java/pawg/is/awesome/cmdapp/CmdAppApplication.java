package pawg.is.awesome.cmdapp;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import pawg.is.awesome.configurer.Printer;

@SpringBootApplication
public class CmdAppApplication implements CommandLineRunner, ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(CmdAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.printf("%n%n%n");
        try {
            Printer printer = applicationContext.getBean(Printer.class);
            printer.print();
            System.out.printf("For your curiosity the actual printer bean type is [%s]%n", printer.getClass().getName());
        } catch (BeansException e) {
            System.err.printf("This is expected, when starter printer is not enabled: [%s]%n", e.getMessage());
            System.out.println("Sad Hello world :(");
        }
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
