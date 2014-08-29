package estam.app.iddl.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.iddl.service.IddlAassWvflVO;
import estam.app.iddl.service.IddlAassWvflDefaultVO;

/**
 * @Class Name : IddlAassWvflDAO.java
 * @Description : IddlAassWvfl DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("iddlAassWvflDAO")
public class IddlAassWvflDAO extends EgovAbstractDAO {

	/**
	 * IDDL_AASS_WVFL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 IddlAassWvflVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
        return (String)insert("iddlAassWvflDAO.insertIddlAassWvfl_S", vo);
    }

    /**
	 * IDDL_AASS_WVFL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 IddlAassWvflVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
        update("iddlAassWvflDAO.updateIddlAassWvfl_S", vo);
    }

    /**
	 * IDDL_AASS_WVFL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 IddlAassWvflVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
        delete("iddlAassWvflDAO.deleteIddlAassWvfl_S", vo);
    }

    /**
	 * IDDL_AASS_WVFL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 IddlAassWvflVO
	 * @return 조회한 IDDL_AASS_WVFL
	 * @exception Exception
	 */
    public IddlAassWvflVO selectIddlAassWvfl(IddlAassWvflVO vo) throws Exception {
        return (IddlAassWvflVO) selectByPk("iddlAassWvflDAO.selectIddlAassWvfl_S", vo);
    }

    /**
	 * IDDL_AASS_WVFL 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_WVFL 목록
	 * @exception Exception
	 */
    public List selectIddlAassWvflList(IddlAassWvflDefaultVO searchVO) throws Exception {
        return list("iddlAassWvflDAO.selectIddlAassWvflList_D", searchVO);
    }

    /**
	 * IDDL_AASS_WVFL 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_WVFL 총 갯수
	 * @exception
	 */
    public int selectIddlAassWvflListTotCnt(IddlAassWvflDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("iddlAassWvflDAO.selectIddlAassWvflListTotCnt_S", searchVO);
    }

    /**
  	 * IDDL_AASS_WVFL 목록을 조회한다.
  	 * @param searchVO - 조회할 정보가 담긴 VO
  	 * @return IDDL_AASS_WVFL 목록
  	 * @exception Exception
  	 */
    public List selectWaveEventFrmInfo(IddlAassWvflDefaultVO searchVO) throws Exception {
    	 return list("iddlAassWvflDAO.selectWaveEventFrmInfo_D", searchVO);
     }
}
