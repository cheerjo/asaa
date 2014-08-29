package estam.app.com.rev;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
 

public class QuartzJob extends QuartzJobBean {
    
	private RunTask runTask;
	
	public void setRunTask(RunTask runTask) {
		this.runTask = runTask;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		runTask.dataWork();
		
	}

 
}