package estam.app.com.rev.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.com.rev.ConObsLogVO;
import estam.app.com.rev.ConObsMetaVO;
import estam.app.com.rev.service.ConObsMetaService;
import estam.app.com.rev.service.ReportDataService;
import estam.app.com.rev.service.ReportService;

/**
 * @Class Name : ReportServiceImpl.java
 * @Description :
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.18
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("reportService")
public class ReportServiceImpl extends AbstractServiceImpl implements ReportService {

	@Resource(name = "conObsMetaService")
	private ConObsMetaService conObsMetaService;

	@Resource(name = "reportData02Service")
	private ReportDataService reportData02Service;

	@Resource(name = "reportData03Service")
	private ReportDataService reportData03Service;

	@Resource(name = "reportData04Service")
	private ReportDataService reportData04Service;

	@Resource(name = "reportData05Service")
	private ReportDataService reportData05Service;

	public void execute() throws Exception {

		System.out.println("Start!!!!!!!!!!!!!");

		List<ConObsMetaVO> comvList = conObsMetaService.selectConObsMetaList(new ConObsMetaVO());
		System.out.println(comvList.size());

		FileInputStream is = null;
		Scanner sc = null;
		List<String[]> strList = null;
		String[] arr = null;
		ConObsLogVO conObsLogVO = null;

		int i = 1; // TEST
		for (ConObsMetaVO conObsMetaVO : comvList) {

			System.out.print("loop" + i++);
			System.out.println("	conDaGbcd : " + conObsMetaVO.getConDaGbcd());

			conObsLogVO = new ConObsLogVO();
			conObsLogVO.setIptDt(conObsMetaVO.getIptDt());
			conObsLogVO.setFctyCd(conObsMetaVO.getFctyCd());
			conObsLogVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());
			conObsLogVO.setGvmtCd(conObsMetaVO.getGvmtCd());
			conObsLogVO.setSuccessYn("N");

			File conFile = new File(conObsMetaVO.getConDaFlSvch(), conObsMetaVO.getConDaFlNm());
			if (conFile.exists()) {

				conObsLogVO.setFileExistYn("Y");

				is = new FileInputStream(conFile);
				sc = new Scanner(is, "EUC-KR");
				sc.useDelimiter("\n");
				strList = new ArrayList<String[]>();

				try {

					while (sc.hasNext()) {

						arr = StringUtils.split(new String(sc.next().getBytes("UTF-8"), "UTF-8"), ":");

						strList.add(new String[] { StringUtils.trim(arr[0]), arr.length <= 1 ? "" : StringUtils.trim(arr[1]) });
					}
					sc.close();
					is.close();

					if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "02")) {

						reportData02Service.loadReport(strList, conObsMetaVO);

					} else if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "03")) {

						reportData03Service.loadReport(strList, conObsMetaVO);

					} else if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "04")) {

						reportData04Service.loadReport(strList, conObsMetaVO);

					} else if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "05")) {

						reportData05Service.loadReport(strList, conObsMetaVO);
					}

					conObsLogVO.setSuccessYn("Y");

				} catch (Exception e) {
					e.printStackTrace();

				} finally {
					if (sc != null)
						sc.close();
					if (is != null)
						is.close();
				}

			} else {
				conObsLogVO.setFileExistYn("N");
			}

			conObsMetaService.insertConObsLog(conObsLogVO);

		}
		System.out.println("End!!!!!!!!!!!!!");
	}

}
