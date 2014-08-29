package estam.app.com.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {

	private Log log = LogFactory.getLog(getClass());

	public Object loggingMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("logging");
		try {
			return joinPoint.proceed();
		} finally {
			stopWatch.stop();
			if (log.isInfoEnabled()) {
				String className = joinPoint.getTarget().getClass().getName();
				String methodName = joinPoint.getSignature().getName();
				Object[] args = joinPoint.getArgs();
				log.info("logging class=" + className);
				log.info("logging method=" + methodName);
				if (args != null) {
					for (int i = 0; i < args.length; i++) {
						log.info("method args[" + i + "]=" + args[i]);
					}
				}
				log.info("elapsed time: " + stopWatch.getTotalTimeMillis()
						+ "ms");
			}
		}
	}
}
