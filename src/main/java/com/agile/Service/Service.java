package com.agile.Service;

import com.agile.Dao.Database;
import com.agile.Entity.User_Details;

public interface Service {

	 Boolean login(String username, String password);
	    Boolean logout(String username);
	    Boolean createOrder(User_Details details, Database db);
	    String searchOrder(String id,Database db);
	    Boolean updateOrder(User_Details details,Database db);
	    Boolean deleteOrder(String id,Database db);
}
