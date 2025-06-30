package awesome.pawg.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircularServiceA {
    private final CircularServiceB circularServiceB;

    @Autowired
    public CircularServiceA(CircularServiceB circularServiceB) {
        this.circularServiceB = circularServiceB;
    }
}
