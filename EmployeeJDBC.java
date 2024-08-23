import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeJDBC {
    static final String DB_URL = "jdbc:mysql://localhost:3306/my_database";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        EmployeeJDBC app = new EmployeeJDBC();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Add Employee");
            System.out.println("2: Update Employee");
            System.out.println("3: Retrieve All Employees");
            System.out.println("4: Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    app.addEmployee(id, name, position, salary);
                    break;

                case 2:
                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Position: ");
                    String newPosition = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = scanner.nextDouble();
                    app.updateEmployee(updateId, newName, newPosition, newSalary);
                    break;

                case 3:
                    app.getAllEmployees();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add an employee
    public void addEmployee(int id, String name, String position, double salary) {
        String sql = "INSERT INTO employee (Id, name, position, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, position);
            pstmt.setDouble(4, salary);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Employee added. Rows inserted: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an employee
    public void updateEmployee(int id, String name, String position, double salary) {
        String sql = "UPDATE employee SET name = ?, position = ?, salary = ? WHERE Id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, position);
            pstmt.setDouble(3, salary);
            pstmt.setInt(4, id);

            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Employee updated. Rows updated: " + rowsAffected);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all employees
    public void getAllEmployees() {
        String sql = "SELECT Id, name, position, salary FROM employee";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("Id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                double salary = rs.getDouble("salary");

                System.out.println("ID: " + id + ", Name: " + name + 
                                   ", Position: " + position + ", Salary: " + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
