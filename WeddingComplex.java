import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeddingComplex {
    public static Map<String, String> createBestCouple(Map<String, List<String>> first,
            Map<String, List<String>> second) {
        Map<String, String> couple = new HashMap<String, String>();
        Set<String> firstSet = first.keySet();
        Map<String, String> statuscouple1 = getStatusCouple(first);
        Map<String, String> statuscouple2 = getStatusCouple(second);

        while (statuscouple1.containsValue("single")) {
            for (String person : firstSet) {
                for (String w : first.get(person)) {
                    if (isSingle(statuscouple1, person)) {
                        if (isSingle(statuscouple2, w)) {
                            addCouple(couple, person, w);
                            changeStatus(statuscouple1, person, "married");
                            changeStatus(statuscouple2, w, "married");
                        } else {
                            String person2 = getKey(couple, w);
                            if (prefers(second.get(w), person, person2)) {
                                changeStatus(statuscouple1, person2, "single");
                                changeStatus(statuscouple1, person, "married");
                                changeStatus(statuscouple2, w, "married");
                                addCouple(couple, person, w);
                            }
                        }
                    }
                }
            }
        }
        return couple;

    }

    public static Map<String, String> getStatusCouple(Map<String, List<String>> map) {
        Set<String> set = map.keySet();
        Map<String, String> statuscouple = new HashMap<String, String>();
        for (String person : set) {
            statuscouple.put(person, "single");
        }
        return statuscouple;
    }

    public static boolean isSingle(Map<String, String> map, String person) {
        if (map.get(person) == "single") {
            return true;
        }
        return false;
    }

    public static void changeStatus(Map<String, String> map, String person, String value) {
        map.replace(person, value);
    }

    public static void addCouple(Map<String, String> map, String person, String person2) {
        map.put(person, person2);
    }

    public static boolean prefers(List<String> preferences, String person, String person1) {
        if (preferences.indexOf(person) < preferences.indexOf(person1)) {
            return true;
        }
        return false;
    }

    public static String getKey(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}