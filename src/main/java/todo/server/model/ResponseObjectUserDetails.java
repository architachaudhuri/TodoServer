package todo.server.model;

public class ResponseObjectUserDetails {

	private String statusCode;
	private String message;
	private UserDetails responsePayload;

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

	public UserDetails getResponsePayload() {
		return responsePayload;
	}

	public void setResponsePayload(UserDetails responsePayload) {
		this.responsePayload = responsePayload;
	}

}
