package estam.app.com.rev.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.com.rev.ConObsMetaVO;
import estam.app.com.rev.service.ReportDataService;
import estam.app.scn.rpt.service.RptStabRatgService;
import estam.app.scn.rpt.service.RptStabRatgVO;

/**
 * @Class Name : ReportData05ServiceImpl.java
 * @Description :
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.18
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("reportData05Service")
public class ReportData05ServiceImpl extends AbstractServiceImpl implements ReportDataService {

	@Resource(name = "rptStabRatgService")
	private RptStabRatgService rptStabRatgService;

	/**
	 * 안전성평가보고서
	 */
	public void loadReport(List<String[]> strList, ConObsMetaVO conObsMetaVO) throws Exception {

		RptStabRatgVO rptStabRatgVO = new RptStabRatgVO();

		// 연계데이터 구분코드
		rptStabRatgVO.setConDaGbcd(conObsMetaVO.getConDaGbcd());

		// 점검일자
		rptStabRatgVO.setIptDt(conObsMetaVO.getIptDt());

		for (String[] arr : strList) {

			// 지진이벤트구분코드
			if (StringUtils.equals(arr[0], "ditc")) {

				rptStabRatgVO.setEhqkEvntCd(arr[1]);

				// 지진이벤트아이디
			} else if (StringUtils.equals(arr[0], "event_id")) {

				rptStabRatgVO.setEhqkEvntId(arr[1]);

				// 기관코드
			} else if (StringUtils.equals(arr[0], "net")) {

				rptStabRatgVO.setGvmtCd(arr[1]);

				// 시설물코드
			} else if (StringUtils.equals(arr[0], "obs_id")) {

				rptStabRatgVO.setFctyCd(arr[1]);

				// 최대층간변위비_장축
			} else if (StringUtils.equals(arr[0], "dis_long")) {

				rptStabRatgVO.setIdrRngMj(arr[1]);

				// 최대층간변위비_단축
			} else if (StringUtils.equals(arr[0], "dis_short")) {

				rptStabRatgVO.setIdrRngShot(arr[1]);

				// 고유진동수비_장축
			} else if (StringUtils.equals(arr[0], "fre_long")) {

				rptStabRatgVO.setStrFrqMj(arr[1]);

				// 고유진동수비_단축
			} else if (StringUtils.equals(arr[0], "fre_short")) {

				rptStabRatgVO.setStrFrqShot(arr[1]);

				// 지반과공진가능성_장축
			} else if (StringUtils.equals(arr[0], "pro_long")) {

				rptStabRatgVO.setGrdRsnnPsbyMj(arr[1]);

				// 지반과공진가능성_단축
			} else if (StringUtils.equals(arr[0], "pro_short")) {

				rptStabRatgVO.setGrdRsnnPsbyShot(arr[1]);

				// 최대가속도비_장축
			} else if (StringUtils.equals(arr[0], "acc_long")) {

				rptStabRatgVO.setMaxScnMj(arr[1]);

				// 최대가속도비_단축
			} else if (StringUtils.equals(arr[0], "acc_short")) {

				rptStabRatgVO.setMaxScnShot(arr[1]);

				// 안전성_종합평가
			} else if (StringUtils.equals(arr[0], "result")) {

				rptStabRatgVO.setSfTot(arr[1]);

				// 안전성_담당부서
			} else if (StringUtils.equals(arr[0], "user_dept")) {

				rptStabRatgVO.setSfUsrDept(arr[1]);

				// 안전성_직책
			} else if (StringUtils.equals(arr[0], "user_duty")) {

				rptStabRatgVO.setSfUsrDuty(arr[1]);

				// 안전성_담담자성명
			} else if (StringUtils.equals(arr[0], "user_name")) {

				rptStabRatgVO.setSfUsrNm(arr[1]);

				// 안전성_담당자연락처
			} else if (StringUtils.equals(arr[0], "user_tel")) {

				rptStabRatgVO.setSfUsrTel(arr[1]);

			}

		}

		// 보고서_안전성평가
		rptStabRatgService.insertRptStabRatg(rptStabRatgVO);
	}

}
