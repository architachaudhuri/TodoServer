package todo.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import todo.server.dao.ToDoDAOIF;
import todo.server.model.LoginDetails;

@Component
public class ToDoServiceImpl implements ToDoServiceIF {

	@Autowired
	ToDoDAOIF toDoDAOIF;

	@Override
	public LoginDetails authenticateUser(String userName, String password) {
		LoginDetails loginDetails = new LoginDetails();
		boolean isUserAuthenticated = toDoDAOIF.isUserAuthenticated(userName, password);
		if (isUserAuthenticated) {
			loginDetails.setUserName(userName);
			loginDetails.setPassword(password);
		}
		return loginDetails;
	}

}
