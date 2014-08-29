package estam.app.signalux.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.signalux.service.SignalUxExecVO;
import estam.app.signalux.service.SignalUxExecDefaultVO;

/**
 * @Class Name : SignalUxExecDAO.java
 * @Description : SignalUxExec DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("signalUxExecDAO")
public class SignalUxExecDAO extends EgovAbstractDAO {

	/**
	 * TB_CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SignalUxExecVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSignalUxExec(SignalUxExecVO vo) throws Exception {
        return (String)insert("signalUxExecDAO.insertSignalUxExec_S", vo);
    }

    /**
	 * TB_CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SignalUxExecVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSignalUxExec(SignalUxExecVO vo) throws Exception {
        update("signalUxExecDAO.updateSignalUxExec_S", vo);
    }

    /**
	 * TB_CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SignalUxExecVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSignalUxExec(SignalUxExecVO vo) throws Exception {
        delete("signalUxExecDAO.deleteSignalUxExec_S", vo);
    }

    /**
	 * TB_CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SignalUxExecVO
	 * @return 조회한 TB_CODE
	 * @exception Exception
	 */
    public SignalUxExecVO selectSignalUxExec(SignalUxExecVO vo) throws Exception {
        return (SignalUxExecVO) selectByPk("signalUxExecDAO.selectSignalUxExec_S", vo);
    }

    /**
	 * TB_CODE 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return TB_CODE 목록
	 * @exception Exception
	 */
    public List selectSignalUxExecList(SignalUxExecDefaultVO searchVO) throws Exception {
        return list("signalUxExecDAO.selectSignalUxExecList_D", searchVO);
    }

    /**
	 * TB_CODE 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return TB_CODE 총 갯수
	 * @exception
	 */
    public int selectSignalUxExecListTotCnt(SignalUxExecDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("signalUxExecDAO.selectSignalUxExecListTotCnt_S", searchVO);
    }

}
