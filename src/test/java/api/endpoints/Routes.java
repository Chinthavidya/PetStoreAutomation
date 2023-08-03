package api.endpoints;

public class Routes {
//swagger URI=>https://petstore.swagger.io
//createUser= https://petstore.swagger.io/v2/user
//get user=   https://petstore.swagger.io/v2/user/{username}
//updateUser= https://petstore.swagger.io/v2/user/{username}
//Delete user=https://petstore.swagger.io/v2/user/{username}
	public static String base_url="https://petstore.swagger.io/v2";
	
	//UserModule
	public static String post_url=base_url+ "/user";
	public static String get_url=base_url+ "/user/{username}";
	public static String put_url=base_url+ "/user/{username}";
	public static String delete_url=base_url+ "/user/{username}";
	
}
