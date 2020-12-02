package crudjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("crudjpa");
	private static EntityManager em = emf.createEntityManager();

	public static EntityManager connection() {
		return em;
	}

}
