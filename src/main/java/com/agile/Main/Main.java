package com.agile.Main;

import com.agile.Dao.Database;
import com.agile.Exception.Exception;
import com.agile.Entity.User_Details;
import com.agile.Service.ServiceImplementation;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
    static ServiceImplementation service = new ServiceImplementation();
    static Database db = new Database();
    static int count = 0;

    public static void main(String args[]) {
        Database.initDBConnection();
        System.out.println("Select an Option");
        System.out.println("Press 1.Login for Admin");
        System.out.println("Press 2.Exit");

        int choice = sc.nextInt();
        if (choice == 1) {
            adminLogin();
        } else if (choice == 2) {
            System.out.println("Application terminated");
            System.exit(0);
        } else {
            System.out.println("Please select 1 to go into Admin login section");
            main(null);
        }

    }

    public static void adminLogin() {
        System.out.println("Welcome to Manager page \n ");

        
        System.out.println("Enter your username:");
        String username = sc.next();


        System.out.println("Enter your password:");
        String password = sc.next();
        try {
            if (service.login(username, password)) {
                System.out.println("You have logged in");
                adminScreen();
            } else {
                adminLogin();
            }
        } catch (Exception e) {
            System.out.println("Error detected:---->" + e.getMessage());
            adminLogin();
        }

    }

    public static void adminScreen() {
        System.out.println("Please select an option \n ");
        System.out.println("Press 1.Add new Order \n ");
        System.out.println("Press 2.Update an Order \n ");
        System.out.println("Press 3.Search for an Order \n ");
        System.out.println("Press 4.Delete an Order \n ");
 
        int choice = sc.nextInt();
        if (choice == 1) {
            addOrder();
        } else if (choice == 2) {
            updateOrder();
        } else if (choice == 3) {
            searchOrder();
        } else if (choice == 4) {
            deleteOrder();
        } 
        else {
            System.out.println("-----------------------");
            System.out.println("Please select an option above \n ");
            adminScreen();
        }



    }

    public static void addOrder() {
        

        System.out.println("Enter Order Name \n ");
        String Name = sc.next();
        
  
        System.out.println("How many Order \n ");
        String Orders = sc.next();

        User_Details details = new User_Details();
        details.setName(Name);
        details.setOrders(Orders);

        try {
            if (service.createOrder(details, db)) {
                System.out.println(" \n Order has been created \n ");
                adminScreen();

            }
        } catch (Exception e) {
            System.out.println("|---------------|");
            System.out.println(e.getMessage());
            adminScreen();
        }


    }

    public static void updateOrder() {
        System.out.println("To Update order using the Id \n ");
        System.out.println("Enter Id number \n ");
        int id = sc.nextInt();

        System.out.println("Update Order name  \n ");
        String Name = sc.next();

        System.out.println("Update Orders  \n ");
        String order = sc.next();
        
        User_Details details = new User_Details();
        details.setId(id);
        details.setName(Name);
        details.setOrders(order);
        
        try {
            if (service.updateOrder(details, db)) {
                System.out.println("|--- Order has been updated successfully");
                adminScreen();
            }

        } catch (Exception e) {
            System.out.println("---------------- \n " + e.getMessage() + "\n ------------------");
            adminScreen();
        }


    }

    public static void searchOrder() {

        System.out.println("----------- \n To Search Order using the Id \n ");
        System.out.println("Please enter Order Id \n ");
        int id=sc.nextInt();
        try{
            System.out.println(service.searchOrder(id,db));
            adminScreen();
        }
        catch (Exception e){
            System.out.println("---------------- \n " + e.getMessage() + "\n ------------------");
            adminScreen();
        }

    }

    public static void deleteOrder() {
        System.out.println("----------- \n To Delete Order using Id \n ---------");

        System.out.println(" \n Do you really want to delete an Order, press y for yes or n for no: \n ");
        String choice= sc.next();
        if(choice.equalsIgnoreCase("y")) {

            System.out.println(" \n Please enter Order Id to get details\n ");
            int id = sc.nextInt();

            try{
               service.deleteOrder(id,db);
               System.out.println("Order has been deleted successfully");
               adminScreen();

            }
            catch (Exception e){
                System.out.println("---------------- \n " + e.getMessage() + "\n ------------------");
                adminScreen();
            }
        }
        else if(choice.equalsIgnoreCase("n")){
            adminScreen();
        }
        else{
            System.out.println(" \n Please choose a option:\n ");
            deleteOrder();
        }
    }


}
