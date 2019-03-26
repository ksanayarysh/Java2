package courses;

import animals.Animal;
import teams.Team;
import valuestype.ActType;

import java.util.ArrayList;
import java.util.HashMap;

public class Courses {
    ArrayList<CourseItem> courses;

    public Courses(ArrayList<CourseItem> courses) {
        this.courses = courses;
    }

    public void add(CourseItem c){
        courses.add(c);
    }


    public void printInfo() {
        System.out.println();
        System.out.println("Полоса препятствий:");
        for (CourseItem c: courses) {
            c.printInfo();
        }
    }

    public void go(Team t) {
        HashMap<Animal, Boolean> resultTable = new HashMap<>();
        for (Animal a : t.getTeamMembers()) {
            boolean result = true;
            for (CourseItem c : courses) {
                result = result && ((c.getActionType() == ActType.JUMP && c.getValue() <= a.jump())
                        || (c.getActionType() == ActType.RUN && c.getValue() <= a.run()));
            }
            resultTable.put(a, result);

            t.setResults(resultTable);
        }
    }
}
