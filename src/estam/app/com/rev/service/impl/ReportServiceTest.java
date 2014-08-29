package estam.app.com.rev.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import estam.app.com.rev.ConObsMetaVO;
import estam.app.com.rev.service.ConObsMetaService;
import estam.app.com.rev.service.ReportDataService;

/**
 * @Class Name : ReportServiceImpl.java
 * @Description :
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/egovframework/spring/com/context-*.xml" })
public class ReportServiceTest {

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

	@Test
	@Rollback(true)
	public void test() throws Exception {

		System.out.println("Start!!!!!!!!!!!!!");

		List<ConObsMetaVO> comvList = conObsMetaService.selectConObsMetaList(new ConObsMetaVO());
		System.out.println(comvList.size());

		FileInputStream is = null;
		Scanner scanner = null;
		List<String[]> strList = null;

		int i = 1; // TEST
		for (ConObsMetaVO conObsMetaVO : comvList) {

			System.out.println("loop : " + i++);

			//File conFile = new File(conObsMetaVO.getConDaFlSvch(), conObsMetaVO.getConDaFlNm());
			File conFile = new File("C:\\backup\\rcv\\AC\\AJ\\RPT\\2014\\RPT03_AC_AJ_20140212.txt");
			if (!conFile.exists()) {
				continue;
			}

			is = new FileInputStream(conFile);
			scanner = new Scanner(is, "EUC-KR");
			scanner.useDelimiter("\n");

			System.out.println("conDaGbcd : " + conObsMetaVO.getConDaGbcd());

			strList = new ArrayList<String[]>();

			try {
				while (scanner.hasNext()) {

					//String[] arr = StringUtils.split(new String(scanner.next().getBytes("UTF-8"), "UTF-8"), ":");

					// strList.add(new String[] { StringUtils.trim(arr[0]),
					// StringUtils.trim(arr[1]) });
					System.out.println(scanner.next());
				}
				is.close();
				scanner.close();

				if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "02")) {

					reportData02Service.loadReport(strList, conObsMetaVO);

				} else if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "03")) {

					reportData03Service.loadReport(strList, conObsMetaVO);

				} else if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "04")) {

					reportData04Service.loadReport(strList, conObsMetaVO);

				} else if (StringUtils.equals(conObsMetaVO.getConDaGbcd(), "05")) {

					reportData05Service.loadReport(strList, conObsMetaVO);
				}
			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				if (is != null)
					is.close();
				if (scanner != null)
					scanner.close();
			}
		}

	}

}
