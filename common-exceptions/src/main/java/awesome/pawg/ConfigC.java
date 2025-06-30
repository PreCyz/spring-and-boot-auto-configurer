package awesome.pawg;

import org.springframework.context.annotation.Bean;

public class ConfigC {

    @Bean
    public ServiceC serviceC() {
        return new ServiceC();
    }

    @Bean
    public RepoC repoC() {
        return new RepoC();
    }
}
