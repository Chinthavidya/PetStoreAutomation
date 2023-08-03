package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {
	Faker fak;
	User userpayload;
	public Logger logger;
@BeforeClass()
public void setupData()
{
	 fak=new Faker();
	 userpayload=new User();
	 userpayload.setId(fak.idNumber().hashCode());
	 userpayload.setUsername(fak.name().username());
	 userpayload.setFirsename(fak.name().firstName());
	 userpayload.setLastname(fak.name().lastName());
	 userpayload.setEmail(fak.internet().safeEmailAddress());
	 userpayload.setPassword(fak.internet().password(2, 10));
	 userpayload.setPhone(fak.phoneNumber().cellPhone());

	 logger=LogManager.getLogger(this.getClass());
}
@Test(priority = 1)
public void testPostUser()
{
logger.info("******creating user*****");
Response res=  UserEndpoints2.createUser(userpayload);
res.then().log().all();
Assert.assertEquals(res.getStatusCode(), 200);
logger.info("****** user created*****");
}

@Test(priority=2)
public void testgetUserByName()
{
	logger.info("******Reading User Info******");
	Response response=UserEndpoints2.readUser(this.userpayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("*****User read info******");
}
@Test(priority = 3)
public void testUpdateByUsingName()
{
	logger.info("****updating User******");
	userpayload.setFirsename(fak.name().firstName());
	userpayload.setLastname(fak.name().lastName());
	userpayload.setEmail(fak.internet().safeEmailAddress());
	Response response=UserEndpoints2.update_user(this.userpayload.getUsername(), userpayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("********updated user************");
}
//after updating the user
@Test(priority = 4)
void testAfterUpdate()
{
Response response=UserEndpoints2.readUser(this.userpayload.getUsername());
response.then().log().all();
Assert.assertEquals(response.getStatusCode(), 200);
}
@Test(priority=5)
public void testDelUser()
{
	logger.info("********deleting user************");
	Response response=UserEndpoints2.del_user(this.userpayload.getUsername());
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 200);
	logger.info("********user deleted************");
}
}
