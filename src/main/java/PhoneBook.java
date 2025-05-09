import java.util.TreeMap;

public class PhoneBook {

    private final TreeMap<String, Long> store = new TreeMap<>();

    public Integer add (String name, Long number) {
        store.put(name, number);
        return store.size();
    }
}
