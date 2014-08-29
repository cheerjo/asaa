package estam.app.spt.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.EgovWebUtil;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.rte.fdl.property.EgovPropertyService;
import estam.app.com.util.FileUtil;
import estam.app.fcty.service.EhqkScnService;
import estam.app.fcty.service.EhqkScnVO;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.fcty.service.RccService;
import estam.app.fcty.service.RccVO;
import estam.app.spt.service.SptIptnEtcVO;
import estam.app.spt.service.SptIptnFlorService;
import estam.app.spt.service.SptIptnFlorVO;
import estam.app.spt.service.SptIptnRccService;
import estam.app.spt.service.SptIptnRccVO;
import estam.app.spt.service.SptIptnRptService;
import estam.app.spt.service.SptIptnRsltDefaultVO;
import estam.app.spt.service.SptIptnRsltFlService;
import estam.app.spt.service.SptIptnRsltFlVO;
import estam.app.spt.service.SptIptnRsltService;
import estam.app.spt.service.SptIptnRsltVO;
import estam.app.spt.service.SptIptnScnService;
import estam.app.spt.service.SptIptnScnVO;

/**
 * @Class Name : SptIptnRsltController.java
 * @Description : SptIptnRslt Controller class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = SptIptnRsltVO.class)
public class SptIptnRsltController {

	private static final Logger logger = LoggerFactory.getLogger(SptIptnRsltController.class);

	@Resource(name = "sptIptnRsltService")
	private SptIptnRsltService sptIptnRsltService;

	@Resource(name = "sptIptnFlorService")
	private SptIptnFlorService sptIptnFlorService;

	@Resource(name = "sptIptnRccService")
	private SptIptnRccService sptIptnRccService;

	@Resource(name = "rccService")
	private RccService rccService;

	@Resource(name = "sptIptnRsltFlService")
	private SptIptnRsltFlService sptIptnRsltFlService;

	@Resource(name = "sptIptnScnService")
	private SptIptnScnService sptIptnScnService;

	@Resource(name = "ehqkScnService")
	private EhqkScnService ehqkScnService;

	@Resource(name = "sptIptnRptService")
	private SptIptnRptService sptIptnRptService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** EgovCmmUseService */
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	@Autowired
	private ServletContext servletContext;

	/**
	 * 현장점검보고서리스트를 출력한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 SptIptnRsltDefaultVO
	 * @return "/sptIptnRslt/SptIptnRsltList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/spt/SptIptnRsltReport.do")
	public String selectSptIptnRsltList(@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, ModelMap model) throws Exception {

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
		// List sptIptnRsltList =
		// sptIptnRsltService.selectSptIptnRsltList(searchVO);
		// model.addAttribute("resultList", sptIptnRsltList);
		//
		// int totCnt =
		// sptIptnRsltService.selectSptIptnRsltListTotCnt(searchVO);
		// paginationInfo.setTotalRecordCount(totCnt);
		// model.addAttribute("paginationInfo", paginationInfo);

		ComDefaultCodeVO vo = new ComDefaultCodeVO();

		vo.setCommCd("ITEM_008");
		List fctyAreaList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyAreaList", fctyAreaList);

		vo.setCommCd("ITEM_011");
		List fctyKndList = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("fctyKndList", fctyKndList);

		logger.debug("fctyKndList" + fctyKndList);
		// var stime = addDay(-90);
		// var etime = getTimeStamp().substring(0,10);

		String pattern = "yyyy-MM-dd";
		SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		String StrDate = sdfCurrent.format(ts.getTime());

		if (searchVO.getSptIptnSDt() == null) {
			searchVO.setSptIptnSDt(addDays(StrDate, -90));
			searchVO.setSptIptnEDt(StrDate);
		}
		if (searchVO.getFctyCplnSDt() == null) {
			searchVO.setFctyCplnSDt(addDays(StrDate, -90));
			searchVO.setFctyCplnEDt(StrDate);
		}
		searchVO.setSptIptnSDt(replace(searchVO.getSptIptnSDt(), "-", ""));
		searchVO.setSptIptnEDt(replace(searchVO.getSptIptnEDt(), "-", ""));
		searchVO.setFctyCplnSDt(replace(searchVO.getFctyCplnSDt(), "-", ""));
		searchVO.setFctyCplnEDt(replace(searchVO.getFctyCplnEDt(), "-", ""));

		List sptIptnRsltList = sptIptnRsltService.selectSptIptnRsltList(searchVO);
		model.addAttribute("sptIptnRsltList", sptIptnRsltList);

		int totCnt = sptIptnRsltService.selectSptIptnRsltListTotCnt(searchVO);
		model.addAttribute("sptIptnRsltCnt", totCnt);
		model.addAttribute("searchVO", searchVO);

		return "/estam/spt/SptIptnRsltReport";
	}

	public static String addDays(String s, int i) {
		return addDays(s, i, "yyyy-MM-dd");
	}

	public static String addDays(String s, int i, String s1) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s1, Locale.KOREA);
		Date date = check(s, s1);
		date.setTime(date.getTime() + (long) i * 1000L * 60L * 60L * 24L);
		return simpledateformat.format(date);
	}

	public static Date check(String s) throws ParseException {
		return check(s, "yyyy-MM-dd");
	}

	public static Date check(String s, String s1) {
		if (s == null)
			return null;
		if (s1 == null)
			return null;
		SimpleDateFormat simpledateformat = new SimpleDateFormat(s1, Locale.KOREA);
		Date date = null;
		try {
			date = simpledateformat.parse(s);
		} catch (Exception ex) {
			return null;
		}
		if (!simpledateformat.format(date).equals(s))
			return null;
		else
			return date;
	}

	public static String replace(java.lang.String str, java.lang.String src, java.lang.String tgt) {
		StringBuffer buf = new StringBuffer();
		String ch = null;
		// System.out.println(str);
		if (str == null || str.length() == 0)
			return "";

		int i = 0;
		int len = src.length();
		while (i < str.length() - len + 1) {

			ch = str.substring(i, i + len);
			if (ch.equals(src)) {
				buf.append(tgt);
				i = i + len;
			} else {
				buf.append(str.substring(i, i + 1));
				i++;
			}
		}

		if (i < str.length())
			buf.append(str.substring(i, str.length()));

		return buf.toString();
	}

	/**
	 * 현장점검보고서리스트를 엑셀로 출력한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 SptIptnRsltDefaultVO
	 * @return "/sptIptnRslt/SptIptnRsltExcel"
	 * @exception Exception
	 */
	@RequestMapping(value = "/spt/SptIptnRsltReportExcel.do")
	public String selectSptIptnRsltExcel(@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, ModelMap model) throws Exception {

		searchVO.setSptIptnSDt(replace(searchVO.getSptIptnSDt(), "-", ""));
		searchVO.setSptIptnEDt(replace(searchVO.getSptIptnEDt(), "-", ""));
		searchVO.setFctyCplnSDt(replace(searchVO.getFctyCplnSDt(), "-", ""));
		searchVO.setFctyCplnEDt(replace(searchVO.getFctyCplnEDt(), "-", ""));

		List sptIptnRsltList = sptIptnRsltService.selectSptIptnRsltList(searchVO);
		model.addAttribute("sptIptnRsltList", sptIptnRsltList);

		return "/estam/spt/SptIptnRsltReportExcel";

	}

	/**
	 * 센서정보 리스트를 조회한다. (팝업창 오픈)
	 * 
	 * @param sptIptnScnVO
	 * @param model
	 *            the model
	 * @return "/estam/spt/sptIptnScnListPopUp"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/sptIptnScnSearchList.do")
	public String sptIptnScnSearchList(@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, ModelMap model, HttpServletRequest request)
			throws Exception {

		SptIptnScnVO sptIptnScnVO = new SptIptnScnVO();
		SptIptnRccVO sptIptnRccVO = new SptIptnRccVO();
		// sptIptnScnVO = new SptIptnScnVO();

		String formNm = "";
		String zip1FormNm = "";
		String zip2FormNm = "";
		String addr1FormNm = "";

		/* 부모창으로 넘겨줄 폼필드 값 */
		/*
		 * if( !EgovStringUtil.isEmpty(request.getParameter("formNm")) ) {
		 * formNm = request.getParameter("formNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("zip1FormNm")) ) {
		 * zip1FormNm = request.getParameter("zip1FormNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("zip2FormNm")) ) {
		 * zip2FormNm = request.getParameter("zip2FormNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("addr1FormNm")) ) {
		 * addr1FormNm = request.getParameter("addr1FormNm"); }
		 * 
		 * model.addAttribute("formNm", formNm);
		 * model.addAttribute("zip1FormNm", zip1FormNm);
		 * model.addAttribute("zip2FormNm", zip2FormNm);
		 * model.addAttribute("addr1FormNm", addr1FormNm);
		 */

		// if( !EgovStringUtil.isEmpty(zipCodeVO.getDong()) ) {
		// List resultList = zipCodeService.selectZipCodeList(zipCodeVO);
		// model.addAttribute("resultList", resultList);
		// }

		// sptIptnScnVO.setFctyCd(searchVO.getFctyCd());
		// sptIptnScnVO.setGvmtCd(searchVO.getGvmtCd());
		// sptIptnScnVO.setSptIptnDt(searchVO.getSptInptDt());

		/* 센서정보 조회결과 */
		// if( !EgovStringUtil.isEmpty(sptIptnScnVO.getFctyCd()) ) {
		List sptIptnScnSearchList = sptIptnScnService.selectSptIptnScnSearchList(sptIptnScnVO);
		model.addAttribute("sptIptnScnSearchList", sptIptnScnSearchList);
		// }

		model.addAttribute("sptIptnScnVO", sptIptnScnVO);

		System.out.println("============sptIptnScnVO.getEhqkScnMdl()========:" + sptIptnScnVO.getEhqkScnMdl());
		System.out.println("============searchVO========:" + searchVO.toString());
		System.out.println("=============sptIptnScnSearchList======:" + sptIptnScnSearchList.toString());

		return "/estam/spt/sptIptnScn/sptIptnScnListPopUp";
	}

	/**
	 * 기록계정보 리스트를 조회한다. (팝업창 오픈)
	 * 
	 * @param sptIptnScnVO
	 * @param model
	 *            the model
	 * @return "/estam/spt/sptIptnRccListPopUp"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/sptIptnRccSearchList.do")
	public String sptIptnRccSearchList(@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, ModelMap model, HttpServletRequest request)
			throws Exception {

		SptIptnRccVO sptIptnRccVO = new SptIptnRccVO();
		// sptIptnScnVO = new SptIptnScnVO();

		String formNm = "";
		String zip1FormNm = "";
		String zip2FormNm = "";
		String addr1FormNm = "";

		/* 부모창으로 넘겨줄 폼필드 값 */
		/*
		 * if( !EgovStringUtil.isEmpty(request.getParameter("formNm")) ) {
		 * formNm = request.getParameter("formNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("zip1FormNm")) ) {
		 * zip1FormNm = request.getParameter("zip1FormNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("zip2FormNm")) ) {
		 * zip2FormNm = request.getParameter("zip2FormNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("addr1FormNm")) ) {
		 * addr1FormNm = request.getParameter("addr1FormNm"); }
		 * 
		 * model.addAttribute("formNm", formNm);
		 * model.addAttribute("zip1FormNm", zip1FormNm);
		 * model.addAttribute("zip2FormNm", zip2FormNm);
		 * model.addAttribute("addr1FormNm", addr1FormNm);
		 */

		// if( !EgovStringUtil.isEmpty(zipCodeVO.getDong()) ) {
		// List resultList = zipCodeService.selectZipCodeList(zipCodeVO);
		// model.addAttribute("resultList", resultList);
		// }

		// sptIptnScnVO.setFctyCd(searchVO.getFctyCd());
		// sptIptnScnVO.setGvmtCd(searchVO.getGvmtCd());
		// sptIptnScnVO.setSptIptnDt(searchVO.getSptInptDt());

		/* 기록계정보 조회결과 */
		// if( !EgovStringUtil.isEmpty(sptIptnScnVO.getFctyCd()) ) {
		List sptIptnRccSearchList = sptIptnRccService.selectSptIptnRccSearchList(sptIptnRccVO);
		model.addAttribute("sptIptnRccSearchList", sptIptnRccSearchList);
		// }

		model.addAttribute("sptIptnRccVO", sptIptnRccVO);

		// System.out.println("============sptIptnScnVO.getEhqkScnMdl()========:"
		// + sptIptnRccVO.getEhqkScnMdl());
		System.out.println("=============sptIptnRccSearchList======:" + sptIptnRccSearchList.toString());

		return "/estam/spt/sptIptnRcc/sptIptnRccListPopUp";
	}

	/**
	 * 센서정보 리스트를 추가한다.
	 * 
	 * @param sptIptnScnVO
	 * @param model
	 *            the model
	 * @return "redirect:/sptIptnRslt/sptIptnScnSearchList.do"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/sptIptnScnInsert.do")
	public String sptIptnScnInsert(@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, ModelMap model, HttpServletRequest request)
			throws Exception {

		SptIptnScnVO sptIptnScnVO = new SptIptnScnVO();
		SptIptnRccVO sptIptnRccVO = new SptIptnRccVO();
		// sptIptnScnVO = new SptIptnScnVO();

		String formNm = "";
		String zip1FormNm = "";
		String zip2FormNm = "";
		String addr1FormNm = "";

		/* 부모창으로 넘겨줄 폼필드 값 */
		/*
		 * if( !EgovStringUtil.isEmpty(request.getParameter("formNm")) ) {
		 * formNm = request.getParameter("formNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("zip1FormNm")) ) {
		 * zip1FormNm = request.getParameter("zip1FormNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("zip2FormNm")) ) {
		 * zip2FormNm = request.getParameter("zip2FormNm"); } if(
		 * !EgovStringUtil.isEmpty(request.getParameter("addr1FormNm")) ) {
		 * addr1FormNm = request.getParameter("addr1FormNm"); }
		 * 
		 * model.addAttribute("formNm", formNm);
		 * model.addAttribute("zip1FormNm", zip1FormNm);
		 * model.addAttribute("zip2FormNm", zip2FormNm);
		 * model.addAttribute("addr1FormNm", addr1FormNm);
		 */

		// if( !EgovStringUtil.isEmpty(zipCodeVO.getDong()) ) {
		// List resultList = zipCodeService.selectZipCodeList(zipCodeVO);
		// model.addAttribute("resultList", resultList);
		// }

		// sptIptnScnVO.setFctyCd(searchVO.getFctyCd());
		// sptIptnScnVO.setGvmtCd(searchVO.getGvmtCd());
		// sptIptnScnVO.setSptIptnDt(searchVO.getSptInptDt());

		/* 센서정보 조회결과 */
		// if( !EgovStringUtil.isEmpty(sptIptnScnVO.getFctyCd()) ) {
		List sptIptnScnSearchList = sptIptnScnService.selectSptIptnScnSearchList(sptIptnScnVO);
		model.addAttribute("sptIptnScnSearchList", sptIptnScnSearchList);
		// }

		model.addAttribute("sptIptnScnVO", sptIptnScnVO);

		System.out.println("============sptIptnScnVO.getEhqkScnMdl()========:" + sptIptnScnVO.getEhqkScnMdl());
		System.out.println("============searchVO========:" + searchVO.toString());
		System.out.println("=============sptIptnScnSearchList======:" + sptIptnScnSearchList.toString());

		return "redirect:/sptIptnRslt/sptIptnScnSearchList.do";
	}

	@RequestMapping(value = "/sptIptnRslt/fileDown.do")
	public void fileDownload(@RequestParam("fileNm") String fileNm, @RequestParam("orginlFileNm") String orginlFileNm,
			@RequestParam("fileLc") String fileLc, HttpServletRequest request, HttpServletResponse response) throws Exception {

		// String storePathString = 'http://192.168.0.42:22' ;
		// storePathString = "C:/workspace/necis-tms/src/main/webapp/Files/";

		String sRootPath = EgovProperties.getProperty("Globals.webappRootPath");

		if (fileNm != null && !"".equals(fileNm)) {
			/* 첨부파일명, 저장경로.. 정보 가져오기 */
			// File uFile = new File("/home/necis/ROOT/files/",
			// "JMJ.SHN.2013.254.00.00.00");
			// fileLc = "D:/asaa/";

			logger.info(sRootPath + fileLc + fileNm);

			File uFile = new File(sRootPath + fileLc, fileNm);

			int fSize = (int) uFile.length();
			byte[] buffer = new byte[1024];

			// fileVO.setFileSn(fileSn);

			if (fSize > 0) {
				String mimetype = "application/x-msdownload";
				response.setContentType(mimetype);
				// setDisposition(orginlFileNm, request, response);
				String dispositionPrefix = "attachment; filename=";
				String encodedFilename = null;

				encodedFilename = URLEncoder.encode(orginlFileNm, "UTF-8").replaceAll("\\+", "%20");

				response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
				response.setContentLength(fSize);
				/*
				 * FileCopyUtils.copy(in, response.getOutputStream());
				 * in.close(); response.getOutputStream().flush();
				 * response.getOutputStream().close();
				 */
				BufferedInputStream in = null;
				BufferedOutputStream out = null;

				try {
					in = new BufferedInputStream(new FileInputStream(uFile));
					out = new BufferedOutputStream(response.getOutputStream());

					int read;
					while ((read = in.read(buffer, 0, 1024)) != -1) {
						// 상기 라인의 버그 테스트에서 예시한 xss보안성 취약점 및 개선책은 자바스크립트에서 발생할 수
						// 있는 문제에 대한 개선책이며 지적하신 부분은
						// 서블릿 객체로 사용되는 부분입니다. 버그로 분류하신 XSS 문제점을 찾을 수 없습니다. 그리고
						// 'out'은 BufferedOutputStream이라는
						// EGovFrmae 지원 공통 클래스의 VO class 명칭이며, FASOO 스패로 소스
						// 인스펙터를 통해 버그 대상으로 분류되지 않아야할 문제 입니다.
						out.write(buffer, 0, read);
					}
					out.close();
					in.close();
				} catch (Exception ex) {
					// ex.printStackTrace();
					// 다음 Exception 무시 처리
					// Connection reset by peer: socket write error
				} finally {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
					}

					if (new BufferedInputStream(new FileInputStream(uFile)) != null) {
						try {

							new BufferedInputStream(new FileInputStream(uFile)).close();
							// } catch (Exception ignore) {}
						} catch (FileNotFoundException fe) {
							fe.printStackTrace();
						} catch (Exception ie) {
							ie.printStackTrace();
						}

					}
					if (new BufferedOutputStream(response.getOutputStream()) != null) {
						try {

							new BufferedOutputStream(response.getOutputStream()).close();

						} catch (FileNotFoundException fe) {
							fe.printStackTrace();
						} catch (Exception ie) {
							ie.printStackTrace();
						}
					}
				}

			} else {
				response.setContentType("application/x-msdownload");

				PrintWriter printwriter = response.getWriter();

				printwriter.println("<html>");
				printwriter.println("<head>");
				printwriter.println("</head>");
				printwriter.println("<body>");
				printwriter.println("<div id='http_404_error'>");
				printwriter.println("<h1 style='font-size:16px'>have no file!</h1>");
				printwriter.println("<p><strong>no file!</strong></p>");
				printwriter.println("</div>");
				printwriter.println("</body>");
				printwriter.println("</html>");

				printwriter.flush();
				printwriter.close();

			}
		}

	}

	@RequestMapping("/sptIptnRslt/addSptIptnRslt.do")
	public String addSptIptnRslt(SptIptnRsltVO sptIptnRsltVO, @ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, SessionStatus status)
			throws Exception {
		sptIptnRsltService.insertSptIptnRslt(sptIptnRsltVO);
		status.setComplete();
		return "forward:/sptIptnRslt/SptIptnRsltList.do";
	}

	@RequestMapping("/sptIptnRslt/updateSptIptnRsltView.do")
	public String updateSptIptnRsltView(@RequestParam("fctyCd") java.lang.String fctyCd, @RequestParam("sptIptnDt") java.lang.String sptIptnDt,
			@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, Model model) throws Exception {
		SptIptnRsltVO sptIptnRsltVO = new SptIptnRsltVO();
		sptIptnRsltVO.setFctyCd(fctyCd);
		sptIptnRsltVO.setSptIptnDt(sptIptnDt);
		// 변수명은 CoC 에 따라 sptIptnRsltVO
		model.addAttribute(selectSptIptnRslt(sptIptnRsltVO, searchVO));
		return "/sptIptnRslt/SptIptnRsltRegister";
	}

	@RequestMapping("/sptIptnRslt/selectSptIptnRslt.do")
	public @ModelAttribute("sptIptnRsltVO")
	SptIptnRsltVO selectSptIptnRslt(SptIptnRsltVO sptIptnRsltVO, @ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO) throws Exception {
		return sptIptnRsltService.selectSptIptnRslt(sptIptnRsltVO);
	}

	@RequestMapping("/sptIptnRslt/updateSptIptnRslt.do")
	public String updateSptIptnRslt(SptIptnRsltVO sptIptnRsltVO, @ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, SessionStatus status)
			throws Exception {
		sptIptnRsltService.updateSptIptnRslt(sptIptnRsltVO);
		status.setComplete();
		return "forward:/sptIptnRslt/SptIptnRsltList.do";
	}

	@RequestMapping("/sptIptnRslt/deleteSptIptnRslt.do")
	public String deleteSptIptnRslt(SptIptnRsltVO sptIptnRsltVO, @ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, SessionStatus status)
			throws Exception {
		sptIptnRsltService.deleteSptIptnRslt(sptIptnRsltVO);
		status.setComplete();
		return "forward:/sptIptnRslt/SptIptnRsltList.do";
	}

	/**
	 * 이미지 파일 업로드
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/sptIptnRslt/imgFileUpload.do")
	public void addImgFile(@RequestParam("imgFile") MultipartFile file, @ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("... doUploadFile() is called");
		// 파일명
		String fileName = file.getOriginalFilename();
		// WebappRoot Path
		String sRootPath = EgovProperties.getProperty("Globals.webappRootPath");

		String fctyCd = searchVO.getFctyCd();
		String gvmtCd = searchVO.getGvmtCd();
		String sptIptnDt = searchVO.getSptIptnDt();
		logger.debug(searchVO.toString());

		String sSvrFilePath = FileUtil.getFilePath(sRootPath, fctyCd, gvmtCd, "img");
		String sSvrFileName = FileUtil.getFileName(fileName, fctyCd, gvmtCd);

		// 파일 관련 변수 선언
		InputStream inStream = null;
		OutputStream outStream = null;
		// AJAX 관련 변수 선언
		PrintWriter outWriter = null;

		try {
			// 파일 업로드 변수 설정
			inStream = file.getInputStream();
			logger.debug("path:" + sRootPath + sSvrFilePath);
			File newFile = new File(sRootPath + sSvrFilePath, sSvrFileName);
			if (!newFile.exists()) {
				newFile.getParentFile().mkdirs();
			}
			// 파일 업로드 실행
			boolean isUploaded = FileUtil.uploadFormFile(file, newFile);
			Map<String, Object> mapResult = new HashMap<String, Object>();
			if (isUploaded) {
				mapResult.put("result", "success");
				// 업로드 파일 정보 셋팅
				mapResult.put("file_name", fileName);
				mapResult.put("file_svr_name", sSvrFileName);
				mapResult.put("file_svr_path", sSvrFilePath);
				mapResult.put("file_size", file.getSize());
				mapResult.put("file_org_name", fileName);
				mapResult.put("content_type", file.getContentType());

				// 한글 처리를 위한 response 설정
				response.setContentType("text/plain;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Cache-Control", "no-chche");

				// 파일 업로드 내용 저장
				mapResult.put("fctyCd", fctyCd);
				mapResult.put("gvmtCd", gvmtCd);
				mapResult.put("sptIptnDt", sptIptnDt);

				sptIptnRsltService.updateSptIptnFlor(mapResult);

			} else {
				mapResult.put("result", "failure");
			}
			logger.debug("==============>mapResult:" + mapResult.toString());
			// 업로드 결과 전송
			Gson gson = new Gson();
			outWriter = response.getWriter();
			outWriter.print(gson.toJson(mapResult));
			outWriter.flush();
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			try {
				if (inStream != null)
					inStream.close();
			} catch (Exception ex) {
			}
			try {
				if (outStream != null)
					outStream.close();
			} catch (Exception ex) {
			}
			try {
				if (outWriter != null)
					outWriter.close();
			} catch (Exception ex) {
			}
		}

	}

	/**
	 * 현장점검 결과파일 업로드
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/sptIptnRslt/rptFileUpload.do")
	public void rptFileUpload(@RequestParam("rptFile") MultipartFile file, @ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("... doUploadFile() is called");
		// 파일명
		String fileName = file.getOriginalFilename();
		// WebappRoot Path
		String sRootPath = EgovProperties.getProperty("Globals.webappRootPath");

		String fctyCd = searchVO.getFctyCd();
		String gvmtCd = searchVO.getGvmtCd();
		String sptIptnDt = searchVO.getSptIptnDt();
		logger.debug(searchVO.toString());

		String sSvrFilePath = FileUtil.getFilePath(sRootPath, fctyCd, gvmtCd, "img");
		String sSvrFileName = FileUtil.getFileName(fileName, fctyCd, gvmtCd);

		// 파일 관련 변수 선언
		InputStream inStream = null;
		OutputStream outStream = null;
		// AJAX 관련 변수 선언
		PrintWriter outWriter = null;

		SptIptnRsltFlVO sirfv = new SptIptnRsltFlVO();

		try {

			// 파일 업로드 변수 설정
			inStream = file.getInputStream();
			logger.debug("path:" + sRootPath + sSvrFilePath);
			File newFile = new File(sRootPath + sSvrFilePath, sSvrFileName);
			if (!newFile.exists()) {
				newFile.getParentFile().mkdirs();
			}
			// 파일 업로드 실행
			boolean isUploaded = FileUtil.uploadFormFile(file, newFile);
			Map<String, Object> mapResult = new HashMap<String, Object>();
			if (isUploaded) {
				mapResult.put("result", "success");
				// 업로드 파일 정보 셋팅
				mapResult.put("file_name", fileName);
				mapResult.put("file_svr_name", sSvrFileName);
				mapResult.put("file_svr_path", sSvrFilePath);
				mapResult.put("file_size", file.getSize());
				mapResult.put("content_type", file.getContentType());

				// 한글 처리를 위한 response 설정
				response.setContentType("text/plain;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Cache-Control", "no-chche");

				// 파일 업로드 내용 저장
				mapResult.put("fctyCd", fctyCd);
				mapResult.put("gvmtCd", gvmtCd);
				mapResult.put("sptIptnDt", sptIptnDt);

				sirfv.setFctyCd(fctyCd);
				sirfv.setGvmtCd(gvmtCd);
				sirfv.setSptIptnDt(sptIptnDt);
				sirfv.setSptIptnFlsv(sSvrFilePath);
				sirfv.setSptIptnFlnm(sSvrFileName);
				sirfv.setSptIptnFsSz(BigDecimal.valueOf(file.getSize()));
				sirfv.setSptIptnOrgFlnm(fileName);

				sptIptnRsltFlService.insertSptIptnRsltFl(sirfv);

			} else {
				mapResult.put("result", "failure");
			}
			logger.debug("==============>mapResult:" + mapResult.toString());
			// 업로드 결과 전송
			Gson gson = new Gson();
			outWriter = response.getWriter();
			outWriter.print(gson.toJson(mapResult));
			outWriter.flush();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			try {
				if (inStream != null)
					inStream.close();
			} catch (Exception ex) {
			}
			try {
				if (outStream != null)
					outStream.close();
			} catch (Exception ex) {
			}
			try {
				if (outWriter != null)
					outWriter.close();
			} catch (Exception ex) {
			}
		}

	}

	@RequestMapping(value = "/sptIptnRslt/rptFileDelete.do")
	public void rptFileDelete(SptIptnRsltFlVO sirfv, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug(sirfv.toString());

		try {
			sptIptnRsltFlService.deleteSptIptnRsltFl(sirfv);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

	}

	@RequestMapping(value = "/sptIptnRslt/imgFileDown.do")
	public void imgFileDownload(@RequestParam("orginlFileNm") String orginlFileNm, @RequestParam("fileNm") String fileNm,
			@RequestParam("fileLc") String fileLc, HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("fileLc = " + fileLc + " || orginlFileNm = " + orginlFileNm);

		String sRootPath = EgovProperties.getProperty("Globals.webappRootPath");

		String downFileName = sRootPath + fileLc + fileNm;
		String orgFileName = FileUtil.convertKorToUTF(orginlFileNm);

		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;

		try {

			orgFileName = orgFileName.replaceAll("\r", "").replaceAll("\n", "");

			File file = new File(EgovWebUtil.filePathBlackList(downFileName));

			if (!file.exists()) {
				throw new FileNotFoundException(downFileName);
			}

			if (!file.isFile()) {
				throw new FileNotFoundException(downFileName);
			}

			byte[] b = new byte[2048]; // buffer size 2K.

			String encodedFilename = null;
			encodedFilename = URLEncoder.encode(orgFileName, "UTF-8").replaceAll("\\+", "%20");

			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition:", "attachment; filename=" + encodedFilename);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");

			fin = new BufferedInputStream(new FileInputStream(file));
			outs = new BufferedOutputStream(response.getOutputStream());
			int read = 0;

			while ((read = fin.read(b)) != -1) {
				outs.write(b, 0, read);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (outs != null) {
				try {
					outs.close();
				} catch (Exception ignore) {
					// System.out.println("IGNORED: " + ignore.getMessage());
					logger.debug("IGNORED: " + ignore.getMessage());
				}
			}
			if (fin != null) {
				try {
					fin.close();
				} catch (Exception ignore) {
					// System.out.println("IGNORED: " + ignore.getMessage());
					logger.debug("IGNORED: " + ignore.getMessage());
				}
			}
		}

	}

	@RequestMapping(value = "/sptIptnRslt/imgFileDelete.do")
	public void imgFileDelete(@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.debug(searchVO.toString());

		try {
			sptIptnRsltService.deleteSptIptnFlor(searchVO);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

	}

	/**
	 * 기타 파일 업로드
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/sptIptnRslt/etcFileUpload.do")
	public void addEtcFile(@RequestParam("etcFile") MultipartFile file, @ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		logger.debug("... doUploadFile() is called");
		// 파일명
		String fileName = file.getOriginalFilename();
		// WebappRoot Path
		String sRootPath = EgovProperties.getProperty("Globals.fileStorePath"); // /web/ROOT/up_file
		String wRootPath = EgovProperties.getProperty("Globals.webappRootPath"); // /web/ROOT/

		String fctyCd = searchVO.getFctyCd();
		String gvmtCd = searchVO.getGvmtCd();
		String sptIptnDt = searchVO.getSptIptnDt();
		logger.debug(searchVO.toString());

		String sSvrFilePath = FileUtil.getFilePath(sRootPath, fctyCd, gvmtCd, "");
		String sSvrFileName = FileUtil.getFileName(fileName, fctyCd, gvmtCd);

		// 파일 관련 변수 선언
		InputStream inStream = null;
		OutputStream outStream = null;
		// AJAX 관련 변수 선언
		PrintWriter outWriter = null;

		try {
			// 파일 업로드 변수 설정
			inStream = file.getInputStream();
			logger.debug("path:" + wRootPath + sSvrFilePath + sSvrFileName);

			File newFile = new File(wRootPath + sSvrFilePath, sSvrFileName);
			if (!newFile.exists()) {
				newFile.getParentFile().mkdirs();
			}
			// 파일 업로드 실행
			boolean isUploaded = FileUtil.uploadFormFile(file, newFile);
			Map<String, Object> mapResult = new HashMap<String, Object>();
			if (isUploaded) {
				mapResult.put("result", "success");
				// 업로드 파일 정보 셋팅
				mapResult.put("file_name", fileName);
				mapResult.put("file_svr_name", sSvrFileName);
				mapResult.put("file_svr_path", sSvrFilePath);
				mapResult.put("file_size", file.getSize());
				mapResult.put("content_type", file.getContentType());

				// 한글 처리를 위한 response 설정
				response.setContentType("text/plain;charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Cache-Control", "no-chche");

				// 파일 업로드 내용 저장
				mapResult.put("fctyCd", fctyCd);
				mapResult.put("gvmtCd", gvmtCd);
				mapResult.put("sptIptnDt", sptIptnDt);

				sptIptnRsltService.updateSptIptnEtc(mapResult);

			} else {
				mapResult.put("result", "failure");
			}
			logger.debug("==============>mapResult:" + mapResult.toString());
			// 업로드 결과 전송
			Gson gson = new Gson();
			outWriter = response.getWriter();
			outWriter.print(gson.toJson(mapResult));
			outWriter.flush();
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
		} finally {
			try {
				if (inStream != null)
					inStream.close();
			} catch (Exception ex) {
			}
			try {
				if (outStream != null)
					outStream.close();
			} catch (Exception ex) {
			}
			try {
				if (outWriter != null)
					outWriter.close();
			} catch (Exception ex) {
			}

		}

	}

	@RequestMapping(value = "/sptIptnRslt/etcFileDown.do")
	public void etcFileDownload(@RequestParam("orginlFileNm") String orginlFileNm, @RequestParam("fileLc") String fileLc, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.debug("fileLc = " + fileLc + " || orginlFileNm = " + orginlFileNm);

		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;

		String wRootPath = EgovProperties.getProperty("Globals.webappRootPath");

		try {

			String downFileName = fileLc;
			String orgFileName = FileUtil.convertKorToUTF(orginlFileNm);

			orgFileName = orgFileName.replaceAll("\r", "").replaceAll("\n", "");

			File file = new File(wRootPath + EgovWebUtil.filePathBlackList(downFileName));

			if (!file.exists()) {
				throw new FileNotFoundException(downFileName);
			}

			if (!file.isFile()) {
				throw new FileNotFoundException(downFileName);
			}

			byte[] b = new byte[2048]; // buffer size 2K.

			String encodedFilename = null;
			encodedFilename = URLEncoder.encode(orgFileName, "UTF-8").replaceAll("\\+", "%20");

			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition:", "attachment; filename=" + encodedFilename);
			response.setHeader("Content-Transfer-Encoding", "binary");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");

			fin = new BufferedInputStream(new FileInputStream(file));
			outs = new BufferedOutputStream(response.getOutputStream());
			int read = 0;

			while ((read = fin.read(b)) != -1) {
				outs.write(b, 0, read);
			}
			fin.close();
			outs.close();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (Exception ignore) {
					// System.out.println("IGNORED: " + ignore.getMessage());
					logger.debug("IGNORED: " + ignore.getMessage());
				}
			}
			if (outs != null) {
				try {
					outs.close();
				} catch (Exception ignore) {
					// System.out.println("IGNORED: " + ignore.getMessage());
					logger.debug("IGNORED: " + ignore.getMessage());
				}
			}
		}

	}

	@RequestMapping(value = "/sptIptnRslt/etcFileDelete.do")
	public void etcFileDelete(@ModelAttribute("searchVO") SptIptnRsltDefaultVO searchVO, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.debug(searchVO.toString());

		try {
			sptIptnRsltService.deleteSptIptnEtc(searchVO);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

	}

	/**
	 * 센서정보 리스트를 조회한다. (팝업창 오픈)
	 * 
	 * @param sptIptnScnVO
	 * @param model
	 *            the model
	 * @return "/estam/spt/sptRptView"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/sptRptInput.do")
	public String sptRptInput(SptIptnRsltDefaultVO searchVO, HttpServletRequest request) throws Exception {

		SptIptnRsltVO sptIptnRsltVO = new SptIptnRsltVO();
		EhqkScnVO ehqkScnVO = new EhqkScnVO();
		RccVO rccVO = new RccVO();
		SptIptnFlorVO sptIptnFlorVO = new SptIptnFlorVO();
		SptIptnEtcVO sptIptnEtcVO = new SptIptnEtcVO();
		SptIptnRsltFlVO sptIptnRsltFlVO = new SptIptnRsltFlVO();
		SptIptnScnVO sptIptnScnVO = new SptIptnScnVO();
		SptIptnRccVO sptIptnRccVO = new SptIptnRccVO();

		if (searchVO != null && searchVO.getFctyCd() != null && searchVO.getGvmtCd() != null) {

			try {

				if (StringUtils.isEmpty(searchVO.getSptIptnDt())) {

					// 시설물개요, 관리자 개요
					sptIptnRsltVO = sptIptnRsltService.selectSptIptnRslt(searchVO);
					request.setAttribute("sptIptnRsltVo", sptIptnRsltVO);

					// 센서정보
					ehqkScnVO.setFctyCd(searchVO.getFctyCd());
					ehqkScnVO.setGvmtCd(searchVO.getGvmtCd());
					List sptIptnScnList = ehqkScnService.selectEhqkScnListByKey(ehqkScnVO);
					request.setAttribute("sptIptnScnList", sptIptnScnList);

					// 기록계정보
					rccVO.setFctyCd(searchVO.getFctyCd());
					rccVO.setGvmtCd(searchVO.getGvmtCd());
					List sptIptnRccList = rccService.selectRccListByKey(rccVO);
					request.setAttribute("sptIptnRccList", sptIptnRccList);

				} else {

					// 시설물개요, 관리자 개요
					sptIptnRsltVO = sptIptnRsltService.selectSptIptnRsltByKey(searchVO);
					request.setAttribute("sptIptnRsltVo", sptIptnRsltVO);

					// 현장점검 개요
					sptIptnRsltFlVO.setFctyCd(searchVO.getFctyCd());
					sptIptnRsltFlVO.setGvmtCd(searchVO.getGvmtCd());
					sptIptnRsltFlVO.setSptIptnDt(searchVO.getSptIptnDt());
					List sptIptnRsltFlList = sptIptnRsltFlService.selectSptIptnRsltFlList(sptIptnRsltFlVO);
					request.setAttribute("sptIptnRsltFlList", sptIptnRsltFlList);

					// 센서정보
					sptIptnScnVO.setFctyCd(searchVO.getFctyCd());
					sptIptnScnVO.setGvmtCd(searchVO.getGvmtCd());
					sptIptnScnVO.setSptIptnDt(searchVO.getSptIptnDt());
					List sptIptnScnList = sptIptnScnService.selectSptIptnScnListForView(sptIptnScnVO);
					if (sptIptnScnList == null || sptIptnScnList.size() == 0) {

						ehqkScnVO.setFctyCd(searchVO.getFctyCd());
						ehqkScnVO.setGvmtCd(searchVO.getGvmtCd());
						sptIptnScnList = ehqkScnService.selectEhqkScnListByKey(ehqkScnVO);
					}
					request.setAttribute("sptIptnScnList", sptIptnScnList);

					// 기록계정보
					sptIptnRccVO.setFctyCd(searchVO.getFctyCd());
					sptIptnRccVO.setGvmtCd(searchVO.getGvmtCd());
					sptIptnRccVO.setSptIptnDt(searchVO.getSptIptnDt());
					List sptIptnRccList = sptIptnRccService.selectSptIptnRccList(sptIptnRccVO);
					if (sptIptnRccList == null || sptIptnRccList.size() == 0) {
						rccVO.setFctyCd(searchVO.getFctyCd());
						rccVO.setGvmtCd(searchVO.getGvmtCd());
						sptIptnRccList = rccService.selectRccListByKey(rccVO);
					}
					request.setAttribute("sptIptnRccList", sptIptnRccList);

					// 도면정보
					sptIptnFlorVO.setFctyCd(searchVO.getFctyCd());
					sptIptnFlorVO.setGvmtCd(searchVO.getGvmtCd());
					sptIptnFlorVO.setSptIptnDt(searchVO.getSptIptnDt());
					List sptIptnFlorList = sptIptnFlorService.selectSptIptnFlorList(sptIptnFlorVO);
					request.setAttribute("sptIptnFlorList", sptIptnFlorList);

					// 마지막 도면정보
					SptIptnFlorVO lastSptIptnFlorVO = new SptIptnFlorVO();

					if (sptIptnFlorList != null && sptIptnFlorList.size() > 0) {

						int lastIndex = sptIptnFlorList.size();
						lastIndex = lastIndex - 1;
						lastSptIptnFlorVO = (SptIptnFlorVO) sptIptnFlorList.get(lastIndex);
						request.setAttribute("lastSptIptnFlorVO", lastSptIptnFlorVO);
					}

					// 기타정보
					sptIptnEtcVO.setFctyCd(searchVO.getFctyCd());
					sptIptnEtcVO.setGvmtCd(searchVO.getGvmtCd());
					sptIptnEtcVO.setSptIptnDt(searchVO.getSptIptnDt());
					List sptIptnEtcList = sptIptnRsltService.selectSptIptnEtcList(sptIptnEtcVO);
					request.setAttribute("sptIptnEtcList", sptIptnEtcList);

				}

			} catch (Exception e) {

				e.printStackTrace();
				throw e;
			}
		}

		return "/estam/spt/sptIptnRpt/sptRptInput";
	}

	/**
	 * 센서정보 리스트를 조회한다. (팝업창 오픈)
	 * 
	 * @param sptIptnScnVO
	 * @param model
	 *            the model
	 * @return "/estam/spt/sptRptView"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/sptRptView.do")
	public String sptRptView(SptIptnRsltDefaultVO searchVO, ModelMap model, HttpServletRequest request) throws Exception {

		SptIptnRsltVO sptIptnRsltVO = new SptIptnRsltVO();
		EhqkScnVO ehqkScnVO = new EhqkScnVO();
		RccVO rccVO = new RccVO();
		SptIptnFlorVO sptIptnFlorVO = new SptIptnFlorVO();
		SptIptnEtcVO sptIptnEtcVO = new SptIptnEtcVO();
		SptIptnRsltFlVO sptIptnRsltFlVO = new SptIptnRsltFlVO();
		SptIptnScnVO sptIptnScnVO = new SptIptnScnVO();
		SptIptnRccVO sptIptnRccVO = new SptIptnRccVO();

		try {

			// 시설물개요, 관리자 개요
			sptIptnRsltVO = sptIptnRsltService.selectSptIptnRsltByKey(searchVO);
			model.addAttribute("sptIptnRslt", sptIptnRsltVO);

			// 현장점검 개요
			sptIptnRsltFlVO.setFctyCd(searchVO.getFctyCd());
			sptIptnRsltFlVO.setGvmtCd(searchVO.getGvmtCd());
			sptIptnRsltFlVO.setSptIptnDt(searchVO.getSptIptnDt());
			List sptIptnRsltFlList = sptIptnRsltFlService.selectSptIptnRsltFlList(sptIptnRsltFlVO);
			model.addAttribute("sptIptnRsltFlList", sptIptnRsltFlList);

			// 센서정보
			sptIptnScnVO.setFctyCd(searchVO.getFctyCd());
			sptIptnScnVO.setGvmtCd(searchVO.getGvmtCd());
			sptIptnScnVO.setSptIptnDt(searchVO.getSptIptnDt());
			List sptIptnScnList = sptIptnScnService.selectSptIptnScnListForView(sptIptnScnVO);
			if (sptIptnScnList == null || sptIptnScnList.size() == 0) {

				ehqkScnVO.setFctyCd(searchVO.getFctyCd());
				ehqkScnVO.setGvmtCd(searchVO.getGvmtCd());
				sptIptnScnList = ehqkScnService.selectEhqkScnListByKey(ehqkScnVO);
			}
			model.addAttribute("sptIptnScnList", sptIptnScnList);

			// 기록계정보
			sptIptnRccVO.setFctyCd(searchVO.getFctyCd());
			sptIptnRccVO.setGvmtCd(searchVO.getGvmtCd());
			sptIptnRccVO.setSptIptnDt(searchVO.getSptIptnDt());
			List sptIptnRccList = sptIptnRccService.selectSptIptnRccList(sptIptnRccVO);
			if (sptIptnRccList == null || sptIptnRccList.size() == 0) {
				rccVO.setFctyCd(searchVO.getFctyCd());
				rccVO.setGvmtCd(searchVO.getGvmtCd());
				sptIptnRccList = rccService.selectRccListByKey(rccVO);
			}
			model.addAttribute("sptIptnRccList", sptIptnRccList);

			// 도면정보
			sptIptnFlorVO.setFctyCd(searchVO.getFctyCd());
			sptIptnFlorVO.setGvmtCd(searchVO.getGvmtCd());
			sptIptnFlorVO.setSptIptnDt(searchVO.getSptIptnDt());
			List sptIptnFlorList = sptIptnFlorService.selectSptIptnFlorList(sptIptnFlorVO);
			model.addAttribute("sptIptnFlorList", sptIptnFlorList);

			// 마지막 도면정보
			SptIptnFlorVO lastSptIptnFlorVO = new SptIptnFlorVO();

			if (sptIptnFlorList != null && sptIptnFlorList.size() > 0) {

				int lastIndex = sptIptnFlorList.size();
				lastIndex = lastIndex - 1;
				lastSptIptnFlorVO = (SptIptnFlorVO) sptIptnFlorList.get(lastIndex);
				model.addAttribute("lastSptIptnFlorVO", lastSptIptnFlorVO);
			}

			// 기타정보
			sptIptnEtcVO.setFctyCd(searchVO.getFctyCd());
			sptIptnEtcVO.setGvmtCd(searchVO.getGvmtCd());
			sptIptnEtcVO.setSptIptnDt(searchVO.getSptIptnDt());
			List sptIptnEtcList = sptIptnRsltService.selectSptIptnEtcList(sptIptnEtcVO);
			model.addAttribute("sptIptnEtcList", sptIptnEtcList);

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}

		return "/estam/spt/sptIptnRpt/sptRptView";
	}

	/**
	 * 센서정보 리스트를 조회한다. (팝업창 오픈)
	 * 
	 * @param sptIptnScnVO
	 * @param model
	 *            the model
	 * @return "/estam/spt/sptIptnScnListPopUp"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/sptRptSearchFcty.do")
	public String sptRptSearchFcty(FctyMgrVO vo, ModelMap model, HttpServletRequest request) throws Exception {

		List<FctyMgrVO> fctyMgrList = sptIptnRptService.selectFctyMgrList(vo);

		model.addAttribute("fctyMgrList", fctyMgrList);
		model.addAttribute("fctyMgrVO", vo);

		return "/estam/spt/sptIptnRpt/sptRptFctySearch";
	}

	/**
	 * 현장점검보고서 정보를 등록한다
	 * 
	 * @param saveSptIptnRslt
	 * @param model
	 *            the model
	 * @return "/estam/spt/saveSptIptnRslt"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/saveSptIptnRslt.do")
	public void saveSptIptnRslt(SptIptnRsltVO vo, ModelMap model, HttpServletRequest request, HttpServletResponse response, SessionStatus status)
			throws Exception {

		try {

			// AJAX 관련 변수 선언
			PrintWriter outWriter = null;
			Map<String, Object> mapResult = new HashMap<String, Object>();

			sptIptnRsltService.insertSptIptnRslt(vo);

			status.setComplete();
			mapResult.put("result", "success");

			Gson gson = new Gson();
			outWriter = response.getWriter();
			outWriter.print(gson.toJson(mapResult));
			outWriter.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 센서 정보를 등록한다
	 * 
	 * @param saveSptIptnScn
	 * @param model
	 *            the model
	 * @return "/estam/spt/saveSptIptnScn"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/saveSptIptnScn.do")
	public void saveSptIptnScn(SptIptnScnVO sisv, ModelMap model, HttpServletRequest request, HttpServletResponse response, SessionStatus status)
			throws Exception {

		try {

			// AJAX 관련 변수 선언
			PrintWriter outWriter = null;
			Map<String, Object> mapResult = new HashMap<String, Object>();

			sptIptnScnService.insertSptIptnScnVOList(sisv.getSisvList(), sisv.getSptIptnDt());

			status.setComplete();
			mapResult.put("result", "success");

			Gson gson = new Gson();
			outWriter = response.getWriter();
			outWriter.print(gson.toJson(mapResult));
			outWriter.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 기록계 정보를 등록한다
	 * 
	 * @param saveSptIptnRcc
	 * @param model
	 *            the model
	 * @return "/estam/spt/saveSptIptnRcc"
	 * @throws Exception
	 *             the exception
	 */
	@RequestMapping(value = "/sptIptnRslt/saveSptIptnRcc.do")
	public void saveSptIptnRcc(SptIptnRccVO sirv, ModelMap model, HttpServletRequest request, HttpServletResponse response, SessionStatus status)
			throws Exception {

		try {

			// AJAX 관련 변수 선언
			PrintWriter outWriter = null;
			Map<String, Object> mapResult = new HashMap<String, Object>();

			sptIptnRccService.insertSptIptnRccList(sirv.getSirvList(), sirv.getSptIptnDt());

			status.setComplete();
			mapResult.put("result", "success");

			Gson gson = new Gson();
			outWriter = response.getWriter();
			outWriter.print(gson.toJson(mapResult));
			outWriter.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
