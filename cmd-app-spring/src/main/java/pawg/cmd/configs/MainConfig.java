package pawg.cmd.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import pawg.cmd.beans.Print;
import pawg.cmd.beans.PrintService;

@Configuration
@Import({SecondConfig.class, ThirdConfig.class})
public class MainConfig {

    @Bean
    @Primary
    public Print printService() {
        return new PrintService();
    }

}
