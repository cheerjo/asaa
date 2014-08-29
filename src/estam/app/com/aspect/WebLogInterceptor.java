package estam.app.com.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WebLogInterceptor extends HandlerInterceptorAdapter {

	private Log log = LogFactory.getLog(this.getClass());

	public static final SimpleDateFormat TIMESTAMP_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss SSS");

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Date RequestDate = new Date(System.currentTimeMillis());
		if (log.isDebugEnabled()) {
			log.debug("remoteAddr=" + request.getRemoteAddr());
			log.debug("requestURI=" + request.getRequestURI());
			log.debug("requestDate=" + TIMESTAMP_FORMAT.format(RequestDate));
		}
	}
}
