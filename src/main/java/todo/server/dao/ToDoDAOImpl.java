package todo.server.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import todo.server.model.UserDetails;

@Component
public class ToDoDAOImpl implements ToDoDAOIF {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean isUserAuthenticated(String userName, String password) {
		boolean isAuthenticated = false;
		StringBuilder query = new StringBuilder();
		query.append("Select count(USER_USERNAME) from HR.LOGINUSER where USER_USERNAME = '");
		query.append(userName);
		query.append("' and USER_PASSWORD = '");
		query.append(password);
		query.append("'");
		int rowCount = this.jdbcTemplate.queryForObject(query.toString(), Integer.class);
		if (rowCount > 0)
			isAuthenticated = true;
		return isAuthenticated;
	}

	@Override
	public UserDetails createUser(UserDetails userDetails) throws SQLException {
		try {
			StringBuilder query = new StringBuilder();
			query.append(
					"insert into HR.LOGINUSER (USER_FIRST_NAME, USER_LAST_NAME, USER_USERNAME, USER_PASSWORD, USER_CONTACT) values (?, ?, ?, ?, ?)");
			int row = this.jdbcTemplate
					.update(query.toString(),
							new Object[] { userDetails.getFirstName(), userDetails.getLastName(),
									userDetails.getUserName(), userDetails.getPassword(),
									userDetails.getContactNumber() });
			if (row <= 0)
				userDetails = null;
		} catch (DataAccessException ex) {
			throw new SQLException(ex.getMessage());
		}
		return userDetails;
	}

}
