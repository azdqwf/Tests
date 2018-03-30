package lambdas.ex7;
/**
7. Write a static method andThen that takes as parameters two Runnable instances
        and returns a Runnable that runs the first, then the second. In the main method,
        pass two lambda expressions into a call to andThen, and run the returned
        instance.
 **/
public class Main {
    private static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            r1.run();
            r2.run();
        };
    }

    public static void main(String[] args) {
       andThen(()-> System.out.println("i'm first"), ()-> System.out.println("i'm second")).run();
    }
}
