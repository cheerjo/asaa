package estam.app.com.rev;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import estam.app.com.rev.service.ReportService;

/**
 * @Class Name : RevAjaxController.java
 * @Description : RevAjaxController class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.04
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
@Controller
public class WaveRevAjaxController {

	private static final Logger log = LoggerFactory.getLogger(WaveRevAjaxController.class);

	private static String[] bufferMMa = new String[5];

	private static String wvFctyCd = "SL";
	private static String wvGvmtCd = "AC";

	private static String buffMMa = "0";

	@Resource(name = "reportService")
	private ReportService reportService;

	private static Map<String, Object> fctyDataMap = new HashMap<String, Object>();

	public static void setWaveFomBuffer(String[] sckString) {
		bufferMMa = sckString;
		// log.debug("received WaveRevAjaxController : " + bufferMMa);
	}

	@RequestMapping(value = "/atmosphere/waveFormRev.do")
	@ResponseBody
	public String getCurrentMMA(@RequestBody Map<String, Object> fctyJsonData, Model model) {

		// log.debug("received fctyDataMap.get(wvGvmtCd.concat(wvFctyCd)) : " +
		// fctyJsonData.get("fctyCd"));
		// log.debug("received fctyDataMap.get(wvGvmtCd.concat(wvFctyCd)) : " +
		// fctyJsonData.get("gvmtCd"));

		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		Map<String, Object> barFctyDataMap = new HashMap<String, Object>();

		if (!fctyJsonData.get("fctyCd").toString().isEmpty()) {
			wvFctyCd = fctyJsonData.get("fctyCd").toString();
			wvGvmtCd = fctyJsonData.get("gvmtCd").toString();
		}

		String flagChk = "FALSE";
		String bufMMa = "0";

		fctyDataMap.put(bufferMMa[1].concat(bufferMMa[2]), bufferMMa[4]);

		// if((wvFctyCd.concat("G").equals(conMMaData.getMmaFctyLocVal())) &&
		// (wvGvmtCd.equals(conMMaData.getMmaGvmtCd()))) {
		// if( ((wvFctyCd.equals(bufferMMa[2])) &&
		// wvGvmtCd.equals(bufferMMa[1])) ) { //
		bufMMa = fctyDataMap.get(wvGvmtCd.concat(wvFctyCd)).toString();
		log.debug("received fctyDataMap.get(wvGvmtCd.concat(wvFctyCd)) : " + bufMMa);
		if ((bufMMa != null) || (!bufMMa.isEmpty())) {

			flagChk = "TRUE";
			barFctyDataMap.put("flagChk", flagChk);

			if (bufMMa.isEmpty()) {
				buffMMa = "0";
			} else {
				buffMMa = bufMMa;
			}
			barFctyDataMap.put("pgaTotal", buffMMa);
		} else {
			flagChk = "FALSE";
			barFctyDataMap.put("flagChk", flagChk);
			barFctyDataMap.put("pgaTotal", buffMMa);
		}

		try {
			reqDataJson = m.writeValueAsString(barFctyDataMap);

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.debug("EhqkInfoJson : " + reqDataJson);

		return reqDataJson;

	}

	@RequestMapping(value = "/report/run.do")
	public void reportTest(Model model) {

		try {
			reportService.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
