package lambdas.ex9;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface Collection2<T> extends Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        Objects.requireNonNull(filter);
        forEach(e -> {
            if (filter.test(e)) action.accept(e);
        });
    }
}

class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {
}

public class Main {
    public static void main(String[] args) {
        Collection2<Integer> c2 = new ArrayList2<>();
        c2.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        c2.forEachIf(System.out::println, integer -> integer % 2 == 0);
    }
}
