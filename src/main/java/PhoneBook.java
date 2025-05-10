import java.util.TreeMap;

public class PhoneBook {

    private final TreeMap<String, Long> store = new TreeMap<>();

    public Integer add (String name, Long number) {

        if (name == null || name.isEmpty() || !name.matches("[a-zA-Zа-яА-Я]*"))
            throw new IllegalArgumentException("Name is not valid");

        if (number == null || number < 1)
            throw new IllegalArgumentException("Number is not valid");

        store.put(name, number);
        return store.size();
    }

    public String findByNumber (Long number) {
        return null;
    }
}
