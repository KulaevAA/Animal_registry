import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimalDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/animal_registry?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345";

    public static void addAnimalToDatabase(String name, LocalDate birthDate, String type, String commands) {
        String insertSQL = "INSERT INTO animals (name, birth_date, type, commands) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.jdbc.Driver"); // Загружаем драйвер вручную для Connector/J 5.1

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(insertSQL)) {
                 
                stmt.setString(1, name);
                stmt.setDate(2, java.sql.Date.valueOf(birthDate));
                stmt.setString(3, type);
                stmt.setString(4, commands);
                stmt.executeUpdate();
                System.out.println("Животное добавлено в базу данных.");
            } catch (SQLException e) {
                System.out.println("Ошибка при добавлении в БД: " + e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Ошибка: драйвер MySQL не найден. Убедитесь, что он добавлен в classpath.");
        }
    }

    public static List<String> getAllAnimals() {
        List<String> animals = new ArrayList<>();
        String query = "SELECT name, birth_date, type, commands FROM animals";
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
    
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
    
                while (rs.next()) {
                    String name = rs.getString("name");
                    String birthDate = rs.getDate("birth_date").toString();
                    String type = rs.getString("type");
                    String commands = rs.getString("commands");
    
                    String info = String.format("name: %s | type: %s | BirthDate: %s | Commands: %s",
                            name, type, birthDate, commands);
                    animals.add(info);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при получении данных из БД: " + e.getMessage());
        }
    
        return animals;
    }


    public static String getCommandsByName(String name) {
        String query = "SELECT commands FROM animals WHERE name = ?";
        String result = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver"); // для Connector/J 5.1
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query)) {
    
                stmt.setString(1, name);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        result = rs.getString("commands");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при получении команд: " + e.getMessage());
        }
    
        return result;
    }

    public static boolean updateCommandsByName(String name, String commands) {
        String updateSQL = "UPDATE animals SET commands = ? WHERE name = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(updateSQL)) {

                stmt.setString(1, commands);
                stmt.setString(2, name);
                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ошибка при обновлении команд: " + e.getMessage());
            return false;
        }
    }

    public static List<String> getAllAnimalsSortedByBirthDate() {
        List<String> animals = new ArrayList<>();
        String query = "SELECT name, birth_date, type, commands " +
                       "FROM animals " +
                       "ORDER BY birth_date";  // сортируем в SQL
    
        try {
            Class.forName("com.mysql.jdbc.Driver");   
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
    
                while (rs.next()) {
                    String name      = rs.getString("name");
                    String birthDate = rs.getDate("birth_date").toString();
                    String type      = rs.getString("type");
                    String commands  = rs.getString("commands");
    
                    String info = String.format("name: %s | type: %s | BirthDate: %s | Commands: %s",
                            name, type, birthDate, commands);
                    animals.add(info);
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка при получении списка животных из БД: " + e.getMessage());
        }
    
        return animals;
    }

}


