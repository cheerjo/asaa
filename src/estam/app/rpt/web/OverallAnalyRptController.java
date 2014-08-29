package estam.app.rpt.web;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.Globals;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import estam.app.fcty.service.FctyImgService;
import estam.app.fcty.service.FctyMgrService;
import estam.app.iddl.service.IddlAassInfoService;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlAassRlstService;
import estam.app.iddl.service.IddlAassRlstStttService;
import estam.app.iddl.service.WvIddlAassRlstVO;
import estam.app.rpt.service.OverallAnalyRptDefaultVO;
import estam.app.rpt.service.OverallAnalyRptService;

/**
 * @Class Name : OverallAnalyRptController.java
 * @Description :
 * @Modification Information
 * 
 * @author
 * @since 2013.12.09
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
public class OverallAnalyRptController {
	private static final Logger logger = LoggerFactory
			.getLogger(FctyEstmEvalRptController.class);

	private static final String[] FCTY_SCN_RSLT_PATH_FILE_10 = { "f_acc.rec" }; // 가속도
																				// 파형3
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_10 = { "4" }; // 가속도
																			// 파형3
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_20 = { "f_vel.rec" }; // 속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_20 = { "4" }; // 속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_30 = { "f_dis.rec" }; // 변위
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_30 = { "4" }; // 변위
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_40 = { "f_hvr.rec",
			"f_spect.rec" }; // 응답스펙트럼
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_40 = { "2", "7" }; // 응답스펙트럼
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_50 = { "tr_acc.rec" }; // 최상층가속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_50 = { "3" }; // 최상층가속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_60 = { "tr_vel.rec" }; // 최상층속도
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_60 = { "3" }; // 최상층속도
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_70 = { "tr_dis.rec" }; // 최상층
																					// 변위
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_70 = { "3" }; // 최상층
																			// 변위
	private static final String[] FCTY_SCN_RSLT_PATH_FILE_80 = { "tr_tf.rec",
			"tr_dis.rec" }; // 안정성평가결과
	private static final String[] FCTY_SCN_RSLT_FILE_COLUMN_80 = { "3", "3" }; // 안정성평가결과

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name = "fctyMgrService")
	private FctyMgrService fctyMgrService;

	@Resource(name = "fctyImgService")
	private FctyImgService fctyImgService;

	@Resource(name = "iddlAassRlstStttService")
	private IddlAassRlstStttService iddlAassRlstStttService;

	@Resource(name = "iddlAassInfoService")
	private IddlAassInfoService iddlAassInfoService;

	@Resource(name = "overallAnalyRptService")
	private OverallAnalyRptService overallAnalyRptService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	@Resource(name = "iddlAassRlstService")
	private IddlAassRlstService iddlAassRlstService;

	/**
	 * 보고서작성 - 지진발생자료 종합분석 보고서
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 OverallAnalyRptDefaultVO
	 * @return "/rpt/OverallAnlyRpt"
	 * @exception Exception
	 */
	@RequestMapping(value = "/rpt/OverallAnalyRpt.do")
	public String selectOverallAnlyRpt(
			@ModelAttribute("searchVO") OverallAnalyRptDefaultVO searchVO,
			ModelMap model) throws Exception {
		
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		
		//vo.setCommCd("ITEM_008"); 
		//List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
		//model.addAttribute("fctyAreaList", fctyAreaList);
		
		// 분석결과 목록 조회
		List analyRsltList = overallAnalyRptService.selectAnalyRsltList(searchVO);
		model.addAttribute("analyRsltList", analyRsltList);

		int totCnt = overallAnalyRptService.selectAnalyRsltListTotCnt(searchVO);
		model.addAttribute("analyRsltCnt", totCnt);
		
		//시설물 목록 조회
//		List fctyList = overallAnalyRptService.selectFctyList(searchVO);
//		model.addAttribute("fctyList", fctyList);
		
		String analyRsltSearch="";
        if(analyRsltList.size() > 0) {
        	EgovMap rsltMap = (EgovMap)analyRsltList.get(0);
        	analyRsltSearch = "analyRslt:" 
     			   + rsltMap.get("ehqkReqId").toString() +":"
     			   + rsltMap.get("ehqkTranGbcd").toString() +":"
     			   + rsltMap.get("iddlAassNo").toString();
        }
        model.addAttribute("analyRsltSearch", analyRsltSearch);  

		return "/estam/rpt/OverallAnalyRpt";
	}
	
	/**
	 * 보고서작성 - 시설물 목록
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 OverallAnalyRptDefaultVO
	 * @return "/rpt/OverallAnalyFcty"
	 * @exception Exception
	 */
	@RequestMapping(value = "/rpt/getOverallAnalyFcty.do")
	public String getOverallAnalyFcty(
			@ModelAttribute("searchVO") OverallAnalyRptDefaultVO searchVO,
			ModelMap model) throws Exception {
		
		//시설물 목록 조회
		List fctyList = overallAnalyRptService.selectFctyList(searchVO);
		model.addAttribute("fctyList", fctyList);
		
		return "/estam/rpt/OverallAnalyFcty";
	}

	/**
	 * 종합보고서 - 지진발생자료 종합분석 보고서
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 OverallAnalyRptDefaultVO
	 * @return "/rpt/OverallAnalyRptPrint"
	 * @exception Exception
	 */
	@RequestMapping("/rpt/OverallAnalyRptPrint.do")
	public String selectOverallAnlyRptPrint(
			@ModelAttribute("searchVO") OverallAnalyRptDefaultVO searchVO,
			Model model) throws Exception {
		
		List ehqkOcurInfo = overallAnalyRptService.selectEhqkOcurInfo(searchVO);
		model.addAttribute("ehqkOcurInfo", ehqkOcurInfo);
		
		//
		ArrayList fctyArrList = new ArrayList();
		String[] array = searchVO.getFctyList().toString().split(",");
		for(int i=0;i<array.length;i++){
			fctyArrList.add(array[i]);
		}
		searchVO.setFctyListAL(fctyArrList);
		
		//분석결과 요약
		String[] chkRult = searchVO.getChkRult().toString().split(",");
		String chkRult1View = "";
		String chkRult2View = "";
		String chkRult3View = "";
		
		for(int i=0;i<chkRult.length;i++){
			//지반 가속도 계측 관측소
			if(chkRult[i].equals("chkRult1")) {
				List chkRult1 = overallAnalyRptService.selectChkRult1(searchVO);
				model.addAttribute("chkRult1", chkRult1);
				chkRult1View = "view";
			} 
			//설계지반가속도 초과지역
			else if(chkRult[i].equals("chkRult2")) {
				List chkRult2 = overallAnalyRptService.selectChkRult2(searchVO);
				model.addAttribute("chkRult2", chkRult2);
				chkRult2View = "view";
			} 
			//점검필요 시설물 목록
			else if(chkRult[i].equals("chkRult3")) {
				chkRult3View = "view";
			}
		}
		model.addAttribute("chkRult1View", chkRult1View);
		model.addAttribute("chkRult2View", chkRult2View);
		model.addAttribute("chkRult3View", chkRult3View);
		
		
		List analyRsltInfo = overallAnalyRptService.selectAnalyRsltInfo(searchVO);
		model.addAttribute("analyRsltInfo", analyRsltInfo);

		return "/estam/rpt/inc/OverallAnalyRptPrint";
	}

	@RequestMapping("/rpt/OverallAnalyRptPrintGrp.do")
	public String selectOverallAnlyRptPrintGrp(
			@ModelAttribute("searchVO") OverallAnalyRptDefaultVO searchVO,
			IddlAassRlstDefaultVO searchVO1, Model model) throws Exception {

		String url = "/estam/rpt/inc/OverallAnalyRptGrp";
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(searchVO.getGvmtCd());
		System.out.println(searchVO.getFctyCd());
		System.out.println(searchVO.getDataList());
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		try {
			//관측소별 자료목록
			String[] dataList = searchVO.getDataList().toString().split(",");
			String dataList1View = "none";
			String dataList2View = "none";
			String dataList3View = "none";
			
			for(int i=0;i<dataList.length;i++){
				//자유장 가속도 시간이력
				if(dataList[i].equals("dataList1")) {
					dataList1View = "block";
				} 
				//가속도 응답 스펙트럼
				else if(dataList[i].equals("dataList2")) {
					dataList2View = "block";
				} 
				//속도 응답 스펙트럼
				else if(dataList[i].equals("dataList3")) {
					dataList3View = "block";
				}
			}
			model.addAttribute("dataList1View", dataList1View);
			model.addAttribute("dataList2View", dataList2View);
			model.addAttribute("dataList3View", dataList3View);
			
			ArrayList<WvIddlAassRlstVO> wvList1 = new ArrayList<WvIddlAassRlstVO>();
			ArrayList<WvIddlAassRlstVO> wvList2 = new ArrayList<WvIddlAassRlstVO>();
			ArrayList<WvIddlAassRlstVO> wvList3 = new ArrayList<WvIddlAassRlstVO>();
			
			model.addAttribute("rCnt", searchVO.getModes());

			if (searchVO.getIddlAassNo() != null) {
				String storageFilePath = Globals.STORAGE_ROOT; // 스토리지에 파형위치 정보를 가지고
																// 온다...
				String fileName = "";
				String fileName2 = "";
				String filePath = "";

				IddlAassInfoVO iddlAassInfoVO = new IddlAassInfoVO();

				Map<String, Object> map = null;

				iddlAassInfoVO.setGvmtCd(searchVO.getGvmtCd());
				iddlAassInfoVO.setFctyCd(searchVO.getFctyCd());
				iddlAassInfoVO.setIddlAassNo(searchVO.getIddlAassNo());
				iddlAassInfoVO.setEhqkReqId(searchVO.getEhqkReqId());
				iddlAassInfoVO = iddlAassInfoService.selectIddlAassInfo(iddlAassInfoVO);

				filePath = iddlAassInfoVO.getWvScnRsltFlsv() + "/";

				logger.error(storageFilePath + filePath);
				
				url = "/estam/rpt/inc/OverallAnalyRptGrp";
				
				//가속도 
				wvList1 = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_10[0], FCTY_SCN_RSLT_FILE_COLUMN_10[0]);
				
				//응답스펙트럼
				wvList2 = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_40[0],FCTY_SCN_RSLT_FILE_COLUMN_40[0]);
				wvList3 = readIddlAassRlstFile(storageFilePath + filePath, FCTY_SCN_RSLT_PATH_FILE_40[1], FCTY_SCN_RSLT_FILE_COLUMN_40[1]);
				
				model.addAttribute("data1", wvList1);
				model.addAttribute("data2", wvList2);
				model.addAttribute("data3", wvList3);

			} else {
				model.addAttribute("data1", wvList1);
				model.addAttribute("data2", wvList2);
				model.addAttribute("data3", wvList3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;

	}

	public ArrayList<WvIddlAassRlstVO> readIddlAassRlstFile(
			String storageFilePath, String fileName, String columnCnt)
			throws Exception {

		ArrayList<WvIddlAassRlstVO> wvList = new ArrayList<WvIddlAassRlstVO>();
		File uFile = new File(storageFilePath, fileName);

		int fSize = (int) uFile.length();

		if (!uFile.exists()) {
			System.out
					.println("path_error.... please change path in this program");
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
						v_WvIddlAassRlst
								.setRsltValueY2(new BigDecimal(accCol2));
						v_WvIddlAassRlst
								.setRsltValueY3(new BigDecimal(accCol3));
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
}
