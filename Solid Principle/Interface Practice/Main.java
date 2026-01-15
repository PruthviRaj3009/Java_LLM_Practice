interface CarInterface {
    public void gears();

    public void start();

    default void airbags() {
        System.out.println("6 air bags");
    };

    static void run() {
        System.out.println("run by itself");
    }

}

class manualcar implements CarInterface {
    @Override
    public void gears() {
        System.out.println("6 gears");
    }
    @Override
    public void start() {
        System.out.println("manual");
    }
}
public class  Main{
    public static void main(String[] args) {
        manualcar obj1 = new manualcar();
        obj1.airbags();
        obj1.start();
        CarInterface.run();
    }
}