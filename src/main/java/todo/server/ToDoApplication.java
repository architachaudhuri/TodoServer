package todo.server;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;

import oracle.jdbc.pool.OracleDataSource;

@SpringBootApplication
public class ToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
	}
	
	@Bean
	DataSource dataSource(DataSourceProperties properties) throws SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(properties.getUsername());
		dataSource.setPassword(properties.getPassword());
		dataSource.setURL(properties.getUrl());
		dataSource.setImplicitCachingEnabled(true);
		dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}
}
