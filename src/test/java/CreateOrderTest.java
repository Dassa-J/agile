import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.agile.Entity.User_Details;
import com.agile.Exception.Exception;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.agile.Dao.Database;
import com.agile.Service.ServiceImplementation;

@RunWith(MockitoJUnitRunner.class)
public class CreateOrderTest {
	ServiceImplementation service = new ServiceImplementation();
	@Test
    public void createOrder() throws Exception {
        User_Details details = new User_Details(1, "Food", "BagShoesCarTruckLorry");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                Exception.class, () -> {
                    service.createOrder(details, db);
                }
        );
        assertEquals("Order not valid", exception.getMessage());
    }
	
	  @Test
	    public void createOrder01() {
	        User_Details details = new User_Details(1, "Perfume", "5");
	        Database db = mock(Database.class);
	        when(db.createOrder(details)).thenReturn(true);

	        assertEquals(true, service.createOrder(details, db));

	    }
}
