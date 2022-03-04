import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class Engine implements Runnable {
    EntityManager entityManager;
    Scanner scan;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.scan = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Enter ex number: ");
        int exNum = Integer.parseInt(scan.nextLine());
        switch (exNum) {
            case 2 -> exTwo();
            case 3 -> exThree();
            case 4 -> exFour();
            case 5 -> exFive();
            case 6 -> exSix();
            case 7 -> exSeven();
            case 8 -> exEight();
            case 9 -> exNine();
            case 10 -> exTen();
            case 11 -> exEleven();
            case 12 -> exTwelve();
            case 13 -> exThirteen();
        }
    }

    private void exThirteen() {
        System.out.println("Enter town name: ");
        String townName = scan.nextLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t " +
                "WHERE t.name = :t_name", Town.class)
                .setParameter("t_name", townName)
                .getSingleResult();

        System.out.printf("%d address in %s deleted", removeAddressesByTown(townName), townName);

        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private int removeAddressesByTown(String townName) {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.name = :town", Address.class)
                .setParameter("town", townName)
                .getResultList();

            entityManager.getTransaction().begin();
            addresses.forEach(entityManager::remove);
            entityManager.getTransaction().commit();
        return addresses.size();
    }

    private void exTwelve() {
        List<Object[]> resultList = entityManager.createQuery("SELECT d.name, MAX (e.salary) FROM Department d " +
                "JOIN Employee e ON e.department.id = d.id " +
                "GROUP BY d.id " +
                "HAVING MAX (e.salary) NOT BETWEEN 30000 AND 70000")
                .getResultList();
        for (Object[] objects : resultList) {
            System.out.printf("%s\t %.2f%n", (String) objects[0], (BigDecimal) objects[1]);
        }
    }

    private void exEleven() {
        //first and last names, their job title and salary
        System.out.println("Enter pattern: ");
        String pattern = scan.nextLine() + "%";
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :p", Employee.class)
                .setParameter("p", pattern)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));
    }

    private void exTen() {
        List<String> departmentNames = Arrays.asList(
                "Engineering",
                "Tool Design",
                "Marketing",
                "Information Services");
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.name IN :names ", Employee.class)
                .setParameter("names", departmentNames).getResultList();
        BigDecimal percent = new BigDecimal("1.12");
        for (Employee employee : employees) {
            entityManager.getTransaction().begin();
            employee.setSalary(employee.getSalary().multiply(percent));
            entityManager.persist(employee);
            entityManager.getTransaction().commit();
            System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }
    }

    private void exNine() {
        //last 10 started projects. Print their name, description, start and end date and sort them by name
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

        entityManager.createQuery("SELECT p FROM Project p " +
                "ORDER BY p.startDate DESC ", Project.class).setMaxResults(10).getResultStream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p -> System.out.printf("""
                                Project name: %s
                                 \tProject Description: %s
                                 \tProject Start Date: %s
                                 \tProject End Date: %s
                                """,
                        p.getName(),
                        p.getDescription().substring(0, 35) + " ...",
                        p.getStartDate().format(dateFormatter),
                        p.getEndDate() == null ? null : p.getEndDate().format(dateFormatter)));
    }

    private void exEight() {
        System.out.println("Enter employee ID: ");
        int id = Integer.parseInt(scan.nextLine());
        Employee e = entityManager.find(Employee.class, id);
        //first name, last name, job title and projects (only their names)
        System.out.printf("%s %s - %s\n", e.getFirstName(), e.getLastName(), e.getJobTitle());
        e.getProjects()
                .stream()
                .map(Project::getName)
                .sorted()
                .forEach(p -> System.out.println("\t" + p));
    }

    private void exSeven() {
        entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC ", Address.class)
                .getResultStream()
                .limit(10)
                .forEach(a -> {
                    System.out.printf("%s, %s - %d employees%n",
                            a.getText(),
                            a.getTown() == null ? "Unknown" : a.getTown().getName(),
                            a.getEmployees().size());
                });
    }

    private void exSix() {
        entityManager.getTransaction().begin();
        Address newAddress = new Address();
        newAddress.setText("Vitoshka 15");
        entityManager.persist(newAddress);
        System.out.println("Enter employee last name: ");
        String lastName = scan.nextLine();
        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.lastName = :ln", Employee.class).setParameter("ln", lastName).getSingleResult();
        employee.setAddress(newAddress);
        entityManager.getTransaction().commit();
    }

    private void exFive() {
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = 'Research and Development' " +
                        "ORDER BY e.salary, e.id", Employee.class)
                .getResultList()
                .forEach(e -> System.out.printf("%s %s from Research and Development - $%.2f%n", e.getFirstName(), e.getLastName(), e.getSalary()));
    }

    private void exFour() {
        entityManager.createQuery("SELECT e FROM Employee e " +
                "where e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void exThree() {
        System.out.println("Enter fullName: ");
        String[] name = scan.nextLine().split("\\s+");
        String firstName = name[0];
        String lastName = name[1];
        Query query = entityManager.createQuery("select e FROM Employee e " +
                "where e.firstName = :fn and e.lastName = :ln", Employee.class)
                .setParameter("fn", firstName)
                .setParameter("ln", lastName);

        var employees = query.getResultList();

        System.out.println(employees.isEmpty() ? "No" : "Yes");

    }

    private void exTwo() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("update Town t " +
                "set t.name = upper(t.name) " +
                "where length(t.name) <= 5 ").executeUpdate();
        entityManager.getTransaction().commit();

    }
}
