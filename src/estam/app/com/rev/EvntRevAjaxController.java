package estam.app.com.rev;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDtlCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import estam.app.fcty.service.FctyStatSensService;
import estam.app.fcty.service.FctyStatSensVO;
import estam.app.scn.mma.service.ConMmaDataService;
import estam.app.scn.mma.service.FctyMmaService;
import estam.app.scn.mma.service.FctyMmaVO;

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

@Service("EvntRevAjaxController")
public class EvntRevAjaxController {

	private static final Logger log = LoggerFactory.getLogger(EvntRevAjaxController.class);

	private static final String FCTY_EVENT_SENS = "01"; // 이상진동감
	private static final String FCTY_SENS_ERR = "02"; // 계측신호 오류감지

	private static String FCTY_STAT_SCN_GAL = "0";
	private static String FCTY_STAT_SCN_ERR01 = "0";
	private static String FCTY_STAT_SCN_ERR02 = "0";

	private static String[] bufferMMa = new String[5];

	private static Map<String, Object> fctyDataMap = new HashMap<String, Object>();

	private static int iDbCnt = 0;
	private static String buffMMa = "0";

	// private static SocketUtil soktUtil = new SocketUtil();

	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	@Resource(name = "fctyMmaService")
	private FctyMmaService fctyMmaService;

	@Resource(name = "conMmaDataService")
	private ConMmaDataService conMmaDataService;

	@Resource(name = "fctyStatSensService")
	private FctyStatSensService fctyStatSensService;

	public void WaveRevAjaxController() {

	}

