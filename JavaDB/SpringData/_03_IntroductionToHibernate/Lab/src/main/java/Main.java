import entities.City;
import entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.awt.event.PaintEvent;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADemo");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        var varna = new City();
        varna.setName("Varna");

        var gosho = new User();
        gosho.setUsername("Gosho");
        gosho.setPassword("dasd1233as");
        gosho.setCity(varna);

        em.persist(gosho);

        em.getTransaction().commit();

//        Session session = new Configuration().configure().buildSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
////        var gosho = new User();
////        gosho.setUsername("gosho");
////        gosho.setPassword("parola gosho");
////        session.persist(gosho);
//
//        TypedQuery <User> query = session.createQuery("FROM User u where u.city.name = :city_name", User.class);
//        query.setParameter("city_name", "Kazanlak");
//        query.getResultList().forEach(System.out::println);
//
//        transaction.commit();
    }
}
