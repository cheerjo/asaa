package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.EhqkScnDefaultVO;
import estam.app.fcty.service.EhqkScnVO;

/**
 * @Class Name : EhqkScnDAO.java
 * @Description : EhqkScn DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("ehqkScnDAO")
public class EhqkScnDAO extends EgovAbstractDAO {

	/**
	 * EHQK_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertEhqkScn(EhqkScnVO vo) throws Exception {
		return (String) insert("ehqkScnDAO.insertEhqkScn_S", vo);
	}

	/**
	 * EHQK_SCN을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 EhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateEhqkScn(EhqkScnVO vo) throws Exception {
		update("ehqkScnDAO.updateEhqkScn_S", vo);
	}

	/**
	 * EHQK_SCN을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 EhqkScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteEhqkScn(EhqkScnVO vo) throws Exception {
		delete("ehqkScnDAO.deleteEhqkScn_S", vo);
	}

	/**
	 * EHQK_SCN을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 EhqkScnVO
	 * @return 조회한 EHQK_SCN
	 * @exception Exception
	 */
	public EhqkScnVO selectEhqkScn(EhqkScnVO vo) throws Exception {
		return (EhqkScnVO) selectByPk("ehqkScnDAO.selectEhqkScn_S", vo);
	}

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	public List selectEhqkScnList(EhqkScnDefaultVO searchVO) throws Exception {
		return list("ehqkScnDAO.selectEhqkScnList_D", searchVO);
	}

	/**
	 * EHQK_SCN 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return EHQK_SCN 총 갯수
	 * @exception
	 */
	public int selectEhqkScnListTotCnt(EhqkScnDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("ehqkScnDAO.selectEhqkScnListTotCnt_S", searchVO);
	}

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map List
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EhqkScnVO> selectEhqkScnListByKey(EhqkScnVO searchVO) {
		return list("ehqkScnDAO.selectEhqkScnList", searchVO);
	}

	/**
	 * EHQK_SCN 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map List
	 * @return EHQK_SCN 목록
	 * @exception Exception
	 */
	public List<EhqkScnVO> selectEhqkScnListByCd(EhqkScnVO searchVO) {
		return list("ehqkScnDAO.selectEhqkScnListByCd", searchVO);
	}

}
