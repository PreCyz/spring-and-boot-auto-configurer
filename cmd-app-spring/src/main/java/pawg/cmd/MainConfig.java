package pawg.cmd;

import org.springframework.context.annotation.*;

@Configuration
@Import({SecondConfig.class, ThirdConfig.class})
public class MainConfig {

    @Bean
    @Primary
    public Print printService() {
        return new PrintService();
    }

}
