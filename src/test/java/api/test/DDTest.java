package api.test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;
import api.utilities.*;

public class DDTest {
@Test(priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
public void testpostUser(String UserID, String Username, String FirstNmae, String LastNmae, String Email, String Password, String Phone)
{
	User userpayload=new User();
	userpayload.setId(Integer.parseInt(UserID));
	userpayload.setUsername(Username);
	userpayload.setFirsename(FirstNmae);
	userpayload.setLastname(LastNmae);
	userpayload.setEmail(Email);
	userpayload.setPassword(Password);
	userpayload.setPhone(Phone);
	Response response=UserEndpoints.createUser(userpayload);
	Assert.assertEquals(response.getStatusCode(), 200);
}

@Test(priority=2, dataProvider="alldata", dataProviderClass=DataProviders.class)
public void testDelUser(String Username)
{
Response response=UserEndpoints.del_user(Username);

}

}
