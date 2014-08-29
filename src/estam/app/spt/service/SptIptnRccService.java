package estam.app.spt.service;

import java.util.List;

/**
 * @Class Name : SptIptnRccService.java
 * @Description : SptIptnRcc Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface SptIptnRccService {

	/**
	 * SPT_IPTN_RCC을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertSptIptnRcc(SptIptnRccVO vo) throws Exception;

	/**
	 * SPT_IPTN_RCC을 등록한다.
	 * 
	 * @param string
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertSptIptnRccList(List<SptIptnRccVO> sirvList, String sptIptnDt) throws Exception;

	/**
	 * SPT_IPTN_RCC을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SptIptnRccVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnRcc(SptIptnRccVO vo) throws Exception;

	/**
	 * SPT_IPTN_RCC을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SptIptnRccVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSptIptnRcc(SptIptnRccVO vo) throws Exception;

	/**
	 * SPT_IPTN_RCC을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnRccVO
	 * @return 조회한 SPT_IPTN_RCC
	 * @exception Exception
	 */
	public SptIptnRccVO selectSptIptnRcc(SptIptnRccVO vo) throws Exception;

	/**
	 * SPT_IPTN_RCC 검색목록을 조회한다.(팝업용)
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnRccVO
	 * @return 조회한 SPT_IPTN_RCC
	 * @exception Exception
	 */
	public List selectSptIptnRccSearchList(SptIptnRccVO vo) throws Exception;

	/**
	 * SPT_IPTN_RCC 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RCC 목록
	 * @exception Exception
	 */
	public List selectSptIptnRccList(SptIptnRccDefaultVO searchVO) throws Exception;

	/**
	 * SPT_IPTN_RCC 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RCC 총 갯수
	 * @exception
	 */
	public int selectSptIptnRccListTotCnt(SptIptnRccDefaultVO searchVO);

}
