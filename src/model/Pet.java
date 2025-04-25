package model;
import java.time.LocalDate;

// Домашние животные
public abstract class Pet extends Animal {
    public Pet(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}