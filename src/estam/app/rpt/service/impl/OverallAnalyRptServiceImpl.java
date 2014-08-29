package estam.app.rpt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.rpt.service.OverallAnalyRptDefaultVO;
import estam.app.rpt.service.OverallAnalyRptService;


/**
 * @Class Name : OverallAnalyRptServiceImpl.java
 * @Description : OverallAnalyRpt Business Implement class
 * @Modification Information
 *
 * @author 
 * @since 2013.12.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Service("overallAnalyRptService")
public class OverallAnalyRptServiceImpl extends AbstractServiceImpl implements OverallAnalyRptService {

	@Resource(name="overallAnalyRptDAO")
    private OverallAnalyRptDAO overallAnalyRptDAO;
	
	/**
   	 * 분석결과 목록을 조회한다.
   	 * @return 분석결과 목록
   	 * @exception Exception
   	 */
	public List selectAnalyRsltList(OverallAnalyRptDefaultVO searchVO) {
		return overallAnalyRptDAO.selectAnalyRsltList(searchVO);
	}

	/**
   	 * 분석결과 목록Count 조회한다
   	 * @return 분석결과 목록Count 
   	 * @exception Exception
   	 */
	public int selectAnalyRsltListTotCnt(OverallAnalyRptDefaultVO searchVO) {
		return overallAnalyRptDAO.selectAnalyRsltListTotCnt(searchVO);
	}

	/**
   	 * 지진개요 조회
   	 * @return 지진개요
   	 * @exception Exception
   	 */
	public List selectEhqkOcurInfo(OverallAnalyRptDefaultVO searchVO) {
		return overallAnalyRptDAO.selectEhqkOcurInfo(searchVO);
	}

	/**
   	 * 보고서에 필요한 데이터 조회
   	 * @return 보고서 데이터 
   	 * @exception Exception
   	 */
	public List selectAnalyRsltInfo(OverallAnalyRptDefaultVO vo) {
		return overallAnalyRptDAO.selectAnalyRsltInfo(vo);
	}

	/**
   	 * 시설물목록 조회
   	 * @return 보고서 데이터 
   	 * @exception Exception
   	 */
	public List selectFctyList(OverallAnalyRptDefaultVO vo) {
		return overallAnalyRptDAO.selectFctyList(vo);
	}

	/**
   	 * 최대지반가속도 계측 관측소 조회
   	 * @return 보고서 데이터 
   	 * @exception Exception
   	 */
	public List selectChkRult1(OverallAnalyRptDefaultVO vo) {
		return overallAnalyRptDAO.selectChkRult1(vo);
	}
	
	/**
   	 * 설계지반가속도 초과지역 조회
   	 * @return 보고서 데이터 
   	 * @exception Exception
   	 */
	public List selectChkRult2(OverallAnalyRptDefaultVO vo) {
		return overallAnalyRptDAO.selectChkRult2(vo);
	}

}
