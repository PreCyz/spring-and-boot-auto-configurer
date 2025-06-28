package awesome.pawg;

import org.springframework.context.annotation.Bean;

// TODO: 1. A circular @Import has been detected. BeanDefinitionParsingException: Configuration problem
//@Import({ConfigA.class, ConfigC.class})
public class ConfigB {

    @Bean
    public ServiceB serviceB() {
        return new ServiceB();
    }

    @Bean
    public RepoB repoB() {
        return new RepoB();
    }
}
