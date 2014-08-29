package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.FctyMgrUsrVO;
import estam.app.fcty.service.FctyMgrUsrDefaultVO;

/**
 * @Class Name : FctyMgrUsrDAO.java
 * @Description : FctyMgrUsr DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("fctyMgrUsrDAO")
public class FctyMgrUsrDAO extends EgovAbstractDAO {

	/**
	 * FCTY_MGR_USR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyMgrUsrVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
        return (String)insert("fctyMgrUsrDAO.insertFctyMgrUsr_S", vo);
    }

    /**
	 * FCTY_MGR_USR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyMgrUsrVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
        update("fctyMgrUsrDAO.updateFctyMgrUsr_S", vo);
    }

    /**
	 * FCTY_MGR_USR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyMgrUsrVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
        delete("fctyMgrUsrDAO.deleteFctyMgrUsr_S", vo);
    }

    /**
	 * FCTY_MGR_USR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyMgrUsrVO
	 * @return 조회한 FCTY_MGR_USR
	 * @exception Exception
	 */
    public FctyMgrUsrVO selectFctyMgrUsr(FctyMgrUsrVO vo) throws Exception {
        return (FctyMgrUsrVO) selectByPk("fctyMgrUsrDAO.selectFctyMgrUsr_S", vo);
    }

    /**
	 * FCTY_MGR_USR 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_MGR_USR 목록
	 * @exception Exception
	 */
    public List selectFctyMgrUsrList(FctyMgrUsrDefaultVO searchVO) throws Exception {
        return list("fctyMgrUsrDAO.selectFctyMgrUsrList_D", searchVO);
    }

    /**
	 * FCTY_MGR_USR 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_MGR_USR 총 갯수
	 * @exception
	 */
    public int selectFctyMgrUsrListTotCnt(FctyMgrUsrDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("fctyMgrUsrDAO.selectFctyMgrUsrListTotCnt_S", searchVO);
    }

}
