package collections;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        CheckCount c = new CheckCount();
        c.check();


        PhoneBook ph = new PhoneBook();

        ph.add(new Human("Иванов", "12323566"));
        ph.add(new Human("Иванов", "12323788"));
        ph.add(new Human("Петров", "127884455"));
        ph.add(new Human("Сидоров", "992321245"));
        ph.add(new Human("Зайцев", "545454545"));
        ph.add(new Human("Мишкин", "21212212"));

        List<Human> found = ph.get("Иванов");

        System.out.println();
        System.out.println("Телефонная книга:");
        for (Human h: found) System.out.println(h);
    }
}
