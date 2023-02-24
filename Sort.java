import java.util.Arrays;
import java.util.List;

public class Sort {

    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return null;
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.sort(array);
        return Arrays.asList(array);
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return null;
        }
        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.sort(array, (a, b) -> b - a);
        return Arrays.asList(array);
    }
}