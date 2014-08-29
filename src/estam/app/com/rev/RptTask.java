package estam.app.com.rev;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import estam.app.com.rev.service.impl.ReportServiceImpl;

@Component
public class RptTask {

	@Resource(name = "reportService")
	ReportServiceImpl reportService;

	public void runRptTask() {

		try {
			reportService.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}