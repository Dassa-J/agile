import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.agile.Entity.User_Details;
import com.agile.Exception.Exception;
import org.junit.jupiter.api.Test;


import com.agile.Dao.Database;
import com.agile.Service.ServiceImplementation;

//@RunWith(MockitoJUnitRunner.class
public class UpdateOrderTest {
	
	ServiceImplementation service = new ServiceImplementation();
	
	@Test
	 public void updateOrder() throws Exception {
        User_Details details = new User_Details(1, "SpiciesFoodJuice", "1234567890098765432");
        Database db = mock(Database.class);

        Throwable exception = assertThrows(
                Exception.class, () -> {
                    service.updateOrder(details, db);
                }
        );
        assertEquals("Invalid Name or Order", exception.getMessage());
    }
	
	@Test
    public void updateOrder01() {
        User_Details details = new User_Details(2, "Bag", "3");
        Database db = mock(Database.class);
       

        assertEquals(true, service.updateOrder(details, db));

    }
}
