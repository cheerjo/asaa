package estam.app.scn.evnt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.evnt.service.EhqkOcurInfoDefaultVO;
import estam.app.scn.evnt.service.EhqkOcurInfoVO;

/**
 * @Class Name : EhqkOcurInfoDAO.java
 * @Description : EhqkOcurInfo DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("ehqkOcurInfoDAO")
public class EhqkOcurInfoDAO extends EgovAbstractDAO {

	/**
	 * EHQK_OCUR_INFO을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkOcurInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		return (String) insert("ehqkOcurInfoDAO.insertEhqkOcurInfo_S", vo);
	}

	/**
	 * EHQK_OCUR_INFO을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 EhqkOcurInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		update("ehqkOcurInfoDAO.updateEhqkOcurInfo_S", vo);
	}

	/**
	 * EHQK_OCUR_INFO을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 EhqkOcurInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		delete("ehqkOcurInfoDAO.deleteEhqkOcurInfo_S", vo);
	}

	/**
	 * EHQK_OCUR_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 EhqkOcurInfoVO
	 * @return 조회한 EHQK_OCUR_INFO
	 * @exception Exception
	 */
	public EhqkOcurInfoVO selectEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		return (EhqkOcurInfoVO) selectByPk("ehqkOcurInfoDAO.selectEhqkOcurInfo_S", vo);
	}

	/**
	 * EHQK_OCUR_INFO 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return EHQK_OCUR_INFO 목록
	 * @exception Exception
	 */
	public List selectEhqkOcurInfoList(EhqkOcurInfoDefaultVO searchVO) throws Exception {
		return list("ehqkOcurInfoDAO.selectEhqkOcurInfoList_D", searchVO);
	}

	/**
	 * EHQK_OCUR_INFO 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return EHQK_OCUR_INFO 총 갯수
	 * @exception
	 */
	public int selectEhqkOcurInfoListTotCnt(EhqkOcurInfoDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ehqkOcurInfoDAO.selectEhqkOcurInfoListTotCnt_S", searchVO);
	}

	/**
	 * EHQK_OCUR_INFO 최신 지진번호를 조회한다.
	 * 
	 * @param
	 * 
	 * @return EHQK_OCUR_INFO 의 EHQK_REQ_ID 최신번호
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public String selectMaxEhqkReqId() {
		return (String) getSqlMapClientTemplate().queryForObject("ehqkOcurInfoDAO.selectMaxEhqkReqId", null);
	}

}
