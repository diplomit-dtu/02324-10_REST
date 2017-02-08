package rest;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("password")
public class PasswordService {
	
	@POST
	public String testPassword(@FormParam("brugernavn") String brugernavn, @FormParam("password") String password){
		System.out.println(brugernavn + password);
		return (password.equals("test") && brugernavn.equals("test")) ?
			"Passwordet er korrekt" : "Passwordet er forkert";

	}

}
