package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("xxx")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("getMovieList")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieList() {

        List<Movie> movies = FACADE.getAllMovies();

        List<MovieDTO> movieDTO = new ArrayList();

        for (Movie movie : movies) {

            movieDTO.add(new MovieDTO(movie));

        }

        return GSON.toJson(movieDTO);
    }

    @Path("getMovieCount")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMovieCount() {

        long count = FACADE.getMovieCount();

        return GSON.toJson(count);

    }

    @Path("title/{title}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeById(@PathParam("title") String title) {

        MovieDTO movieDTO = new MovieDTO(FACADE.getMovieFromTitle(title));

        return GSON.toJson(movieDTO);

    }

    @Path("year/{year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get(@PathParam("year") int year) {

        MovieDTO movieDTO = new MovieDTO(FACADE.getMovieFromYear(year));

        return GSON.toJson(movieDTO);

    }

}
