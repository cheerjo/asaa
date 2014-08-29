package estam.app.fcty.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.fcty.service.FctyStatSensVO;
import estam.app.fcty.service.FctyStatSensDefaultVO;

/**
 * @Class Name : FctyStatSensDAO.java
 * @Description : FctyStatSens DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("fctyStatSensDAO")
public class FctyStatSensDAO extends EgovAbstractDAO {

	/**
	 * FCTY_STAT_SENS을 등록한다.
	 * @param vo - 등록할 정보가 담긴 FctyStatSensVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertFctyStatSens(FctyStatSensVO vo) throws Exception {
        return (String)insert("fctyStatSensDAO.insertFctyStatSens_S", vo);
    }

    /**
	 * FCTY_STAT_SENS을 수정한다.
	 * @param vo - 수정할 정보가 담긴 FctyStatSensVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateFctyStatSens(FctyStatSensVO vo) throws Exception {
        update("fctyStatSensDAO.updateFctyStatSens_S", vo);
    }

    /**
	 * FCTY_STAT_SENS을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 FctyStatSensVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteFctyStatSens(FctyStatSensVO vo) throws Exception {
        delete("fctyStatSensDAO.deleteFctyStatSens_S", vo);
    }

    /**
	 * FCTY_STAT_SENS을 조회한다.
	 * @param vo - 조회할 정보가 담긴 FctyStatSensVO
	 * @return 조회한 FCTY_STAT_SENS
	 * @exception Exception
	 */
    public FctyStatSensVO selectFctyStatSens(FctyStatSensVO vo) throws Exception {
        return (FctyStatSensVO) selectByPk("fctyStatSensDAO.selectFctyStatSens_S", vo);
    }

    /**
	 * FCTY_STAT_SENS 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_STAT_SENS 목록
	 * @exception Exception
	 */
    public List selectFctyStatSensList(FctyStatSensDefaultVO searchVO) throws Exception {
        return list("fctyStatSensDAO.selectFctyStatSensList_D", searchVO);
    }

    /**
	 * FCTY_STAT_SENS 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_STAT_SENS 총 갯수
	 * @exception
	 */
    public int selectFctyStatSensListTotCnt(FctyStatSensDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("fctyStatSensDAO.selectFctyStatSensListTotCnt_S", searchVO);
    }

}
