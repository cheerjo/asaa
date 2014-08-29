package estam.app.com.exception;

public class ServiceException extends Exception {

	public ServiceException() {
		super();
	}

	public ServiceException(String code) {
		super(code);
	}

	public ServiceException(String code, Throwable cause) {
		super(code, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
