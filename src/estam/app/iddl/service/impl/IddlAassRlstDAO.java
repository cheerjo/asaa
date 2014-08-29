package estam.app.iddl.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.iddl.service.IddlAassRlstDefaultVO;
import estam.app.iddl.service.IddlAassRlstVO;
import estam.app.iddl.service.IddlSubAassRlstVO;

/**
 * @Class Name : IddlAassRlstDAO.java
 * @Description : IddlAassRlst DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("iddlAassRlstDAO")
public class IddlAassRlstDAO extends EgovAbstractDAO {

	/**
	 * IDDL_AASS_RLST을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 IddlAassRlstVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		return (String) insert("iddlAassRlstDAO.insertIddlAassRlst_S", vo);
	}

	/**
	 * IDDL_AASS_RLST을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 IddlAassRlstVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		update("iddlAassRlstDAO.updateIddlAassRlst_S", vo);
	}

	/**
	 * IDDL_AASS_RLST을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 IddlAassRlstVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		delete("iddlAassRlstDAO.deleteIddlAassRlst_S", vo);
	}

	/**
	 * IDDL_AASS_RLST을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		return (IddlAassRlstVO) selectByPk("iddlAassRlstDAO.selectIddlAassRlst_S", vo);
	}

	/**
	 * IDDL_AASS_RLST을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectIddlAassRlstRpt(IddlAassRlstVO vo) throws Exception {
		return (IddlAassRlstVO) selectByPk("iddlAassRlstDAO.selectIddlAassRlst_R", vo);
	}

	/**
	 * IDDL_AASS_RLST 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_RLST 목록
	 * @exception Exception
	 */
	public List selectIddlAassRlstList(IddlAassRlstDefaultVO searchVO) throws Exception {
		return list("iddlAassRlstDAO.selectIddlAassRlstList_D", searchVO);
	}

	/**
	 * IDDL_AASS_RLST 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_RLST 총 갯수
	 * @exception
	 */
	public int selectIddlAassRlstListTotCnt(IddlAassRlstDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("iddlAassRlstDAO.selectIddlAassRlstListTotCnt_S", searchVO);
	}

	// 점검필요 시설물 갯수
	public int selectFctyChkListTotCnt(IddlAassRlstDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("iddlAassRlstDAO.selectFctyChkListTotCnt_S", searchVO);
	}

	/**
	 * 지진안정성분석결과 목록을 조회한다.
	 * 
	 * @return 지진안정성분석결과 목록
	 * @exception Exception
	 */
	public List selectEhqkOtnInfo(IddlAassRlstDefaultVO iddlAassRlstDfVo) throws Exception {
		return list("iddlAassRlstDAO.selectEhqkOtnInfo_D", iddlAassRlstDfVo);
	}

	/**
	 * 점검필요 시설물 목록을 조회한다.
	 * 
	 * @return 점검필요 시설물 목록
	 * @exception Exception
	 */
	public List selectIptnInfo(IddlAassRlstDefaultVO iddlAassRlstDfVo) throws Exception {
		return list("iddlAassRlstDAO.selectIptnInfo_D", iddlAassRlstDfVo);
	}

	/**
	 * 분석결과 요약 조회한다.
	 * 
	 * @return 분석결과 요약
	 * @exception Exception
	 */
	public List selectSfResultInfo() throws Exception {
		return list("iddlAassRlstDAO.selectSfResultInfo_D", null);
	}

	/**
	 * 안전평가 결과를 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlAassRlstVO selectSFIddlAassRlst(IddlAassRlstVO vo) throws Exception {
		return (IddlAassRlstVO) selectByPk("iddlAassRlstDAO.selectSFIddlAassRlst_S", vo);
	}

	/**
	 * 평가보조자료을 조회
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassRlstVO
	 * @return 조회한 IDDL_AASS_RLST
	 * @exception Exception
	 */
	public IddlSubAassRlstVO selectSubIddlAassRlst(IddlSubAassRlstVO vo) throws Exception {
		return (IddlSubAassRlstVO) selectByPk("iddlAassRlstDAO.selectSubIddlAassRlst_S", vo);
	}

	@SuppressWarnings("unchecked")
	public List<IddlAassRlstVO> selectIddlAassInfoList(IddlAassInfoVO iddlAassInfoVO) {
		return list("iddlAassRlstDAO.selectIddlAassInfoList", iddlAassInfoVO);
	}

	public List selectIddlAassRlstListByFctyStrTycd(IddlAassRlstVO searchVO) {
		return list("iddlAassRlstDAO.selectIddlAassRlstListByFctyStrTycd", searchVO);
	}

	public List selectIddlAassRlstList() {
		return list("iddlAassRlstDAO.selectIddlAassRlstList", null);
	}

	public List selectIddlAassRlstList(IddlAassInfoVO searchVO) {
		return list("iddlAassRlstDAO.selectIddlAassRlstListByIddlAassDt", searchVO);
	}
}
