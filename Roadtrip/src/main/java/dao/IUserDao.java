package dao;

import dao.UserDao.dao;
import entities.UserModel;

public interface IUserDao {
	public interface User extends dao<UserModel, Integer>{
		

	}
}
