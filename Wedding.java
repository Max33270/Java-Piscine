import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> names1, Set<String> names2) {
        Map<String, String> couple = new HashMap<>();
        Iterator<String> it1 = names1.iterator();
        Iterator<String> it2 = names2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            couple.put(it1.next(), it2.next());
        }
        return couple;
    }
}
