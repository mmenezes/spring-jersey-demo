package au.limepoint.dao.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import au.limepoint.dao.IUserDao;
import au.limepoint.domain.User;
import au.limepoint.mapper.UserMapper;

public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * au.limepoint.dao.impl.IUserDao#findUserByUserNamePassword(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	public User findUserByUserNamePassword(String userName, String password) {
		User user = null;

		String sql = "SELECT * from user where name=? and password=?";
		try {
			user = getJdbcTemplate().queryForObject(sql,
					new Object[] { userName, password }, new UserMapper());
		} catch (EmptyResultDataAccessException e) {

		}
		return user;
	}

}
