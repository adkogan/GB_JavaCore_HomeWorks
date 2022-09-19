import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {


        //Task 1
        String[] arr = new String[]{"farm", "home", "farm", "village", "fort", "forest", "rain",
                "homework", "rain", "prancing pony", "home", "shire"};

        //System.out.println(Arrays.toString(arr));

        HashSet<String> uniqueArr = new HashSet<>(Arrays.asList(arr));
        //System.out.println(uniqueArr);

        countSimilarWords(arr);



        //Task 2

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addNumber("123456", "Peter");
        phoneBook.addNumber("1234567", "Peter");
        phoneBook.addNumber("12345", "Olga");
        phoneBook.addNumber("1111", "Masha");
        phoneBook.addNumber("22222", "Masha");

        phoneBook.printNumbers("Masha");




    }

    private static void countSimilarWords(String[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String word = array[i];

            if (map.containsKey(word)) {
                int count = map.get(word);
                map.put(word, count + 1);

            } else {
                map.put(word, 1);
            }
        }
            for (String key : map.keySet()) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }

