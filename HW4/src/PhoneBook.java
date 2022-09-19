import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {

    private HashMap<String, String> phoneBook = new HashMap<>();


    public void addNumber(String number, String name) {
        phoneBook.put(number, name);
    }

    private List<String> getNumbersByName(String name) {
        ArrayList<String> result = new ArrayList<>();
        for (var e : phoneBook.entrySet()) {
            if (e.getValue().equals(name)) {
                result.add(e.getKey());
            }
        }
        return result;
    }

    public void printNumbers(String name){
        List<String> numbersByName = getNumbersByName(name);
        if (numbersByName.isEmpty()){
            System.out.println("no such name");
            return;
        }
        System.out.println(numbersByName);

    }

}

