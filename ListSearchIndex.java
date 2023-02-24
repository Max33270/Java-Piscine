import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null; 
        }
        if (list.contains(value)) {
            return list.lastIndexOf(value); 
        }
        return null; 
    }

    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        if (list == null) {
            return null; 
        }
        if (list.contains(value)) {
            return list.indexOf(value); 
        }
        return null; 
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> myList = new ArrayList<Integer>();
        if (list != null) {
            int[] indexes = IntStream.range(0, list.size())
                    .filter(i -> list.get(i).equals(value))
                    .toArray();

            {
                for (int index : indexes) {
                    myList.add(index);
                }
            }
            ;
            return myList;
        }
        return myList;
    }
}

