package au.limepoint.service;

import au.limepoint.domain.User;

public interface ILoginManager {

	public abstract boolean validateUser(String userName, String password);

	public abstract void logUser(User user);

}