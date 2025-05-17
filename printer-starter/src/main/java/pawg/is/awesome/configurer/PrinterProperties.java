package pawg.is.awesome.configurer;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("printer")
public class PrinterProperties {
    private String message;
    private boolean enabled;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
