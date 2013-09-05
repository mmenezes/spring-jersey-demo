package au.limepoint.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import au.limepoint.domain.User;

public class UserMapper  implements RowMapper <User>{
	 public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	      User user = new User();
	      user.setId(rs.getLong("id"));
	      user.setUserName(rs.getString("name"));
	      user.setPassword(rs.getString("password"));
	      return user;
	   }
}
