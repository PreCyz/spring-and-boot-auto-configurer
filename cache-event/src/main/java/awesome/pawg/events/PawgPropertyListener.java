package awesome.pawg.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

import java.util.LinkedHashMap;
import java.util.Map;

public class PawgPropertyListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (event.getApplicationContext() instanceof ConfigurableApplicationContext) {
            ConfigurableEnvironment environment = ((ConfigurableApplicationContext) event.getApplicationContext()).getEnvironment();
            for (PropertySource<?> propertySource : environment.getPropertySources()) {
                System.out.println(propertySource.getName());
                if ("application.properties".equals(propertySource.getName())) {
                    System.out.println("application.properties: " + propertySource.getSource());
                    Map<String, Object> propertyOverrides = new LinkedHashMap<>();
//                    PropertySource<?> customProperties = new MapPropertySource("pawg " + propertySource.getName(), propertyOverrides);
//                    environment.getPropertySources().addBefore(propertySource.getName(), customProperties);
                }
            }
        }
        System.out.printf("PawgPropertyListener onApplicationEvent %s%n", event);
    }

}
