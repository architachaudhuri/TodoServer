package todo.server.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import todo.server.dao.ToDoDAOIF;
import todo.server.model.LoginDetails;
import todo.server.model.UserDetails;

@Component
public class ToDoServiceImpl implements ToDoServiceIF {

	@Autowired
	ToDoDAOIF toDoDAOIF;

	@Override
	public LoginDetails authenticateUser(String userName, String password) {
		LoginDetails loginDetails = null;
		boolean isUserAuthenticated = toDoDAOIF.isUserAuthenticated(userName, password);
		if (isUserAuthenticated) {
			loginDetails = new LoginDetails();
			loginDetails.setUserName(userName);
			loginDetails.setPassword(password);
		}
		return loginDetails;
	}

	@Override
	public UserDetails createUser(UserDetails userDetails) throws SQLException {
		try {
			toDoDAOIF.createUser(userDetails);
		} catch (SQLException ex) {
			userDetails = null;
			throw new SQLException(ex.getMessage());
		}
		return userDetails;
	}

}
