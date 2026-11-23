import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ProcviceniLambdy {
    public static void main(String[] args) {
        List<String> jmena = List.of("Kuba", "Dan", "Lukáš", "", "Kuba", "Míša");
        List<Integer> body = List.of(2, 3, 4, 6, 5, 7, 3);
        delkyJmen(jmena);
        delkyJmen(List.of());
        dvaSeznamy();
        ulozHodnotu();
        // pocetVRozsahu(body);
    }

    static void delkyJmen(List<String> jmena) {
        String prefix = "K";

        Predicate<String> startsPrefix = n -> n.startsWith(prefix);
        Function<String, Integer> lenghtReference = String::length;
        Consumer<String> print = n -> System.out.println(lenghtReference.apply(n));
        //Consumer<String> print2 = System.out::println;

        for(String j : jmena) {
            if(startsPrefix.test(j)) {
                print.accept(j);
                //print2.accept(String.valueOf(lenghtReference.apply(j)));
            }
        }
    }

    static void dvaSeznamy() {

        Supplier<List<String>> listFactory = ArrayList::new;

        List<String> jedna = listFactory.get();
        List<String> dva = listFactory.get();

        jedna.add("Vašek");
        dva.add("Ondra");

        System.out.println(jedna);
        System.out.println(dva);

        //listFactory.get().add("Vašek");
        //listFactory.get().add("Ondra");



        // TODO Vytvoř přes Supplier dvě samostatné soupisky a vypiš je.
    }

    static void ulozHodnotu() {
        // Předloha k opravě.
        int limit = 2;
        limit++;
        final int finalLimit = limit;
        Runnable vypis = () -> System.out.println(finalLimit);
        limit++;
        vypis.run();
    }

    static void pocetVRozsahu(List<Integer> body) {
        int minimum = 3;
        int maximum = 6;

        Predicate<Integer> moreThanMin = n -> n >= minimum;
        Predicate<Integer> lessThenMax = n -> n < maximum;

        Predicate<Integer> mezi = moreThanMin.and(lessThenMax);

        int kolik = 0;
        for(Integer i : body) {
            if(mezi.test(i)) {
                kolik++;

            }
        }
        System.out.println(kolik);

        // TODO Slož podmínky a vypiš počet hodnot v intervalu.
    }
}