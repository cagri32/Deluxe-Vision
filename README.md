# Deluxe-Vision


Dependencies and Technologies We used:

1. JDK 20
2. Git 
3. Eclipse, Intellij
4. Apache Tomcat (version 8)
5. MYSQLSH Command Line Interface (CLI)

Steps to get the application running:

Run the database:
Open MYSQLH CLI
Run "\connect root@localhost" command
Enter the password

Run the backend:

Open the project in an IDE (Intellij, Eclipse etc)
Run 'mvn clean install' command in the project directory.
Right click on "/backend/src/main/java/com/backend/deluxevision/DeluxevisionApplication.java" and choose Run As > Java Application

Run the frontend:

Open the project in VS Code
Right click 'frontend/src' and Select 'Open In Integrated Terminal'
In terminal run 'ng serve'
Open localhost 

