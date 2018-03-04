package todo.server.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Component;

import todo.server.model.UserDetails;

@Component
public interface ToDoDAOIF {

	boolean isUserAuthenticated(String userName, String password);

	UserDetails createUser(UserDetails userDetails) throws SQLException;

}
