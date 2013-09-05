package au.limepoint.dao;

import au.limepoint.domain.User;

public interface IUserDao {

	public abstract User findUserByUserNamePassword(String userName,
			String password);

}