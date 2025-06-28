package awesome.pawg.configurer;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnClass(Printer.class)
@EnableConfigurationProperties(PrinterProperties.class)
public class PawgAwesomePrinterAutoConfiguration {

    @Bean
    @ConditionalOnProperty(
            prefix = "printer",
            name = "enabled",
            havingValue = "true",
            matchIfMissing = true
    )
    public Printer printer(PrinterProperties properties) {
        return new PawgPrinter(properties);
    }
}
