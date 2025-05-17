package pawg.cmd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConfig {

    @Bean("inlinePrintService")
    public Print printService() {
        return () -> System.out.println("How beautiful am I printing? I'm doing this inline you know?");
    }
}
