package awesome.pawg.configurer;

class PawgPrinter implements Printer {

    private final PrinterProperties properties;

    public PawgPrinter(PrinterProperties properties) {
        this.properties = properties;
    }

    @Override
    public void print() {
        if (properties.isEnabled()) {
            System.out.println(properties.getMessage());
            System.out.println("And BTW Happy hello world :)");
        }
    }
}
