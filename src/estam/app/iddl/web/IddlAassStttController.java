package estam.app.iddl.web;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.iddl.service.FctyListInspVO;
import estam.app.iddl.service.IddlAassRlstStatsVO;
import estam.app.iddl.service.IddlAassRlstStttService;
import estam.app.iddl.service.IddlAassWvflVO;
import estam.app.iddl.service.IddlEhqkOcurInfoVO;

/**
 * @Class Name : IddlAassWvflController.java
 * @Description : IddlAassWvfl Controller class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = IddlAassWvflVO.class)
public class IddlAassStttController {

	private static final Logger logger = LoggerFactory.getLogger(IddlAassStttController.class);

	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	// @Resource(name = "iddlAassWvflService")
	// private IddlAassWvflService iddlAassWvflService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name = "iddlAassRlstStttService")
	private IddlAassRlstStttService iddlAassRlstStttService;

	/**
	 * 평가결과통계자료 - 출력을 위한 화면 호출
	 * 
	 * @param
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/iddl/IddlFctyStttMgr.do")
	public String selectFctyManger(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, ModelMap model) throws Exception {

		try {
			ComDefaultCodeVO vo = new ComDefaultCodeVO();

			vo.setCommCd("ITEM_008");
			List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("fctyAreaList", fctyAreaList);

			vo.setCommCd("ITEM_011");
			List fctyKndList = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("fctyKndList", fctyKndList);

			// System.out.println("[selectFctyManger]fctyAreaCd : "+searchVO.getFctyAreaCd());
			// System.out.println("[selectFctyManger]fctyKndCd : "+searchVO.getFctyKndCd());
			// System.out.println("[selectFctyManger]fctyUseYn : "+searchVO.getFctyUseYn());
			//
			// System.out.println("[selectFctyManger]searchCondition : "+searchVO.getSearchCondition());
			// System.out.println("[selectFctyManger]searchKeyword : "+searchVO.getSearchKeyword());

			// logger.debug("fctyKndList"+ fctyKndList);
			// 가지고 올때 이미지 정보도 통합해서 가지고 온다.
			List fctyMgrList = fctyMgrService.selectFctyMgrList(searchVO);
			model.addAttribute("fctyMgrList", fctyMgrList);

			int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
			model.addAttribute("fctyMgrCnt", totCnt);

			String fctyAreaCd = searchVO.getFctyAreaCd();

			// 지진정보
			IddlEhqkOcurInfoVO eqVo = new IddlEhqkOcurInfoVO();

			// Start of 검색조건과
			// 소트오더---------------------------------------------------------

			String searchKeyword = searchVO.getSearchKeyword(); // 검색어
			String searchCondition = searchVO.getSearchCondition(); // 소트오더

			if (searchKeyword != null && searchKeyword != "") {
				searchKeyword = searchKeyword.replace(",", ""); // 검색조건상에 ,가 존재할
																// 경우 없앰(단일
																// 검색조건만 지원)
				eqVo.setSearchKeyword(searchKeyword);
			}

			if (searchCondition != null && searchCondition != "") {
				eqVo.setSearchCondition(searchCondition);
			}

			// End of 검색조건과 소트오더
			// ---------------------------------------------------------

			// 지역코드
			if (null != fctyAreaCd && "" != fctyAreaCd) {
				eqVo.setFctyAreaCd(fctyAreaCd);
			}

			List ehqkOcurInfoList = iddlAassRlstStttService.selectIddlEhqkOcurInfoList2(eqVo); // 진원시별,
																								// 분석일시별
																								// 1건만
																								// 나오게
																								// 수정함
			model.addAttribute("ehqkOcurInfoList", ehqkOcurInfoList);

			// 점검통계
			IddlAassRlstStatsVO stVo = new IddlAassRlstStatsVO();

			if (null != fctyAreaCd && "" != fctyAreaCd) {
				stVo.setFctyAreaCd(fctyAreaCd);
			}
			model.addAttribute("fctyAreaCd", fctyAreaCd);

			String returnVal = "";
			if (ehqkOcurInfoList.size() > 0) {
				EgovMap ehqkMap = (EgovMap) ehqkOcurInfoList.get(0);
				// logger.debug("ehqkMap.toString() >>>>> "+ehqkMap.toString());
				returnVal = "ehqkList:" + ehqkMap.get("iddlAassDt").toString() + ":" + ehqkMap.get("ehqkOrgTm").toString();
			}
			model.addAttribute("returnVal", returnVal);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * // System.out.println("[selectFctyManger]fctyAreaCd : "+searchVO.
		 * getFctyAreaCd());
		 * 
		 * List iddlAassRlstStatsList =
		 * iddlAassRlstStttService.selectIddlAassRlstStatsList(stVo);
		 * model.addAttribute("iddlAassRlstStatsList", iddlAassRlstStatsList);
		 * 
		 * // 점검필요 시설물 목록 FctyListInspVO flVo = new FctyListInspVO();
		 * 
		 * if (null != fctyAreaCd && "" != fctyAreaCd) {
		 * flVo.setFctyAreaCd(fctyAreaCd); }
		 * 
		 * List fctyListInspList =
		 * iddlAassRlstStttService.selectFctyListInspList(flVo);
		 * model.addAttribute("fctyListInspList", fctyListInspList);
		 */

		return "/estam/iddl/IddlFctyStttMgr";
	}

	@RequestMapping(value = "/iddl/IddlFctyStttRslt.do")
	public String selectIddlFctyStttRslt(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, ModelMap model) throws Exception {

		ComDefaultCodeVO vo = new ComDefaultCodeVO();

		vo.setCommCd("ITEM_008");
		List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyAreaList", fctyAreaList);

		vo.setCommCd("ITEM_011");
		List fctyKndList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyKndList", fctyKndList);

		// 가지고 올때 이미지 정보도 통합해서 가지고 온다.
		List fctyMgrList = fctyMgrService.selectFctyMgrList(searchVO);
		model.addAttribute("fctyMgrList", fctyMgrList);

		int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
		model.addAttribute("fctyMgrCnt", totCnt);

		String fctyAreaCd = searchVO.getFctyAreaCd();

		// 지진정보
		IddlEhqkOcurInfoVO eqVo = new IddlEhqkOcurInfoVO();

		// Start of 검색조건과
		// 소트오더---------------------------------------------------------

		String searchKeyword = searchVO.getSearchKeyword(); // 검색어
		String searchCondition = searchVO.getSearchCondition(); // 소트오더

		if (searchKeyword != null && searchKeyword != "") {
			searchKeyword = searchKeyword.replace(",", ""); // 검색조건상에 ,가 존재할 경우
															// 없앰(단일 검색조건만 지원)
			eqVo.setSearchKeyword(searchKeyword);
		}

		if (searchCondition != null && searchCondition != "") {
			eqVo.setSearchCondition(searchCondition);
		}

		// End of 검색조건과 소트오더
		// ---------------------------------------------------------

		// 지역코드
		if (null != fctyAreaCd && "" != fctyAreaCd) {
			eqVo.setFctyAreaCd(fctyAreaCd);
		}

		// 진원시별, 분석일시별 1건만 나오게 수정함
		List ehqkOcurInfoList = iddlAassRlstStttService.selectIddlEhqkOcurInfoList2(eqVo);
		model.addAttribute("ehqkOcurInfoList", ehqkOcurInfoList);

		// 점검통계
		IddlAassRlstStatsVO stVo = new IddlAassRlstStatsVO();

		if (null != fctyAreaCd && "" != fctyAreaCd) {
			stVo.setFctyAreaCd(fctyAreaCd);
		}
		model.addAttribute("fctyAreaCd", fctyAreaCd);

		stVo.setEhqkOrgTm(searchVO.getEhqkOrgTm());
		stVo.setIddlAassDt(searchVO.getIddlAassDt());

		List iddlAassRlstStatsList = iddlAassRlstStttService.selectIddlAassRlstStatsList(stVo);
		model.addAttribute("iddlAassRlstStatsList", iddlAassRlstStatsList);

		// 점검필요 시설물 목록
		FctyListInspVO flVo = new FctyListInspVO();

		if (null != fctyAreaCd && "" != fctyAreaCd) {
			flVo.setFctyAreaCd(fctyAreaCd);
		}
		flVo.setEhqkReqId(searchVO.getEhqkReqId());

		List fctyListInspList = iddlAassRlstStttService.selectFctyListInspList(flVo);
		model.addAttribute("fctyListInspList", fctyListInspList);

		return "/estam/iddl/inc/IddlFctyStttRslt";
	}

}
