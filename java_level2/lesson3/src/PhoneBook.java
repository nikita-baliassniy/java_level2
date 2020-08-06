import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String surname, String number) {
        List<String> list = new ArrayList<>();
        if (phoneBook.containsKey(surname)) {
            list = phoneBook.get(surname);
        }
        if (!list.contains(number)) {
            list.add(number);
            phoneBook.put(surname, list);
        }
    }

    public List<String> get(String surname) {
        if (!phoneBook.containsKey(surname)) {
            System.out.println("There is no such human in phonebook!");
            return null;
        } else return phoneBook.get(surname);
    }

}




