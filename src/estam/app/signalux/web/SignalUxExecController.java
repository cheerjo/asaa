package estam.app.signalux.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.nio.channels.FileChannel;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.service.Globals;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.fcty.service.EhqkScnService;
import estam.app.fcty.service.EhqkScnVO;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrService;
import estam.app.iddl.service.IddlAassInfoDefaultVO;
import estam.app.iddl.service.IddlAassInfoService;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassOpinVService;
import estam.app.iddl.service.IddlAassOpinVVO;
import estam.app.iddl.service.IddlAassRlstService;
import estam.app.iddl.service.IddlAassRlstStttService;
import estam.app.iddl.service.IddlAassRlstVO;
import estam.app.iddl.service.IddlAassWvflService;
import estam.app.iddl.service.IddlAassWvflVO;
import estam.app.iddl.service.IddlEhqkOcurInfoVO;
import estam.app.iddl.service.WvIddlAassRlstVO;
import estam.app.scn.evnt.service.ConEvntDataDefaultVO;
import estam.app.scn.evnt.service.ConEvntDataService;
import estam.app.scn.evnt.service.ConEvntDataVO;
import estam.app.signalux.service.AnysIdxCoffCfgService;
import estam.app.signalux.service.AnysIdxCoffCfgVO;
import estam.app.signalux.service.SignalUxExecDefaultVO;
import estam.app.signalux.service.SignalUxExecService;
import estam.app.signalux.service.SignalUxExecVO;

