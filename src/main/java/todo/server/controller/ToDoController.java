package todo.server.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todo.server.constants.ToDoApplicationConstants;
import todo.server.constants.ToDoStatusConstants;
import todo.server.model.LoginDetails;
import todo.server.model.ResponseObjectLoginDetails;
import todo.server.model.ResponseObjectUserDetails;
import todo.server.model.UserDetails;
import todo.server.service.ToDoServiceIF;

@RestController
public class ToDoController {

	@Autowired
	ToDoServiceIF toDoServiceIF;

	@RequestMapping(value = ToDoApplicationConstants.LOGIN_ENDPOINT, method = RequestMethod.GET)
	public ResponseEntity<ResponseObjectLoginDetails> authenticateUser(
			@PathVariable(ToDoApplicationConstants.USERNAME) String userName,
			@PathVariable(ToDoApplicationConstants.PASSWORD) String password) {

		ResponseObjectLoginDetails responseObject = new ResponseObjectLoginDetails();
		LoginDetails response = toDoServiceIF.authenticateUser(userName, password);

		if (null != response) {
			responseObject.setStatusCode(ToDoStatusConstants.STATUS_CODE_SUCCESS);
			responseObject.setMessage(ToDoStatusConstants.MESSAGE_SUCCESS);
			responseObject.setResponsePayload(response);
		} else {
			responseObject.setStatusCode(ToDoStatusConstants.STATUS_CODE_SUCCESS_NO_CONTENT);
			responseObject.setMessage(ToDoStatusConstants.MESSAGE_NO_CONTENT_FOUND);
		}
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}

	@RequestMapping(value = ToDoApplicationConstants.CREATE_USER_ENDPOINT, method = RequestMethod.POST)
	public ResponseEntity<ResponseObjectUserDetails> createUser(@RequestBody UserDetails userDetails)
			throws SQLException {
		ResponseObjectUserDetails responseObject = new ResponseObjectUserDetails();
		try {
			UserDetails response = toDoServiceIF.createUser(userDetails);
			if (null != response) {
				responseObject.setStatusCode(ToDoStatusConstants.STATUS_CODE_SUCCESS);
				responseObject.setMessage(ToDoStatusConstants.MESSAGE_SUCCESS);
				responseObject.setResponsePayload(response);
			} else {
				responseObject.setStatusCode(ToDoStatusConstants.STATUS_CODE_SUCCESS_NO_CONTENT);
				responseObject.setMessage(ToDoStatusConstants.MESSAGE_NO_CONTENT_FOUND);
			}
		} catch (SQLException ex) {
			responseObject.setMessage(ex.getMessage());
			responseObject.setStatusCode(ToDoStatusConstants.STATUS_CODE_FAILURE);
		}
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}

}
