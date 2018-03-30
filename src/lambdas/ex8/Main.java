package lambdas.ex8;

import java.util.ArrayList;
import java.util.List;

/**
 * 8. What happens when a lambda expression captures values in an enhanced
 * for loop such as this one?
 * String[] names = { "Peter", "Paul", "Mary" };
 * List<Runnable> runners = new ArrayList<>();
 * for (String name : names)
 * runners.add(() -> System.out.println(name));
 **/
public class Main {
    public static void main(String[] args) {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
//        for (String name : names)
//            runners.add(() -> System.out.println(name));
        for (int i = 0; i < names.length; i++) {
            final int j = i;
            runners.add(() -> System.out.println(names[j]));

        }
        for (Runnable r : runners) {
            r.run();
        }
    }
}