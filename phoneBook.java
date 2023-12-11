import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class PhoneBook {
    
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        ArrayList<Integer> phoneNums = phoneBook.getOrDefault(name, new ArrayList<Integer>());
        phoneNums.add(phoneNum);
        phoneBook.put(name,phoneNums);
    }

    public ArrayList<Integer> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<Integer>());
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

    //переопределение метода "toString()" возвращает отсортированные записи телефонной книги
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        ArrayList<Map.Entry<String, ArrayList<Integer>>> list = new ArrayList<Map.Entry<String, ArrayList<Integer>>>(phoneBook.entrySet());
        
        list.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        
        for (Map.Entry<String, ArrayList<Integer>> entry : list) {
            ArrayList<Integer> phoneNumbers = entry.getValue();
            sb.append(String.format("%s: %s\n", entry.getKey(), phoneNumbers.toString()));
        }

        return sb.toString();
    }    
}
