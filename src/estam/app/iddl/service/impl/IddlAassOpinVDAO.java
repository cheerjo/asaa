package estam.app.iddl.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.iddl.service.IddlAassOpinVVO;
import estam.app.iddl.service.IddlAassOpinVDefaultVO;

/**
 * @Class Name : IddlAassOpinVDAO.java
 * @Description : IddlAassOpinV DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("iddlAassOpinVDAO")
public class IddlAassOpinVDAO extends EgovAbstractDAO {

	/**
	 * IDDL_AASS_OPIN_V을 등록한다.
	 * @param vo - 등록할 정보가 담긴 IddlAassOpinVVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
        return (String)insert("iddlAassOpinVDAO.insertIddlAassOpinV_S", vo);
    }

    /**
	 * IDDL_AASS_OPIN_V을 수정한다.
	 * @param vo - 수정할 정보가 담긴 IddlAassOpinVVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
        update("iddlAassOpinVDAO.updateIddlAassOpinV_S", vo);
    }

    /**
	 * IDDL_AASS_OPIN_V을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 IddlAassOpinVVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
        delete("iddlAassOpinVDAO.deleteIddlAassOpinV_S", vo);
    }

    /**
	 * IDDL_AASS_OPIN_V을 조회한다.
	 * @param vo - 조회할 정보가 담긴 IddlAassOpinVVO
	 * @return 조회한 IDDL_AASS_OPIN_V
	 * @exception Exception
	 */
    public IddlAassOpinVVO selectIddlAassOpinV(IddlAassOpinVVO vo) throws Exception {
        return (IddlAassOpinVVO) selectByPk("iddlAassOpinVDAO.selectIddlAassOpinV_S", vo);
    }

    /**
	 * IDDL_AASS_OPIN_V 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_OPIN_V 목록
	 * @exception Exception
	 */
    public List selectIddlAassOpinVList(IddlAassOpinVDefaultVO searchVO) throws Exception {
        return list("iddlAassOpinVDAO.selectIddlAassOpinVList_D", searchVO);
    }

    /**
	 * IDDL_AASS_OPIN_V 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return IDDL_AASS_OPIN_V 총 갯수
	 * @exception
	 */
    public int selectIddlAassOpinVListTotCnt(IddlAassOpinVDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("iddlAassOpinVDAO.selectIddlAassOpinVListTotCnt_S", searchVO);
    }

}
