package rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("password")
public class PasswordService {
	
	@POST
	public String testPassword(@FormParam("brugernavn") String brugernavn, @FormParam("password") String password){
		System.out.println(brugernavn + password);
		return ("test".equals(password) && "test".equals(brugernavn)) ?
			"Passwordet er korrekt" : "Passwordet er forkert";
	}
	
	@Path("query")
	@POST
	public String testQueryPassword(
			@QueryParam("brugernavn") String brugernavn, 
			@QueryParam("password") String password){
		return testPassword(brugernavn, password);
	}
	@Path("{brugernavn}/{password}")
	@POST
	public String testPathPassword(
			@PathParam("brugernavn") String brugernavn,
			@PathParam("password") String password){
		return this.testPassword(brugernavn, password);
	}

}
