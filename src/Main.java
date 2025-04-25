import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.sql.*;
import java.time.LocalDate;

// Родительский класс Animal
abstract class Animal {
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

// Домашние животные
abstract class Pet extends Animal {
    public Pet(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Вьючные животные
abstract class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретные классы домашних животных
class Dog extends Pet {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

class Cat extends Pet {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

class Hamster extends Pet {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

// Конкретные классы вьючных животных
class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

class Camel extends PackAnimal {
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}

class AnimalRegistry {
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

    // public void showCommandsByName(String name) {
    //     for (Animal animal : animals) {
    //         if (animal.getName().equalsIgnoreCase(name)) {
    //             System.out.println("Команды, которые знает " + animal.getName() + ":");
    //             animal.printCommands();
    //             return;
    //         }
    //     }
    //     System.out.println("Животное с именем \"" + name + "\" не найдено.");
    // }

    // public void teachCommand(String name, String command) {
    //     for (Animal animal : animals) {
    //         if (animal.getName().equalsIgnoreCase(name)) {
    //             animal.addCommand(command);
    //             System.out.println("Животное " + animal.getName() + " выучило команду: " + command);
    //             return;
    //         }
    //     }
    //     System.out.println("Животное с именем \"" + name + "\" не найдено.");
    // }

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

class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;
    private boolean usedInTryWithResources = false;

    public void markUsedInTry() {
        usedInTryWithResources = true;
    }

    public void add() {
        if (closed) {
            throw new IllegalStateException("Ресурс уже закрыт.");
        }
        count++;
        System.out.println("Счётчик: " + count);
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        closed = true;
        if (!usedInTryWithResources) {
            throw new IllegalStateException("Counter должен использоваться внутри try-with-resources!");
        }
        System.out.println("Счётчик закрыт.");
    }
}



public class Main {
    private static final AnimalRegistry registry = new AnimalRegistry();
    private static final Scanner scanner = new Scanner(System.in);
    private static int totalAdded = 0;

    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\n1. Добавить животное");
            System.out.println("2. Показать всех животных");
            System.out.println("3. Показать все команды, которые выполняет животное");
            System.out.println("4. Обучить животное новой команде");
            System.out.println("5. Показать животных по дате рождения");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addAnimalFromInput();
                    break;
                // case "2":
                //     registry.showAllAnimals();
                //     break;
                case "2":
                    List<String> animals = AnimalDatabase.getAllAnimals();
                    if (animals.isEmpty()) {
                        System.out.println("Животных в базе данных нет.");
                    } else {
                        System.out.println("Список животных:");
                    for (String animal : animals) {
                        System.out.println(animal);
                             }
                        }
                     break;
                case "3":
                    showCommandsByName();
                    break;
                case "4":
                    teachCommandToAnimal();
                    break;
                // case "5":
                //     registry.showAnimalsByBirthDate(); // Выводим животных по дате рождения
                //     break;

                case "5":
                     List<String> sorted = AnimalDatabase.getAllAnimalsSortedByBirthDate();
                        if (sorted.isEmpty()) {
                            System.out.println("Животных в базе данных нет.");
                        } else {
                            System.out.println("Животные из БД, отсортированные по дате рождения:");
                        for (String line : sorted) {
                            System.out.println(line);
                                     }
                                }
                        break;
                case "6":
                    System.out.println("Всего животных добавлено: " + totalAdded);
                    running = false;
                    break;
                default:
                    System.out.println("Некорректный выбор");
            }
        }
    }

  
    private static void addAnimalFromInput() {
        try (Counter counter = new Counter()) {
            counter.markUsedInTry();
    
            System.out.print("Введите тип животного (Dog, Cat, Hamster, Horse, Camel, Donkey): ");
            String type = scanner.nextLine().trim();
            if (type.isEmpty()) throw new IllegalArgumentException("Тип животного не может быть пустым");
    
            System.out.print("name животного: ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) throw new IllegalArgumentException("name не может быть пустым");
    
            System.out.print("Дата рождения (yyyy-mm-dd): ");
            String dateInput = scanner.nextLine().trim();
            if (dateInput.isEmpty()) throw new IllegalArgumentException("Дата рождения не может быть пустой");
            LocalDate birthDate = LocalDate.parse(dateInput);
    
            Animal animal;
            switch (type.toLowerCase()) {
                case "dog":
                    animal = new Dog(name, birthDate);
                    break;
                case "cat":
                    animal = new Cat(name, birthDate);
                    break;
                case "hamster":
                    animal = new Hamster(name, birthDate);
                    break;
                case "horse":
                    animal = new Horse(name, birthDate);
                    break;
                case "camel":
                    animal = new Camel(name, birthDate);
                    break;
                case "donkey":
                    animal = new Donkey(name, birthDate);
                    break;
                default:
                    System.out.println("Неизвестный тип животного.");
                    return;
            }
    
            System.out.print("Введите команды через запятую (например: Сидеть, Лежать): ");
            String commandsInput = scanner.nextLine();
            String[] commands = commandsInput.split(",");
    
            // Преобразуем команды в строку
            String commandsString = String.join(", ", commands);

           // Добавляем команды в объект animal
            for (String cmd : commands) {
                animal.addCommand(cmd.trim());
                    }


        // Добавляем животное и его команды в базу данных
        AnimalDatabase.addAnimalToDatabase(name, birthDate, type, commandsString);

            registry.addAnimal(animal);
            counter.add();
            totalAdded += counter.getCount();
    
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    //private static void showCommandsByName() {
      //  System.out.print("Введите name ");
      //  String name = scanner.nextLine().trim();
      //  registry.showCommandsByName(name);

   // }
   private static void showCommandsByName() {
    System.out.print("Введите name: ");
    String name = scanner.nextLine().trim();

    String commands = AnimalDatabase.getCommandsByName(name);

    if (commands == null) {
        System.out.println("Животное с именем \"" + name + "\" не найдено в базе данных.");
    } else if (commands.trim().isEmpty()) {
        System.out.println(name + " пока не знает ни одной команды.");
    } else {
        System.out.println(name + " знает команды: " + commands);
    }
}

    // private static void teachCommandToAnimal() {
    //     System.out.print("Введите имя животного, которого хотите обучить: ");
    //     String name = scanner.nextLine().trim();
    
    //     System.out.print("Введите новую команду: ");
    //     String command = scanner.nextLine().trim();
    
    //     registry.teachCommand(name, command);
    // }
    private static void teachCommandToAnimal() {
        System.out.print("Введите имя животного, которого хотите обучить: ");
        String name = scanner.nextLine().trim();
    
        // 1) Получаем текущие команды из БД
        String existing = AnimalDatabase.getCommandsByName(name);
        if (existing == null) {
            System.out.println("Животное с именем \"" + name + "\" не найдено в БД.");
            return;
        }
    
        System.out.print("Введите новую команду: ");
        String newCmd = scanner.nextLine().trim();
    
        // 2) Составляем новую строку команд
        String updated;
        if (existing.trim().isEmpty()) {
            updated = newCmd;
        } else {
            updated = existing + ", " + newCmd;
        }
    
        // 3) Сохраняем в БД
        boolean ok = AnimalDatabase.updateCommandsByName(name, updated);
        if (ok) {
            System.out.println(name + " успешно выучил команду: " + newCmd);
        } else {
            System.out.println("Не удалось сохранить команду в БД.");
        }
    }
}