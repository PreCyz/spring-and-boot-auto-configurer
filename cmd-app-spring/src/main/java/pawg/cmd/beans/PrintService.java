package pawg.cmd.beans;

public class PrintService implements Print {
    @Override
    public void print() {
        System.out.println("How beautiful am I printing?");
    }
}
