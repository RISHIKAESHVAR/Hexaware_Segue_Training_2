package Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Chemist;
import model.Myorder;

public class Connection {

	private static SessionFactory fac;
	public Connection()
	{
		fac=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Chemist.class).addAnnotatedClass(Myorder.class).buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFact()
	{
		Connection c=new Connection();
		return fac;
	}
	
}
