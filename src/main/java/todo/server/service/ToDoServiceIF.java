package todo.server.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import todo.server.model.LoginDetails;
import todo.server.model.UserDetails;

@Service
public interface ToDoServiceIF {

	LoginDetails authenticateUser(String userName, String password);

	UserDetails createUser(UserDetails userDetails) throws SQLException;

}
