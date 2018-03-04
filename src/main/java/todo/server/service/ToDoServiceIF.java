package todo.server.service;

import org.springframework.stereotype.Service;

import todo.server.model.LoginDetails;

@Service
public interface ToDoServiceIF {

	LoginDetails authenticateUser(String userName, String password);

}
