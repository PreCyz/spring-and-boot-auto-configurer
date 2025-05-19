package pawg.cmd.beans;

public class PrintService implements Print {
    @Override
    public void print() {
        System.out.println("How beautiful am I printing?");
    }

    private void init() {
        System.out.println("Initializing PrintService.");
    }
}
