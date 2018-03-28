package lambdas.ex6;
interface RunnableEx{
    void run() throws Exception;
}
public class Unchecked {
    private static Runnable uncheck(RunnableEx runnableEx){
        return null;
    }

    public static void main(String[] args) {
        new Thread(uncheck(
                () -> { System.out.println("Zzz"); Thread.sleep(1000);})).start();
    }
}
