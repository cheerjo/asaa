package estam.app.fcty.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstService;

/**
 * @Class Name : AnalyRsltHistController.java
 * @Description :
 * @Modification Information
 * 
 * @author
 * @since 2014.02.04
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
public class AnalyRsltHistController {
	private static final Logger logger = LoggerFactory.getLogger(AnalyRsltHistController.class);

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** IddlAassRlstService */
	@Resource(name = "iddlAassRlstService")
	private IddlAassRlstService iddlAassRlstService;

	/** fctyMgrService */
	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	/**
	 * 계측자료 누적기록 화면 호출
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 FctyMgrDefaultVO
	 * @return "/fcty/FctyMgrList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fcty/IddlFctyRlstMgr.do")
	public String selectFctyManger(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, ModelMap model) throws Exception {

		ComDefaultCodeVO vo = new ComDefaultCodeVO();

		vo.setCommCd("ITEM_008");
		List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyAreaList", fctyAreaList);

		vo.setCommCd("ITEM_011");
		List fctyKndList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyKndList", fctyKndList);

		logger.debug("fctyKndList" + fctyKndList);

		// 가지고 올때 이미지 정보도 통합해서 가지고 온다.
		List fctyMgrList = fctyMgrService.selectFctyMgrList(searchVO);
		model.addAttribute("fctyMgrList", fctyMgrList);

		String fctycdSearch = "";
		if (fctyMgrList.size() > 0) {
			FctyMgrVO fctyMgrVO = (FctyMgrVO) fctyMgrList.get(0);
			fctycdSearch = "fctycd:" + fctyMgrVO.getFctyCd() + ":" + fctyMgrVO.getGvmtCd();
		}
		model.addAttribute("fctycdSearch", fctycdSearch);

		return "/estam/fcty/IddlFctyRlstMgr";
	}

	/**
	 * 계측자료 누적기록
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 XXXDefaultVO
	 * @return "/rpt/OverallAnlyRpt"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fcty/ReadIddlAassRlst.do")
	public String readIddlAassRlst(@ModelAttribute("searchVO") IddlAassInfoVO searchVO, HttpServletRequest request, ModelMap model) throws Exception {

		try {
			List data = iddlAassRlstService.selectIddlAassRlstList(searchVO);

			model.addAttribute("data", data);
			model.addAttribute("searchVO", searchVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String url = "/estam/fcty/inc/iddlLeftAclnInfo";

		return url;

	}
}
