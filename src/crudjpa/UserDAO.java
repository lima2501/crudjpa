package crudjpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class UserDAO {

	public EntityManager em = ConnectionFactory.connection();

	public void create(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	public TypedQuery<User> readAll() {
		String jpql = "select u from User u";

		TypedQuery<User> query = em.createQuery(jpql, User.class);
		return query;

	}

	public User readByid(int id) {

		User user = em.find(User.class, id);

		return user;
	}

	public void updateById(User user, int id) {

		em.getTransaction().begin();
		User newUser = em.find(User.class, id);
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
		em.merge(newUser);
		em.getTransaction().commit();
	}

	public void delete(int id) {
		User user = em.find(User.class, id);
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}

}
