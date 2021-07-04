package com.engeto.restapi.demorestapi;

import org.springframework.web.servlet.support.JstlUtils;

import java.sql.*;

public class DBController
{
    private static final String DATABASE_PATH = "jdbc:mysql://localhost:3306/sys";
    private static final String DATABASE_USER_NAME = "root";
    private static final String DATABASE_PASSWORD = "password12341";

    public Student saveToDB(Student student)
    {

        StudentDomain studentDomain = new StudentDomain();
        studentDomain.setFirstName(student.getFirstName());
        studentDomain.setLastName(student.getLastName());


        try {
            Connection connection = DriverManager.getConnection(DATABASE_PATH, DATABASE_USER_NAME, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO students (firstName, lastName) VALUES (" + studentDomain.getFirstName() + ", "
                    + studentDomain.getLastName() + ")", Statement.RETURN_GENERATED_KEYS);
            ResultSet getKey = statement.getGeneratedKeys();
            getKey.next();
            studentDomain.setId(getKey.getLong(1));
            System.out.println("Student ulozen.");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        student.setFirstName(studentDomain.getFirstName());
        student.setLastName(studentDomain.getLastName());
        student.setId(studentDomain.getId());

        System.out.println(studentDomain);
        System.out.println(student);
        return student;
    }

    public Student getFromDB(Long id)
    {
        Student student = new Student();
        try {
            Connection connection = DriverManager.getConnection(DATABASE_PATH, DATABASE_USER_NAME, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE id = " + id);
            resultSet.next();
            student.setId(resultSet.getLong("id"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setLastName(resultSet.getString("lastName"));
            System.out.println("Student ziskan.");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return student;
    }

    public void deleteStudentFromDB(Long id)
    {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_PATH,DATABASE_USER_NAME,DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM students WHERE id = " + id);
            System.out.println("Student odstranen.");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateStudent(Long id, Student student)
    {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_PATH, DATABASE_USER_NAME, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE students SET firstName = " + student.getFirstName()
                    + ", lastName = " + student.getLastName() + " WHERE id = " + id);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
