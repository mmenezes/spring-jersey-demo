package au.limepoint.dao;

import au.limepoint.domain.User;

public interface ILogUserDao {

	public abstract void saveLog(User user, String message);

}