/**
 * @Class Name : SignalUxExecController.java
 * @Description : SignalUxExec Controller class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = SignalUxExecVO.class)
public class SignalUxExecController {

	private static final Logger logger = LoggerFactory.getLogger(SignalUxExecController.class);

	@Resource(name = "signalUxExecService")
	private SignalUxExecService signalUxExecService;

	@Resource(name = "iddlAassRlstService")
	private IddlAassRlstService iddlAassRlstService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	@Resource(name = "fctyImgService")
	private FctyImgService fctyImgService;

	@Resource(name = "iddlAassRlstStttService")
	private IddlAassRlstStttService iddlAassRlstStttService;

	@Resource(name = "iddlAassInfoService")
	private IddlAassInfoService iddlAassInfoService;

	@Resource(name = "iddlAassOpinVService")
	private IddlAassOpinVService iddlAassOpinVService;

	@Resource(name = "anysIdxCoffCfgService")
	private AnysIdxCoffCfgService anysIdxCoffCfgService;

	@Resource(name = "ehqkScnService")
	private EhqkScnService ehqkScnService;

	@Resource(name = "conEvntDataService")
	private ConEvntDataService conEvntDataService;

	@Resource(name = "iddlAassWvflService")
	private IddlAassWvflService iddlAassWvflService;

	private String signalUxPath = EgovProperties.getProperty("Globals.SignalUxPath");
	private String storageFilePath = Globals.STORAGE_ROOT;

	private String filename = "lin_c_conf.txt";
	private String filename2 = "RESULT_conf.txt";

	private SimpleDateFormat sdfCurrent = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);

	private int nofile = 0;

	/**
	 * 지진데이터 분석을 하기 위한 처리
	 * 
	 * @param
	 * @return
	 * @exception Exception
	 */
	/*
	 * @RequestMapping(value="/signalux/SignalUxExecMgr.do") public String
	 * selectSignalUxExecList(@ModelAttribute("searchVO") FctyMgrDefaultVO
	 * searchVO, IddlAassInfoDefaultVO searchVO1 ,ModelMap model) throws
	 * Exception {
	 * 
	 * 
	 * ComDefaultCodeVO vo = new ComDefaultCodeVO();
	 * 
	 * vo.setCommCd("ITEM_008"); List fctyAreaList =
	 * cmmUseService.selectCmmCodeDetail(vo); model.addAttribute("fctyAreaList",
	 * fctyAreaList);
	 * 
	 * 
	 * vo.setCommCd("ITEM_011"); List fctyKndList =
	 * cmmUseService.selectCmmCodeDetail(vo); model.addAttribute("fctyKndList",
	 * fctyKndList);
	 * 
	 * logger.debug("fctyKndList"+ fctyKndList);
	 * 
	 * //가지고 올때 이미지 정보도 통합해서 가지고 온다. List fctyMgrList =
	 * fctyMgrService.selectFctyMgrList(searchVO);
	 * model.addAttribute("fctyMgrList", fctyMgrList);
	 * 
	 * int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
	 * model.addAttribute("fctyMgrCnt", totCnt);
	 * 
	 * String fctyAreaCd = searchVO.getFctyAreaCd();
	 * 
	 * // 지진정보 IddlEhqkOcurInfoVO eqVo = new IddlEhqkOcurInfoVO();
	 * 
	 * if (null != fctyAreaCd && "" != fctyAreaCd) {
	 * eqVo.setFctyAreaCd(fctyAreaCd); }
	 * 
	 * List iddlAassInfoList =
	 * iddlAassInfoService.selectIddlAassInfoList(searchVO1);
	 * model.addAttribute("ehqkOcurInfoList", iddlAassInfoList); //
	 * fctyIddlAassList
	 * 
	 * ////List ehqkOcurInfoList =
	 * iddlAassRlstStttService.selectIddlEhqkOcurInfoList(eqVo);
	 * ////model.addAttribute("ehqkOcurInfoList", ehqkOcurInfoList);
	 * 
	 * return "/estam/signalux/SignalUxExecMgr"; }
	 */

	/**
	 * 지진데이터 분석을 하기 위한 처리
	 * 
	 * @param
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/signalux/SignalUxExecMgr.do")
	public String selectSignalUxExecList(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, IddlAassInfoDefaultVO searchVO1, ModelMap model)
			throws Exception {

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

		List ehqkOcurInfoList = iddlAassRlstStttService.selectIddlEhqkOcurInfoList2(eqVo); // 진원시별,
																							// 분석일시별
																							// 1건만
																							// 나오게
																							// 수정함
		model.addAttribute("ehqkOcurInfoList", ehqkOcurInfoList);

		return "/estam/signalux/SignalUxExecMgr";
	}

	/**
	 * 지진데이터 우측화면
	 * 
	 * @param
	 * @return
	 * @exception Exception
	 */
	@RequestMapping(value = "/signalux/SignalUxExecMain.do")
	public String selectSignalUxExecMain(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, IddlAassInfoDefaultVO searchVO1, ModelMap model)
			throws Exception {

		return "/estam/signalux/SignalUxExecMain";
	}

	@RequestMapping(value = "/cmmnl/progressMgrPopup.do")
	public String ProgressMgrPopup(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, IddlAassInfoDefaultVO searchVO1, ModelMap model)
			throws Exception {

		return "/estam/signalux/egovProgress";
	}

	@RequestMapping("/signalUxExec/SignalUxExecMgr_l.do")
	public String SignalUxExecMgr_l(@ModelAttribute("searchVO") FctyMgrDefaultVO searchVO, IddlAassInfoDefaultVO searchVO1, ModelMap model)
			throws Exception {

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

		int totCnt = fctyMgrService.selectFctyMgrListTotCnt(searchVO);
		model.addAttribute("fctyMgrCnt", totCnt);

		List iddlAassInfoList = iddlAassInfoService.selectIddlAassInfoList(searchVO1);
		model.addAttribute("ehqkOcurInfoList", iddlAassInfoList); // fctyIddlAassList

		return "/estam/signalux/SignalUxExecMgr";
	}

	@RequestMapping("/signalUxExec/addSignalUxExec.do")
	public String addSignalUxExec(SignalUxExecVO signalUxExecVO, @ModelAttribute("searchVO") SignalUxExecDefaultVO searchVO, SessionStatus status)
			throws Exception {
		signalUxExecService.insertSignalUxExec(signalUxExecVO);
		// iddlAassInfoDAO.insertSignalUxExec(signalUxExecVO);
		status.setComplete();
		return "forward:/signalUxExec/SignalUxExecList.do";
	}

	public void step1(ConEvntDataVO conEvntDataVO) throws Exception {

		IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
		IddlAassWvflVO iddlAassWvflVO = new IddlAassWvflVO();
		IddlAassOpinVVO iddlAassOpinVVO = new IddlAassOpinVVO();

		// 시설물 기본정보 삭제
		iddlAassInfoVO.setFctyCd(conEvntDataVO.getFctyCd());
		iddlAassInfoVO.setGvmtCd(conEvntDataVO.getGvmtCd());
		iddlAassInfoService.deleteIddlAassInfo(iddlAassInfoVO);

		// 개별분석 파일정보 삭제
		iddlAassWvflVO.setFctyCd(conEvntDataVO.getFctyCd());
		iddlAassWvflVO.setGvmtCd(conEvntDataVO.getGvmtCd());
		iddlAassWvflService.deleteIddlAassWvfl(iddlAassWvflVO);

		// 개별분석 설정값 삭제
		iddlAassOpinVVO.setFctyCd(conEvntDataVO.getFctyCd());
		iddlAassOpinVVO.setGvmtCd(conEvntDataVO.getGvmtCd());
		iddlAassOpinVService.deleteIddlAassOpinV(iddlAassOpinVVO);
	}

	public void step2(ConEvntDataVO conEvntDataVO, String iddlAassNo) throws Exception {

		String wvScnExtFlsv = "";
		String wvScnExtFlnm = "";
		String wvScnRsltFlsv = "";
		String command = "";
		boolean sucess = false;

		String StrDate = sdfCurrent.format(new Timestamp(System.currentTimeMillis()).getTime());

		wvScnExtFlsv = "/signalux/" + conEvntDataVO.getEhqkReqId() + "/" + conEvntDataVO.getGvmtCd() + "/" + conEvntDataVO.getFctyCd() + "/"
				+ StrDate + "/SEED/";
		wvScnRsltFlsv = "/signalux/" + conEvntDataVO.getEhqkReqId() + "/" + conEvntDataVO.getGvmtCd() + "/" + conEvntDataVO.getFctyCd() + "/"
				+ StrDate + "/RESULT/";
		wvScnExtFlnm = "lin_c_conf.txt";

		IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
		iddlAassInfoVO.setIddlAassNo(new BigDecimal(iddlAassNo));
		iddlAassInfoVO.setEhqkReqId(conEvntDataVO.getEhqkReqId());
		iddlAassInfoVO.setEhqkTranGbcd(conEvntDataVO.getEhqkTranGbcd());
		iddlAassInfoVO.setFctyCd(conEvntDataVO.getFctyCd());
		iddlAassInfoVO.setGvmtCd(conEvntDataVO.getGvmtCd());
		iddlAassInfoVO.setWvScnExtFlsv(wvScnExtFlsv);
		iddlAassInfoVO.setWvScnExtFlnm(wvScnExtFlnm);
		iddlAassInfoVO.setWvScnRsltFlsv(wvScnRsltFlsv);

		String filedir1 = wvScnExtFlsv + iddlAassNo + "/";
		String filedir2 = wvScnRsltFlsv + iddlAassNo + "/";

		// SEED 파일 경로
		File f = new File(storageFilePath + filedir1 + filename);

		// RESULT 파일 경로
		File f2 = new File(storageFilePath + filedir2 + filename2);

		if (!f.exists()) {
			// logger.debug("[[[[[[ getGvmtCd  ]]]]]]]]]]]]" + storageFilePath +
			// filedir1 + filename);
			f.getParentFile().mkdirs();
			f.createNewFile(); // 파일이 없으면 파일 생성
		}

		if (!f2.exists()) { // signalux 다음에 지진번호 경로 추가
			// logger.debug("[[[[[[ getGvmtCd  ]]]]]]]]]]]]" + storageFilePath +
			// filedir2 + filename2);
			f2.getParentFile().mkdirs();
			f2.createNewFile(); // 파일이 없으면 파일 생성
		}

		// logger.debug("[[[[[[ 시작 루틴 적  ]]]]]]]]]]]]" + storageFilePath +
		// filedir1 + wvScnExtFlnm);
		// logger.debug("[[[[[[ 함 보자  ]]]]]]]]]]]]" + signalUxPath +
		// "SignalUx_non_seed  " + storageFilePath + filedir1 + wvScnExtFlnm);

		// tar 파일 옮기고 압축 해제 로직 추가 시작
		try {
			sucess = copyFile(conEvntDataVO.getEhqkFlsv(), storageFilePath + filedir1 + "/", conEvntDataVO.getEhqkFlnm());
			if (sucess) {

				ProcessBuilder pb = null;

				if (conEvntDataVO.getEhqkFlnm().endsWith(".zip")) {

					command = "unzip " + storageFilePath + filedir1 + conEvntDataVO.getEhqkFlnm();
					pb = new ProcessBuilder("unzip", storageFilePath + filedir1 + conEvntDataVO.getEhqkFlnm());

				} else {
					command = "tar xvf " + storageFilePath + filedir1 + conEvntDataVO.getEhqkFlnm();
					pb = new ProcessBuilder("tar", "xvf", storageFilePath + filedir1 + conEvntDataVO.getEhqkFlnm());
				}

				pb.directory(new File(storageFilePath + filedir1));
				Process process = pb.start();

				// InputStream is = process.getInputStream();
				// InputStream os = process.getErrorStream();
				//
				// while (is.read() > 0) {
				// ;
				// }
				// while (os.read() > 0) {
				// ;
				// }

				Thread.sleep(1000);

				// process.waitFor();

				new File(storageFilePath + filedir1 + conEvntDataVO.getEhqkFlnm()).delete();

				// logger.debug(command);
				System.out.println("step2 : " + conEvntDataVO.getGvmtCd() + " " + conEvntDataVO.getFctyCd());
			}
		} catch (FileNotFoundException e) {
			sucess = false;
			e.printStackTrace();
			nofile++;
		} catch (Exception e) {
			sucess = false;
			e.printStackTrace();
		}
		// tar 파일 옮기고 압축 해제 로직 추가 끝
	}

	public void step3(ConEvntDataVO conEvntDataVO, String iddlAassNo) throws Exception {

		String StrDate = sdfCurrent.format(new Timestamp(System.currentTimeMillis()).getTime());

		String wvScnExtFlsv = "/signalux/" + conEvntDataVO.getEhqkReqId() + "/" + conEvntDataVO.getGvmtCd() + "/" + conEvntDataVO.getFctyCd() + "/"
				+ StrDate + "/SEED/";
		String wvScnRsltFlsv = "/signalux/" + conEvntDataVO.getEhqkReqId() + "/" + conEvntDataVO.getGvmtCd() + "/" + conEvntDataVO.getFctyCd() + "/"
				+ StrDate + "/RESULT/";
		String wvScnExtFlnm = "lin_c_conf.txt";

		IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
		iddlAassInfoVO.setIddlAassNo(new BigDecimal(iddlAassNo));
		iddlAassInfoVO.setEhqkReqId(conEvntDataVO.getEhqkReqId());
		iddlAassInfoVO.setEhqkTranGbcd(conEvntDataVO.getEhqkTranGbcd());
		iddlAassInfoVO.setFctyCd(conEvntDataVO.getFctyCd());
		iddlAassInfoVO.setGvmtCd(conEvntDataVO.getGvmtCd());
		iddlAassInfoVO.setWvScnExtFlsv(wvScnExtFlsv);
		iddlAassInfoVO.setWvScnExtFlnm(wvScnExtFlnm);
		iddlAassInfoVO.setWvScnRsltFlsv(wvScnRsltFlsv);

		try {
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>!!");
			logger.debug("step3 : " + signalUxPath + "/mseed2ascii  " + storageFilePath + wvScnExtFlsv + iddlAassNo + "/");
			// System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>!!");

			ProcessBuilder pb = new ProcessBuilder(signalUxPath + "/mseed2ascii", storageFilePath + wvScnExtFlsv + iddlAassNo + "/");

			Process process = pb.start();
			// process.waitFor();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean step4(ConEvntDataVO conEvntDataVO, String iddlAassNo) throws Exception {

		IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();
		IddlAassWvflVO iddlAassWvflVO = new IddlAassWvflVO();
		IddlAassOpinVVO iddlAassOpinVVO = new IddlAassOpinVVO();
		AnysIdxCoffCfgVO anysIdxCoffCfgVO = new AnysIdxCoffCfgVO();

		String StrDate = sdfCurrent.format(new Timestamp(System.currentTimeMillis()).getTime());

		String wvScnExtFlsv = "/signalux/" + conEvntDataVO.getEhqkReqId() + "/" + conEvntDataVO.getGvmtCd() + "/" + conEvntDataVO.getFctyCd() + "/"
				+ StrDate + "/SEED/";
		String wvScnRsltFlsv = "/signalux/" + conEvntDataVO.getEhqkReqId() + "/" + conEvntDataVO.getGvmtCd() + "/" + conEvntDataVO.getFctyCd() + "/"
				+ StrDate + "/RESULT/";
		String wvScnExtFlnm = "lin_c_conf.txt";

		iddlAassInfoVO.setIddlAassNo(new BigDecimal(iddlAassNo));
		iddlAassInfoVO.setEhqkReqId(conEvntDataVO.getEhqkReqId());
		iddlAassInfoVO.setEhqkTranGbcd(conEvntDataVO.getEhqkTranGbcd());
		iddlAassInfoVO.setFctyCd(conEvntDataVO.getFctyCd());
		iddlAassInfoVO.setGvmtCd(conEvntDataVO.getGvmtCd());
		iddlAassInfoVO.setWvScnExtFlsv(wvScnExtFlsv);
		iddlAassInfoVO.setWvScnExtFlnm(wvScnExtFlnm);
		iddlAassInfoVO.setWvScnRsltFlsv(wvScnRsltFlsv);

		String filedir = wvScnExtFlsv + iddlAassNo + "/";

		// 분석지표계수설정 값 로드
		anysIdxCoffCfgVO.setAnysIdxCoffNo(BigDecimal.ONE);
		anysIdxCoffCfgVO = anysIdxCoffCfgService.selectAnysIdxCoffCfg(anysIdxCoffCfgVO);

		Map<String, Object> mapVO = new HashMap<String, Object>();

		String[][] xFiles = { { "sensor_location_free_X", "G_HGE_00.rec" }, { "sensor_location_free_Y", "G_HGN_00.rec" },
				{ "sensor_location_free_Z", "G_HGZ_00.rec" }, { "sensor_location_bot_X", "B_HCX_00.rec" },
				{ "sensor_location_bot_Y", "B_HCY_00.rec" }, { "sensor_location_bot_Z", "B_HCZ_00.rec" },
				{ "sensor_location_mid_X", "M_HCX_00.rec" }, { "sensor_location_mid_Y1", "M_HCY_00.rec" },
				{ "sensor_location_mid_Y2", "N_HCY_00.rec" }, { "sensor_location_top_X", "T_HCX_00.rec" },
				{ "sensor_location_top_Y1", "T_HCY_00.rec" }, { "sensor_location_top_Y2", "V_HCY_00.rec" } };

		String fileHeads = conEvntDataVO.getGvmtCd() + "_" + conEvntDataVO.getFctyCd();

		for (int i = 0; i < xFiles.length; i++) {

			boolean isExist = new File(storageFilePath + filedir + conEvntDataVO.getGvmtCd() + "_" + conEvntDataVO.getFctyCd() + xFiles[i][1])
					.exists();

			mapVO.put(xFiles[i][0], (isExist ? fileHeads + xFiles[i][1] : "-"));

			// logger.debug(storageFilePath + filedir +
			// conEvntDataVO.getGvmtCd() + "_" + conEvntDataVO.getFctyCd() +
			// xFiles[i][1]);
			// logger.debug("----------------------------------");
			// logger.debug(String.valueOf(mapVO.get(xFiles[i][0])));
			// logger.debug("----------------------------------");

			if (!isExist) {
				if ((i != 6 && i != 7 && i != 8)) {

					return false;
				}
			}
		}

		System.out.println("step4 : Y");

		// 개별분석기본정보에 기본 데이터를 넣는다.
		iddlAassInfoService.insertIddlAassInfo(iddlAassInfoVO);
		IddlAassInfoVO iddlAassInfo = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);

		for (int z = 0; z < mapVO.size(); z++) {

			// logger.debug("+++++++++++++++++++++++++++++++++++");
			// logger.debug(String.valueOf(mapVO.get(xFiles[z][0])));
			// logger.debug("+++++++++++++++++++++++++++++++++++");

			iddlAassWvflVO.setGvmtCd(conEvntDataVO.getGvmtCd());
			iddlAassWvflVO.setFctyCd(iddlAassInfo.getFctyCd());
			iddlAassWvflVO.setIddlAassNo(iddlAassInfo.getIddlAassNo());

			String key = iddlAassInfo.getGvmtCd() + "_" + iddlAassInfo.getFctyCd() + "_R" + (z < 10 ? "0" : "") + z;
			iddlAassWvflVO.setIddlAassScnFlcd(key);
			iddlAassWvflVO.setIddlAassScnFlsv(storageFilePath + iddlAassInfo.getWvScnRsltFlsv());
			iddlAassWvflVO.setIddlAassScnFlnm(mapVO.get(xFiles[z][0]).toString());

			iddlAassWvflService.insertIddlAassWvfl(iddlAassWvflVO);
		}

		FileWriter fw = new FileWriter(storageFilePath + filedir + filename);
		fw.write("seed_file_path : " + storageFilePath + filedir + "\n");
		fw.write("seed_dest_path : " + storageFilePath + iddlAassInfo.getWvScnRsltFlsv() + "\n");
		// fw.write("seed_dest_path : /SIGNALUX/seed/"+"\n");
		fw.write("sensor_location_free_X : " + mapVO.get("sensor_location_free_X") + "\n");
		fw.write("sensor_location_free_Y : " + mapVO.get("sensor_location_free_Y") + "\n");
		fw.write("sensor_location_free_Z : " + mapVO.get("sensor_location_free_Z") + "\n");
		fw.write("sensor_location_bot_X : " + mapVO.get("sensor_location_bot_X") + "\n");
		fw.write("sensor_location_bot_Y : " + mapVO.get("sensor_location_bot_Y") + "\n");
		fw.write("sensor_location_bot_Z : " + mapVO.get("sensor_location_bot_Z") + "\n");
		fw.write("sensor_location_mid_X : " + mapVO.get("sensor_location_mid_X") + "\n");
		fw.write("sensor_location_mid_Y1 : " + mapVO.get("sensor_location_mid_Y1") + "\n");
		fw.write("sensor_location_mid_Y2 : " + mapVO.get("sensor_location_mid_Y2") + "\n");
		fw.write("sensor_location_top_X : " + mapVO.get("sensor_location_top_X") + "\n");
		fw.write("sensor_location_top_Y1 : " + mapVO.get("sensor_location_top_Y1") + "\n");
		fw.write("sensor_location_top_Y2 : " + mapVO.get("sensor_location_top_Y2") + "\n");
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
		fw.write("analy_option_idr_amp : " + (anysIdxCoffCfgVO.getMovTrmLent() == null ? "1.2" : anysIdxCoffCfgVO.getMovTrmLent()) + "\n");
		fw.write("analy_option_str_height : " + (iddlAassInfo.getFctyHt() == null ? "30000.0" : iddlAassInfo.getFctyHt()) + "\n");
		fw.write("analy_option_seismic_area : " + (iddlAassInfo.getEhqkAreaCd() == null ? "1" : iddlAassInfo.getEhqkAreaCd()) + "\n");
		fw.write("analy_option_str_type : " + (iddlAassInfo.getFctyStrTycd() == null ? "1" : iddlAassInfo.getFctyStrTycd().substring(1)) + "\n");
		fw.write("analy_option_str_name : " + iddlAassInfo.getFctyNm() + "\n");
		fw.write("analy_option_str_freq_window : " + anysIdxCoffCfgVO.getStrFrqWinMjH() + ", " + anysIdxCoffCfgVO.getStrFrqWinMjL() + ", "
				+ anysIdxCoffCfgVO.getStrFrqWinShotH() + "," + anysIdxCoffCfgVO.getStrFrqWinShotL() + "\n");
		fw.write("analy_option_str_freq_window_move : 10.0, 5.0" + "\n");
		fw.write("analy_option_limit_state_mean : 0.0042, 0.0067, 0.0133" + "\n");
		fw.write("analy_option_limit_state_dev : 0.59, 0.65, 0.70" + "\n");
		fw.write("analy_option_freq_prev_X : " + iddlAassInfo.getMoniMjNrfy() + "\n");
		fw.write("analy_option_freq_prev_Y : " + iddlAassInfo.getMoniShotNrfy() + "\n");
		fw.write("safe_idr_range_smf : " + anysIdxCoffCfgVO.getSmfSf() + ", " + anysIdxCoffCfgVO.getSmfChk() + ", 2.5, 5.0" + "\n");
		fw.write("safe_idr_range_sef : " + anysIdxCoffCfgVO.getSefSf() + ", " + anysIdxCoffCfgVO.getSefChk() + ", 1.5, 2.0" + "\n");
		fw.write("safe_idr_range_rcf : " + anysIdxCoffCfgVO.getRcfSf() + ", " + anysIdxCoffCfgVO.getRcfChk() + ", 2.0, 4.0" + "\n");
		fw.write("safe_idr_range_rcsw : " + anysIdxCoffCfgVO.getRcswSf() + ", " + anysIdxCoffCfgVO.getRcswChk() + ", 1.0, 2.0" + "\n");
		fw.write("safe_nat_freq_range : " + anysIdxCoffCfgVO.getNatFrqRng() + "\n");
		fw.write("safe_str_free_nat_freq_range : " + anysIdxCoffCfgVO.getStrFreeNatFrqRng() + "\n");
		fw.write("safe_over_acc_range : " + anysIdxCoffCfgVO.getOvrAccRng() + "\n");

		/** 추가항목 2014.03.10 **/
		EhqkScnVO ehqkScnVo = new EhqkScnVO();
		ehqkScnVo.setFctyCd(conEvntDataVO.getFctyCd());
		ehqkScnVo.setGvmtCd(conEvntDataVO.getGvmtCd());

		double xval = 0.0001;
		Map<String, Double> esMap = null;
		List<EhqkScnVO> ehqkScnVoList = ehqkScnService.selectEhqkScnListByCd(ehqkScnVo);

		esMap = getEhqkScnByLocation("G", ehqkScnVoList);
		DecimalFormat df = new DecimalFormat("##.############");

		double defaultVal = 0.0001;

		fw.write("sensor_physical_factor_G_E : " + df.format((esMap == null ? defaultVal : (esMap.get("eSen") / esMap.get("eRes") * xval))) + "\n");
		fw.write("sensor_physical_factor_G_N : " + df.format((esMap == null ? defaultVal : (esMap.get("nSen") / esMap.get("nRes") * xval))) + "\n");
		fw.write("sensor_physical_factor_G_Z : " + df.format((esMap == null ? defaultVal : (esMap.get("zSen") / esMap.get("zRes") * xval))) + "\n");

		esMap = getEhqkScnByLocation("B", ehqkScnVoList);
		fw.write("sensor_physical_factor_B_E : " + df.format((esMap == null ? defaultVal : (esMap.get("eSen") / esMap.get("eRes") * xval))) + "\n");
		fw.write("sensor_physical_factor_B_N : " + df.format((esMap == null ? defaultVal : (esMap.get("nSen") / esMap.get("nRes") * xval))) + "\n");
		fw.write("sensor_physical_factor_B_Z : " + df.format((esMap == null ? defaultVal : (esMap.get("zSen") / esMap.get("zRes") * xval))) + "\n");

		esMap = getEhqkScnByLocation("M", ehqkScnVoList);
		fw.write("sensor_physical_factor_M_E : " + df.format((esMap == null ? defaultVal : (esMap.get("eSen") / esMap.get("eRes") * xval))) + "\n");
		fw.write("sensor_physical_factor_M_N : " + df.format((esMap == null ? defaultVal : (esMap.get("nSen") / esMap.get("nRes") * xval))) + "\n");

		esMap = getEhqkScnByLocation("N", ehqkScnVoList);
		fw.write("sensor_physical_factor_N_N : " + df.format((esMap == null ? defaultVal : (esMap.get("nSen") / esMap.get("nRes") * xval))) + "\n");

		esMap = getEhqkScnByLocation("T", ehqkScnVoList);
		fw.write("sensor_physical_factor_T_E : " + df.format((esMap == null ? defaultVal : (esMap.get("eSen") / esMap.get("eRes") * xval))) + "\n");
		fw.write("sensor_physical_factor_T_N : " + df.format((esMap == null ? defaultVal : (esMap.get("nSen") / esMap.get("nRes") * xval))) + "\n");

		esMap = getEhqkScnByLocation("V", ehqkScnVoList);
		fw.write("sensor_physical_factor_V_N : " + df.format((esMap == null ? defaultVal : (esMap.get("nSen") / esMap.get("nRes") * xval))) + "\n");
		/** 추가항목 끝 **/

		fw.close();

		// 개별분석 설정값 저장
		iddlAassOpinVVO.setFctyCd(iddlAassInfo.getFctyCd());
		iddlAassWvflVO.setIddlAassNo(iddlAassInfo.getIddlAassNo());
		iddlAassOpinVVO.setGvmtCd(iddlAassInfo.getGvmtCd());
		iddlAassOpinVVO.setIddlAassNo(String.valueOf(iddlAassInfo.getIddlAassNo()));

		iddlAassOpinVVO.setScnFitrFreeX("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrFreeY("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrFreeZ("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrBotX("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrBotY("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrBotZ("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrMidX("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrMidY1("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrMidY2("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrTopX("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrTopY1("2, 0.008, 0.8");
		iddlAassOpinVVO.setScnFitrTopY2("2, 0.008, 0.8");

		iddlAassOpinVVO.setAnaOpinIdrAmp(String.valueOf(anysIdxCoffCfgVO.getMovTrmLent()));
		iddlAassOpinVVO.setAnaOpinSimcArea(iddlAassInfo.getEhqkAreaCd());
		iddlAassOpinVVO.setAnaOpinStrHei(iddlAassInfo.getFctyHt());
		iddlAassOpinVVO.setAnaOpinStrTycd(iddlAassInfo.getFctyStrTycd());
		iddlAassOpinVVO.setAnaOpinStrNm(iddlAassInfo.getFctyNm());
		iddlAassOpinVVO.setAnaOpinStrFrqWinMjL(anysIdxCoffCfgVO.getStrFrqWinMjH().toString());
		iddlAassOpinVVO.setAnaOpinStrFrqWinMjH(anysIdxCoffCfgVO.getStrFrqWinMjL().toString());
		iddlAassOpinVVO.setAnaOpinStrFrqWinShotL(anysIdxCoffCfgVO.getStrFrqWinShotL().toString());
		iddlAassOpinVVO.setAnaOpinStrFrqWinShotH(anysIdxCoffCfgVO.getStrFrqWinShotH().toString());
		iddlAassOpinVVO.setAnaOpinLimiStatMenSlit("0.0042");
		iddlAassOpinVVO.setAnaOpinLimiStatMenNor("0.0067");
		iddlAassOpinVVO.setAnaOpinLimiStatMenHsh("0.0133");
		iddlAassOpinVVO.setAnaOpinLimiStatSlit("0.59");
		iddlAassOpinVVO.setAnaOpinLimiStatNor("0.65");
		iddlAassOpinVVO.setAnaOpinLimiStatHsh("0.70");
		iddlAassOpinVVO.setAnaOpinFrqPrvX(iddlAassInfo.getMoniMjNrfy().toString());
		iddlAassOpinVVO.setAnaOpinFrqPrvY(iddlAassInfo.getMoniShotNrfy().toString());

		iddlAassOpinVVO.setSfIdrRngSmfSf(anysIdxCoffCfgVO.getSmfSf().toString());
		iddlAassOpinVVO.setSfIdrRngSmfChk(anysIdxCoffCfgVO.getSmfChk().toString());
		iddlAassOpinVVO.setSfIdrRngSmfHsh("2.5");
		iddlAassOpinVVO.setSfIdrRngSmfShr("5.0");
		iddlAassOpinVVO.setSfIdrRngSefSf(anysIdxCoffCfgVO.getSefSf().toString());
		iddlAassOpinVVO.setSfIdrRngSefChk(anysIdxCoffCfgVO.getSefChk().toString());
		iddlAassOpinVVO.setSfIdrRngSefHsh("1.5");
		iddlAassOpinVVO.setSfIdrRngSefShr("2.0");
		iddlAassOpinVVO.setSfIdrRngRcfSf(anysIdxCoffCfgVO.getRcfSf().toString());
		iddlAassOpinVVO.setSfIdrRngRcfChk(anysIdxCoffCfgVO.getRcfChk().toString());
		iddlAassOpinVVO.setSfIdrRngRcfHsh("2.0");
		iddlAassOpinVVO.setSfIdrRngRcfShr("4.0");
		iddlAassOpinVVO.setSfIdrRngRcswSf(anysIdxCoffCfgVO.getRcswSf().toString());
		iddlAassOpinVVO.setSfIdrRngRcswChk(anysIdxCoffCfgVO.getRcswChk().toString());
		iddlAassOpinVVO.setSfIdrRngRcswHsh("1.0");
		iddlAassOpinVVO.setSfIdrRngRcswShr("2.0");
		iddlAassOpinVVO.setSfNatFrqRng(anysIdxCoffCfgVO.getNatFrqRng().toString());
		iddlAassOpinVVO.setSfStrFreeNatFrqRng(anysIdxCoffCfgVO.getStrFreeNatFrqRng().toString());
		iddlAassOpinVVO.setSfOvrAccRng(anysIdxCoffCfgVO.getOvrAccRng().toString());

		iddlAassOpinVService.insertIddlAassOpinV(iddlAassOpinVVO);

		return true;
	}

	public void step5(ConEvntDataVO conEvntDataVO, String iddlAassNo) throws Exception {

		IddlAassInfoVO iddlAassInfo = new IddlAassInfoVO();
		iddlAassInfo.setEhqkReqId(conEvntDataVO.getEhqkReqId());
		iddlAassInfo.setEhqkTranGbcd(conEvntDataVO.getEhqkTranGbcd());
		iddlAassInfo.setFctyCd(conEvntDataVO.getFctyCd());
		iddlAassInfo.setGvmtCd(conEvntDataVO.getGvmtCd());

		iddlAassInfo = iddlAassInfoService.selectIddlAassInfo(iddlAassInfo);

		String filedir = iddlAassInfo.getWvScnExtFlsv();

		try {
			logger.debug("step5 : " + signalUxPath + "/SignalUx_non_seed  " + storageFilePath + filedir + iddlAassInfo.getWvScnExtFlnm());

			ProcessBuilder pb = new ProcessBuilder(signalUxPath + "/SignalUx_non_seed", storageFilePath + filedir + iddlAassInfo.getWvScnExtFlnm());

			Process process = pb.start();
			// process.waitFor();
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.debug("[[[[[[ 종료루틴적용   ]]]]]]]]]]]]" + storageFilePath +
		// filedir + iddlAassInfo.getWvScnExtFlnm());

		IddlAassRlstVO iddlAassRlstVO2 = new IddlAassRlstVO();

		iddlAassRlstVO2.setFctyCd(iddlAassInfo.getFctyCd());
		iddlAassRlstVO2.setGvmtCd(iddlAassInfo.getGvmtCd());
		iddlAassRlstVO2.setIddlAassNo(iddlAassInfo.getIddlAassNo());

		iddlAassRlstService.deleteIddlAassRlst(iddlAassRlstVO2);

		// 개별분석결과 저장
		iddlAassRlstVO2 = readIddlAassRlstFile2(storageFilePath + iddlAassInfo.getWvScnRsltFlsv(), "result.txt");
		iddlAassRlstVO2.setFctyCd(iddlAassInfo.getFctyCd());
		iddlAassRlstVO2.setGvmtCd(iddlAassInfo.getGvmtCd());
		iddlAassRlstVO2.setIddlAassNo(iddlAassInfo.getIddlAassNo());

		iddlAassRlstService.insertIddlAassRlst(iddlAassRlstVO2);
	}

	@RequestMapping("/signalUxExec/addSignalUxRsltExec.do")
	@ResponseBody
	public String addSignalUxRsltExec(ModelMap model, @ModelAttribute("searchVO") ConEvntDataDefaultVO searchVO, SessionStatus status)
			throws Exception {

		Map<String, Object> fctyDataMap = new HashMap<String, Object>();
		ObjectMapper m = new ObjectMapper();
		String reqDataJson = "";

		try {
			// 지전 이벤트 구간 데이터 전체를 읽는다.
			List<ConEvntDataVO> conEvntDataList = conEvntDataService.selectConEvntDataList(searchVO);

			String iddlAassNo = iddlAassInfoService.selectIddlAassNo(null);

			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			logger.debug(iddlAassNo);
			logger.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

			boolean result = true;
			int noMustfile = 0;
			int run = 0;
			int success = 0;

			for (ConEvntDataVO conEvntDataVO : conEvntDataList) {

				// 기본 정보 삭제
				// step1(conEvntDataVO);

				// tar 복사후 압축 해제
				step2(conEvntDataVO, iddlAassNo);

				// mseed2ascii 실행
				step3(conEvntDataVO, iddlAassNo);

				// 개별분석파형파일정보, 개별분석 설정값 저장 등록
				result = step4(conEvntDataVO, iddlAassNo);

				if (result) {

					// 생성완료 된경우 결과 값 생성을 위한 루틴 처리
					step5(conEvntDataVO, iddlAassNo);
					success++;
				} else {
					noMustfile++;
				}
				run++;
			}

			System.out.println("**************************************");
			System.out.println("실행횟수 : " + run);
			System.out.println("성공 : " + success);
			System.out.println("필수파일누락 : " + noMustfile);
			System.out.println("파일없음 : " + nofile);
			System.out.println("**************************************");

			fctyDataMap.put("result", result);
			reqDataJson = m.writeValueAsString(fctyDataMap);
			logger.debug("FctyInfoJson : " + reqDataJson);

			status.setComplete();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return reqDataJson;
	}

	@RequestMapping("/signalUxExec/addSignalUxRsltExecDel.do")
	public String addSignalUxRsltExecDel(ModelMap model, @ModelAttribute("searchVO") ConEvntDataDefaultVO searchVO, SessionStatus status)
			throws Exception {

		IddlAassInfoVO iddlAassInfo = new IddlAassInfoVO();
		iddlAassInfo.setEhqkReqId(searchVO.getEhqkReqId());
		iddlAassInfo.setEhqkTranGbcd(searchVO.getEhqkTranGbcd());
		iddlAassInfo = iddlAassInfoService.selectIddlAassInfo(iddlAassInfo);
		// 개별분석 기본정보 삭제
		// iddlAassInfoService.deleteIddlAassInfo(vo);
		// 개별분석파형파일정보 삭제
		// iddlAassWvflService.deleteIddlAassWvfl(vo);
		// 개별분석설정값 삭제
		// iddlAassOpinVService.deleteIddlAassOpinV(vo);
		// 개별분석 결과 삭제
		// iddlAassRlstService.deleteIddlAassRlst(vo);

		return "/estam/signalux/SignalUxExecMain";
	}

	private boolean conEvntDataCreate(ConEvntDataDefaultVO searchVO, SessionStatus status) {

		return true;

	}

	// 처리해서 VO 객채로 돌려주는 함수
	public IddlAassRlstVO readIddlAassRlstFile2(String storageFilePath, String fileName) throws Exception {

		ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
		IddlAassRlstVO iddlAassRlstVO = new IddlAassRlstVO();
		File uFile = new File(storageFilePath, fileName);

		int fSize = (int) uFile.length();

		if (!uFile.exists()) {
			logger.debug("path_error.... please change path in this program");
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
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltMaxIdrX(yVal);
				}
				if (xVal.indexOf("result_max_idr_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltMaxIdrY(yVal);
				}
				if (xVal.indexOf("result_over_acc_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltOvrAccX(yVal);
				}
				if (xVal.indexOf("result_over_acc_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltOvrAccY(yVal);
				}
				if (xVal.indexOf("result_nat_freq_move_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltNatFrqMvX(yVal);
				}
				if (xVal.indexOf("result_nat_freq_move_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltNatFrqMvY(yVal);
				}
				if (xVal.indexOf("result_str_free_nat_freq_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltStrFreeNatFrqX(yVal);
				}
				if (xVal.indexOf("result_str_free_nat_freq_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltStrFreeNatFrqY(yVal);
				}
				if (xVal.indexOf("safe_check_max_idr_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkMaxIdrXRslt(yVal);
				}
				if (xVal.indexOf("safe_check_max_idr_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkMaxIdrYRslt(yVal);
				}
				if (xVal.indexOf("safe_check_nat_freq_move_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkNatFrqMvXRslt(yVal);
				}
				if (xVal.indexOf("safe_check_nat_freq_move_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkNatFrqMvYRslt(yVal);
				}
				if (xVal.indexOf("safe_check_str_free_nat_freq_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkStrFreeNatFrqX(yVal);
				}
				if (xVal.indexOf("safe_check_str_free_nat_freq_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkStrFreeNatFrqY(yVal);
				}
				if (xVal.indexOf("safe_check_over_acc_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkOvrAccXRslt(yVal);
				}
				if (xVal.indexOf("safe_check_over_acc_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setSfChkOvrAccYRslt(yVal);
				}
				if (xVal.indexOf("data_free_max_disp_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setDataFreeMaxDispX(yVal);
				}
				if (xVal.indexOf("data_free_max_disp_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setDataFreeMaxDispY(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_speed_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setDataTopRelMaxSpedX(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_speed_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setDataTopRelMaxSpedY(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_disp_X") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setDataTopRelMaxDispX(yVal);
				}
				if (xVal.indexOf("data_top_rel_max_disp_Y") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					iddlAassRlstVO.setDataTopRelMaxDispY(yVal);
				}
				if (xVal.indexOf("data_free_acc") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataFreeAccX(yy[0].trim());
					iddlAassRlstVO.setDataFreeAccY(yy[1].trim());
					iddlAassRlstVO.setDataFreeAccHorz(yy[2].trim());
					iddlAassRlstVO.setDataFreeAccZ(yy[3].trim());
				}
				if (xVal.indexOf("data_free_vel") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataFreeAccSpedX(yy[0].trim());
					iddlAassRlstVO.setDataFreeAccSpedY(yy[1].trim());
					iddlAassRlstVO.setDataFreeAccSpedHorz(yy[2].trim());
					iddlAassRlstVO.setDataFreeAccSpedZ(yy[3].trim());
				}
				if (xVal.indexOf("data_free_disp") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataFreeAccDispX(yy[0].trim());
					iddlAassRlstVO.setDataFreeAccDispY(yy[1].trim());
					iddlAassRlstVO.setDataFreeAccDispHorz(yy[2].trim());
					iddlAassRlstVO.setDataFreeAccDispZ(yy[3].trim());
				}
				if (xVal.indexOf("data_str_bot_acc") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrBotAccX(yy[0].trim());
					iddlAassRlstVO.setDataStrBotAccY(yy[1].trim());
					iddlAassRlstVO.setDataStrBotAccZ(yy[2].trim());
				}
				if (xVal.indexOf("data_str_bot_vel") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrBotSpedX(yy[0].trim());
					iddlAassRlstVO.setDataStrBotSpedY(yy[1].trim());
				}
				if (xVal.indexOf("data_str_bot_disp") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrBotDispX(yy[0].trim());
					iddlAassRlstVO.setDataStrBotDispY(yy[1].trim());
				}
				if (xVal.indexOf("data_str_mid_acc") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrMidAccX(yy[0].trim());
					iddlAassRlstVO.setDataStrMidAccY1(yy[1].trim());
					iddlAassRlstVO.setDataStrMidAccY2(yy[2].trim());
				}
				if (xVal.indexOf("data_str_top_acc") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrTopAccX(yy[0].trim());
					iddlAassRlstVO.setDataStrTopAccY1(yy[1].trim());
					iddlAassRlstVO.setDataStrTopAccY2(yy[2].trim());
				}
				if (xVal.indexOf("data_str_freq") != -1) {
					aa = xVal.split(":");
					yVal = aa[1];
					String yy[];
					yy = yVal.split(",");
					iddlAassRlstVO.setDataStrFrqX(yy[0].trim());
					iddlAassRlstVO.setDataStrFrqY(yy[1].trim());
				}
				if (xVal.indexOf("data_free_freq") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setDataFreeFrq(yVal);
				}
				if (xVal.indexOf("design_acc") != -1) {
					aa = xVal.split(":");
					yVal = aa[1].trim();
					iddlAassRlstVO.setRsltOvrAccVal(yVal);
				}

				i++;
			}

		}
		return iddlAassRlstVO;
	}

	/**
	 * 파일복사..
	 * 
	 * @param in
	 * @param out
	 * @throws Exception
	 */
	public boolean copyFile(String sOldDir, String sNewDir, String sFileName) throws Exception {
		boolean suc = false;
		File oOldFile = null;
		File oNewFile = null;

		oOldFile = new File(sOldDir, sFileName);
		oNewFile = new File(sNewDir, sFileName);

		// System.out.println("########################################### sNewDir");
		// System.out.println(sOldDir + "/" + sFileName);
		// System.out.println(sNewDir + "/" + sFileName);
		// System.out.println("oOldFile.exists() : " + oOldFile.exists());
		// System.out.println("###########################################");

		FileChannel sourceChannel = new FileInputStream(oOldFile).getChannel();
		FileChannel destinationChannel = new FileOutputStream(oNewFile).getChannel();
		sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);

		sourceChannel.close();
		destinationChannel.close();
		suc = true;
		return suc;
	}

	public static void cmd(PrintStream out, String msg) throws IOException {
		byte[] b = new byte[5000];

		if (msg != null) {
			out.println(msg);
			out.flush();
		}

	}

	/*
	 * @RequestMapping("/signalUxExec/addSignalUxRsltExec.do") public String
	 * addSignalUxRsltExec( SignalUxExecVO signalUxExecVO,
	 * 
	 * @ModelAttribute("searchVO") SignalUxExecDefaultVO searchVO, SessionStatus
	 * status) throws Exception {
	 * signalUxExecService.insertSignalUxExec(signalUxExecVO); //
	 * iddlAassInfoDAO.insertSignalUxExec(signalUxExecVO); status.setComplete();
	 * return "forward:/signalUxExec/SignalUxExecList.do"; }
	 */

	public ArrayList<IddlAassInfoVO> readIddlAassRlstFile(String storageFilePath, String fileName, IddlAassInfoVO iddlAassInfo) throws Exception {

		ArrayList<IddlAassInfoVO> wvList = new ArrayList<IddlAassInfoVO>();
		File uFile = new File(storageFilePath, fileName);

		int fSize = (int) uFile.length();

		if (!uFile.exists()) {
			logger.debug("path_error.... please change path in this program");
		}

		if (fSize > 0) {
			// 파일 읽기
			FileInputStream fls = new FileInputStream(uFile);
			Scanner s = new Scanner(fls);
			String times = "", accCol1, accCol2, accCol3, accCol4, accCol5, accCol6, accCol7, accCol8, accCol9, accCol10, accCol11, accCol12, accCol13, accCol14;
			String accCol15, accCol16, accCol17, accCol18, accCol19, accCol20, accCol21, accCol22, accCol23, accCol24, accCol25, accCol26, accCol27, accCol28, accCol29, accCol30, accCol31, accCol32, accCol33;

			int i = 0;
			// int columns = Integer.parseInt(columnCnt);
			while (s.hasNext()) {
				IddlAassInfoVO v_WvIddlAassRlst = new IddlAassInfoVO();

				times = s.next();
				accCol1 = s.next();
				accCol2 = s.next();
				accCol3 = s.next();
				accCol4 = s.next();
				accCol5 = s.next();
				accCol6 = s.next();
				accCol7 = s.next();
				accCol8 = s.next();
				accCol9 = s.next();
				accCol10 = s.next();
				accCol11 = s.next();
				accCol12 = s.next();
				accCol13 = s.next();
				accCol14 = s.next();
				accCol15 = s.next();
				accCol16 = s.next();
				accCol17 = s.next();
				accCol18 = s.next();
				accCol19 = s.next();
				accCol20 = s.next();
				accCol21 = s.next();
				accCol22 = s.next();
				accCol23 = s.next();
				accCol24 = s.next();
				accCol25 = s.next();
				accCol26 = s.next();
				accCol27 = s.next();
				accCol28 = s.next();
				accCol29 = s.next();
				accCol30 = s.next();
				accCol31 = s.next();
				accCol32 = s.next();
				accCol33 = s.next();

				v_WvIddlAassRlst.setResultMaxIdrX(new BigDecimal(accCol1));
				v_WvIddlAassRlst.setResultMaxIdrY(new BigDecimal(accCol2));
				v_WvIddlAassRlst.setResultOverAccX(new BigDecimal(accCol3));
				v_WvIddlAassRlst.setResultOverAccY(new BigDecimal(accCol4));
				v_WvIddlAassRlst.setResultNatFreqMoveX(new BigDecimal(accCol5));
				v_WvIddlAassRlst.setResultNatFreqMoveY(new BigDecimal(accCol6));
				v_WvIddlAassRlst.setResultStrFreeNatFreqX(new BigDecimal(accCol7));
				v_WvIddlAassRlst.setResultStrFreeNatFreqY(new BigDecimal(accCol8));
				v_WvIddlAassRlst.setSafeCheckMaxIdrX(accCol9);
				v_WvIddlAassRlst.setSafeCheckMaxIdrY(accCol10);
				v_WvIddlAassRlst.setSafeCheckNatFreqMoveX(accCol11);
				v_WvIddlAassRlst.setSafeCheckNatFreqMoveY(accCol12);
				v_WvIddlAassRlst.setSafeCheckStrFreeNatFreqX(accCol13);
				v_WvIddlAassRlst.setSafeCheckStrFreeNatFreqY(accCol14);
				v_WvIddlAassRlst.setSafeCheckOverAccX(accCol15);
				v_WvIddlAassRlst.setSafeCheckOverAccY(accCol16);
				v_WvIddlAassRlst.setDataFreeMaxDispX(new BigDecimal(accCol17));
				v_WvIddlAassRlst.setDataFreeMaxDispY(new BigDecimal(accCol18));
				v_WvIddlAassRlst.setDataTopRelMaxSpeedX(new BigDecimal(accCol19));
				v_WvIddlAassRlst.setDataTopRelMaxSpeedY(new BigDecimal(accCol20));
				v_WvIddlAassRlst.setDataTopRelMaxDispX(new BigDecimal(accCol21));
				v_WvIddlAassRlst.setDataTopRelMaxDispY(new BigDecimal(accCol22));
				v_WvIddlAassRlst.setDataFreeAcc(new BigDecimal(accCol23));
				v_WvIddlAassRlst.setDataFreeVel(new BigDecimal(accCol24));
				v_WvIddlAassRlst.setDataFreeDisp(new BigDecimal(accCol25));
				v_WvIddlAassRlst.setDataStrBotAcc(new BigDecimal(accCol26));
				v_WvIddlAassRlst.setDataStrBotVel(new BigDecimal(accCol27));
				v_WvIddlAassRlst.setDataStrBotDisp(new BigDecimal(accCol28));
				v_WvIddlAassRlst.setDataStrMidAcc(new BigDecimal(accCol29));
				v_WvIddlAassRlst.setDataStrTopAcc(new BigDecimal(accCol30));
				v_WvIddlAassRlst.setDataStrFreq(new BigDecimal(accCol31));
				v_WvIddlAassRlst.setDataFreeFreq(new BigDecimal(accCol32));
				v_WvIddlAassRlst.setDesignAcc(new BigDecimal(accCol33));

				wvList.add(v_WvIddlAassRlst);
				i++;
			}

		}

		return wvList;

	}

	private Map<String, Double> getEhqkScnByLocation(String location, List<EhqkScnVO> ehqkScnVoList) throws Exception {

		Map<String, Double> result = new HashMap<String, Double>();

		for (EhqkScnVO esVo : ehqkScnVoList) {

			String val = StringUtils.substring(esVo.getEhqkScnId(), esVo.getEhqkScnId().length() - 1, esVo.getEhqkScnId().length());

			if (StringUtils.equals(val, location)) {

				result.put("eSen", Double.parseDouble(esVo.getEhqkScnESen()) <= 0 ? 1 : Double.parseDouble(esVo.getEhqkScnESen()));
				result.put("nSen", Double.parseDouble(esVo.getEhqkScnNSen()) <= 0 ? 1 : Double.parseDouble(esVo.getEhqkScnNSen()));
				result.put("zSen", Double.parseDouble(esVo.getEhqkScnZSen()) <= 0 ? 1 : Double.parseDouble(esVo.getEhqkScnZSen()));
				result.put("eRes", Double.parseDouble(esVo.getEhqkScnERes()) <= 0 ? 1 : Double.parseDouble(esVo.getEhqkScnERes()));
				result.put("nRes", Double.parseDouble(esVo.getEhqkScnNRes()) <= 0 ? 1 : Double.parseDouble(esVo.getEhqkScnNRes()));
				result.put("zRes", Double.parseDouble(esVo.getEhqkScnZRes()) <= 0 ? 1 : Double.parseDouble(esVo.getEhqkScnZRes()));
				return result;
			}
		}
		return null;
	}

	// @RequestMapping("/signalUxExec/updateSignalUxExecView.do")
	// public String updateSignalUxExecView(
	// @RequestParam("cd") java.lang.String cd ,
	// @RequestParam("grCd") java.lang.String grCd ,
	// @ModelAttribute("searchVO") SignalUxExecDefaultVO searchVO, Model model)
	// throws Exception {
	// SignalUxExecVO signalUxExecVO = new SignalUxExecVO();
	// signalUxExecVO.setCd(cd);
	// signalUxExecVO.setGrCd(grCd);
	// // 변수명은 CoC 에 따라 signalUxExecVO
	// model.addAttribute(selectSignalUxExec(signalUxExecVO, searchVO));
	// return "/signalUxExec/SignalUxExecRegister";
	// }
	//
	// @RequestMapping("/signalUxExec/selectSignalUxExec.do")
	// public @ModelAttribute("signalUxExecVO")
	// SignalUxExecVO selectSignalUxExec(
	// SignalUxExecVO signalUxExecVO,
	// @ModelAttribute("searchVO") SignalUxExecDefaultVO searchVO) throws
	// Exception {
	// return signalUxExecService.selectSignalUxExec(signalUxExecVO);
	// }
	//
	// @RequestMapping("/signalUxExec/updateSignalUxExec.do")
	// public String updateSignalUxExec(
	// SignalUxExecVO signalUxExecVO,
	// @ModelAttribute("searchVO") SignalUxExecDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// signalUxExecService.updateSignalUxExec(signalUxExecVO);
	// status.setComplete();
	// return "forward:/signalUxExec/SignalUxExecList.do";
	// }
	//
	// @RequestMapping("/signalUxExec/deleteSignalUxExec.do")
	// public String deleteSignalUxExec(
	// SignalUxExecVO signalUxExecVO,
	// @ModelAttribute("searchVO") SignalUxExecDefaultVO searchVO, SessionStatus
	// status)
	// throws Exception {
	// signalUxExecService.deleteSignalUxExec(signalUxExecVO);
	// status.setComplete();
	// return "forward:/signalUxExec/SignalUxExecList.do";
	// }

}
