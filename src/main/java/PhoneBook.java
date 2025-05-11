import java.util.TreeMap;

public class PhoneBook {

    private final TreeMap<String, Long> nameStore = new TreeMap<>();
    private final TreeMap<Long, String> numberStore = new TreeMap<>();

    public Integer add (String name, Long number) {

        if (name == null || name.isEmpty() || !name.matches("[a-zA-Zа-яА-Я]*"))
            throw new IllegalArgumentException("Name is not valid");

        if (number == null || number < 1)
            throw new IllegalArgumentException("Number is not valid");

        nameStore.put(name, number);
        numberStore.put(number, name);
        return nameStore.size();
    }

    public String findByNumber (Long number) throws ClassNotFoundException {

        if (!numberStore.containsKey(number))
           throw new ClassNotFoundException("Phone number not found");

        return numberStore.get(number);
    }

    public Long findByName (String name) throws ClassNotFoundException {

        if (!nameStore.containsKey(name))
            throw new ClassNotFoundException("Contact not found");

        return nameStore.get(name);
    }

    public String printAllNames () {
        String names = nameStore.keySet().toString();
        return names.substring(1, names.length() - 1);
    }
}
