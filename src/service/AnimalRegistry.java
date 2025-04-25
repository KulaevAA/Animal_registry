package service;

import model.Animal;
import util.AnimalBirthDateComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println("Добавлено животное: " + animal.getName());
    }

    public void showAllAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " (" + animal.getBirthDate() + ")");
            animal.printCommands();
        }
    }

   

    public void showAnimalsByBirthDate() {
        // Создаём компаратор для сортировки по дате рождения
        Comparator<Animal> comparator = new AnimalBirthDateComparator();
    
        // Сортируем список животных по дате рождения (по возрастанию)
        Collections.sort(animals, comparator);
    
        // Выводим отсортированный список животных
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " (" + animal.getBirthDate() + ")");
            animal.printCommands();
        }
    }
}
