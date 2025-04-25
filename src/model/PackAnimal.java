package model;
import java.time.LocalDate;

// Вьючные животные
public abstract class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}