package rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("password")
public class PasswordService {

	@POST
	public String testPassword(String body){
		String returnString = null;
		if (body!= null){
			String[] userPassArray = body.split(" ");
			if (userPassArray.length==2){
				returnString = testUserAndPass(userPassArray[0], userPassArray[1]);
			} else {
				returnString = "Wrong number of arguments";
			}
		}
		return returnString;
	}

	@POST
	@Path("form")
	public String testPasswordForm(@FormParam("username") String username, @FormParam("password") String password){
		System.out.println(username + password);
		return testUserAndPass(username, password);
	}

	@Path("query")
	@POST
	public String testQueryPassword(
			@QueryParam("username") String username, 
			@QueryParam("password") String password){
		return testUserAndPass(username, password);
	}
	@Path("{username}/{password}")
	@POST
	public String testPathPassword(
			@PathParam("username") String username,
			@PathParam("password") String password){
		return testUserAndPass(username, password);
	}

	private String testUserAndPass(String username, String password) {
		if (username==null || password==null) return "parameter mangler";
		return ("test".equals(password) && "test".equals(username)) ?
				"Passwordet er korrekt" : "Passwordet er forkert";
	}

}
