package pawg.cmd.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pawg.cmd.beans.FactoryService;
import pawg.cmd.beans.Print;

@Configuration
public class SecondConfig {

    @Bean("inlinePrintService")
    public Print printService() {
        return () -> System.out.println("How beautiful am I printing? I'm doing this inline you know?");
    }

    @Bean
    public FactoryService factoryService() {
        return new  FactoryService();
    }
}
