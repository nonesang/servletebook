
package com.mycompany.util;

import com.mycompany.model.Book;
import com.mycompany.model.User;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;




public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration();
	Properties settings = new Properties();
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
	settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
	settings.put(Environment.URL, "jdbc:mysql://35.240.154.38:3306/ebook");
	settings.put(Environment.USER, "ebook");
        settings.put(Environment.PASS, "113114115");
	settings.put(Environment.SHOW_SQL, "true");
	configuration.setProperties(settings);
	configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Book.class);

	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
				
	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


	
}