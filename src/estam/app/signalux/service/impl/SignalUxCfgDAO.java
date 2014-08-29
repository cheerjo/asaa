package estam.app.signalux.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.signalux.service.SignalUxCfgVO;
import estam.app.signalux.service.SignalUxCfgDefaultVO;

/**
 * @Class Name : SignalUxCfgDAO.java
 * @Description : SignalUxCfg DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.08.07
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("signalUxCfgDAO")
public class SignalUxCfgDAO extends EgovAbstractDAO {

	/**
	 * TB_CODE을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SignalUxCfgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSignalUxCfg(SignalUxCfgVO vo) throws Exception {
        return (String)insert("signalUxCfgDAO.insertSignalUxCfg_S", vo);
    }

    /**
	 * TB_CODE을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SignalUxCfgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSignalUxCfg(SignalUxCfgVO vo) throws Exception {
        update("signalUxCfgDAO.updateSignalUxCfg_S", vo);
    }

    /**
	 * TB_CODE을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SignalUxCfgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSignalUxCfg(SignalUxCfgVO vo) throws Exception {
        delete("signalUxCfgDAO.deleteSignalUxCfg_S", vo);
    }

    /**
	 * TB_CODE을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SignalUxCfgVO
	 * @return 조회한 TB_CODE
	 * @exception Exception
	 */
    public SignalUxCfgVO selectSignalUxCfg(SignalUxCfgVO vo) throws Exception {
        return (SignalUxCfgVO) selectByPk("signalUxCfgDAO.selectSignalUxCfg_S", vo);
    }

    /**
	 * TB_CODE 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return TB_CODE 목록
	 * @exception Exception
	 */
    public List selectSignalUxCfgList(SignalUxCfgDefaultVO searchVO) throws Exception {
        return list("signalUxCfgDAO.selectSignalUxCfgList_D", searchVO);
    }

    /**
	 * TB_CODE 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return TB_CODE 총 갯수
	 * @exception
	 */
    public int selectSignalUxCfgListTotCnt(SignalUxCfgDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("signalUxCfgDAO.selectSignalUxCfgListTotCnt_S", searchVO);
    }

}
