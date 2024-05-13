import java.util.stream.Collectors;
import static java.util.Comparator.comparingInt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneBook{

    private static final HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        Map<Integer, String> names = new HashMap<>();
        names.put(123456, "Иванов");
        names.put(321456, "Васильев");
        names.put(234561, "Петрова");
        names.put(234432, "Иванов");
        names.put(654321, "Петрова");
        names.put(345678, "Иванов");
        names.put(867857, "Васильев");
        names.put(476879, "Васильев");
        names.put(546776, "Васильев");

        names.forEach((k, v) -> addNum(v, k));

        Map<String, ArrayList<Integer>> result = phoneBook.entrySet().stream()
                .sorted(comparingInt(e -> e.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new)).reversed();
        System.out.println(result);
    }


    public static void addNum(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            ArrayList<Integer> list = phoneBook.get(name);
            list.add(phoneNum);
            phoneBook.put(name, list);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(phoneNum);
            phoneBook.put(name, list);
        }
    }
}