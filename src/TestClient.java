import java.util.List;




import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient(); // to be able to call a rest based webservice, we need instance of the client class, this client class comes from jax-rs and its role is to enable us to make requests to a server

////	code to get a specific movie
//		Response response = client.target("http://localhost:8080/ServerProgrammering/webservice/movies/87") // this is where we specify the url of the resource that we are accessing .
//				.request().buildGet().invoke();
//		
//		System.out.println(response.getStatus());
//		System.out.println(response.readEntity(String.class)); // reading and printing out the data
//		response.close();

		
////	code to add movie
//		Movie newMovie = new Movie();
//		newMovie.setTitle("The Godfather");
//		newMovie.setDirector("Francis Ford Coppola");
//		newMovie.setStars("Marlon Brando, Al Pacino, James Caan");
//		newMovie.setRunningTime("2h 55min");
//		newMovie.setGenre("Crime, Drama");
//		newMovie.setYear(1972);
//		newMovie.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
//
//		Entity newMovieEntity = Entity.entity(newMovie, "application/JSON"); // to be able to post we need the Entity object
//		Response response = client.target("http://localhost:8080/ServerProgrammering/webservice/movies").request()
//				.buildPost(newMovieEntity).invoke();
//
//////		status code 201 means it has been created		
//		System.out.println("Creating a new Movie returned status code of " + response.getStatus());
//		if(response.getStatus() == 201) {
//		System.out.println(response.getHeaders().toString());		
//		}
//		response.close();

		
////	code to update
//		Movie updatedMovie = new Movie();
//		updatedMovie.setTitle("Godfather");
//		updatedMovie.setDirector("Francis Ford Coppola");
//		updatedMovie.setStars("Marlon Brando, Al Pacino, James Caan");
//		updatedMovie.setRunningTime("2h 55min");
//		updatedMovie.setGenre("Crime, Drama");
//		updatedMovie.setYear(1973);
//		updatedMovie.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
//		
//		Entity eEntity = Entity.entity(updatedMovie, "application/JSON");
//		Response response = client.target("http://localhost:8080/ServerProgrammering/webservice/movies/98").request().buildPut(eEntity).invoke();
//		System.out.println("Update status was " + response.getStatus());
//		System.out.println(response.readEntity(String.class));
		
		
////	code to delete a movie
		Response response = client.target("http://localhost:8080/ServerProgrammering/webservice/movies/").request().buildDelete().invoke();
		System.out.println("Delete status was " + response.getStatus());
		response.close();
		
		
////	code to get all movies
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
		response = client.target("http://localhost:8080/ServerProgrammering/webservice/movies").request().buildGet()
				.invoke();

		List<Movie> movies = response.readEntity(new GenericType<List<Movie>>() {
		});

		for (Movie m : movies) {
			System.out.println(m);
		}
	}
}
