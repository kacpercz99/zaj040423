import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Integer, B> bMap = new HashMap<>();
        bList.forEach(b -> bMap.put(b.getId(), b));

        bList.stream()
                .map(B::getId)
                .filter(id -> aList.stream().noneMatch(a -> a.getId().equals(id)))
                .forEach(bMap::remove);

        aList.forEach(a -> {
            if (!bMap.containsKey(a.getId())) {
                bMap.put(a.getId(), new B(a.getId(), a.getName()));
            }
        });
        return new ArrayList<>(bMap.values());
    }
}