	@RequestMapping(value = "/evnt/FctyStatScnGal.do")
	@ResponseBody
	public String getEvntStat(@RequestParam(value = "flag", required = false) String flag, Model model, SessionStatus status) throws Exception {
		String chkEvnt = "FALSE";
		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		Map<String, Object> barFctyDataMap = new HashMap<String, Object>();
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		List<CmmnDtlCode> restdeCodeList;
		// 지진정보에 데이터가 들어오는 경우 처리 부분 추가
		vo.setCommCd("ITEM_001"); // 이상감지기
		restdeCodeList = cmmUseService.selectCmmCodeDetail(vo);

		for (int i = 0; i < restdeCodeList.size(); i++) {
			CmmnDtlCode cmmnDtlCode = new CmmnDtlCode();
			cmmnDtlCode = (CmmnDtlCode) restdeCodeList.get(i);
			log.debug("===== FCTY_STAT_SCN_GAL =====" + cmmnDtlCode.getItem01());
			FCTY_STAT_SCN_GAL = cmmnDtlCode.getItem01();
		}

		// log.debug("===== FCTY_STAT_SCN_GAL --buffMMa =====" + buffMMa);
		// log.debug("===== FCTY_STAT_SCN_GAL =====" + FCTY_STAT_SCN_GAL);

		if (Double.parseDouble(buffMMa) >= Double.parseDouble(FCTY_STAT_SCN_GAL)) {
			chkEvnt = "SCNPGA";
		}
		barFctyDataMap.put("chkEvnt", chkEvnt);
		try {

			reqDataJson = m.writeValueAsString(barFctyDataMap);
			// fctyMmaUpdate();
			// DataMmaInsert();

			// status.isComplete();
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

		log.debug("===== FCTY_STAT_SCN_GAL =====" + reqDataJson);
		return reqDataJson;
	}

	public void DataMmaInsert() {

		String mmaDataTm = "";
		FctyStatSensVO vFctyStatSensVo = new FctyStatSensVO();
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		List<CmmnDtlCode> restdeCodeList;

		if (bufferMMa[4] != null) {

			try {

				// 지진정보에 데이터가 들어오는 경우 처리 부분 추가
				vo.setCommCd("ITEM_001"); // 이상감지기
				restdeCodeList = cmmUseService.selectCmmCodeDetail(vo);

				for (int i = 0; i < restdeCodeList.size(); i++) {
					CmmnDtlCode cmmnDtlCode = new CmmnDtlCode();
					cmmnDtlCode = (CmmnDtlCode) restdeCodeList.get(i);
					log.debug("===== FCTY_STAT_SCN_GAL =====" + cmmnDtlCode.getItem01());
					FCTY_STAT_SCN_GAL = cmmnDtlCode.getItem01();
				}

				vo.setCommCd("ITEM_002"); // 이상감지기
				restdeCodeList = cmmUseService.selectCmmCodeDetail(vo);

				for (int i = 0; i < restdeCodeList.size(); i++) {
					CmmnDtlCode cmmnDtlCode = new CmmnDtlCode();
					cmmnDtlCode = (CmmnDtlCode) restdeCodeList.get(i);

					FCTY_STAT_SCN_ERR01 = cmmnDtlCode.getItem01(); // 계측신호이상감지
					FCTY_STAT_SCN_ERR02 = cmmnDtlCode.getItem02(); // 계측신호이상감GAL
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// MMA저장 부분 추가
			try {

				fctyDataMap.put(bufferMMa[1].concat(bufferMMa[2]), bufferMMa[3]);

				// TODO 이상진동감지시 저장 루틴 추가
				vFctyStatSensVo.setFctyCd(bufferMMa[2]);
				vFctyStatSensVo.setGvmtCd(bufferMMa[1]);
				vFctyStatSensVo.setFctyStatSensGbcd(FCTY_EVENT_SENS);

				fctyStatSensService.deleteFctyStatSens(vFctyStatSensVo);

				// if (conMMaData.getMmaTotPga().compareTo(new
				// BigDecimal(FCTY_STAT_SCN_GAL)) >= 0) {
				if (Double.parseDouble(buffMMa) >= Double.parseDouble(FCTY_STAT_SCN_GAL)) {

					vFctyStatSensVo.setFctyStatSensTm(bufferMMa[3]);
					vFctyStatSensVo.setFctyStatSensPga(new BigDecimal(buffMMa));

					fctyStatSensService.insertFctyStatSens(vFctyStatSensVo);
					// connSens(vFctyStatSensVo);

				}

				// 계측신호 오류 감지...
				vFctyStatSensVo.setFctyCd(bufferMMa[2]);
				vFctyStatSensVo.setGvmtCd(bufferMMa[1]);
				vFctyStatSensVo.setFctyStatSensGbcd(FCTY_SENS_ERR);

				fctyStatSensService.deleteFctyStatSens(vFctyStatSensVo);

				if (fctyDataMap.get(bufferMMa[1].concat(bufferMMa[2])) != null) {
					mmaDataTm = fctyDataMap.get(bufferMMa[1].concat(bufferMMa[2])).toString();
					log.debug("mmaDataTm : " + mmaDataTm);

					if ((mmaDataTm != null) && (!mmaDataTm.isEmpty())) {

						String strDbDate = mmaDataTm;
						String strCurrDate = DateTime.now().toString("yyyyMMddhhmmss");
						DateFormat df = DateFormat.getDateTimeInstance();
						Date dateDb = null;
						Date dateCurr = null;
						SimpleDateFormat sdf = new SimpleDateFormat();
						sdf.applyPattern("yyyyMMddhhmmss");
						try {
							dateDb = sdf.parse(strDbDate);
							dateCurr = sdf.parse(strCurrDate);
							log.debug("Date1 : " + df.format(dateDb) + "\n" + "Date2 : " + df.format(dateCurr));
						} catch (Exception e) {
							e.printStackTrace();
						}

						Calendar c1 = Calendar.getInstance();
						Calendar c2 = Calendar.getInstance();
						c1.setTime(dateDb);
						c2.setTime(dateCurr);

						log.debug("c1 : " + df.format(c1.getTime()) + ", " + c1.getTimeInMillis());
						log.debug("c2 : " + df.format(c2.getTime()) + ", " + c2.getTimeInMillis());

						log.debug("c2 - c1 : " + (c2.getTimeInMillis() - c1.getTimeInMillis()));

						long minute = 1000 * 60;

						long intervalMilli = (c2.getTimeInMillis() - c1.getTimeInMillis()) / minute;

						log.debug("Double.parseDouble(buffMMa) : " + buffMMa);
						log.debug("Double.parseDouble(FCTY_STAT_SCN_ERR02) : " + FCTY_STAT_SCN_ERR02);
						log.debug("Double.parseDouble(FCTY_STAT_SCN_ERR01) : " + FCTY_STAT_SCN_ERR01);
						log.debug("Double.parseDouble(intervalMilli) : " + intervalMilli);

						if (Double.parseDouble(buffMMa) >= Double.parseDouble(FCTY_STAT_SCN_ERR02)) {

							vFctyStatSensVo.setFctyStatSensTm(bufferMMa[3]);
							vFctyStatSensVo.setFctyStatSensPga(new BigDecimal(bufferMMa[4]));

							fctyStatSensService.insertFctyStatSens(vFctyStatSensVo);

						} else if (intervalMilli > Long.parseLong(FCTY_STAT_SCN_ERR01)) {

							vFctyStatSensVo.setFctyStatSensTm(bufferMMa[3]);
							vFctyStatSensVo.setFctyStatSensPga(new BigDecimal(bufferMMa[4]));

							fctyStatSensService.insertFctyStatSens(vFctyStatSensVo);
							// connSens(vFctyStatSensVo);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void fctyMmaUpdate() throws Exception {

		double unit_g = 980.7;
		double acc_p = 0;
		double v_p = 0;
		double u_p = 0.49;
		double time_p = 1;
		double vMmi = 0;
		double uMmi = 0;

		FctyMmaVO fctyMmaVo = new FctyMmaVO();

		buffMMa = bufferMMa[4];

		fctyMmaService.updateFctyMma(fctyMmaVo);

		try {
			if (bufferMMa[3] != null) {
				fctyMmaVo.setFctyCd(bufferMMa[2]);
				fctyMmaVo.setGvmtCd(bufferMMa[1]);
				fctyMmaVo.setFctyPga(new BigDecimal(buffMMa));
				vMmi = v_p + 0.5 * (acc_p + Double.valueOf(buffMMa)) * time_p;
				uMmi = u_p + 0.5 * (v_p + vMmi) * 1;

				fctyMmaVo.setFctyMma(new BigDecimal(uMmi));
/*
				if (34 >= Double.parseDouble(buffMMa)) {

					if (Double.parseDouble(buffMMa) < 0.17) {
						fctyMmaVo.setFctyMma(new BigDecimal("1"));
					} else if ((Double.parseDouble(buffMMa) < 0.17) && (Double.parseDouble(buffMMa) <= 1.4)) {
						fctyMmaVo.setFctyMma(new BigDecimal("2"));
					} else if ((Double.parseDouble(buffMMa) < 1.4) && (Double.parseDouble(buffMMa) <= 3.9)) {
						fctyMmaVo.setFctyMma(new BigDecimal("3"));
					} else if ((Double.parseDouble(buffMMa) < 3.9) && (Double.parseDouble(buffMMa) <= 9.2)) {
						fctyMmaVo.setFctyMma(new BigDecimal("4"));
					} else if ((Double.parseDouble(buffMMa) < 9.2) && (Double.parseDouble(buffMMa) <= 18)) {
						fctyMmaVo.setFctyMma(new BigDecimal("5"));
					} else if ((Double.parseDouble(buffMMa) < 18) && (Double.parseDouble(buffMMa) <= 34)) {
						fctyMmaVo.setFctyMma(new BigDecimal("6"));
					}
				} else {
					if ((Double.parseDouble(fctyMmaVo.getFctyMma().toString()) < 31) && (Double.parseDouble(fctyMmaVo.getFctyMma().toString()) <= 60)) {
						fctyMmaVo.setFctyMma(new BigDecimal("7"));
					} else if ((Double.parseDouble(fctyMmaVo.getFctyMma().toString()) < 60)
							&& (Double.parseDouble(fctyMmaVo.getFctyMma().toString()) <= 116)) {
						fctyMmaVo.setFctyMma(new BigDecimal("8"));
					} else if (Double.parseDouble(fctyMmaVo.getFctyMma().toString()) < 116) {
						fctyMmaVo.setFctyMma(new BigDecimal("9"));
					}
				}
*/

				if (Double.parseDouble(buffMMa) < 1.7) {
					fctyMmaVo.setFctyMma(new BigDecimal("1"));
				} else if (Double.parseDouble(buffMMa) < 13.7 && Double.parseDouble(buffMMa) >= 1.7) {
					fctyMmaVo.setFctyMma(new BigDecimal("2.5"));
				} else if (Double.parseDouble(buffMMa) < 38.2 && Double.parseDouble(buffMMa) >= 13.7) {
					fctyMmaVo.setFctyMma(new BigDecimal("4"));
				} else if (Double.parseDouble(buffMMa) < 90.2 && Double.parseDouble(buffMMa) >= 38.2) {
					fctyMmaVo.setFctyMma(new BigDecimal("5"));
				} else if (Double.parseDouble(buffMMa) < 176.5 && Double.parseDouble(buffMMa) >= 90.2) {
					fctyMmaVo.setFctyMma(new BigDecimal("6"));
				} else if (Double.parseDouble(buffMMa) < 333.4 && Double.parseDouble(buffMMa) >= 176.5) {
					fctyMmaVo.setFctyMma(new BigDecimal("7"));
				} else if (Double.parseDouble(buffMMa) < 637.5 && Double.parseDouble(buffMMa) >= 333.4) {
					fctyMmaVo.setFctyMma(new BigDecimal("8"));
				} else if (Double.parseDouble(buffMMa) < 1216.1 && Double.parseDouble(buffMMa) >= 637.5) {
					fctyMmaVo.setFctyMma(new BigDecimal("9"));
				} else if (Double.parseDouble(buffMMa) >= 1216.1) {
					fctyMmaVo.setFctyMma(new BigDecimal("10"));
				}

				// 진도계산하여 넣기
				log.debug("===== FCTY_STAT_SCN_GAL fctyMmaVo=====" + fctyMmaVo.toString());
				fctyMmaService.updateFctyMma(fctyMmaVo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void setWaveFomBuffer(String[] sckString) {
		bufferMMa = sckString;
		// log.debug("received WaveRevAjaxController : " + bufferMMa);
	}

}
