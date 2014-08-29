package estam.app.spt.service;

import java.util.List;

/**
 * @Class Name : SptIptnScnService.java
 * @Description : SptIptnScn Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface SptIptnScnService {

	/**
	 * SPT_IPTN_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertSptIptnScn(SptIptnScnVO vo) throws Exception;

	/**
	 * SPT_IPTN_SCN을 등록한다.
	 * 
	 * @param sisv
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnScnVO List
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertSptIptnScnVOList(List<SptIptnScnVO> sisvList, String sptIptnDt) throws Exception;

	/**
	 * SPT_IPTN_SCN을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SptIptnScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnScn(SptIptnScnVO vo) throws Exception;

	/**
	 * SPT_IPTN_SCN을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SptIptnScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSptIptnScn(SptIptnScnVO vo) throws Exception;

	/**
	 * SPT_IPTN_SCN을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnScnVO
	 * @return 조회한 SPT_IPTN_SCN
	 * @exception Exception
	 */
	public SptIptnScnVO selectSptIptnScn(SptIptnScnVO vo) throws Exception;

	/**
	 * SPT_IPTN_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnList(SptIptnScnVO vo) throws Exception;

	/**
	 * SPT_IPTN_SCN 검색목록을 조회한다.(팝업용)
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnSearchList(SptIptnScnVO vo) throws Exception;

	/**
	 * SPT_IPTN_SCN 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 총 갯수
	 * @exception
	 */
	public int selectSptIptnScnListTotCnt(SptIptnScnDefaultVO searchVO);

	/**
	 * SPT_IPTN_SCN 검색목록을 조회한다.(팝업용)
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnListForView(SptIptnScnVO sptIptnScnVO) throws Exception;

}
