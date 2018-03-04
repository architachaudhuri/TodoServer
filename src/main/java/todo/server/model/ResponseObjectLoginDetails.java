package todo.server.model;

public class ResponseObjectLoginDetails {

	private String statusCode;
	private String message;
	private LoginDetails responsePayload;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoginDetails getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(LoginDetails responsePayload) {
		this.responsePayload = responsePayload;
	}
}
