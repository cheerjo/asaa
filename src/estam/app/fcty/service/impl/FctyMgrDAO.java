package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.FctyMgrDefaultVO;
import estam.app.fcty.service.FctyMgrVO;
import estam.app.main.service.FctyMgrInfoVO;

/**
 * @Class Name : FctyMgrDAO.java
 * @Description : FctyMgr DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("fctyMgrDAO")
public class FctyMgrDAO extends EgovAbstractDAO {

	/**
	 * FCTY_MGR을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 FctyMgrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertFctyMgr(FctyMgrVO vo) throws Exception {
		return (String) insert("fctyMgrDAO.insertFctyMgr_S", vo);
	}

	/**
	 * FCTY_MGR을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 FctyMgrVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateFctyMgr(FctyMgrVO vo) throws Exception {
		update("fctyMgrDAO.updateFctyMgr_S", vo);
	}

	/**
	 * FCTY_MGR을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 FctyMgrVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteFctyMgr(FctyMgrVO vo) throws Exception {
		delete("fctyMgrDAO.deleteFctyMgr_S", vo);
	}

	/**
	 * FCTY_MGR을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 FctyMgrVO
	 * @return 조회한 FCTY_MGR
	 * @exception Exception
	 */
	public FctyMgrVO selectFctyMgr(FctyMgrVO vo) throws Exception {
		return (FctyMgrVO) selectByPk("fctyMgrDAO.selectFctyMgr_S", vo);
	}

	/**
	 * FCTY_MGR 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return FCTY_MGR 목록
	 * @exception Exception
	 */
	public List selectFctyMgrList(FctyMgrDefaultVO searchVO) throws Exception {
		return list("fctyMgrDAO.selectFctyMgrList_D", searchVO);
	}

	/**
	 * FCTY_MGR 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return FCTY_MGR 총 갯수
	 * @exception
	 */
	@SuppressWarnings("deprecation")
	public int selectFctyMgrListTotCnt(FctyMgrDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("fctyMgrDAO.selectFctyMgrListTotCnt_S", searchVO);
	}

	/**
	 * PGA 목록을 조회한다.
	 * 
	 * @return PGA 목록
	 * @exception Exception
	 */
	public List selectFctyPga() throws Exception {
		return list("fctyMgrDAO.selectFctyPga_D", null);
	}

	/**
	 * 진도(MMI) 목록을 조회한다.
	 * 
	 * @return 진도(MMI) 목록
	 * @exception Exception
	 */
	public List selectFctyMmi() throws Exception {
		return list("fctyMgrDAO.selectFctyMmi_D", null);
	}

	/**
	 * 계측소 목록을 조회한다.
	 * 
	 * @return 계측소 목록
	 * @exception Exception
	 */
	public List selectFctyGvmt() throws Exception {
		return list("fctyMgrDAO.selectFctyGvmt_D", null);
	}

	/**
	 * 지반분류 목록을 조회한다.
	 * 
	 * @return 지반분류 목록
	 * @exception Exception
	 */
	public List selectFctyGrnd() throws Exception {
		return list("fctyMgrDAO.selectFctyGrnd_D", null);
	}

	/**
	 * 이상진동감지 목록을 조회한다.
	 * 
	 * @return 이상진동감지 목록
	 * @exception Exception
	 */
	public List selectFctyEvnt() throws Exception {
		return list("fctyMgrDAO.selectFctyEvnt_D", null);
	}

	/**
	 * 시설물 종류에 따른 시설물갯수 및 기타정보 목록을 조회한다.
	 * 
	 * @return 시설물 종류에 따른 시설물갯수 및 기타정보 목록
	 * @exception Exception
	 */
	public List listFctyTypeInfo() throws Exception {
		return list("fctyMgrDAO.listFctyTypeInfo_D", null);
	}

	/**
	 * 계측소을 총 수를 구한다.
	 * 
	 * @return
	 * @exception Exception
	 */
	@SuppressWarnings("deprecation")
	public int selectFctyTotCnt() throws Exception {
		return (Integer) getSqlMapClientTemplate().queryForObject("fctyMgrDAO.selectFctyTotCnt_S", null);
	}

	/**
	 * 시설물 정보를 조회한다.
	 * 
	 * @return 시설물 정보를 조회
	 * @exception Exception
	 */

	@SuppressWarnings("deprecation")
	public FctyMgrInfoVO selectFctyMgrInfo(FctyMgrInfoVO vfctyMgrSerarchVO) throws Exception {

		return (FctyMgrInfoVO) getSqlMapClientTemplate().queryForObject("fctyMgrDAO.selectFctyMgrInfo_S", vfctyMgrSerarchVO);
	}

	@SuppressWarnings("unchecked")
	public List<FctyMgrVO> selectFctyMgrListBySearch(FctyMgrVO vo) {
		return (List<FctyMgrVO>) list("fctyMgrDAO.selectFctyMgrListBySearch", vo);
	}
}
