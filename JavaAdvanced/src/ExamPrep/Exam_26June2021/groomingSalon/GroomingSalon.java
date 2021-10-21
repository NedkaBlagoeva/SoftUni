package ExamPrep.Exam_26June2021.groomingSalon;

import java.util.LinkedList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new LinkedList<>();
    }

    public void add(Pet pet) {
        if (capacity > data.size()) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder out = new StringBuilder();
        out.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            out.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
