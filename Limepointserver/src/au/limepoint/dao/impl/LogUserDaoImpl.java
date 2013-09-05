package au.limepoint.dao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import au.limepoint.dao.ILogUserDao;
import au.limepoint.domain.User;

public class LogUserDaoImpl extends JdbcDaoSupport implements ILogUserDao{
	/* (non-Javadoc)
	 * @see au.limepoint.dao.impl.ILogUserDao#saveLog(au.limepoint.domain.User, java.lang.String)
	 */
	@Override
	public void saveLog(User user,String message){
		String sql = "INSERT into logs (user_id,message) values(?,?)";
		getJdbcTemplate().update(sql,new Object[]{user.getId(),message});
	}
}
