package awesome.pawg.circular;

import org.springframework.stereotype.Service;

@Service
public class CircularServiceB {
    private final CircularServiceA circularServiceA;

//  TODO: 9. No need for @Autowired on constructor from spring 4.2

    public CircularServiceB(CircularServiceA circularServiceA) {
        this.circularServiceA = circularServiceA;
    }
}
