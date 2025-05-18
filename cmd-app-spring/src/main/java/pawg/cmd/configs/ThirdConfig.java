package pawg.cmd.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pawg.cmd.beans.Print;

@Configuration
public class ThirdConfig {

    @Bean("nestedPrintService")
    public Print printService() {
        return new NestedPrintService();
    }

    private static class NestedPrintService implements Print {
        @Override
        public void print() {
            System.out.println("Am I printing beautifully? I'm nested.");
        }
    }
}
