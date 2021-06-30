package com.company;

import javax.swing.plaf.nimbus.State;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Methods
{
    Item loadItemById(Integer id)
    {
        Item item = new Item();
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "tomaspavlik123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM item WHERE id = " + id);
            resultSet.next();

            item.setId(resultSet.getInt("id"));
            item.setPartNo(resultSet.getString("partNo"));
            item.setSerialNo(resultSet.getString("serialNo"));
            item.setName(resultSet.getString("name"));
            item.setDescription(resultSet.getString("description"));
            item.setNumberInStock(resultSet.getInt("numberInStock"));
            item.setPrice(resultSet.getBigDecimal("price"));

            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return item;
    }

    void deleteAllOutOfStockItems()
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "tomaspavlik123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM item WHERE numberInStock = 0");
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    List<Item> loadAllAvailableItems()
    {
        ArrayList<Item> listOfItems = new ArrayList<>();

        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "tomaspavlik123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM item WHERE numberInStock > 0");

            while (resultSet.next())
            {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setPartNo(resultSet.getString("partNo"));
                item.setSerialNo(resultSet.getString("serialNo"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                item.setNumberInStock(resultSet.getInt("numberInStock"));
                item.setPrice(resultSet.getBigDecimal("price"));

                listOfItems.add(item);
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return listOfItems;
    }

    void saveItem(Item item)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "tomaspavlik123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO item VALUES (" + item.getId() + ", " + item.getPartNo() + ", " + item.getSerialNo() + ", " + item.getName()
            + ", " + item.getDescription() + ", " + item.getNumberInStock() + ", " + item.getPrice() + ")");
            connection.close();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    void updatePrice(Integer id, BigDecimal newPrice)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "tomaspavlik123");
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE item SET price = " + newPrice + " WHERE id = " + id);
            connection.close();
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

}
