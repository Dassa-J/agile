package com.agile.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import com.agile.Entity.User_Details;



public class Database {

	private static  Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    
    public static void initDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/agile";

            con = DriverManager.getConnection(url, "root", "12345");

            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Connection to database not successful");
        }
    }
    
    public boolean createOrder(User_Details details) {

        String cmd = "INSERT INTO ordertable VALUES("+null+",'" + details.getName() + "','" + details.getOrders() + "');";
        try {
            stmt.executeUpdate(cmd);

            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    
    public boolean updateOrder(User_Details details) {

        //String cmd = "UPDATE ordertable SET name='"+ details.getName()+"', orders='" + details.getOrders()+"' WHERE id='"+ details.getId()"';";
        String cmd = "UPDATE ordertable SET name='" +details.getName() +  "', orders = '" +details.getOrders()+ "' WHERE id = '"+details.getId()+"'; ";
        try {
            stmt.executeUpdate(cmd);

            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
        
    public boolean deleteOrder(int id) {

        String cmd = "DELETE FROM ordertable where id='"+id+"';";
        try {
            stmt.executeUpdate(cmd);

            return true;
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return false;
    }
    
    public  User_Details findOrderId(int id){
        User_Details details= new User_Details();
      
        String name = "",orders="";
       

        String query = "SELECT * from ordertable where id='"+id+"'";
        try {
            rs = stmt.executeQuery(query);

            while (rs.next()) {

                name = rs.getString(2);
                orders = rs.getString(3);       
            }
            details.setName(name);;
            details.setOrders(orders);
        
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
        return details;
    }

    public  boolean idExist(int id){
        if(findOrderId(id).getName().trim().matches("")){
            //System.out.println(false);
            return false;
        }
        else{
            //System.out.println(true);
            return true;
        }
    }
    
}
