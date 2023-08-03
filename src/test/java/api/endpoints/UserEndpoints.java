package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This class is used to perform the crud operations
//like create, read, update, delete
public class UserEndpoints {
	//Create User
	public static Response createUser(User payload)
	{
		Response response=given()
		                    .contentType(ContentType.JSON)
		                    .accept(ContentType.JSON)
		                    .body(payload)
		                  .when()
		                     .post(Routes.post_url);
		                      return response;
	}
	//readUser
	public static Response readUser(String UserName)
	{
        Response response=given()
		                      .pathParam("username", UserName)
		                  .when()
                              .get(Routes.get_url);
		                       return response;
		
	}
	//update User
	public static Response update_user(String userName, User payload)
	{
        Response response=given()
		                     .contentType(ContentType.JSON)
		                     .accept(ContentType.JSON)
		                     .pathParam("username", "UserName")
		                     .body(payload)
		                  .when()
		                     .put(Routes.put_url);
		                      return response;
	 }
	//Delete User
	public static Response del_user(String userName)
	{
		Response response=given()
		                    .pathParam("username", userName)
		                  .when()
		                    .delete(Routes.delete_url);
		                     return response;
		
	}

}
