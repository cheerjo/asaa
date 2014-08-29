package estam.app.com.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExceptionAspect {

	private Log log = LogFactory.getLog(getClass());

	public void handleException(Exception ex) {
		if (log.isErrorEnabled()) {
			log.error("exception class=" + ex.getClass().getName());
			log.error("exception message=" + ex.getMessage());
		}
	}
}
