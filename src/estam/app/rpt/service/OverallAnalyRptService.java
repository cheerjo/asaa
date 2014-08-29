package estam.app.rpt.service;

import java.util.List;

/**
 * @Class Name : OverallAnalyRptService.java
 * @Description : OverallAnalyRpt Business class
 * @Modification Information
 *
 * @author 
 * @since 2013.12.09
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

public interface OverallAnalyRptService {

	/**
	 * 분석결과 목록을 조회한다.
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 분석결과 목록
	 * @exception Exception
	 */
	List selectAnalyRsltList(OverallAnalyRptDefaultVO searchVO);

	/**
	 * 분석결과 목록Count 조회한다.
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 분석결과 목록Count 
	 * @exception Exception
	 */
	int selectAnalyRsltListTotCnt(OverallAnalyRptDefaultVO searchVO);

	/**
	 * 지진개요 조회
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 지진개요
	 * @exception Exception
	 */
	List selectEhqkOcurInfo(OverallAnalyRptDefaultVO searchVO);

	/**
	 * 보고서에 필요한 데이터 조회
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 보고서 데이터
	 * @exception Exception
	 */
	List selectAnalyRsltInfo(OverallAnalyRptDefaultVO searchVO);

	/**
	 * 시설물 목록 조회
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 보고서 데이터
	 * @exception Exception
	 */
	List selectFctyList(OverallAnalyRptDefaultVO searchVO);

	/**
	 * 최대지반가속도 계측 관측소 조회
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 보고서 데이터
	 * @exception Exception
	 */
	List selectChkRult1(OverallAnalyRptDefaultVO searchVO);
	
	/**
	 * 설계지반가속도 초과지역 조회
	 * @param VO - 조회할 정보가 담긴 VO
	 * @return 보고서 데이터
	 * @exception Exception
	 */
	List selectChkRult2(OverallAnalyRptDefaultVO searchVO);


}
