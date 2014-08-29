package estam.app.com.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import egovframework.rte.fdl.property.EgovPropertyService;

public class CustomWebBindingInitializer implements WebBindingInitializer,
		InitializingBean {

	private static SimpleDateFormat dateFormat;
	private static DecimalFormat currencyFormat;

	@Autowired
	protected EgovPropertyService propertyService;

	public void afterPropertiesSet() throws Exception {
		dateFormat = new SimpleDateFormat(
				propertyService.getString("date.format"));
		dateFormat.setLenient(false);

		currencyFormat = new DecimalFormat(
				propertyService.getString("currency.format"));
	}

	public void initBinder(WebDataBinder binder, WebRequest request) {
		// 금액 바인딩
		binder.registerCustomEditor(Double.class, new CustomNumberEditor(
				Double.class, currencyFormat, true));

		// 날짜 바인딩
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}
}
