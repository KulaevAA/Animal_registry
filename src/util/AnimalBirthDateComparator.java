package util;
import model.Animal;
import java.util.Comparator;

public class AnimalBirthDateComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        // Сравниваем животных по дате рождения
        return a1.getBirthDate().compareTo(a2.getBirthDate());
    }
}