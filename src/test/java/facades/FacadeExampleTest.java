package facades;

import entities.Movie;
import utils.EMF_Creator;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;

    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = MovieFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            em.createNativeQuery("DELETE FROM MOVIE").executeUpdate();

            //em.createNamedQuery("startcode_test.deleteAllRows").executeUpdate();
            em.persist(new Movie("Test1", "Test1", "Test1", 1990));
            em.persist(new Movie("Test2", "Test2", "Test2", 2000));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testGetAllMovies() {

        List<Movie> movies = facade.getAllMovies();

        assertThat(movies, hasSize(2));

    }

    @Test
    public void testGetMovieFromYear() {

        Movie movie = facade.getMovieFromYear(1990);

        assertEquals("Test1", movie.getTitle());

    }

    @Test
    public void testGetMovieFromTitle() {

        Movie movie = facade.getMovieFromTitle("Test1");

        assertEquals("Test1", movie.getTitle());

    }

    @Test
    public void testGetMovieCount() {

        long count = facade.getMovieCount();

        assertEquals(2, count);

    }

}
