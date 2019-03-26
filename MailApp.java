import animals.Animal;
import animals.Cat;
import animals.Dog;
import courses.CourseItem;
import courses.Courses;
import teams.Team;
import valuestype.ActType;
import valuestype.Gender;

import java.util.ArrayList;

public class MailApp {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Cat(2, "Vasya", Gender.MALE));
        animals.add(new Dog(6, "Nayda", Gender.FEMALE));
        animals.add(new Cat(3, "Sandra", Gender.FEMALE));
        animals.add(new Dog(1, "Sharik", Gender.MALE));

        Team team = new Team(animals, "Our great team");
        //System.out.println(team.toString());
        team.pringInfo();

        ArrayList<CourseItem> course = new ArrayList<>();
        course.add(new CourseItem(ActType.JUMP, 1));
        course.add(new CourseItem(ActType.RUN, 2));
        course.add(new CourseItem(ActType.JUMP, 3));
        course.add(new CourseItem(ActType.RUN, 1));

        Courses courses = new Courses(course);
        courses.printInfo();

        courses.go(team);

        team.printResultTable();
    }
}
