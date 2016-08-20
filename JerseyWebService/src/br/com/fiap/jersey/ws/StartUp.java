package br.com.fiap.jersey.ws;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("init")
public class StartUp {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String StartUp(){
		return "Jersey is running!";
	}
}
