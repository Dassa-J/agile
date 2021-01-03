import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.agile.Exception.Exception;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.agile.Dao.Database;
import com.agile.Entity.User_Details;
import com.agile.Service.ServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
public class DeleteOrderTest {

	ServiceImplementation service = new ServiceImplementation();
	
	 public void deleteOrder(){
	        Database db = mock(Database.class);
	        when(db.idExist(2)).thenReturn(false);

	        Throwable exception = assertThrows(
	                Exception.class, () -> {
	                    service.deleteOrder(3, db);
	                }
	        );
	        assertEquals("ID does not Exist", exception.getMessage());
	    }
	 
	 @Test
	 public void deleteOrde01(){
	        User_Details details= new User_Details(1, "Gucci", "3");
	        Database db = mock(Database.class);
	        when(db.idExist(1)).thenReturn(true);
	        when(db.findOrderId(1)).thenReturn(details);


	        assertEquals(true,service.deleteOrder(1,db) );
	    }

}
