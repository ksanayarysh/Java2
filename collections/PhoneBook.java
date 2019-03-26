package collections;

import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Human> phoneBook = new ArrayList<>();

    public void add(Human human){
        phoneBook.add(human);
    }

    public ArrayList<Human> get(String name){
        ArrayList<Human> result = new ArrayList<>();
        for (Human h: phoneBook){
            if (h.name.equals(name)) result.add(h);
        }
        return result;
    }
}
