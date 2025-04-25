package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


// Родительский класс Animal
public abstract class Animal {
    private String name;
    private LocalDate birthDate;
    private List<String> commands = new ArrayList<>();

    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    // Геттеры и Сеттеры
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<String> getCommands() {
        return new ArrayList<>(commands);
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void printCommands() {
        if (commands.isEmpty()) {
            System.out.println(name + " не знает команд.");
        } else {
            System.out.println(name + " знает команды: " + String.join(", ", commands));
        }
    }
}