package estam.app.com.rev;

import javax.annotation.Resource;

public class RunTask {

	@Resource(name = "EvntRevAjaxController")
	private EvntRevAjaxController evntRevAjaxController;

	public void dataWork() {

		try {
			// evntRevAjaxController.fctyMmaUpdate();
			// evntRevAjaxController.DataMmaInsert();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}