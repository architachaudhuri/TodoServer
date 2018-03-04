package todo.server.dao;

import org.springframework.stereotype.Component;

@Component
public interface ToDoDAOIF {

	boolean isUserAuthenticated(String userName, String password);

}
