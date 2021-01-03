import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.agile.Exception.Exception;


import com.agile.Dao.Database;
import com.agile.Service.ServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
public class SearchOrderTest {
	
	ServiceImplementation service = new ServiceImplementation();
	@Test
	public void searchEmployee01(){
	        Database db = mock(Database.class);
	        when(db.idExist(1)).thenReturn(false);
	
	        Throwable exception = assertThrows(
	                Exception.class, () -> {
	                    service.searchOrder(2, db);
	                }
	        );
	        assertEquals("ID doesnt exist", exception.getMessage());
	    }
}
