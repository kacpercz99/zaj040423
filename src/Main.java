import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<B> bList = new java.util.ArrayList<>(List.of(
                new B(1, "B1"),
                new B(2, "B2"),
                new B(5, "B5")
        ));
        List<A> aList = new ArrayList<>(List.of(
                new A(1, "A1", "111"),
                new A(2, "A2", "222"),
                new A(3, "A3", "333"),
                new A(7, "A7", "777")
        ));
        System.out.println(mapAToB(aList, bList));
    }

    public static List<B> mapAToB(List<A> aList, List<B> bList) {
        Map<Integer, B> bMap = bList.stream()
                .filter(b -> aList.stream().noneMatch(a -> a.getId().equals(b.getId())))
                .collect(Collectors.toMap(B::getId, Function.identity()));
        aList.forEach(a -> bMap.putIfAbsent(a.getId(), new B(a.getId(), a.getName())));
        return new ArrayList<>(bMap.values());
    }
}