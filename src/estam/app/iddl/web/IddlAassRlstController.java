package estam.app.iddl.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.Globals;
import egovframework.rte.fdl.cmmn.exception.EgovBizException;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyImgVO;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.iddl.service.IddlAassInfoDefaultVO;
import estam.app.iddl.service.IddlAassInfoService;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassOpinVService;
import estam.app.iddl.service.IddlAassOpinVVO;
import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlAassRlstService;
import estam.app.iddl.service.IddlAassRlstStttService;
import estam.app.iddl.service.IddlAassRlstVO;
import estam.app.iddl.service.IddlAassWvflService;
import estam.app.iddl.service.IddlEhqkOcurInfoVO;
import estam.app.iddl.service.WvIddlAassRlstVO;
import estam.app.signalux.service.AnysIdxCoffCfgService;
import estam.app.signalux.service.AnysIdxCoffCfgVO;

/**
 * @Class Name : IddlAassRlstController.java
 * @Description : IddlAassRlst Controller class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = IddlAassRlstVO.class)
public class IddlAassRlstController {

	private static final Logger logger = LoggerFactory.getLogger(IddlAassRlstController.class);
	// TODO 받아야함.
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_10 = { "f_acc.rec" }; // 가속도
																				// 파형3
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_10 = { "4" }; // 가속도
																			// 파형3
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_20 = { "f_vel.rec" }; // 속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_20 = { "4" }; // 속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_30 = { "f_dis.rec" }; // 변위
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_30 = { "4" }; // 변위
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_40 = { "f_hvr.rec", "f_spect.rec" }; // 응답스펙트럼
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_40 = { "2", "7" }; // 응답스펙트럼
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_50 = { "tr_acc.rec" }; // 최상층가속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_50 = { "3" }; // 최상층가속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_60 = { "tr_vel.rec" }; // 최상층속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_60 = { "3" }; // 최상층속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_70 = { "tr_dis.rec" }; // 최상층
																					// 변위
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_70 = { "3" }; // 최상층
																			// 변위
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_80 = { "tr_tf.rec", "tr_dis.rec" }; // 안정성평가결과
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_80 = { "3", "3" }; // 안정성평가결과

	@Resource(name = "iddlAassRlstService")
	private IddlAassRlstService iddlAassRlstService;

	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	@Resource(name = "fctyImgService")
	private FctyImgService fctyImgService;

	@Resource(name = "iddlAassWvflService")
	private IddlAassWvflService iddlAassWvflService;

	@Resource(name = "iddlAassInfoService")
	private IddlAassInfoService iddlAassInfoService;

	@Resource(name = "iddlAassOpinVService")
	private IddlAassOpinVService iddlAassOpinVService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name = "anysIdxCoffCfgService")
	private AnysIdxCoffCfgService anysIdxCoffCfgService;

	@Resource(name = "iddlAassRlstStttService")
	private IddlAassRlstStttService iddlAassRlstStttService;

	/**
	 * 계측및 평가결과 화면 호출
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 FctyMgrDefaultVO
	 * @return "/fcty/FctyMgrList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/iddl/IddlFctyRlstMgr.do")
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
		// 안쓰는 듯 해서 주석처리
		// int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
		// model.addAttribute("fctyMgrCnt", totCnt);

		return "/estam/iddl/IddlFctyRlstMgr";
	}

	/**
	 * 선택된 이미지의경로에 데이터를 가지고온다.... 위에 통합.
	 * 
	 * @param searchVO
	 * @return "/fcty/FctyMgrList"
	 * @exception Exception
	 */
	@SuppressWarnings("null")
	@RequestMapping(value = "/iddl/IddlFctyImage.do")
	public String selectFctyImage(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, ModelMap model) throws Exception {
		try {
			FctyImgVO fctyImgVO = new FctyImgVO();

			fctyImgVO.setFctyCd(searchVO.getFctyCd());
			fctyImgVO.setGvmtCd(searchVO.getGvmtCd());

			fctyImgVO = fctyImgService.selectFctyImg(fctyImgVO);
			model.addAttribute("fctyImgUrl", fctyImgVO);

		} catch (EgovBizException egbe) {

			logger.debug("EgovBizException : " + egbe.getMessage());
			logger.debug("EgovBizException : " + egbe.getMessageKey());
			// egbe.printStackTrace();

		}
		return "/estam/iddl/inc/IddlFctyImage";
	}

	/**
	 * 최근분석결과를 가지고 온다. max 값.일자별 max값.
	 * 
	 * @param searchVO
	 * @return "/iddl/IddlAassInfoList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/iddl/IddlAassInfoList.do")
	public String selectIddlAassInfoList(@ModelAttribute("searchVO") IddlAassInfoDefaultVO searchVO, ModelMap model) throws Exception {

		IddlEhqkOcurInfoVO eqVo = new IddlEhqkOcurInfoVO();
		eqVo.setFctyCd(searchVO.getFctyCd());
		eqVo.setGvmtCd(searchVO.getGvmtCd());

		// List ehqkOcurInfoList =
		// iddlAassRlstStttService.selectIddlEhqkOcurInfoList(eqVo);
		List ehqkOcurInfoList = iddlAassRlstStttService.selectIddlEhqkOcurRptInfoList(eqVo);
		model.addAttribute("ehqkOcurInfoList", ehqkOcurInfoList);

		// List iddlAassInfoList =
		// iddlAassInfoService.selectIddlAassInfoList(searchVO);
		// model.addAttribute("iddlAassInfoList", iddlAassInfoList);
		// 안쓰는 것 같아서
		// int totCnt =
		// iddlAassInfoService.selectIddlAassInfoListTotCnt(searchVO);
		// model.addAttribute("iddlAassCnt", totCnt);

		return "/estam/iddl/inc/IddlAassInfoList";
	}

	/**
	 * 계측및평가결과 화면상단 도표을 그리기위한 최근 값을 가지고 온다. 선택된 항목에 대해서...
	 * 
	 * @param searchVO
	 * @return "/iddl/ReadIddlAassRlst"
	 * @exception Exception
	 */
	@RequestMapping(value = "/iddl/ReadIddlAassRlstData.do")
	public String readIddlAassRlstData(@ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, ModelMap model) throws Exception {

		IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();

		iddlAassRlstVO.setFctyCd(searchVO.getFctyCd());
		iddlAassRlstVO.setGvmtCd(searchVO.getGvmtCd());
		iddlAassRlstVO.setIddlAassNo(searchVO.getIddlAassNo());

		iddlAassRlstVO = iddlAassRlstService.selectIddlAassRlst(iddlAassRlstVO);
		model.addAttribute("readIddlAssRlst", iddlAassRlstVO);

		return "/estam/iddl/inc/iddlLeftAclnInfoData";

	}

	@RequestMapping(value = "/iddl/ReadIddlAassRlst.do")
	public String readIddlAassRlst(@ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, HttpServletRequest request, ModelMap model)
			throws Exception {

		IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();

		iddlAassRlstVO.setFctyCd(searchVO.getFctyCd());
		iddlAassRlstVO.setGvmtCd(searchVO.getGvmtCd());
		iddlAassRlstVO.setIddlAassNo(searchVO.getIddlAassNo());

		iddlAassRlstVO = iddlAassRlstService.selectIddlAassRlst(iddlAassRlstVO);
		model.addAttribute("readIddlAssRlst", iddlAassRlstVO);

		String url = "/estam/iddl/inc/iddlLeftAclnInfo";
		ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
		ArrayList<WvIddlAassRlstVO> wvList2 = new ArrayList<WvIddlAassRlstVO>();
		// wvList = null;
		// wvList2 = null;
		// if(searchVO.getIddlAassNo() != null && searchVO.getEhqkReqId() !=
		// null) {
		String storageFilePath = Globals.STORAGE_ROOT; // 스토리지에 파형위치 정보를 가지고
														// 온다...
		String filePath = "";

		IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();

		if (searchVO.getIddlAassNo() != null && searchVO.getEhqkReqId() != null) {

			iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
			iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
			iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo());
			iddlAassInfoVO.setEhqkReqId(searchVO.getEhqkReqId());

			iddlAassInfoVO = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);

			int modes = Integer.parseInt(searchVO.getModes());
			filePath = iddlAassInfoVO.getWvScnRsltFlsv() + "/";
			// filePath = "SIGNALUX/";

			switch (modes) {
			case 10:
				// 가속도
				url = "/estam/iddl/inc/iddlLeftAclnInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_10[0], FCTY_SCN_RSLT_FILE_COLUMN_10[0]);
				break;
			case 20:
				// 속도
				url = "/estam/iddl/inc/iddlLeftVltyInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_20[0], FCTY_SCN_RSLT_FILE_COLUMN_20[0]);
				break;
			case 30:
				// 변위
				url = "/estam/iddl/inc/iddlLeftDsltInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_30[0], FCTY_SCN_RSLT_FILE_COLUMN_30[0]);
				break;
			case 40:
				// 응답스펙트럼
				url = "/estam/iddl/inc/iddlLeftSptmInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_40[0], FCTY_SCN_RSLT_FILE_COLUMN_40[0]);
				wvList2 = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_40[1], FCTY_SCN_RSLT_FILE_COLUMN_40[1]);
				break;
			case 50:
				// 최상층가속도
				url = "/estam/iddl/inc/iddlLeftTopAclnInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_50[0], FCTY_SCN_RSLT_FILE_COLUMN_50[0]);
				break;
			case 60:
				// 최상층속도
				url = "/estam/iddl/inc/iddlLeftTopVltyInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_60[0], FCTY_SCN_RSLT_FILE_COLUMN_60[0]);
				break;
			case 70:
				// 최승층변위
				url = "/estam/iddl/inc/iddlLeftTopDsltInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_70[0], FCTY_SCN_RSLT_FILE_COLUMN_70[0]);
				break;
			case 80:
				// 안정성평가결과
				url = "/estam/iddl/inc/iddlLeftStabEvalInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_80[0], FCTY_SCN_RSLT_FILE_COLUMN_80[0]);
				wvList2 = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_80[1], FCTY_SCN_RSLT_FILE_COLUMN_80[1]);
				break;
			case 100:
				// 계측자료 누적기록
				url = "/estam/iddl/inc/iddlLeftCmlvEfftInfo";
				break;
			default:
				// 가속도
				url = "/estam/iddl/inc/iddlLeftAclnInfo";
				wvList = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_10[0], FCTY_SCN_RSLT_FILE_COLUMN_10[0]);
				break;
			}

			request.setAttribute("data", wvList);
			request.setAttribute("data2", wvList2);

		} else {
			request.setAttribute("data", wvList);
			request.setAttribute("data2", wvList2);
		}

		// IddlAassRlstVO iddlAassRlstVO2 = new IddlAassRlstVO();
		// iddlAassRlstVO2 = readIddlAassRlstFile2("D:/estam-ndmi/file",
		// "result_2013_11_28.txt");
		return url;

	}

	public ArrayList<WvIddlAassRlstVO> readIddlAassRlstFile(String storageFilePath, String fileName, String columnCnt) throws Exception {

		ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
		File uFile = new File(storageFilePath, fileName);

		int fSize = (int) uFile.length();

		if (!uFile.exists()) {
			System.out.println("path_error.... please change path in this program");
		}

		if (fSize > 0) {
			// 파일 읽기
			FileInputStream fls = new FileInputStream(uFile);
			Scanner s = new Scanner(fls);
			String times = "", accCol1, accCol2, accCol3, accCol4, accCol5, accCol6, accCol7;
			int i = 0;
			int columns = Integer.parseInt(columnCnt);
			while (s.hasNext()) {
				WvIddlAassRlstVO v_WvIddlAassRlst = new WvIddlAassRlstVO();

				switch (columns) {
				case 2:
					// 응답스펙트럼
					times = s.next();
					accCol2 = s.next();
					v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
					v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
					break;
				case 3:
					// 최상층가속도, 최상층속도, 최상층변위, 안전성평가결과
					if (i == 0) {
						accCol1 = s.nextLine();
						v_WvIddlAassRlst.setStableEvaInfVal(accCol1);
					} else {
						times = s.next();
						v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
						accCol2 = s.next();
						accCol3 = s.next();
						v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
						v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
					}
					break;
				case 4:
					// 가속도, 속도, 변위,
					times = s.next();
					accCol2 = s.next();
					accCol3 = s.next();
					accCol4 = s.next();
					v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
					v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
					v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
					v_WvIddlAassRlst.setRsltValueY4(new BigDecimal(accCol4));
					break;
				case 7:
					// 응답스펙트럼
					times = s.next();
					accCol2 = s.next();
					accCol3 = s.next();
					accCol4 = s.next();
					accCol5 = s.next();
					accCol6 = s.next();
					accCol7 = s.next();
					v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
					v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
					v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
					v_WvIddlAassRlst.setRsltValueY4(new BigDecimal(accCol4));
					v_WvIddlAassRlst.setRsltValueY5(new BigDecimal(accCol5));
					v_WvIddlAassRlst.setRsltValueY6(new BigDecimal(accCol6));
					v_WvIddlAassRlst.setRsltValueY7(new BigDecimal(accCol7));
					break;
				default:
					// 최상층가속도, 최상층속도, 최상층변위, 안전성평가결과
					times = s.next();
					accCol2 = s.next();
					accCol3 = s.next();
					v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
					v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
					v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
					break;
				}
				wvList.add(v_WvIddlAassRlst);
				i++;
			}

		}
		return wvList;
	}

	public IddlAassRlstVO readIddlAassRlstFile2(String storageFilePath, String fileName) throws Exception {

		IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();
		File uFile = new File(storageFilePath, fileName);

		int fSize = (int) uFile.length();

		if (!uFile.exists()) {
			System.out.println("path_error.... please change path in this program");
		}

		if (fSize > 0) {
			// 파일 읽기
			FileInputStream fls = new FileInputStream(uFile);
			Scanner s = new Scanner(fls);
			String xVal = "", yVal;

			int i = 0;
			String aa[];
			while (s.hasNext()) {
				// WvIddlAassRlstVO v_WvIddlAassRlst = new WvIddlAassRlstVO();
				xVal = s.nextLine();
				if (xVal.indexOf("result_max_idr_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					// iddlAassRlstVO.setRsltMaxIdrX(new BigDecimal(yVal));
				}
				if (xVal.indexOf("result_max_idr_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					// iddlAassRlstVO.setRsltMaxIdrY(new BigDecimal(yVal));
				}
				if (xVal.indexOf("result_over_acc_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					// iddlAassRlstVO.setRsltOvrAccX(new BigDecimal(yVal));
				}
				if (xVal.indexOf("result_over_acc_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					// iddlAassRlstVO.setRsltOvrAccY(new BigDecimal(yVal));
				}
				if (xVal.indexOf("result_nat_freq_move_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					// iddlAassRlstVO.setRsltNatFrqMvX(new BigDecimal(yVal));
				}
				if (xVal.indexOf("result_nat_freq_move_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					// iddlAassRlstVO.setRsltNatFrqMvY(new BigDecimal(yVal));
				}
				if (xVal.indexOf("result_str_free_nat_freq_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setRsltStrFreeNatFrqX(yVal);
				}
				if (xVal.indexOf("result_str_free_nat_freq_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					// iddlAassRlstVO.setRsltStrFreeNatFrqY(new
					// BigDecimal(yVal));
				}
				if (xVal.indexOf("safe_check_max_idr_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkMaxIdrXRslt(yVal);
				}
				if (xVal.indexOf("safe_check_max_idr_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkMaxIdrYRslt(yVal);
				}
				if (xVal.indexOf("safe_check_nat_freq_move_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkNatFrqMvXRslt(yVal);
				}
				if (xVal.indexOf("safe_check_nat_freq_move_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkNatFrqMvYRslt(yVal);
				}
				if (xVal.indexOf("safe_check_str_free_nat_freq_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkStrFreeNatFrqX(yVal);
				}
				if (xVal.indexOf("safe_check_str_free_nat_freq_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkStrFreeNatFrqY(yVal);
				}
				if (xVal.indexOf("safe_check_over_acc_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkOvrAccXRslt(yVal);
				}
				if (xVal.indexOf("safe_check_over_acc_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setSfChkOvrAccYRslt(yVal);
				}
				if (xVal.indexOf("data_free_max_disp_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataFreeMaxDispX(yVal);
				}
				if (xVal.indexOf("data_free_max_disp_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataFreeMaxDispY(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_speed_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataTopRelMaxSpedX(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_speed_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataTopRelMaxSpedY(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_disp_X") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataTopRelMaxDispX(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_disp_Y") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataTopRelMaxDispY(yVal);
				}
				if (xVal.indexOf("data_free_acc") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataFreeAccX(yy[0]);
					iddlAassRlstVO.setDataFreeAccY(yy[1]);
					iddlAassRlstVO.setDataFreeAccHorz(yy[2]);
					iddlAassRlstVO.setDataFreeAccZ(yy[3]);
				}
				if (xVal.indexOf("data_free_vel") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataFreeAccSpedX(yy[0]);
					iddlAassRlstVO.setDataFreeAccSpedY(yy[0]);
					iddlAassRlstVO.setDataFreeAccSpedHorz(yy[0]);
					iddlAassRlstVO.setDataFreeAccSpedZ(yy[0]);
				}
				if (xVal.indexOf("data_free_disp") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataFreeAccDispX(yy[0]);
					iddlAassRlstVO.setDataFreeAccDispY(yy[0]);
					iddlAassRlstVO.setDataFreeAccDispHorz(yy[0]);
					iddlAassRlstVO.setDataFreeAccDispZ(yy[0]);
				}
				if (xVal.indexOf("data_str_bot_acc") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrBotAccX(yy[0]);
					iddlAassRlstVO.setDataStrBotAccY(yy[1]);
					iddlAassRlstVO.setDataStrBotAccZ(yy[2]);
				}
				if (xVal.indexOf("data_str_bot_vel") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrBotSpedX(yy[0]);
					iddlAassRlstVO.setDataStrBotSpedY(yy[1]);
				}
				if (xVal.indexOf("data_str_bot_disp") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrBotDispX(yy[0]);
					iddlAassRlstVO.setDataStrBotDispY(yy[0]);
				}
				if (xVal.indexOf("data_str_mid_acc") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrMidAccX(yy[0]);
					iddlAassRlstVO.setDataStrMidAccY1(yy[1]);
					iddlAassRlstVO.setDataStrMidAccY2(yy[2]);
				}
				if (xVal.indexOf("data_str_top_acc") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrTopAccX(yy[0]);
					iddlAassRlstVO.setDataStrTopAccY1(yy[1]);
					iddlAassRlstVO.setDataStrTopAccY2(yy[2]);
				}
				if (xVal.indexOf("data_str_freq") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrFrqX(yy[0]);
					iddlAassRlstVO.setDataStrFrqY(yy[0]);
				}
				if (xVal.indexOf("data_free_freq") == 1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataFreeFrq(yVal);
				}

				i++;
			}

		}
		return iddlAassRlstVO;
	}

	/*
	 * @RequestMapping(value="/iddl/iddlLeftStabEvalInfo") public String
	 * iddlLeftStabEvalInfo(@ModelAttribute("searchVO") IddlAassRlstDefaultVO
	 * searchVO, ModelMap model) throws Exception {
	 * 
	 * IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();
	 * 
	 * iddlAassRlstVO.setFctyCd(searchVO.getFctyCd());
	 * iddlAassRlstVO.setGvmtCd(searchVO.getGvmtCd());
	 * iddlAassRlstVO.setIddlAassNo(searchVO.getIddlAassNo());
	 * 
	 * iddlAassRlstVO = iddlAassRlstService.selectIddlAassRlst(iddlAassRlstVO);
	 * model.addAttribute("readIddlAssRlst", iddlAassRlstVO);
	 * 
	 * if(searchVO.getIddlAassNo() != null) { String storageFilePath =
	 * Globals.STORAGE_ROOT; //스토리지에 파형위치 정보를 가지고 온다... String fileName ="";
	 * String filePath ="";
	 * 
	 * IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
	 * 
	 * Map<String, Object> map=null;
	 * 
	 * iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
	 * iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
	 * iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo()); iddlAassInfoVO =
	 * iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);
	 * 
	 * int modes = Integer.parseInt(searchVO.getModes()); //filePath =
	 * iddlAassInfoVO.getWvScnRsltFlsv()+"/"; filePath = "SIGNALUX/";
	 * 
	 * switch (modes) { case 10 : fileName = "f_acc.rec"; //가독도 break; case 20 :
	 * fileName = "f_vel.rec"; //속도 break; case 30 : fileName = "f_dis.rec";
	 * //변위 break; case 40 : fileName = "f_spect.rec"; //응답스펙트럼 fileName =
	 * "f_hvr.rec"; //응답스펙트럼 break; case 50 : fileName = "tr_acc.rec"; //최상층가속도
	 * break; case 60 : fileName = "tr_vel.rec"; //최상층속도 break; case 70 :
	 * fileName = "tr_dis.rec"; //최승층변위 break; case 80 : fileName = "tr_tf.rec";
	 * //안정성평가결과 fileName = "tr_dis.rec"; //안정성평가결과 break; default: fileName =
	 * "f_acc.rec"; //가속도 break;
	 * 
	 * }
	 * 
	 * ///SIGNALUX/SL/JG/20131120RESULT File uFile = new File(storageFilePath +
	 * filePath,fileName); int fSize = (int)uFile.length();
	 * 
	 * if (!uFile.exists()) {
	 * System.out.println("path_error.... please change path in this program");
	 * }
	 * 
	 * Map<String, Object> fctyIddlDataMap = new HashMap<String, Object>();
	 * ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
	 * 
	 * if (fSize > 0) { //파일 읽기 FileInputStream fls = new
	 * FileInputStream(uFile); Scanner s = new Scanner(fls); String times = "",
	 * accCol1, accCol2, accCol3, accCol4; int i=0; while(s.hasNext()){ times =
	 * s.next(); accCol2 = s.next(); accCol3 = s.next(); accCol4= s.next();
	 * WvIddlAassRlstVO v_WvIddlAassRlst = new WvIddlAassRlstVO();
	 * v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(times));
	 * v_WvIddlAassRlst.setRsltValueY2(new BigDecimal(accCol2));
	 * v_WvIddlAassRlst.setRsltValueY3(new BigDecimal(accCol3));
	 * v_WvIddlAassRlst.setRsltValueY4(new BigDecimal(accCol4));
	 * wvList.add(v_WvIddlAassRlst); i++; } model.addAttribute("data", wvList);
	 * }
	 * 
	 * } return "/estam/iddl/inc/iddlLeftStabEvalInfo"; }
	 */
	/**
	 * 계측및평가결과 안정성평가결과 값 중간
	 * 
	 * @param searchVO
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/iddl/ReadSFIddlAassRlst.do")
	public String readSFIddlAassRlst(@ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, ModelMap model) throws Exception {

		IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();

		try {
			iddlAassRlstVO.setFctyCd(searchVO.getFctyCd());
			iddlAassRlstVO.setIddlAassNo(searchVO.getIddlAassNo());
			// 계측최대값, 설계지반가속도 초과율
			iddlAassRlstVO = iddlAassRlstService.selectSFIddlAassRlst(iddlAassRlstVO);
			model.addAttribute("iddlSFAssRlst", iddlAassRlstVO);
			// 분석지표 계수
			// iddlSubAassRlstVO =
			// iddlAassRlstService.selectSubIddlAassRlst(iddlSubAassRlstVO);
			// model.addAttribute("iddlSubAssRlst", iddlAassRlstVO);

		} catch (EgovBizException egbe) {

			logger.debug("EgovBizException : " + egbe.getMessage());
			logger.debug("EgovBizException : " + egbe.getMessageKey());
			// egbe.printStackTrace();

		}
		return "/estam/iddl/inc/ReadSFIddlAassRlst";
	}

	/**
	 * 계측및평가결과 화면챠트 - 가속도 파일을 읽어와서 파일 데이터를 가지고 처리한다.
	 * 
	 * @param
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/iddl/IddlAassRlstJson.do")
	@ResponseBody
	public String readFileIddlAassRlst(@RequestBody Map<String, Object> iddlJsonData) throws Exception {

		Map<String, Object> fctyIddlDataMap = new HashMap<String, Object>();

		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";
		IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();

		String storageFilePath = Globals.STORAGE_ROOT; // 스토리지에 파형위치 정보를 가지고
														// 온다...
		ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();

		// logger.debug("EventInfoJson : " + ehqkJsonData.get("flag"));
		try {
			// TODO signalux생성한 파형정보를 불러와 값을 맵핑한다. 가속도 파일 3개에 대한 파일 정의은 상단에 한다.

			iddlAassInfoVO.setFctyCd(iddlJsonData.get("fctyCd").toString());
			iddlAassInfoVO.setIddlAassNo(new BigDecimal(iddlJsonData.get("iddlAassNo").toString()));

			iddlAassInfoVO = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);
			Map<String, String> wvDataVo = new HashMap<String, String>();

			for (int idx = 0; idx < FCTY_SCN_RSLT_PATH_FILE_10.length; idx++) {

				wvDataVo = null;

				File fctyScnRsltFile = new File(storageFilePath.concat(iddlAassInfoVO.getWvScnExtFlsv().concat(FCTY_SCN_RSLT_PATH_FILE_10[idx])));

				try {

					BufferedReader input = new BufferedReader(new FileReader(fctyScnRsltFile));

					try {

						String line = null;

						while ((line = input.readLine()) != null) {
							// 데이터을 읽으면서 값을 셋팅한다...초 / 가속
							WvIddlAassRlstVO v_WvIddlAassRlst = new WvIddlAassRlstVO();
							StringTokenizer tokenizer = new StringTokenizer(line, " "); // TODO
																						// 구분자분
							v_WvIddlAassRlst.setRsltTimeX(new BigDecimal(tokenizer.nextToken()));
							v_WvIddlAassRlst.setRsltValueY(new BigDecimal(tokenizer.nextToken()));
							wvList.add(v_WvIddlAassRlst);
						}

						fctyIddlDataMap.put(("wvEv_" + idx), wvList);

					} finally {
						input.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}

			reqDataJson = m.writeValueAsString(fctyIddlDataMap);
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

	// /**
	// * IDDL_AASS_RLST 목록을 조회한다. (pageing)
	// * @param searchVO - 조회할 정보가 담긴 IddlAassRlstDefaultVO
	// * @return "/iddlAassRlst/IddlAassRlstList"
	// * @exception Exception
	// */
	// @RequestMapping(value="/iddlAassRlst/IddlAassRlstList.do")
	// public String selectIddlAassRlstList(@ModelAttribute("searchVO")
	// IddlAassRlstDefaultVO searchVO,
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
	// List iddlAassRlstList =
	// iddlAassRlstService.selectIddlAassRlstList(searchVO);
	// model.addAttribute("resultList", iddlAassRlstList);
	//
	// int totCnt = iddlAassRlstService.selectIddlAassRlstListTotCnt(searchVO);
	// paginationInfo.setTotalRecordCount(totCnt);
	// model.addAttribute("paginationInfo", paginationInfo);
	//
	// return "/iddlAassRlst/IddlAassRlstList";
	// }
	//
	// @RequestMapping("/iddlAassRlst/addIddlAassRlstView.do")
	// public String addIddlAassRlstView(
	// @ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, Model model)
	// throws Exception {
	// model.addAttribute("iddlAassRlstVO", new IddlAassRlstVO());
	// return "/iddlAassRlst/IddlAassRlstRegister";
	// }

	// @RequestMapping("/iddlAassRlst/addIddlAassRlst.do")
	// public String addIddlAassRlst(
	// IddlAassRlstVO iddlAassRlstVO,
	// @ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// iddlAassRlstService.insertIddlAassRlst(iddlAassRlstVO);
	// status.setComplete();
	// return "forward:/iddlAassRlst/IddlAassRlstList.do";
	// }

	@RequestMapping("/iddlAassRlst/addIddlAassInfo.do")
	public String addIddlAassInfo(IddlAassInfoVO iddlAassInfoVO, IddlAassOpinVVO vo, ModelMap model, AnysIdxCoffCfgVO anysIdxCoffCfgVO,
			@ModelAttribute("searchVO") IddlAassInfoDefaultVO searchVO, SessionStatus status) throws Exception {
		iddlAassInfoService.insertIddlAassInfo(iddlAassInfoVO);
		// iddlAassInfoService.updateIddlAassOpin_v1(iddlAassInfoVO);

		// iddlAassOpinVVO vo = new iddlAassOpinVVO();
		// iddlAassOpinVVO

		iddlAassOpinVService.insertIddlAassOpinV(vo);

		// List iddlAassInfoList =
		// iddlAassInfoService.selectIddlAassInfoList(searchVO);
		// model.addAttribute("iddlAassInfoList", iddlAassInfoList);

		// logger.debug("[[[iddlAassInfoList]]]"+ iddlAassInfoList);

		anysIdxCoffCfgVO.setAnysIdxCoffNo(BigDecimal.ONE);
		anysIdxCoffCfgVO = anysIdxCoffCfgService.selectAnysIdxCoffCfg(anysIdxCoffCfgVO);
		model.addAttribute("anysIdxCoffCfgVO", anysIdxCoffCfgVO);

		logger.debug("[[[anysIdxCoffCfgVO]]]" + anysIdxCoffCfgVO);

		logger.debug("[[[anysIdxCoffCfgVO.getRcswSf]]]" + anysIdxCoffCfgVO.getRcswSf());

		status.setComplete();

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMdd";

		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		String StrDate = sdfCurrent.format(ts.getTime());

		// SIGNALUX/KA/YY/20131204/RESULT/7
		// String filedir = "/SIGNALUX/KA/YY/"+StrDate+"/RESULT/2";
		String filedir = "/SIGNALUX/seed";

		String filename = "lin_c_conf.txt";
		String count = "";
		File f = new File(filedir + "/" + filename);

		if (!f.exists()) {
			f.getParentFile().mkdirs();
			f.createNewFile(); // 파일이 없으면 파일 생성
		}

		FileWriter fw = new FileWriter(filedir + "/" + filename);

		logger.debug("[[[[[[ getGvmtCd  ]]]]]]]]]]]]" + vo.getGvmtCd());

		fw.write("seed_file_path : /SIGNALUX/seed/20120901_06.100" + "\n");
		fw.write("seed_dest_path : /SIGNALUX/seed/" + "\n");
		fw.write("sensor_location_free_X : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGE_00.tmp" + "\n");
		fw.write("sensor_location_free_Y : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGN_00.tmp" + "\n");
		fw.write("sensor_location_free_Z : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGZ_00.tmp" + "\n");
		fw.write("sensor_location_bot_X : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGE_01.tmp" + "\n");
		fw.write("sensor_location_bot_Y : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGN_01.tmp" + "\n");
		fw.write("sensor_location_bot_Z : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGZ_01.tmp" + "\n");
		fw.write("sensor_location_mid_X : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGE_02.tmp" + "\n");
		fw.write("sensor_location_mid_Y1 : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGN_02.tmp" + "\n");
		fw.write("sensor_location_mid_Y2 : -" + "\n");
		fw.write("sensor_location_top_X : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGE_03.tmp" + "\n");
		fw.write("sensor_location_top_Y1 : " + vo.getGvmtCd() + "_" + vo.getFctyCd() + "C_HGN_03.tmp" + "\n");
		fw.write("sensor_location_top_Y2 : -" + "\n");
		fw.write("sensor_filtering_free_X : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_free_Y : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_free_Z : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_bot_X : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_bot_Y : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_bot_Z : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_mid_X : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_mid_Y1 : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_mid_Y2 : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_top_X : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_top_Y1 : 2, 0.008, 0.8" + "\n");
		fw.write("sensor_filtering_top_Y2 : 2, 0.008, 0.8" + "\n");
		fw.write("analy_option_idr_amp : 1.2" + "\n");
		fw.write("analy_option_str_height : 30000.0" + "\n");
		fw.write("analy_option_seismic_area : 1" + "\n");
		fw.write("analy_option_str_type : 1" + "\n");
		fw.write("analy_option_str_name : 금천구" + "\n");
		fw.write("analy_option_str_freq_window : 0.0, 0.0, 0.0, 0.0" + "\n");
		fw.write("analy_option_str_freq_window_move : 10.0, 5.0" + "\n");
		fw.write("analy_option_limit_state_mean : 0.0042, 0.0067, 0.0133" + "\n");
		fw.write("analy_option_limit_state_dev : 0.59, 0.65, 0.70" + "\n");
		fw.write("analy_option_freq_prev_X : -1.0" + "\n");
		fw.write("analy_option_freq_prev_Y : -1.0" + "\n");
		fw.write("safe_idr_range_smf : " + anysIdxCoffCfgVO.getSmfSf() + ", " + anysIdxCoffCfgVO.getSmfChk() + ", 0.7, 2.5, 5.0" + "\n");
		fw.write("safe_idr_range_sef : " + anysIdxCoffCfgVO.getSefSf() + ", " + anysIdxCoffCfgVO.getSefChk() + ", 1.5, 2.0" + "\n");
		fw.write("safe_idr_range_rcf : " + anysIdxCoffCfgVO.getRcfSf() + ", " + anysIdxCoffCfgVO.getRcfChk() + ", 2.0, 4.0" + "\n");
		fw.write("safe_idr_range_rcsw : " + anysIdxCoffCfgVO.getRcswSf() + ", " + anysIdxCoffCfgVO.getRcswChk() + ", 1.0, 2.0" + "\n");
		fw.write("safe_nat_freq_range : " + anysIdxCoffCfgVO.getNatFrqRng() + "\n");
		fw.write("safe_str_free_nat_freq_range : " + anysIdxCoffCfgVO.getStrFreeNatFrqRng() + "\n");
		fw.write("safe_over_acc_range : " + anysIdxCoffCfgVO.getOvrAccRng() + "\n");
		fw.close();

		// new
		// ProcessBuilder("/SignalUX_v20131128/SignalUx_131117/SignalUx_Binary/signalux_2013_11_17_2 /SIGNALUX/seed/lin_c_conf.txt").start();

		String filedir1 = "/SIGNALUX/" + vo.getGvmtCd() + "/" + vo.getFctyCd() + "/" + StrDate + "/RESULT/2";

		String filename1 = "RESULT.txt";
		String count1 = "";
		File f1 = new File(filedir1 + "/" + filename1);

		if (!f1.exists()) {
			f.getParentFile().mkdirs();
			f1.createNewFile(); // 파일이 없으면 파일 생성
		}

		FileWriter fw1 = new FileWriter(filedir1 + "/" + filename1);

		fw1.write("result_max_idr_X : 0.00002906" + "\n");
		fw1.write("result_max_idr_Y : 0.00002410" + "\n");
		fw1.write("result_over_acc_X : -99.72834999" + "\n");
		fw1.write("result_over_acc_Y : -99.75611971" + "\n");
		fw1.write("result_nat_freq_move_X : 0.00000000" + "\n");
		fw1.write("result_nat_freq_move_Y : 0.00000000" + "\n");
		fw1.write("result_str_free_nat_freq_X : 7.82967033" + "\n");
		fw1.write("result_str_free_nat_freq_Y : 10.50824176" + "\n");
		fw1.write("safe_check_max_idr_X : OK" + "\n");
		fw1.write("safe_check_max_idr_Y : OK" + "\n");
		fw1.write("safe_check_nat_freq_move_X : OK" + "\n");
		fw1.write("safe_check_nat_freq_move_Y : OK" + "\n");
		fw1.write("safe_check_str_free_nat_freq_X : OK" + "\n");
		fw1.write("safe_check_str_free_nat_freq_Y : OK" + "\n");
		fw1.write("safe_check_over_acc_X : OK" + "\n");
		fw1.write("safe_check_over_acc_Y : OK" + "\n");
		fw1.write("data_free_max_disp_X : 0.00247572" + "\n");
		fw1.write("data_free_max_disp_Y : 0.00283752" + "\n");
		fw1.write("data_top_rel_max_speed_X : 0.04629907" + "\n");
		fw1.write("data_top_rel_max_speed_Y : 0.04185129" + "\n");
		fw1.write("data_top_rel_max_disp_X : 0.00871902" + "\n");
		fw1.write("data_top_rel_max_disp_Y : 0.00722928" + "\n");
		fw1.write("data_free_acc : 0.58609577, 0.52618149, 0.29277226" + "\n");
		fw1.write("data_str_bot_acc : 4.84518418, 0.03557200, 0.05268379" + "\n");
		fw1.write("data_str_mid_acc : 0.21316684, 0.17647675, -1.00000000" + "\n");
		fw1.write("data_str_top_acc : 0.12488664, 0.10245237, -1.00000000" + "\n");
		fw1.write("data_str_freq : 0.69580078, 0.93383789" + "\n");
		fw1.write("data_free_freq : 8.88671875");
		fw1.close();

		// return "forward:/iddlAassRlst/IddlAassRlstList.do";
		return "forward:/signalux/SignalUxExecMgr.do";
		// return "iddlAassOpinV/addIddlAassOpinV.do";

	}

	// @RequestMapping("/iddlAassRlst/updateIddlAassRlstView.do")
	// public String updateIddlAassRlstView(
	// @RequestParam("fctyCd") java.lang.String fctyCd ,
	// @RequestParam("iddlAassNo") java.math.BigDecimal iddlAassNo ,
	// @ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, Model model)
	// throws Exception {
	// IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();
	// iddlAassRlstVO.setFctyCd(fctyCd);
	// iddlAassRlstVO.setIddlAassNo(iddlAassNo);
	// // 변수명은 CoC 에 따라 iddlAassRlstVO
	// model.addAttribute(selectIddlAassRlst(iddlAassRlstVO, searchVO));
	// return "/iddlAassRlst/IddlAassRlstRegister";
	// }
	//
	// @RequestMapping("/iddlAassRlst/selectIddlAassRlst.do")
	// public @ModelAttribute("iddlAassRlstVO")
	// IddlAassRlstVO selectIddlAassRlst(
	// IddlAassRlstVO iddlAassRlstVO,
	// @ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO) throws
	// Exception {
	// return iddlAassRlstService.selectIddlAassRlst(iddlAassRlstVO);
	// }
	//
	// @RequestMapping("/iddlAassRlst/updateIddlAassRlst.do")
	// public String updateIddlAassRlst(
	// IddlAassRlstVO iddlAassRlstVO,
	// @ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// iddlAassRlstService.updateIddlAassRlst(iddlAassRlstVO);
	// status.setComplete();
	// return "forward:/iddlAassRlst/IddlAassRlstList.do";
	// }
	//
	// @RequestMapping("/iddlAassRlst/deleteIddlAassRlst.do")
	// public String deleteIddlAassRlst(
	// IddlAassRlstVO iddlAassRlstVO,
	// @ModelAttribute("searchVO") IddlAassRlstDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// iddlAassRlstService.deleteIddlAassRlst(iddlAassRlstVO);
	// status.setComplete();
	// return "forward:/iddlAassRlst/IddlAassRlstList.do";
	// }

}
