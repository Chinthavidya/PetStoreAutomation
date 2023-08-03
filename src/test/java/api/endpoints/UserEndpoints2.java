package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	static ResourceBundle getUrl()
	{
		//method created fpr getting urls from properties file
		ResourceBundle routers=ResourceBundle.getBundle("routers");//load property file
		return routers;
		
	}
	public static Response createUser(User payload)
	{
		String post_url=getUrl().getString("post_url");
		Response response=given()
		                    .contentType(ContentType.JSON)
		                    .accept(ContentType.JSON)
		                    .body(payload)
		                  .when()
		                     .post(post_url);
		                      return response;
	}
	//readUser
	public static Response readUser(String UserName)
	{
		String get_url=getUrl().getString("get_url");
        Response response=given()
		                      .pathParam("username", UserName)
		                  .when()
                              .get(get_url);
		                       return response;
		
	}
	//update User
	public static Response update_user(String userName, User payload)
	{
		@SuppressWarnings("unused")
		String update_url=getUrl().getString("update_url");
        Response response=given()
		                     .contentType(ContentType.JSON)
		                     .accept(ContentType.JSON)
		                     .pathParam("username", "UserName")
		                     .body(payload)
		                  .when()
		                     .put("update_url");
		                      return response;
	 }
	//Delete User
	public static Response del_user(String userName)
	{
		String Delete_url=getUrl().getString("Delete_url");
		Response response=given()
		                    .pathParam("username", userName)
		                  .when()
		                    .delete(Delete_url);
		                     return response;
		
	}

}
