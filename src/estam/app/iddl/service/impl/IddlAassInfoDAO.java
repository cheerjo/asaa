package estam.app.iddl.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.iddl.service.IddlAassInfoDefaultVO;
import estam.app.iddl.service.IddlAassInfoVO;
import estam.app.scn.evnt.service.ConEvntDataDefaultVO;
import estam.app.scn.evnt.service.EhqkOcurInfoVO;

/**
 * @Class Name : IddlAassInfoDAO.java
 * @Description : IddlAassInfo DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("iddlAassInfoDAO")
public class IddlAassInfoDAO extends EgovAbstractDAO {

	/**
	 * EHQK_OCUR_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassInfoVO
	 * @return 조회한 EHQK_OCUR_INFO
	 * @exception Exception
	 */
	public List<EhqkOcurInfoVO> selectEhqkOcurInfo(IddlAassInfoVO vo) throws Exception {
		return list("iddlAassInfoDAO.selectEhqkOcurInfo", vo);
	}

	/**
	 * IDDL_AASS_INFO을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 IddlAassInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		return (String) insert("iddlAassInfoDAO.insertIddlAassInfo_S", vo);
	}

	/**
	 * IDDL_AASS_INFO을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 IddlAassInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		update("iddlAassInfoDAO.updateIddlAassInfo_S", vo);
	}

	/**
	 * IDDL_AASS_INFO을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 IddlAassInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		delete("iddlAassInfoDAO.deleteIddlAassInfo_S", vo);
	}

	/**
	 * IDDL_AASS_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 IddlAassInfoVO
	 * @return 조회한 IDDL_AASS_INFO
	 * @exception Exception
	 */
	public IddlAassInfoVO selectIddlAassInfo(IddlAassInfoVO vo) throws Exception {
		return (IddlAassInfoVO) selectByPk("iddlAassInfoDAO.selectIddlAassInfo_S", vo);
	}

	/**
	 * IDDL_AASS_INFO 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_INFO 목록
	 * @exception Exception
	 */
	public List selectIddlAassInfoList(IddlAassInfoDefaultVO searchVO) throws Exception {
		return list("iddlAassInfoDAO.selectIddlAassInfoList_D", searchVO);
	}

	/**
	 * IDDL_AASS_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 목록
	 * @exception Exception
	 */
	public List selectWvEvntList(IddlAassInfoDefaultVO searchVO) throws Exception {
		return list("iddlAassInfoDAO.selectWvEvntList_D", searchVO);
	}

	public List selectWvEvntList2(IddlAassInfoDefaultVO searchVO) throws Exception {
		return list("iddlAassInfoDAO.selectWvEvntList2_D", searchVO);
	}

	/**
	 * IDDL_AASS_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return IDDL_AASS_INFO 목록
	 * @exception Exception
	 */
	public List selectBarEventFrmInfo(IddlAassInfoDefaultVO searchVO) throws Exception {
		return list("iddlAassInfoDAO.selectBarEventFrmInfo_D", searchVO);
	}

	/**
	 * IDDL_AASS_INFO 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_INFO 총 갯수
	 * @exception
	 */
	public int selectIddlAassInfoListTotCnt(IddlAassInfoDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("iddlAassInfoDAO.selectIddlAassInfoListTotCnt_S", searchVO);
	}

	public String selectIddlAassNo(ConEvntDataDefaultVO searchVO) {
		return (String) getSqlMapClientTemplate().queryForObject("iddlAassInfoDAO.selectIddlAassNo", searchVO);
	}

}
