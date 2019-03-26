package collections;

import java.util.HashMap;

public class CheckCount {
    public void check(){
        String[] array = {"1", "2", "5", "6", "1", "3", "3", "4", "7", "8", "9", "2", "1", "7", "1", "8", "1", "9", "1", "3"};

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String value = array[i];
            Integer res = hm.get(value);

            hm.put(value, res == null ? 1 : res + 1);
        }

        hm.forEach((String s, Integer i) -> System.out.println(s + " встречается " + i + " раз "));

    }
}
