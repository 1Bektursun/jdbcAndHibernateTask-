package peaksoft.dao;

import org.hibernate.Session;
import peaksoft.config.HibernateConfig;
import peaksoft.model.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = HibernateConfig.getSession().openSession();
        System.out.println("Table created... ");
        session.close();
    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);

        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {

        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        System.out.println(user.getName() + " successfully deleted");
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("from User").getResultList();
        session.getTransaction();
        session.close();
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = HibernateConfig.getSession().openSession();
        session.beginTransaction();
        session.createQuery("delete from User").executeUpdate();
        session.getTransaction().commit();
        System.out.println("table cleaned...");
        session.close();
    }
}
