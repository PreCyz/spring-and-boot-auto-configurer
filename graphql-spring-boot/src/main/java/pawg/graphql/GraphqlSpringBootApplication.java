package pawg.graphql;

import java.util.Arrays;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlSpringBootApplication {

	public static void main(String[] args) {
		String springActiveProfiles = System.getenv("SPRING_ACTIVE_PROFILES");
		boolean showBannerInLogs = springActiveProfiles != null && springActiveProfiles.contains("prod");
		showBannerInLogs |= args != null && args.length > 0 && Arrays.asList(args).contains("prod");
		if (showBannerInLogs) {
			SpringApplication application = new SpringApplication(GraphqlSpringBootApplication.class);
			application.setBannerMode(Banner.Mode.OFF);
			application.run(args);
			/*new SpringApplicationBuilder().sources(GraphqlSpringBootApplication.class)
//										  .child(GraphqlSpringBootApplication.class)
										  .bannerMode(Banner.Mode.OFF)
										  .run(args);*/
		} else {
			SpringApplication.run(GraphqlSpringBootApplication.class, args);
		}
	}

}
