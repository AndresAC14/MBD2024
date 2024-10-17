import java.util.function.*;

public class Main5 {
    public static void main(String[] args) {
        BiPredicate<String, Integer> p = (s, n) -> s.length() > n;
        System.out.println(p.test("hola", 5));

        Predicate<String> q = s -> s.contains("a");
        System.out.println(q.test("hola"));
    }


}
