package estam.app.fcty.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.iddl.service.IddlAassRlstService;
import estam.app.iddl.service.IddlAassRlstVO;

/**
 * @Class Name : AnalyRsltCorrController.java
 * @Description :
 * @Modification Information
 * 
 * @author
 * @since 2013.12.12
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
public class AnalyRsltCorrController {
	private static final Logger logger = LoggerFactory.getLogger(AnalyRsltCorrController.class);

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** IddlAassRlstService */
	@Resource(name = "iddlAassRlstService")
	private IddlAassRlstService iddlAassRlstService;

	/**
	 * 분석결과상관관계
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 XXXDefaultVO
	 * @return "/analyRsltCorr/AnalyRsltCorrMgr"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fcty/AnalyRsltCorrMgr.do")
	public String selectAnalyRsltCorrMgr(@ModelAttribute("searchVO") IddlAassRlstVO searchVO, ModelMap model) throws Exception {

		return "/estam/fcty/analyRsltCorr/AnalyRsltCorrMgr";
	}

	/**
	 * 분석결과 데이타
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 XXXDefaultVO
	 * @return "/rpt/OverallAnlyRpt"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fcty/getAassRlstDataJson.do")
	@ResponseBody
	public String getAassRlstDataJson(@ModelAttribute("searchVO") IddlAassRlstVO searchVO, ModelMap model) throws Exception {

		Map<String, Object> fctyDataMap = new HashMap<String, Object>();
		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";

		searchVO.setFctyStrTycd("S1");
		fctyDataMap.put("iddlAassRlstS1List", iddlAassRlstService.selectIddlAassRlstListByFctyStrTycd(searchVO));

		searchVO.setFctyStrTycd("S2");
		fctyDataMap.put("iddlAassRlstS2List", iddlAassRlstService.selectIddlAassRlstListByFctyStrTycd(searchVO));

		searchVO.setFctyStrTycd("S3");
		fctyDataMap.put("iddlAassRlstS3List", iddlAassRlstService.selectIddlAassRlstListByFctyStrTycd(searchVO));

		searchVO.setFctyStrTycd("S4");
		fctyDataMap.put("iddlAassRlstS4List", iddlAassRlstService.selectIddlAassRlstListByFctyStrTycd(searchVO));

		fctyDataMap.put("iddlAassRlstS5List", iddlAassRlstService.selectIddlAassRlstList());

		reqDataJson = m.writeValueAsString(fctyDataMap);
		logger.debug("FctyInfoJson : " + reqDataJson);

		return reqDataJson;
	}
}
