package pawg.cmd.beans;

import pawg.cmd.Main;

public class PrintService implements Print {

    private PrintService() {
        System.out.printf("[%d]. %s instantiation.%n", Main.COUNTER.incrementAndGet(), getClass().getSimpleName());
    }

    @Override
    public void print() {
        System.out.printf("[%d]. How beautiful am I printing?%n",  Main.COUNTER.incrementAndGet());
    }

    private void awesomeInit() {
        System.out.printf("[%d]. Initializing PrintService.%n", Main.COUNTER.incrementAndGet());
    }
}
