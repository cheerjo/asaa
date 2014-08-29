package estam.app.spt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.spt.service.SptIptnEtcVO;
import estam.app.spt.service.SptIptnRsltDefaultVO;
import estam.app.spt.service.SptIptnRsltVO;

/**
 * @Class Name : SptIptnRsltDAO.java
 * @Description : SptIptnRslt DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("sptIptnRsltDAO")
public class SptIptnRsltDAO extends EgovAbstractDAO {

	/**
	 * SPT_IPTN_RSLT을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnRsltVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertSptIptnRslt(SptIptnRsltVO vo) throws Exception {
		return (String) insert("sptIptnRsltDAO.insertSptIptnRslt_S", vo);
	}

	/**
	 * SPT_IPTN_RSLT을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SptIptnRsltVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnRslt(SptIptnRsltVO vo) throws Exception {
		update("sptIptnRsltDAO.updateSptIptnRslt_S", vo);
	}

	/**
	 * SPT_IPTN_RSLT을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SptIptnRsltVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSptIptnRslt(SptIptnRsltVO vo) throws Exception {
		delete("sptIptnRsltDAO.deleteSptIptnRslt_S", vo);
	}

	/**
	 * SPT_IPTN_RSLT을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnRsltVO
	 * @return 조회한 SPT_IPTN_RSLT
	 * @exception Exception
	 */
	public SptIptnRsltVO selectSptIptnRslt(SptIptnRsltDefaultVO searchVO) throws Exception {
		return (SptIptnRsltVO) selectByPk("sptIptnRsltDAO.selectSptIptnRslt_S", searchVO);
	}

	/**
	 * SPT_IPTN_RSLT 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RSLT 목록
	 * @exception Exception
	 */
	public List selectSptIptnRsltList(SptIptnRsltDefaultVO searchVO) throws Exception {
		return list("sptIptnRsltDAO.selectSptIptnRsltList_D", searchVO);
	}

	/**
	 * SPT_IPTN_RSLT 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RSLT 총 갯수
	 * @exception
	 */
	public int selectSptIptnRsltListTotCnt(SptIptnRsltDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("sptIptnRsltDAO.selectSptIptnRsltListTotCnt_S", searchVO);
	}

	/**
	 * SPT_IPTN_FLOR테이블에서 현장점검 시설물도면 일련번호 정보를 가져옴
	 * 
	 * @param mapResult
	 *            - 정보가 담긴 Map
	 * @return Max SEQ
	 * @exception Exception
	 */
	public String selectSptIptnFlorMaxSeq(Map<String, Object> mapResult) {
		return (String) getSqlMapClientTemplate().queryForObject("sptIptnRsltDAO.selectSptIptnFlorMaxSeq", mapResult);
	}

	/**
	 * SPT_IPTN_FLOR테이블에서 도면 정보를 Insert
	 * 
	 * @param mapResult
	 *            - 정보가 담긴 Map
	 * @return Max SEQ
	 * @exception Exception
	 */
	public void updateSptIptnFlor(Map<String, Object> mapResult) {
		insert("sptIptnRsltDAO.insertSptIptnFlor", mapResult);
	}

	/**
	 * SPT_IPTN_ETC테이블에서 일련번호 정보를 가져옴
	 * 
	 * @param mapResult
	 *            - 정보가 담긴 Map
	 * @return Max SEQ
	 * @exception Exception
	 */
	public String selectSptIptnEtcMaxSeq(Map<String, Object> mapResult) {
		return (String) getSqlMapClientTemplate().queryForObject("sptIptnRsltDAO.selectSptIptnEtcMaxSeq", mapResult);
	}

	/**
	 * SPT_IPTN_ETC테이블에서 기타 정보를 Insert
	 * 
	 * @param mapResult
	 *            - 정보가 담긴 Map
	 * @return Max SEQ
	 * @exception Exception
	 */
	public void updateSptIptnEtc(Map<String, Object> mapResult) {
		insert("sptIptnRsltDAO.updateSptIptnEtc", mapResult);
	}

	/**
	 * SPT_IPTN_ETC 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_ETC 목록
	 * @exception Exception
	 */
	public List selectSptIptnEtcList(SptIptnEtcVO sptIptnEtcVO) throws Exception {
		return list("sptIptnRsltDAO.selectSptIptnEtcList", sptIptnEtcVO);
	}

	/**
	 * SPT_IPTN_FLOR 해서 해당 첨부파일 삭제함
	 * 
	 * @param searchVO
	 *            - 정보가 담긴 VO
	 * @exception Exception
	 */
	public void deleteSptIptnFlor(SptIptnRsltDefaultVO searchVO) {
		delete("sptIptnRsltDAO.deleteSptIptnFlor", searchVO);
	}

	/**
	 * SPT_IPTN_ETC 해서 해당 첨부파일 삭제함
	 * 
	 * @param searchVO
	 *            - 정보가 담긴 VO
	 * @exception Exception
	 */
	public void deleteSptIptnEtc(SptIptnRsltDefaultVO searchVO) {
		delete("sptIptnRsltDAO.deleteSptIptnEtc", searchVO);
	}

	/**
	 * SPT_IPTN_RSLT 정보를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_RSLT 정보
	 * @exception Exception
	 */
	@SuppressWarnings("deprecation")
	public SptIptnRsltVO selectSptIptnRsltByKey(SptIptnRsltDefaultVO searchVO) {
		return (SptIptnRsltVO) getSqlMapClientTemplate().queryForObject("sptIptnRsltDAO.selectSptIptnRsltByKey", searchVO);
	}

}
