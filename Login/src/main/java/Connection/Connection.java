package Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.Login;

public class Connection {

    private static SessionFactory sessionFactory;

    public Connection() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (Connection.class) {
                if (sessionFactory == null) {
                    sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Login.class)
                        .buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }
}
