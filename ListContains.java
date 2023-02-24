import java.util.List;

public class ListContains {
    public static boolean containsValue(List<Integer> list, Integer value) {
        if (list == null) {
            return false; 
        }
        if (list.contains(value)) {
            return true; 
        }
        return false; 
    }
}

