import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence
                .createEntityManagerFactory("SoftUni")
                .createEntityManager();
       Engine engine = new Engine(em);
       engine.run();
    }
}
