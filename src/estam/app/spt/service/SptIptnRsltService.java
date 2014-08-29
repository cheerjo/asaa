package estam.app.spt.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : SptIptnRsltService.java
 * @Description : SptIptnRslt Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface SptIptnRsltService {

	/**
	 * SPT_IPTN_RSLT을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnRsltVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertSptIptnRslt(SptIptnRsltVO vo) throws Exception;

	/**
	 * SPT_IPTN_RSLT을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SptIptnRsltVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnRslt(SptIptnRsltVO vo) throws Exception;

	/**
	 * SPT_IPTN_RSLT을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SptIptnRsltVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSptIptnRslt(SptIptnRsltVO vo) throws Exception;

	/**
	 * SPT_IPTN_RSLT을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnRsltVO
	 * @return 조회한 SPT_IPTN_RSLT
	 * @exception Exception
	 */
	public SptIptnRsltVO selectSptIptnRslt(SptIptnRsltDefaultVO searchVO) throws Exception;

	/**
	 * SPT_IPTN_RSLT 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RSLT 목록
	 * @exception Exception
	 */
	public SptIptnRsltVO selectSptIptnRsltByKey(SptIptnRsltDefaultVO searchVO) throws Exception;

	/**
	 * SPT_IPTN_RSLT 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RSLT 목록
	 * @exception Exception
	 */
	public List selectSptIptnRsltList(SptIptnRsltDefaultVO searchVO) throws Exception;

	/**
	 * SPT_IPTN_RSLT 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RSLT 총 갯수
	 * @exception
	 */
	public int selectSptIptnRsltListTotCnt(SptIptnRsltDefaultVO searchVO);

	/**
	 * SPT_IPTN_FLOR 정보를 갱신함.
	 * 
	 * @param mapResult
	 *            - 정보가 담긴 Map
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnFlor(Map<String, Object> mapResult) throws Exception;

	/**
	 * SPT_IPTN_ETC 정보를 갱신함.
	 * 
	 * @param mapResult
	 *            - 정보가 담긴 Map
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnEtc(Map<String, Object> mapResult) throws Exception;

	/**
	 * SPT_IPTN_ETC 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_ETC 목록
	 * @exception Exception
	 */
	public List selectSptIptnEtcList(SptIptnEtcVO sptIptnEtcVO) throws Exception;

	/**
	 * SPT_IPTN_FLOR 해서 해당 첨부파일 삭제함
	 * 
	 * @param searchVO
	 *            - 정보가 담긴 VO
	 * @exception Exception
	 */
	public void deleteSptIptnFlor(SptIptnRsltDefaultVO searchVO) throws Exception;

	/**
	 * SPT_IPTN_ETC 해서 해당 첨부파일 삭제함
	 * 
	 * @param searchVO
	 *            - 정보가 담긴 VO
	 * @exception Exception
	 */
	public void deleteSptIptnEtc(SptIptnRsltDefaultVO searchVO) throws Exception;

}
