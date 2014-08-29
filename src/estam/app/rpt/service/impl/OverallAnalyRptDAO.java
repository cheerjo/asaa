package estam.app.rpt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.rpt.service.OverallAnalyRptDefaultVO;

/**
 * @Class Name : IddlAassRlstStttDAO.java
 * @Description : IddlAassRlstSttt DAO Class
 * @Modification Information
 *
 * @author arjoona
 * @since 2013.12.1
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("overallAnalyRptDAO")
public class OverallAnalyRptDAO extends EgovAbstractDAO {
	
    /**
	 * 지진발생정보 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  목록
	 * @exception Exception
	 */
	public List selectAnalyRsltList(OverallAnalyRptDefaultVO vo) {
		return list("overallAnalyRptDAO.selectAnalyRsltList", vo);
	}

	/**
	 * 분석결과 목록Count 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  목록
	 * @exception Exception
	 */
	public int selectAnalyRsltListTotCnt(OverallAnalyRptDefaultVO vo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("overallAnalyRptDAO.selectAnalyRsltListTotCnt", vo);
	}

	/**
	 * 지진개요 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  지진개요 조회
	 * @exception Exception
	 */
	public List selectEhqkOcurInfo(OverallAnalyRptDefaultVO vo) {
		return list("overallAnalyRptDAO.selectEhqkOcurInfo", vo);
	}

	/**
	 * 보고서에 필요한 데이터 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  보고서 데이터
	 * @exception Exception
	 */
	public List selectAnalyRsltInfo(OverallAnalyRptDefaultVO vo) {
		return list("overallAnalyRptDAO.selectAnalyRsltInfo", vo);
	}

	/**
	 * 시설물 목록 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  시설물 목록
	 * @exception Exception
	 */
	public List selectFctyList(OverallAnalyRptDefaultVO vo) {
		return list("overallAnalyRptDAO.selectFctyList", vo);
	}

	/**
	 * 최대지반가속도 계측 관측소 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  최대지반가속도 계측 관측소 목록
	 * @exception Exception
	 */
	public List selectChkRult1(OverallAnalyRptDefaultVO vo) {
		return list("overallAnalyRptDAO.selectChkRult1", vo);
	}
	
	/**
	 * 설계지반가속도 초과지역 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return  설계지반가속도 초과지역 목록
	 * @exception Exception
	 */
	public List selectChkRult2(OverallAnalyRptDefaultVO vo) {
		return list("overallAnalyRptDAO.selectChkRult2", vo);
	}
}
