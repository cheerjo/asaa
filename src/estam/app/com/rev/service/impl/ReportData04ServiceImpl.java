package estam.app.com.rev.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.com.rev.ConObsMetaVO;
import estam.app.com.rev.service.ReportDataService;
import estam.app.scn.rpt.service.RptRglrIptnService;
import estam.app.scn.rpt.service.RptRglrIptnVO;

/**
 * @Class Name : ReportData04ServiceImpl.java
 * @Description :
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.18
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("reportData04Service")
public class ReportData04ServiceImpl extends AbstractServiceImpl implements ReportDataService {

	@Resource(name = "rptRglrIptnService")
	private RptRglrIptnService rptRglrIptnService;

	/**
	 * 정기점검보고서
	 */
	public void loadReport(List<String[]> strList, ConObsMetaVO conObsMetaVO) throws Exception {

		RptRglrIptnVO rptRglrIptnVO = new RptRglrIptnVO();

		// 연계데이터 구분코드
		rptRglrIptnVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());

		for (String[] arr : strList) {

			// 점검일자
			if (StringUtils.equals(arr[0], "rpt_date")) {

				arr[1] = StringUtils.remove(arr[1], "-");
				rptRglrIptnVO.setIptDt(arr[1]);

				// 기관코드
			} else if (StringUtils.equals(arr[0], "net")) {

				rptRglrIptnVO.setGvmtCd(arr[1]);

				// 시설물코드
			} else if (StringUtils.equals(arr[0], "obs_id")) {

				rptRglrIptnVO.setFctyCd(arr[1]);

				// 설치상태_항목1적합여부
			} else if (StringUtils.equals(arr[0], "q1_1")) {

				rptRglrIptnVO.setRglrQst11yn(arr[1]);

				// 설치상태_항목2적합여부
			} else if (StringUtils.equals(arr[0], "q1_2")) {

				rptRglrIptnVO.setRglrQst12yn(arr[1]);

				// 설치상태_항목3적합여부
			} else if (StringUtils.equals(arr[0], "q1_3")) {

				rptRglrIptnVO.setRglrQst13yn(arr[1]);

				// 설치상태_항목4적합여부
			} else if (StringUtils.equals(arr[0], "q1_4")) {

				rptRglrIptnVO.setRglrQst14yn(arr[1]);

				// 전원부_항목1적합여부
			} else if (StringUtils.equals(arr[0], "q2_1")) {

				rptRglrIptnVO.setRglrQst21yn(arr[1]);

				// 전원부_항목2적합여부
			} else if (StringUtils.equals(arr[0], "q2_2")) {

				rptRglrIptnVO.setRglrQst22yn(arr[1]);

				// 전원부_항목3적합여부
			} else if (StringUtils.equals(arr[0], "q2_3")) {

				rptRglrIptnVO.setRglrQst23yn(arr[1]);

				// 전원부_항목4적합여부
			} else if (StringUtils.equals(arr[0], "q2_4")) {

				rptRglrIptnVO.setRglrQst24yn(arr[1]);

				// 가속도_기록계_항목1적합여부
			} else if (StringUtils.equals(arr[0], "q3_1")) {

				rptRglrIptnVO.setRglrQst31yn(arr[1]);

				// 가속도_기록계_항목2적합여부
			} else if (StringUtils.equals(arr[0], "q3_2")) {

				rptRglrIptnVO.setRglrQst32yn(arr[1]);

				// 현장점검_항목1적합여부
			} else if (StringUtils.equals(arr[0], "q4_1")) {

				rptRglrIptnVO.setRglrQst41yn(arr[1]);

				// 현장점검_항목2적합여부
			} else if (StringUtils.equals(arr[0], "q4_2")) {

				rptRglrIptnVO.setRglrQst42yn(arr[1]);

				// 현장점검_항목3적합여부
			} else if (StringUtils.equals(arr[0], "q4_3")) {

				rptRglrIptnVO.setRglrQst43yn(arr[1]);

				// 정기점검결과내용
			} else if (StringUtils.equals(arr[0], "bigo")) {

				rptRglrIptnVO.setRglrRsltCtnt(arr[1]);

				// 정기점검처리결과내용
			} else if (StringUtils.equals(arr[0], "result")) {

				rptRglrIptnVO.setRglrMngeCtnt(arr[1]);

				// 정기점검담당부서
			} else if (StringUtils.equals(arr[0], "user_dept")) {

				rptRglrIptnVO.setRglrUsrDept(arr[1]);

				// 정기점검직책
			} else if (StringUtils.equals(arr[0], "user_duty")) {

				rptRglrIptnVO.setRglrUsrDuty(arr[1]);

				// 정기점검담당자성명
			} else if (StringUtils.equals(arr[0], "user_name")) {

				rptRglrIptnVO.setRglrUsrNm(arr[1]);

				// 정기점검담당자연락처
			} else if (StringUtils.equals(arr[0], "user_tel")) {

				rptRglrIptnVO.setRglrUsrTel(arr[1]);

			}

		}

		// 보고서_정기점검
		rptRglrIptnService.insertRptRglrIptn(rptRglrIptnVO);
	}

}
