package todo.server.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ToDoDAOImpl implements ToDoDAOIF {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean isUserAuthenticated(String userName, String password) {
		jdbcTemplate.query(
                "SELECT * FROM customers WHERE first_name = ?", new Object[] { "Josh" },
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));
		return false;
	}

}
