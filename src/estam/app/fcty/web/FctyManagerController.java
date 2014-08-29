package estam.app.fcty.web;

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
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.fcty.service.FctyAddInfoService;
import estam.app.fcty.service.FctyAddInfoVO;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyImgVO;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.iddl.service.IddlAassInfoDefaultVO;
import estam.app.iddl.service.IddlAassInfoService;
import estam.app.iddl.service.IddlAassRlstStttService;
import estam.app.scn.rpt.service.RptMgrHolcImgService;
import estam.app.scn.rpt.service.RptMgrHolcImgVO;
import estam.app.spt.service.SptIptnFlorService;
import estam.app.spt.service.SptIptnFlorVO;

/**
 * @Class Name : FctyMgrController.java
 * @Description : FctyMgr Controller class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = FctyMgrVO.class)
public class FctyManagerController {

	private static final Logger logger = LoggerFactory.getLogger(FctyManagerController.class);

	@Resource(name = "iddlAassRlstStttService")
	private IddlAassRlstStttService iddlAassRlstStttService;

	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	@Resource(name = "fctyImgService")
	private FctyImgService fctyImgService;

	@Resource(name = "iddlAassInfoService")
	private IddlAassInfoService iddlAassInfoService;

	@Resource(name = "rptMgrHolcImgService")
	private RptMgrHolcImgService rptMgrHolcImgService;

	@Resource(name = "fctyAddInfoService")
	private FctyAddInfoService fctyAddInfoService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name = "sptIptnFlorService")
	private SptIptnFlorService sptIptnFlorService;

	/**
	 * 시설물 기본정보 화면을 호출한다. 시설물 리스트를 가지고 온다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 FctyMgrDefaultVO
	 * @return "/fcty/FctyMgrList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fcty/FctyManger.do")
	public String selectFctyManger(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, ModelMap model) throws Exception {

		try {
			ComDefaultCodeVO vo = new ComDefaultCodeVO();

			vo.setCommCd("ITEM_008");
			List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("fctyAreaList", fctyAreaList);

			vo.setCommCd("ITEM_011");
			List fctyKndList = cmmUseService.selectCmmCodeDetail(vo);
			model.addAttribute("fctyKndList", fctyKndList);

			List fctyMgrList = fctyMgrService.selectFctyMgrList(searchVO);
			model.addAttribute("fctyMgrList", fctyMgrList);

			int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
			model.addAttribute("fctyMgrCnt", totCnt);

			String fctycdSearch = "";
			if (fctyMgrList.size() > 0) {
				FctyMgrVO fctyMgrVO = (FctyMgrVO) fctyMgrList.get(0);
				fctycdSearch = "fctycd:" + fctyMgrVO.getFctyCd() + ":" + fctyMgrVO.getGvmtCd();
			}
			model.addAttribute("fctycdSearch", fctycdSearch);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "/estam/fcty/FctyManager";
	}

	/**
	 * 선택된 이미지의경로에 데이터를 가지고온다....
	 * 
	 * @param searchVO
	 * @return "/fcty/FctyMgrList"
	 * @exception Exception
	 */
	@SuppressWarnings("null")
	@RequestMapping(value = "/fcty/fctyImage.do")
	public String selectFctyImage(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, ModelMap model) throws Exception {

		FctyImgVO fctyImgVO = new FctyImgVO();
		try {
			fctyImgVO.setFctyCd(searchVO.getFctyCd());
			fctyImgVO.setGvmtCd(searchVO.getGvmtCd());
			fctyImgVO = fctyImgService.selectFctyImg(fctyImgVO);
			model.addAttribute("fctyImgUrl", fctyImgVO);

		} catch (EgovBizException egbe) {

			logger.debug("EgovBizException : " + egbe.getMessage());
			logger.debug("EgovBizException : " + egbe.getMessageKey());
		}

		return "/estam/fcty/inc/FctyIddlMgrTopInfo";
	}

	/**
	 * 최근분석결과를 가지고 온다.
	 * 
	 * @param searchVO
	 * @return "/iddl/IddlAassInfoList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fcty/FctyIddlAassList.do")
	public String selectIddlAassInfoList(@ModelAttribute("searchVO") IddlAassInfoDefaultVO searchVO, ModelMap model) throws Exception {

		try {
			List iddlAassInfoList = iddlAassInfoService.selectIddlAassInfoList(searchVO);
			model.addAttribute("fctyIddlAassList", iddlAassInfoList);

			int totCnt = iddlAassInfoService.selectIddlAassInfoListTotCnt(searchVO);
			model.addAttribute("fctyIddlAassICnt", totCnt);
		} catch (EgovBizException egbe) {

			logger.debug("EgovBizException : " + egbe.getMessage());
			logger.debug("EgovBizException : " + egbe.getMessageKey());
		}

		// IddlEhqkOcurInfoVO eqVo = new IddlEhqkOcurInfoVO();
		// eqVo.setFctyCd(searchVO.getFctyCd());
		// eqVo.setGvmtCd(searchVO.getGvmtCd());
		//
		// List ehqkOcurInfoList =
		// iddlAassRlstStttService.selectIddlEhqkOcurInfoList(eqVo);
		// model.addAttribute("fctyIddlAassList", ehqkOcurInfoList);
		//
		// int totCnt =
		// iddlAassInfoService.selectIddlAassInfoListTotCnt(searchVO);
		// model.addAttribute("fctyIddlAassICnt", totCnt);

		return "/estam/fcty/inc/FctyIddlAassList";
	}

	/**
	 * 시설물기본정보을 보여준다
	 * 
	 * @param searchVO
	 *            -
	 * @return "/fcty/FctyMgrList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/fcty/FctyIddlManager.do")
	public String selectFctyIddlManager(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, ModelMap model) throws Exception {

		// IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
		RptMgrHolcImgVO rptMgrHolcImgVO = new RptMgrHolcImgVO();
		FctyMgrVO fctyMgrVO = new FctyMgrVO(); // 시설물기본정보
		FctyAddInfoVO fctyAddInfoVO = new FctyAddInfoVO(); // 시설물추가정보
		FctyImgVO fctyImgVO = new FctyImgVO(); // 시설물 이미지정보
		SptIptnFlorVO sptIptnFlorVO = new SptIptnFlorVO(); // 도면정보

		logger.debug("searchVO : " + searchVO.toString());

		try {
			// iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
			// iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
			// iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo());
			// iddlAassInfoVO =
			// iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);
			// model.addAttribute("fctyIddlAass", iddlAassInfoVO);

			fctyMgrVO.setFctyCd(searchVO.getFctyCd());
			fctyMgrVO.setGvmtCd(searchVO.getGvmtCd());
			fctyMgrVO = fctyMgrService.selectFctyMgr(fctyMgrVO);
			model.addAttribute("fctyRsltMgr", fctyMgrVO);

			fctyAddInfoVO.setFctyCd(searchVO.getFctyCd());
			fctyAddInfoVO.setGvmtCd(searchVO.getGvmtCd());
			fctyAddInfoVO = fctyAddInfoService.selectFctyAddInfo(fctyAddInfoVO);
			model.addAttribute("fctyAddRsltMgr", fctyAddInfoVO);

			fctyImgVO.setFctyCd(searchVO.getFctyCd());
			fctyImgVO.setGvmtCd(searchVO.getGvmtCd());
			fctyImgVO = fctyImgService.selectFctyImg(fctyImgVO);
			model.addAttribute("fctyRsltImg", fctyImgVO);

			// 날짜의 max 값을 가지고 온다. 09 - 주상도이미지
			// rptMgrHolcImgVO.setConDaGbcd("09");
			// rptMgrHolcImgVO.setFctyCd(searchVO.getFctyCd());
			// rptMgrHolcImgVO =
			// rptMgrHolcImgService.selectRptMgrHolcImg(rptMgrHolcImgVO);
			// model.addAttribute("fctyHolcImg", rptMgrHolcImgVO);
			// 도면정보
			sptIptnFlorVO.setFctyCd(searchVO.getFctyCd());
			sptIptnFlorVO.setGvmtCd(searchVO.getGvmtCd());
			// sptIptnFlorVO.setSptIptnDt(searchVO.getSptInptDt());
			List sptIptnFlorList = sptIptnFlorService.selectSptIptnFlorList(sptIptnFlorVO);

			model.addAttribute("sptIptnFlorList", sptIptnFlorList);

		} catch (EgovBizException egbe) {

			logger.debug("EgovBizException : " + egbe.getMessage());
			logger.debug("EgovBizException : " + egbe.getMessageKey());
			// egbe.printStackTrace();

		}

		return "/estam/fcty/inc/FctyIddlManager";
	}

	// /**
	// * FCTY_MGR 목록을 조회한다. (pageing)
	// * @param searchVO - 조회할 정보가 담긴 FctyMgrDefaultVO
	// * @return "/fcty/FctyMgrList"
	// * @exception Exception
	// */
	// @RequestMapping(value="/fcty/FctyMgrList.do")
	// public String selectFctyMgrList(@ModelAttribute("searchVO")
	// FctyMgrDefaultVO searchVO,
	// ModelMap model)
	// throws Exception {
	//
	// /** EgovPropertyService.sample */
	// searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
	// searchVO.setPageSize(propertiesService.getInt("pageSize"));
	//
	// /** pageing */
	// PaginationInfo paginationInfo = new PaginationInfo();
	// paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
	// paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
	// paginationInfo.setPageSize(searchVO.getPageSize());
	//
	// searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
	// searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
	// searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
	//
	// List fctyMgrList = fctyMgrService.selectFctyMgrList(searchVO);
	// model.addAttribute("resultList", fctyMgrList);
	//
	// int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
	// paginationInfo.setTotalRecordCount(totCnt);
	// model.addAttribute("paginationInfo", paginationInfo);
	//
	// return "/fcty/FctyMgrList";
	// }
	//
	// @RequestMapping("/fcty/addFctyMgrView.do")
	// public String addFctyMgrView(
	// @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, Model model)
	// throws Exception {
	// model.addAttribute("fctyMgrVO", new FctyMgrVO());
	// return "/fcty/FctyMgrRegister";
	// }
	//
	// @RequestMapping("/fcty/addFctyMgr.do")
	// public String addFctyMgr(
	// FctyMgrVO fctyMgrVO,
	// @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// fctyMgrService.insertFctyMgr(fctyMgrVO);
	// status.setComplete();
	// return "forward:/fcty/FctyMgrList.do";
	// }
	//
	// @RequestMapping("/fcty/updateFctyMgrView.do")
	// public String updateFctyMgrView(
	// @RequestParam("fctyCd") java.lang.String fctyCd ,
	// @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, Model model)
	// throws Exception {
	// FctyMgrVO fctyMgrVO = new FctyMgrVO();
	// fctyMgrVO.setFctyCd(fctyCd);
	// // 변수명은 CoC 에 따라 fctyMgrVO
	// model.addAttribute(selectFctyMgr(fctyMgrVO, searchVO));
	// return "/fcty/FctyMgrRegister";
	// }
	//
	// @RequestMapping("/fcty/selectFctyMgr.do")
	// public @ModelAttribute("fctyMgrVO")
	// FctyMgrVO selectFctyMgr(
	// FctyMgrVO fctyMgrVO,
	// @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO) throws Exception {
	// return fctyMgrService.selectFctyMgr(fctyMgrVO);
	// }
	//
	// @RequestMapping("/fcty/updateFctyMgr.do")
	// public String updateFctyMgr(
	// FctyMgrVO fctyMgrVO,
	// @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// fctyMgrService.updateFctyMgr(fctyMgrVO);
	// status.setComplete();
	// return "forward:/fcty/FctyMgrList.do";
	// }
	//
	// @RequestMapping("/fcty/deleteFctyMgr.do")
	// public String deleteFctyMgr(
	// FctyMgrVO fctyMgrVO,
	// @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// fctyMgrService.deleteFctyMgr(fctyMgrVO);
	// status.setComplete();
	// return "forward:/fcty/FctyMgrList.do";
	// }
	//
	// @RequestMapping("/fcty/FctyManger.do")
	// public String fctyManger(
	// FctyMgrVO fctyMgrVO,
	// @ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	//
	// return "/estam/fcty/FctyManger";
	// }

}
