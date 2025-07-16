package awesome.pawg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ConfigB.class, ConfigC.class})
public class ConfigA {

    private final ConfigB configB;
    private final RepoC repoC;

    @Autowired
    public ConfigA(ConfigB configB, RepoC repoC) {
        this.configB = configB;
        this.repoC = repoC;
    }

    @Bean
    public ContrA contrA() {
        return new ContrA(serviceA());
    }

// TODO: 4a. Unconfusing start here: Spring will not create 2 exactly the same beans (name and type). It will create 1!!!
    @Bean
    public ServiceA serviceA() {
        return new ServiceA(repoA(repoC));
    }

// TODO: 4. NoUniqueBeanDefinitionException: No qualifying bean of type 'awesome.pawg.ServiceA' available:
//  expected single matching bean but found 2: serviceA,serviceA2
    /*@Bean
    public ServiceA serviceA2() {
        return new ServiceA(repoA(repoC));
    }*/

    @Bean
    public RepoA repoA(RepoC repoC) {
        return new RepoA(configB.repoB(), repoC);
    }
}
