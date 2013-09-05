package au.limepoint.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import au.limepoint.dao.impl.LogUserDaoImpl;
import au.limepoint.dao.impl.UserDaoImpl;
import au.limepoint.domain.User;
import au.limepoint.service.ILoginManager;

public class LoginManagerImpl implements ILoginManager {
	
	
	private UserDaoImpl userDao;
	
	private LogUserDaoImpl logDao;

	@Autowired
    public void setUserDao(UserDaoImpl userDao) {
		this.userDao=userDao;
	}
	
	@Autowired
	public void setLogUserDao(LogUserDaoImpl logDaoImpl){
		this.logDao = logDaoImpl;
	}
	
	/* (non-Javadoc)
	 * @see au.limepoint.service.ILoginManager#validateUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean validateUser(String userName, String password){
		boolean result = false;
		
		User user = userDao.findUserByUserNamePassword(userName, password);
		
		if (user!=null){
			result=true;
			this.logUser(user);
		}	
		

		return result;
	}
	
	/* (non-Javadoc)
	 * @see au.limepoint.service.ILoginManager#logUser(java.lang.String, java.lang.String)
	 */
	@Override
	public void logUser(User user){
		logDao.saveLog(user, "User Loggein Successfully");
	}
}
