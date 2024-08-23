Steps to Compile and Run Task:
1. Make sure you're in the C:\Users\path\"Java JDBC Task" directory.
   
2. Use the following command to compile your EmployeeJDBC.java file, ensuring the MySQL connector JAR is included in the classpath:
   javac -cp ".;mysql-connector-j-8.1.0.jar" EmployeeJDBC.java
   
3. After successful compilation, Use the following command to run your Java program with the JAR file in the classpath:
   java -cp ".;mysql-connector-j-8.1.0.jar" EmployeeJDBC
