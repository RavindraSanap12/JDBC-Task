## Steps to Compile and Run Task

1. **Navigate to the Project Directory:**
   - Open your terminal or command prompt.
   - Make sure you're in the `C:\Users\path\Java JDBC Task` directory by using the `cd` command:
     ```bash
     cd "C:\Users\path\Java JDBC Task"
     ```

2. **Compile the Java Program:**
   - Use the following command to compile your `EmployeeJDBC.java` file, ensuring the MySQL connector JAR is included in the classpath:
     ```bash
     javac -cp ".;mysql-connector-j-8.1.0.jar" EmployeeJDBC.java
     ```

3. **Run the Java Program:**
   - After successful compilation, use the following command to run your Java program with the JAR file in the classpath:
     ```bash
     java -cp ".;mysql-connector-j-8.1.0.jar" EmployeeJDBC
     ```
