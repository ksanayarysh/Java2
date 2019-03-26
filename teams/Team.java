package teams;

import animals.Animal;

import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    private ArrayList<Animal> teamMembers;
    private HashMap<Animal, Boolean> results;
    private String teamName;

    public Team(ArrayList<Animal> teamMembers, String teamName) {
        this.teamMembers = teamMembers;
        this.teamName = teamName;
    }

    public ArrayList<Animal> getTeamMembers(){
        return teamMembers;
    }

    public void setResults(HashMap<Animal, Boolean> results) {
        this.results = results;
    }

    public void printResultTable(){
        System.out.println();
        System.out.println("Наши призеры:");
        for (Animal a: teamMembers) {
            if (results.get(a)) System.out.println(MessageFormat.format("{0} прошел полосу препятствий!", a.getName()));
        }
    }

    public HashMap<Animal, Boolean> getResults() {
        return results;
    }

    @Override
    public String toString() {
        String result = teamName.concat("! ");
        for (Animal a : teamMembers) {
            result = result.concat("   ").concat(a.toString());
        }
        return result;
    }

    public void pringInfo(){
        System.out.println("Наша крутая команда:");
        for (Animal a : teamMembers) {
            System.out.println(a);
        }
    }
}
