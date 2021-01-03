package com.agile.Service;


import com.agile.Dao.Database;
import com.agile.Entity.User_Details;
import com.agile.Exception.Exception;

public class ServiceImplementation implements Service {

 
    public Boolean login(String username, String password) {
        boolean res = false;
        if (!username.equals("admin")) {
            throw new Exception("Invalid Username");
        } else if (!password.equals("password")) {
            throw new Exception("Invalid Password");
        } else if (username.equals("admin") && password.equals("password")) {
            res = true;

        }
        return res;
    }

    public Boolean logout(String username) {
        boolean res = false;
        if (!username.equals("admin")) {
            throw new Exception("Invalid Username");
        } else {
            res = true;
            return res;
        }
    }

    public Boolean createOrder(User_Details details,Database db) {
        boolean res = false;
      
        if (details.getName().length() < 2 || details.getOrders().length() > 10) {
            throw new Exception("Order not valid");
        }
        else{
            res=true;
            db.createOrder(details);
        }
        return res;
    }


    @Override
    public Boolean updateOrder(User_Details details,Database db) {

        boolean res = false;
    if  (details.getName().length() < 2 || details.getOrders().length() > 10) {
            throw new Exception("Invalid Name or Order");
        } 
        else{
            res=true;
            db.updateOrder(details);
        }
        return res;
    }

  
    public Boolean deleteOrder(int id,Database db) {
        boolean res=false;
        if(!db.idExist(id)){
            throw new Exception("ID does not Exist");
        }
        else{
            res=true;
            db.deleteOrder(id);

        }
        return res;
    }



    
    public String searchOrder(int Id,Database db) {
        String res="";


        if(!db.idExist(Id)){
            //System.out.println(false);
            throw new Exception("ID doesnt exist");
        }
        else{
            User_Details details= db.findOrderId(Id);
            res="Name: "+details.getName()+"\n Order: "+details.getOrders()+"\n";
            //res=db.findEmployeeByBadge(BadgeNo);
        }



        return res;
    }
	@Override
	public String searchOrder(String id, Database db) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteOrder(String id, Database db) {
		// TODO Auto-generated method stub
		return null;
	}

}
