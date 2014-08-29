package estam.app.main.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.CmmnDtlCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyStatSensDefaultVO;
import estam.app.fcty.service.FctyStatSensService;
import estam.app.fcty.service.FctyStatSensVO;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlAassRlstService;
import estam.app.iddl.service.IddlAassRlstVO;
import estam.app.main.service.FctyMgrInfoVO;
import estam.app.main.service.MainEventSensVO;
import estam.app.main.service.MainMenuMgrService;
import estam.app.main.service.MainMenuMgrVO;
import estam.app.main.service.MainScnErSensVO;
import estam.app.scn.evnt.service.EhqkOcurInfoDefaultVO;
import estam.app.scn.evnt.service.EhqkOcurInfoService;
import estam.app.scn.mma.service.FctyMmaService;
import estam.app.scn.mma.service.FctyMmaVO;

/**
 * 메인 페이지 컨트롤러 클래스
 * 
 * @author atres
 * @since 2013.07.06
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2013.07.06  atres     최초 생성
 * 
 * </pre>
 */
@Controller
@SessionAttributes(types = ComDefaultVO.class)
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	// 화면출력 데이터를 담아 둘 전역 객체
	// 이상진동감지
	// private static final Map<String, Object> eventSensMap = new
	// HashMap<String, Object>();

	// 이상진동감지
	// private static final int eventSensCnt = 0;

	private static final String FCTY_EVENT_SENS = "01";
	// 계측신호오류감지
	// private static final Map<String, Object> scnErSensMap = new
	// HashMap<String, Object>();

	// 계측신호오류감지
	// private static final int scnErSensCnt = 0;
	private static final String FCTY_SCNER_SENS = "02";

	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	@Resource(name = "fctyStatSensService")
	private FctyStatSensService fctyStatSensService;

	// 지진발생정보
	@Resource(name = "ehqkOcurInfoService")
	private EhqkOcurInfoService ehqkOcurInfoService;

	// 지진안정성분석결과 목록, 점검필요 시설물목록,분석결과요약,그래프
	@Resource(name = "iddlAassRlstService")
	private IddlAassRlstService iddlAassRlstService;

	/**
	 * EgovBBSManageService
	 */
	// @Resource(name = "EgovBBSManageService")
	// private EgovBBSManageService bbsMngService;

	/** MainMenuMgrService */
	@Resource(name = "mainMenuMgrService")
	private MainMenuMgrService mainMenuMgrService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	@Resource(name = "fctyMmaService")
	private FctyMmaService fctyMmaService;

	/**
	 * 메인 페이지에서 각 업무 화면으로 연계하는 기능을 제공한다.
	 * 
	 * @param request
	 * @param commandMap
	 * @exception Exception
	 *                Exception
	 */
	@RequestMapping(value = "/cmm/forwardPage.do")
	public String forwardPageWithMenuNo(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		return "";
	}

	@RequestMapping(value = "/intro/EstamIncEvntMapLeft.do")
	public String selectIntroEvntIncMapLeft(@ModelAttribute("mainMenuMgrVO") MainMenuMgrVO mainMenuMgrVO, ModelMap model) throws Exception {
		Map<String, Object> mapFctyLeft = new HashMap<String, Object>();

		List listFctyLeft = mainMenuMgrService.selectEstamIncMapLeft(mainMenuMgrVO);

		for (int idx = 0; idx < listFctyLeft.size(); idx++) {
			mapFctyLeft = (Map<String, Object>) listFctyLeft.get(idx);
		}
		model.addAttribute("readFctyLeft", mapFctyLeft);

		return "estam/intro/intro_estam"; // left 계측소 개수를 리턴한다./이미지링크도 같이 동일하게

	}

	/**
	 * 템플릿 메인 페이지 조회
	 * 
	 * @return 메인페이지 정보 Map [key : 항목명]
	 * 
	 * @param request
	 * @param model
	 * @exception Exception
	 *                Exception
	 */
	@RequestMapping(value = "/main/MainPage.do")
	public String getMainPage(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {

		// MainMapLocationVO mapLocationVo = new MainMapLocationVO();
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		List<CmmnDtlCode> restdeCodeList;
		// 선택된 flag 값에 따른 지도 표출
		String leftMapGubun = String.valueOf(model.get("flag"));
		if (leftMapGubun == null) {
			leftMapGubun = "PGA"; // null인경우 메인화면에 기본값으로 초기화
		}
		// left 시설물 종류에 따른 시설물갯수 및 기타정보
		List listFctyTypeInfo = fctyMgrService.listFctyTypeInfo();
		model.put("listFctyTypeInfo", listFctyTypeInfo);

		// 지진정보에 데이터가 들어오는 경우 처리 부분 추가
		vo.setCommCd("ITEM_001"); // 이상감지기
		restdeCodeList = cmmUseService.selectCmmCodeDetail(vo);

		for (int i = 0; i < restdeCodeList.size(); i++) {
			CmmnDtlCode cmmnDtlCode = new CmmnDtlCode();
			cmmnDtlCode = (CmmnDtlCode) restdeCodeList.get(i);
			logger.debug("===== /main/MainPage =====" + cmmnDtlCode.getItem01());
			model.put("fctyStatScnGal", cmmnDtlCode.getItem01());
		}

		vo.setCommCd("ITEM_002"); // 이상감지기
		restdeCodeList = cmmUseService.selectCmmCodeDetail(vo);

		for (int i = 0; i < restdeCodeList.size(); i++) {
			CmmnDtlCode cmmnDtlCode = new CmmnDtlCode();
			cmmnDtlCode = (CmmnDtlCode) restdeCodeList.get(i);

			model.put("fctyStatScnErr01", cmmnDtlCode.getItem01()); // 계측신호이상감지
			model.put("fctyStatScnErr02", cmmnDtlCode.getItem02()); // 계측신호이상감GAL

		}

		// 공지사항 메인 컨텐츠 조회 시작 ---------------------------------
		// BoardVO boardVO = new BoardVO();
		// boardVO.setPageUnit(5);
		// boardVO.setPageSize(10);//
		// boardVO.setBbsId("BBSMSTR_AAAAAAAAAAAA");
		//
		// PaginationInfo paginationInfo = new PaginationInfo();
		//
		// paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
		// paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
		// paginationInfo.setPageSize(boardVO.getPageSize());
		//
		// boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		// boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
		// boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		//
		// Map<String, Object> map = bbsMngService.selectBoardArticles(boardVO,
		// "BBSA02");
		// model.addAttribute("notiList", map.get("resultList"));
		//
		// boardVO.setBbsId("BBSMSTR_BBBBBBBBBBBB");
		// map = bbsMngService.selectBoardArticles(boardVO, "BBSA02");
		// model.addAttribute("galList", map.get("resultList"));

		// 공지사항 메인컨텐츠 조회 끝 -----------------------------------
		model.put("leftMapGubun", leftMapGubun); // 지도맵처리구분자.
		model.put("curLinkUrl", "/main/MainPage.do"); // 현재 페이지에 따른 값을 처리하기위해 추가
		request.setAttribute("menuNo", "SCN01000");

		return "/estam/main/EstamMain";
	}

	/**
	 * 템플릿 메인 페이지 조회
	 * 
	 * @return 메인페이지 정보 Map [key : 항목명]
	 * 
	 * @param request
	 * @param model
	 * @exception Exception
	 *                Exception
	 */
	@RequestMapping(value = "/main/EstamEventMain.do")
	public String actionMainEvent(HttpServletRequest request, ModelMap model) throws Exception {

		// 선택된 flag 값에 따른 지도 표출
		String leftMapGubun = String.valueOf(model.get("flag"));

		if (leftMapGubun == null) {
			leftMapGubun = "PGA"; // null인경우 메인화면에 기본값으로 초기화
		}
		// left 시설물 종류에 따른 시설물갯수 및 기타정보
		List listFctyTypeInfo = fctyMgrService.listFctyTypeInfo();
		model.put("listFctyTypeInfo", listFctyTypeInfo);

		model.put("leftMapGubun", leftMapGubun); // 지도맵처리구분자.
		model.put("curLinkUrl", "/main/EstamEventMain.do"); // 현재 페이지에 따른 값을
															// 처리하기위해 추가

		return "/estam/emain/EstamEventMain";
	}

	/**
	 * Head메뉴를 조회한다.
	 * 
	 * @param mainMenuMgrVO
	 *            MainMenuMgrVO
	 * @return 출력페이지정보 "main_headG", "main_head"
	 * @exception Exception
	 */
	@RequestMapping(value = "/main/EstamIncHeader.do")
	public String selectMainMenuHead(@ModelAttribute("mainMenuMgrVO") MainMenuMgrVO mainMenuMgrVO,
			@RequestParam(value = "flag", required = false) String flag, ModelMap model) throws Exception {

		LoginVO user = EgovUserDetailsHelper.isAuthenticated() ? (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser() : null;

		if (EgovUserDetailsHelper.isAuthenticated() && user != null) {

			mainMenuMgrVO.setPrivGrpNo(user.getPrivGrpNo()); // 권한그룹설정...
			// model.addAttribute("list_headmenu",
			// mainMenuMgrService.selectMainMenuHeadByAuthor(mainMenuMgrVO));

		} else {

			mainMenuMgrVO.setPrivGrpNo(BigDecimal.ZERO); // 2014-01-21 쿼리 변경 및 0
															// 번을 로그인 없는 사용자로 정의
			// mainMenuMgrVO.setPrivGrpNo(BigDecimal.ZERO);
			// model.addAttribute("list_headmenu",
			// mainMenuMgrService.selectMainMenuHead(mainMenuMgrVO));

		}
		model.addAttribute("list_headmenu", mainMenuMgrService.selectMainMenuHeadByAuthor(mainMenuMgrVO));

		logger.debug("list_headmenu" + mainMenuMgrVO.getLinkUrlImg());
		// if(flag==null){
		// return "estam/main/inc/EstamIncHeader"; // 기타처리
		// }else if(flag.equals("MAIN")){
		return "estam/main/inc/EstamIncHeader"; // 메인화면의 상단메뉴 화면
		// }
	}

	/**
	 * 전체 계측소 카운트
	 * 
	 * @return
	 * @throws Exception
	 */
	private Map<String, Object> fctyTotalCnt() throws Exception {

		Map<String, Object> fctyTotVal = new HashMap<String, Object>();

		int fctyTotCnt = fctyMgrService.selectFctyTotCnt();
		fctyTotVal.put("fctyTotCnt", fctyTotCnt);

		return fctyTotVal;
	}

	/**
	 * 이상진동감지
	 * 
	 * @param fctyJsonData
	 * @return
	 */
	@RequestMapping(value = "/main/EventInfoJson.do")
	@ResponseBody
	public String getEventInfoJson(@RequestBody Map<String, Object> eventJsonData) throws Exception {

		Map<String, Object> fctyDataMap = new HashMap<String, Object>();
		MainEventSensVO vMainEventSensVo = new MainEventSensVO();
		FctyStatSensDefaultVO searchVO = new FctyStatSensDefaultVO();
		List<MainEventSensVO> tpMainEvntSens = new ArrayList<MainEventSensVO>();
		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		logger.debug("EventInfoJson01 : " + eventJsonData.get("flag"));
		searchVO.setFctyStatSensGbcd(FCTY_EVENT_SENS); // 이상진동감지

		try {
			// List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기
			// 위해선언*/
			//
			// toList= (ArrayList)body.get("data");
			//
			// for(int i=0; i<toList.size();i++){
			// Map<String, Object> detail = new HashMap<String, Object>();
			// detail = (Map<String, Object>)toList.get(i);
			// logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			// }
			//
			int totCnt = fctyStatSensService.selectFctyStatSensListTotCnt(searchVO);
			if (totCnt == 0) {
				vMainEventSensVo.setEvntSensCnt("없음");
			} else {
				vMainEventSensVo.setEvntSensCnt(String.valueOf(totCnt));
			}

			// 계측소 개수
			vMainEventSensVo.setFctyTotCnt(fctyTotalCnt().get("fctyTotCnt").toString());

			vMainEventSensVo.setCurrDateTime(""); // 발생시각
			vMainEventSensVo.setEvntSensPga(BigDecimal.ZERO); // pga

			vMainEventSensVo.setFctyCd("");
			vMainEventSensVo.setFctyLat("");
			vMainEventSensVo.setFctyLon("");
			vMainEventSensVo.setFctyNm("");
			vMainEventSensVo.setFctyUsrTel("");

			List<FctyStatSensVO> fctyStatSensList = fctyStatSensService.selectFctyStatSensList(searchVO);

			if (fctyStatSensList.size() > 0) {
				for (int i = 0; i < fctyStatSensList.size(); i++) {

					Map<String, Object> fctyStatSensVO = new HashMap<String, Object>();

					fctyStatSensVO = (Map<String, Object>) fctyStatSensList.get(i);

					vMainEventSensVo.setCurrDateTime(fctyStatSensVO.get("fctyStatSensTm").toString()); // 발생시각
					vMainEventSensVo.setEvntSensPga(new BigDecimal(fctyStatSensVO.get("fctyStatSensPga").toString())); // pga

					vMainEventSensVo.setFctyCd(fctyStatSensVO.get("fctyCd").toString());
					vMainEventSensVo.setFctyLat(fctyStatSensVO.get("fctyLat").toString());
					vMainEventSensVo.setFctyLon(fctyStatSensVO.get("fctyLon").toString());
					vMainEventSensVo.setFctyNm(fctyStatSensVO.get("fctyNm").toString());
					vMainEventSensVo.setFctyUsrTel(fctyStatSensVO.get("fctyUsrTel") == null ? "" : fctyStatSensVO.get("fctyUsrTel").toString());

					tpMainEvntSens.add(vMainEventSensVo);

					if (i == 10)
						break;

				}
			} else {
				tpMainEvntSens.add(vMainEventSensVo);
			}

			fctyDataMap.put("mainEventSens", tpMainEvntSens);
			reqDataJson = m.writeValueAsString(fctyDataMap);
			logger.debug("FctyInfoJson : " + reqDataJson);

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

		return reqDataJson;

	}

	// TODO 확인 후 삭제 - 계측신호오류감지
	// public void setScnErSens(MainScnErSensVO vScnErSens) {
	//
	// //들어온 데이터에 따른 데이터 베이스 저장
	// //DELETE --> INSERT
	// FctyStatSensVO vFctyStatSensVo = new FctyStatSensVO();
	// vFctyStatSensVo.setFctyCd(vScnErSens.getFctyCd());
	// vFctyStatSensVo.setFctyStatSensGbcd(FCTY_SCNER_SENS); //계측신호오류감지
	// vFctyStatSensVo.setFctyStatSensTm(vScnErSens.getCurrDateTime());
	// vFctyStatSensVo.setFctyStatSensPga(BigDecimal.ZERO);
	// //TODO 사용자정보 추가
	// connSens(vFctyStatSensVo); //삭제 등록 메서드 호출
	//
	// }

	/**
	 * left 시설물 종류별 계측소 갯수를 가지고 온다.
	 * 
	 * @param mainMenuMgrVO
	 *            MainMenuMgrVO
	 * @return 출력페이지정보 "main_headG", "main_head"
	 * @exception Exception
	 */
	@RequestMapping(value = "/main/EstamIncMapLeft.do")
	public String selectEstamIncMapLeft(@ModelAttribute("mainMenuMgrVO") MainMenuMgrVO mainMenuMgrVO, ModelMap model) throws Exception {
		try {
			Map<String, Object> mapFctyLeft = new HashMap<String, Object>();

			List listFctyLeft = mainMenuMgrService.selectEstamIncMapLeft(mainMenuMgrVO);

			for (int idx = 0; idx < listFctyLeft.size(); idx++) {
				mapFctyLeft = (Map<String, Object>) listFctyLeft.get(idx);
			}
			model.addAttribute("readFctyLeft", mapFctyLeft);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "estam/main/inc/EstamIncMapLeft"; // left 계측소 개수를 리턴한다./이미지링크도 같이
													// 동일하게

	}

	/**
	 * left 시설물 종류별 계측소 갯수를 가지고 온다.
	 * 
	 * @param mainMenuMgrVO
	 *            MainMenuMgrVO
	 * @return 출력페이지정보 "main_headG", "main_head"
	 * @exception Exception
	 */
	@RequestMapping(value = "/main/EstamIncEvntMapLeft.do")
	public String selectEstamEvntIncMapLeft(@ModelAttribute("mainMenuMgrVO") MainMenuMgrVO mainMenuMgrVO, ModelMap model) throws Exception {
		Map<String, Object> mapFctyLeft = new HashMap<String, Object>();

		List listFctyLeft = mainMenuMgrService.selectEstamIncMapLeft(mainMenuMgrVO);

		for (int idx = 0; idx < listFctyLeft.size(); idx++) {
			mapFctyLeft = (Map<String, Object>) listFctyLeft.get(idx);
		}
		model.addAttribute("readFctyLeft", mapFctyLeft);

		return "estam/emain/inc/EstamIncEvntMapLeft"; // left 계측소 개수를
														// 리턴한다./이미지링크도 같이 동일하게

	}

	/**
	 * 계측신호 오류 감지
	 * 
	 * @param ScnJsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main/ScnErrInfoJson.do")
	@ResponseBody
	public String getScnErrInfoJson(@RequestBody Map<String, Object> ScnJsonData) throws Exception {

		Map<String, Object> fctyDataMap = new HashMap<String, Object>();
		MainScnErSensVO vMainScnErSensVO = new MainScnErSensVO();
		List<MainScnErSensVO> tpMainEvntSens = new ArrayList<MainScnErSensVO>();
		FctyStatSensDefaultVO searchVO = new FctyStatSensDefaultVO();
		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		logger.debug("FctyInfoJson01 : " + ScnJsonData.get("flag"));
		searchVO.setFctyStatSensGbcd(FCTY_SCNER_SENS); // 계측신호 오류 감지
		try {
			// List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기
			// 위해선언*/
			//
			// toList= (ArrayList)body.get("data");
			//
			// for(int i=0; i<toList.size();i++){
			// Map<String, Object> detail = new HashMap<String, Object>();
			// detail = (Map<String, Object>)toList.get(i);
			// logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			// }

			int totCnt = fctyStatSensService.selectFctyStatSensListTotCnt(searchVO);
			if (totCnt == 0) {
				vMainScnErSensVO.setEvntErSensCnt("없음");
			} else {
				vMainScnErSensVO.setEvntErSensCnt(String.valueOf(totCnt));
			}

			// 계측소 개수
			vMainScnErSensVO.setFctyTotCnt(fctyTotalCnt().get("fctyTotCnt").toString());

			vMainScnErSensVO.setCurrDateTime(""); // 발생시각
			// vMainScnErSensVO.setEvntSensPga(fctyStatSensVO.getFctyStatSensPga());
			// //pga

			vMainScnErSensVO.setFctyCd("");
			vMainScnErSensVO.setFctyLat("");
			vMainScnErSensVO.setFctyLon("");
			vMainScnErSensVO.setFctyNm("");
			vMainScnErSensVO.setFctyKndNm("");

			List<HashMap<String, Object>> fctyStatSensList = fctyStatSensService.selectFctyStatSensList(searchVO);

			/*
			 * if (fctyStatSensList.size() > 0) { for(int i=0;
			 * i<fctyStatSensList.size();i++){
			 * 
			 * Map<String, Object> fctyStatSensVO = new HashMap<String,
			 * Object>();
			 * 
			 * fctyStatSensVO = (Map) fctyStatSensList.get(i);
			 * 
			 * vMainScnErSensVO.setCurrDateTime(fctyStatSensVO.get("fctyStatSensTm"
			 * ).toString()); //발생시각 //
			 * vMainScnErSensVO.setEvntSensPga(fctyStatSensVO
			 * .getFctyStatSensPga()); //pga
			 * 
			 * vMainScnErSensVO.setFctyCd(fctyStatSensVO.get("fctyCd").toString()
			 * );
			 * vMainScnErSensVO.setFctyLat(fctyStatSensVO.get("fctyLat").toString
			 * ());
			 * vMainScnErSensVO.setFctyLon(fctyStatSensVO.get("fctyLon").toString
			 * ());
			 * vMainScnErSensVO.setFctyNm(fctyStatSensVO.get("fctyNm").toString
			 * ()); vMainScnErSensVO.setFctyKndNm("[".concat(fctyStatSensVO.get(
			 * "fctyKndNm").toString()).concat("]"));
			 * 
			 * logger.debug("vMainScnErSensVO  데이터 확인. : " +
			 * vMainScnErSensVO.toString());
			 * 
			 * tpMainEvntSens.add(vMainScnErSensVO);
			 * 
			 * } } else { tpMainEvntSens.add(vMainScnErSensVO); }
			 */

			fctyDataMap.put("mainScnErSens", fctyStatSensList);
			fctyDataMap.put("evntErSensCnt", vMainScnErSensVO.getEvntErSensCnt());
			fctyDataMap.put("fctyTotCnt", vMainScnErSensVO.getFctyTotCnt());

			reqDataJson = m.writeValueAsString(fctyDataMap);

			logger.debug("FctyInfoJson : " + reqDataJson);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return reqDataJson;

	}

	/**
	 * 시설물 기본정보
	 * 
	 * @param fctyJsonData
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/main/FctyInfoJson.do")
	@ResponseBody
	public String getFctyInfoJson(@RequestBody Map<String, Object> fctyJsonData) throws Exception {

		Map<String, Object> fctyDataMap = new HashMap<String, Object>();
		FctyMgrInfoVO vFctyMgrInfoVo = new FctyMgrInfoVO();
		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		logger.debug("FctyInfoJson : " + fctyJsonData.get("fctyFlag"));
		logger.debug("FctyInfoJson : " + fctyJsonData.get("fctyCd"));
		logger.debug("FctyInfoJson : " + fctyJsonData.get("gvmtCd"));

		try {
			// List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기
			// 위해선언*/
			//
			// toList= (ArrayList)body.get("data");
			//
			// for(int i=0; i<toList.size();i++){
			// Map<String, Object> detail = new HashMap<String, Object>();
			// detail = (Map<String, Object>)toList.get(i);
			// logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			// }

			vFctyMgrInfoVo.setFctyCd(String.valueOf(fctyJsonData.get("fctyCd")));
			vFctyMgrInfoVo.setGvmtCd(String.valueOf(fctyJsonData.get("gvmtCd")));
			vFctyMgrInfoVo = fctyMgrService.selectFctyMgrInfo(vFctyMgrInfoVo);

			fctyDataMap.put("vFctyMgrInfoVo", vFctyMgrInfoVo);

			reqDataJson = m.writeValueAsString(fctyDataMap);
			logger.debug("FctyInfoJson : " + reqDataJson);

		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reqDataJson;

	}

	/**
	 * 지진정보
	 * 
	 * @param ehqkJsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main/EhqkInfoJson.do")
	@ResponseBody
	public String getEhqkInfoJson(@RequestBody Map<String, Object> ehqkJsonData) throws Exception {

		Map<String, Object> ehqkDataMap = new HashMap<String, Object>();

		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		logger.debug("EventInfoJson : " + ehqkJsonData.get("flag"));
		EhqkOcurInfoDefaultVO searchVO = new EhqkOcurInfoDefaultVO();

		try {
			// List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기
			// 위해선언*/
			//
			// toList= (ArrayList)body.get("data");
			//
			// for(int i=0; i<toList.size();i++){
			// Map<String, Object> detail = new HashMap<String, Object>();
			// detail = (Map<String, Object>)toList.get(i);
			// logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			// }
			// TODO 5분단위로 돌리던지 해서 10개의 스펙이 보이도록처리한다.

			searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
			searchVO.setPageSize(propertiesService.getInt("pageSize"));

			searchVO.setFirstIndex(0);
			searchVO.setLastIndex(10);
			searchVO.setRecordCountPerPage(1);

			searchVO.setFctyCd(ehqkJsonData.get("fctyCd").toString());
			searchVO.setGvmtCd(ehqkJsonData.get("gvmtCd").toString());
			searchVO.setIddlAassNo(ehqkJsonData.get("iddlAassNo").toString());
			searchVO.setEhqkReqId(ehqkJsonData.get("ehqkReqId").toString());
			searchVO.setEhqkTranGbcd(ehqkJsonData.get("ehqkTranGbcd").toString());

			@SuppressWarnings("rawtypes")
			List ehqkOcurInfoList = ehqkOcurInfoService.selectEhqkOcurInfoList(searchVO);

			ehqkDataMap.put("ehqkOcurInfoList", ehqkOcurInfoList);

			reqDataJson = m.writeValueAsString(ehqkDataMap);
			logger.debug("EhqkInfoJson : " + reqDataJson);
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

		return reqDataJson;

	}

	/**
	 * 분석결과 요약
	 * 
	 * @param ehqkOtnJsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main/EhqkOtnInfoJson.do")
	@ResponseBody
	public String getEhqkOtnInfoJson(@RequestBody Map<String, Object> ehqkOtnJsonData) throws Exception {

		Map<String, Object> ehqkDataMap = new HashMap<String, Object>();
		IddlAassRlstDefaultVO iddlAassRlstDfVo = new IddlAassRlstDefaultVO();
		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		logger.debug("EventInfoJson : " + ehqkOtnJsonData.get("flag"));
		try {
			// List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기
			// 위해선언*/
			//
			// toList= (ArrayList)body.get("data");
			//
			// for(int i=0; i<toList.size();i++){
			// Map<String, Object> detail = new HashMap<String, Object>();
			// detail = (Map<String, Object>)toList.get(i);
			// logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			// }

			iddlAassRlstDfVo.setEhqkReqId(ehqkOtnJsonData.get("ehqkReqId").toString());
			iddlAassRlstDfVo.setEhqkTranGbcd(ehqkOtnJsonData.get("ehqkTranGbcd").toString());
			iddlAassRlstDfVo.setIddlAassNo(new BigDecimal(ehqkOtnJsonData.get("iddlAassNo").toString()));

			List ehqkOtnInfoList = iddlAassRlstService.selectEhqkOtnInfo(iddlAassRlstDfVo);

			ehqkDataMap.put("ehqkOtnInfoList", ehqkOtnInfoList);

			reqDataJson = m.writeValueAsString(ehqkDataMap);
			logger.debug("EhqkInfoJson : " + reqDataJson);

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

		return reqDataJson;

	}

	/**
	 * 점검필요 시설물 목록
	 * 
	 * @param ehqkJsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main/IptnInfoJson.do")
	@ResponseBody
	public String getIptnInfoJson(@RequestBody Map<String, Object> ehqkJsonData) throws Exception {

		Map<String, Object> ehqkDataMap = new HashMap<String, Object>();

		IddlAassRlstDefaultVO iddlAassRlstDfVo = new IddlAassRlstDefaultVO();

		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		logger.debug("EventInfoJson : " + ehqkJsonData.get("flag"));
		try {
			// List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기
			// 위해선언*/
			//
			// toList= (ArrayList)body.get("data");
			//
			// for(int i=0; i<toList.size();i++){
			// Map<String, Object> detail = new HashMap<String, Object>();
			// detail = (Map<String, Object>)toList.get(i);
			// logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			// }
			// TODO 점검필요 시설물 목록.쿼리 추가 화면

			iddlAassRlstDfVo.setEhqkReqId(ehqkJsonData.get("ehqkReqId").toString());
			iddlAassRlstDfVo.setEhqkTranGbcd(ehqkJsonData.get("ehqkTranGbcd").toString());

			int totCnt = iddlAassRlstService.selectFctyChkListTotCnt(iddlAassRlstDfVo);
			if (totCnt == 0) {
				ehqkDataMap.put("iddlFctyChkCnt", "없음");
			} else {
				ehqkDataMap.put("iddlFctyChkCnt", String.valueOf(totCnt));
			}

			// 계측소 개수
			ehqkDataMap.put("fctyTotCnt", fctyTotalCnt().get("fctyTotCnt").toString());

			List iptnInfoList = iddlAassRlstService.selectIptnInfo(iddlAassRlstDfVo);
			ehqkDataMap.put("iptnInfoList", iptnInfoList);

			reqDataJson = m.writeValueAsString(ehqkDataMap);
			logger.debug("iptnInfoList : " + reqDataJson);

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

		return reqDataJson;

	}

	/**
	 * 지진안전성분석결과 목록
	 * 
	 * @param ehqkJsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main/SfResultInfoJson.do")
	@ResponseBody
	public String getSfResultInfoJson(@RequestBody Map<String, Object> ehqkJsonData) throws Exception {

		Map<String, Object> ehqkDataMap = new HashMap<String, Object>();

		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		logger.debug("EventInfoJson : " + ehqkJsonData.get("flag"));
		try {
			// List toList = new ArrayList(); /*Json 데이터중 리스트 구조의 데이터를 추출하기
			// 위해선언*/
			//
			// toList= (ArrayList)body.get("data");
			//
			// for(int i=0; i<toList.size();i++){
			// Map<String, Object> detail = new HashMap<String, Object>();
			// detail = (Map<String, Object>)toList.get(i);
			// logger.debug(">>> 리스트내용중 출력..........."+detail.get("price"));
			// } // TODO 분석결과 요약 처리
			List sfResultInfoList = iddlAassRlstService.selectSfResultInfo();
			ehqkDataMap.put("sfResultInfoList", sfResultInfoList);

			reqDataJson = m.writeValueAsString(ehqkDataMap);
			logger.debug("EhqkInfoJson 데이터 출입하다 : " + reqDataJson);
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

		return reqDataJson;

	}

	/**
	 * 지진안전성분석결과 목록
	 * 
	 * @param ehqkJsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main/onEvntMap.do")
	@ResponseBody
	public String onEvntMap(@RequestBody Map<String, Object> ehqkJsonData) throws Exception {

		ObjectMapper m;
		Map<String, Object> resultMap;
		m = new ObjectMapper();
		resultMap = new HashMap<String, Object>();
		try {

			double unit_g = 980.7;
			double acc_p = 0;
			double v_p = 0;
			double u_p = 0.49;
			double time_p = 1;
			double vMmi = 0;
			double uMmi = 0;

			IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
			IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();
			FctyMmaVO fctyMmaVo = null;

			iddlAassInfoVO.setEhqkReqId(ehqkJsonData.get("ehqkReqId").toString());

			List<IddlAassRlstVO> list = iddlAassRlstService.selectIddlAassInfoList(iddlAassInfoVO);

			// 지도 정보 초기화
			fctyMmaService.updateResetFctyIntensity();

			for (int i = 0; i < list.size(); i++) {

				iddlAassRlstVO = list.get(i);

				String buffMMa = iddlAassRlstVO.getMaxDataFreeAcc();
				fctyMmaVo = new FctyMmaVO();

				fctyMmaVo.setFctyCd(iddlAassRlstVO.getFctyCd());
				fctyMmaVo.setGvmtCd(iddlAassRlstVO.getGvmtCd());
				fctyMmaVo.setFctyPga(new BigDecimal(buffMMa));

				// vMmi = v_p + 0.5 * (acc_p + Double.valueOf(buffMMa)) *
				// time_p;
				// uMmi = u_p + 0.5 * (v_p + vMmi) * 1;

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

				// fctyMmaVo.setFctyMma(new BigDecimal(uMmi));

				// 진도계산하여 넣기
				fctyMmaService.updateFctyIntensity(fctyMmaVo);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		resultMap.put("RESULT", "Y");

		return m.writeValueAsString(resultMap);
	}

	/**
	 * 지진안전성분석결과 목록
	 * 
	 * @param ehqkJsonData
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/main/getMaxEqno.do")
	@ResponseBody
	public String getMaxEqno() throws Exception {

		ObjectMapper m;
		Map<String, Object> resultMap;
		m = new ObjectMapper();
		resultMap = new HashMap<String, Object>();

		String maxEqno;
		try {
			maxEqno = ehqkOcurInfoService.selectMaxEhqkReqId();
			resultMap.put("maxEqno", maxEqno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return m.writeValueAsString(resultMap);
	}
}