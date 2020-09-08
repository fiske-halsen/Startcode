package facades;

import entities.Movie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public List<Movie> getAllMovies() {
        EntityManager em = emf.createEntityManager();
        List<Movie> result = null;

        try {
            Query query = em.createQuery("Select m from Movie m");
            result = query.getResultList();

        } finally {
            em.close();
        }

        return result;

    }

    public void addMovie(String title, String genre, String director, int releaseYear) {
        Movie movie = new Movie(title, genre, director, releaseYear);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

       public long getMovieCount() {
       
        EntityManager em = emf.createEntityManager();
        long result = 0;
        
        try {
            Query query = em.createQuery("SELECT COUNT(m) FROM Movie m");
             result = (long) query.getSingleResult();

        } finally {
            em.close();
        }
        
        return result;
    }
        
    
    
    public Movie getMovieFromYear(int releaseYear) {

        EntityManager em = emf.createEntityManager();
        Movie movie = null;
        try {

            Query query = em.createQuery("Select m FROM Movie m WHERE m.releaseYear = :releaseYear");
            query.setParameter("releaseYear", releaseYear);
            movie = (Movie) query.getSingleResult();

        } finally {
            em.close();
        }

        return movie;
    }
    
     public Movie getMovieFromTitle(String title) {

        EntityManager em = emf.createEntityManager();
        Movie movie = null;
        try {

            Query query = em.createQuery("Select m FROM Movie m WHERE m.title = :title");
            query.setParameter("title", title);
            movie = (Movie) query.getSingleResult();

        } finally {
            em.close();
        }

        return movie;
    }
    
    
    
    
    
    
    
    
    
    

}
