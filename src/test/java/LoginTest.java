import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import com.agile.Exception.Exception;
import com.agile.Service.ServiceImplementation;


//@RunWith(MockitoJUnitRunner.class)
public class LoginTest {
	 ServiceImplementation Service = new ServiceImplementation();

	@Test 
	 public void login01(){
		 Throwable exception = assertThrows(
		            Exception.class, () -> {
		                Service.login("admin", "pass");
		            }
		    );
		    assertEquals("Invalid Password", exception.getMessage());
	 }   
	


@Test
public void login02() {

    assertEquals(true, Service.login("admin", "password"));
}
}