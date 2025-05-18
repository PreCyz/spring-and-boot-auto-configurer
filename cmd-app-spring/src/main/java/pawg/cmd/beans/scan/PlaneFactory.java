package pawg.cmd.beans.scan;

import org.springframework.stereotype.Service;
import pawg.cmd.beans.Factory;

@Service
public class PlaneFactory implements Factory {
    @Override
    public void produce() {
        System.out.printf("%s produced plane.%n", getClass().getSimpleName());
    }
}
