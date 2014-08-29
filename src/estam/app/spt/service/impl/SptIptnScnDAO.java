package estam.app.spt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.spt.service.SptIptnScnDefaultVO;
import estam.app.spt.service.SptIptnScnVO;

/**
 * @Class Name : SptIptnScnDAO.java
 * @Description : SptIptnScn DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("sptIptnScnDAO")
public class SptIptnScnDAO extends EgovAbstractDAO {

	/**
	 * SPT_IPTN_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertSptIptnScn(SptIptnScnVO vo) throws Exception {

		return (String) insert("sptIptnScnDAO.insertSptIptnScn_S", vo);
	}

	/**
	 * SPT_IPTN_SCN을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SptIptnScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnScn(SptIptnScnVO vo) throws Exception {
		update("sptIptnScnDAO.updateSptIptnScn_S", vo);
	}

	/**
	 * SPT_IPTN_SCN을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SptIptnScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSptIptnScn(SptIptnScnVO vo) throws Exception {
		delete("sptIptnScnDAO.deleteSptIptnScn_S", vo);
	}

	/**
	 * SPT_IPTN_SCN을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnScnVO
	 * @return 조회한 SPT_IPTN_SCN
	 * @exception Exception
	 */
	public SptIptnScnVO selectSptIptnScn(SptIptnScnVO vo) throws Exception {
		return (SptIptnScnVO) selectByPk("sptIptnScnDAO.selectSptIptnScn_S", vo);
	}

	/**
	 * SPT_IPTN_SCN 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnList(SptIptnScnVO vo) throws Exception {
		return list("sptIptnScnDAO.selectSptIptnScnList_D", vo);
	}

	/**
	 * SPT_IPTN_SCN 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnListForView(SptIptnScnVO vo) {
		return list("sptIptnScnDAO.selectSptIptnScnList", vo);
	}

	/**
	 * SPT_IPTN_SCN 검색목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnSearchList(SptIptnScnVO vo) throws Exception {
		return list("sptIptnScnDAO.selectSptIptnScnSearchList_S", vo);
	}

	/**
	 * SPT_IPTN_SCN 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return SPT_IPTN_SCN 총 갯수
	 * @exception
	 */
	public int selectSptIptnScnListTotCnt(SptIptnScnDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("sptIptnScnDAO.selectSptIptnScnListTotCnt_S", searchVO);
	}

}
