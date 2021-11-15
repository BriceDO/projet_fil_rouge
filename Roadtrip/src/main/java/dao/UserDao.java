package dao;

import java.util.List;

/**
 * 
 * @author road trip planner =>User
 *
 */
public class UserDao {
	
	public interface dao<T, PK> {
		
		public List<T> findAll();

		public T findById(PK id);

		public void create(T obj);

		public void update(T obj);

		public void delete(PK id);
	}
}
