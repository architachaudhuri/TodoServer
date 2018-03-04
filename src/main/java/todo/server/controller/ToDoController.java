package todo.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todo.server.constants.ToDoApplicationConstants;
import todo.server.constants.ToDoStatusConstants;
import todo.server.model.LoginDetails;
import todo.server.model.ResponseObjectLoginDetails;
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

}
