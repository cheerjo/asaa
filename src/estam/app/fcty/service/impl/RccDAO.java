package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.RccDefaultVO;
import estam.app.fcty.service.RccVO;

/**
 * @Class Name : RccDAO.java
 * @Description : Rcc DAO Class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("rccDAO")
public class RccDAO extends EgovAbstractDAO {

	/**
	 * RCC을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 RccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertRcc(RccVO vo) throws Exception {
		return (String) insert("rccDAO.insertRcc_S", vo);
	}

	/**
	 * RCC을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 RccVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateRcc(RccVO vo) throws Exception {
		update("rccDAO.updateRcc_S", vo);
	}

	/**
	 * RCC을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 RccVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteRcc(RccVO vo) throws Exception {
		delete("rccDAO.deleteRcc_S", vo);
	}

	/**
	 * RCC을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 RccVO
	 * @return 조회한 RCC
	 * @exception Exception
	 */
	public RccVO selectRcc(RccVO vo) throws Exception {
		return (RccVO) selectByPk("rccDAO.selectRcc_S", vo);
	}

	/**
	 * RCC 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return RCC 목록
	 * @exception Exception
	 */
	public List selectRccList(RccDefaultVO searchVO) throws Exception {
		return list("rccDAO.selectRccList_D", searchVO);
	}

	/**
	 * RCC 총 갯수를 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return RCC 총 갯수
	 * @exception
	 */
	public int selectRccListTotCnt(RccDefaultVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("rccDAO.selectRccListTotCnt_S", searchVO);
	}

	/**
	 * RCC 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return RCC 목록
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RccVO> selectRccListByKey(RccVO rccVO) {
		return list("rccDAO.selectRccList", rccVO);
	}

}
