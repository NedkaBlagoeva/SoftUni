package ExamPrep.Mine_23Oct2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if (capacity > roster.size()){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        return roster.removeIf(p -> p.getName().equals(name));
    }

    public Person getPerson(String name, String hometown){
        return roster
                .stream()
                .filter(p -> p.getName().equals(name) && p.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount(){
        return roster.size();
    }

    public String getStatistics(){
        StringBuilder out = new StringBuilder();
        out.append("The people in the ExamPrep.Mine_23Oct2021.hotel ").append(name).append(" are:").append(System.lineSeparator());
        roster.forEach(person -> out.append(person).append(System.lineSeparator()));
        return out.toString().trim();
    }
}
