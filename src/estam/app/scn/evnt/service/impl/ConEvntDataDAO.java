package estam.app.scn.evnt.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.scn.evnt.service.ConEvntDataVO;
import estam.app.scn.evnt.service.ConEvntDataDefaultVO;

/**
 * @Class Name : ConEvntDataDAO.java
 * @Description : ConEvntData DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("conEvntDataDAO")
public class ConEvntDataDAO extends EgovAbstractDAO {

	/**
	 * CON_EVNT_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ConEvntDataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertConEvntData(ConEvntDataVO vo) throws Exception {
        return (String)insert("conEvntDataDAO.insertConEvntData_S", vo);
    }

    /**
	 * CON_EVNT_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ConEvntDataVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateConEvntData(ConEvntDataVO vo) throws Exception {
        update("conEvntDataDAO.updateConEvntData_S", vo);
    }

    /**
	 * CON_EVNT_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ConEvntDataVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteConEvntData(ConEvntDataVO vo) throws Exception {
        delete("conEvntDataDAO.deleteConEvntData_S", vo);
    }

    /**
	 * CON_EVNT_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ConEvntDataVO
	 * @return 조회한 CON_EVNT_DATA
	 * @exception Exception
	 */
    public ConEvntDataVO selectConEvntData(ConEvntDataVO vo) throws Exception {
        return (ConEvntDataVO) selectByPk("conEvntDataDAO.selectConEvntData_S", vo);
    }

    /**
	 * CON_EVNT_DATA 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CON_EVNT_DATA 목록
	 * @exception Exception
	 */
    public List selectConEvntDataList(ConEvntDataDefaultVO searchVO) throws Exception {
        return list("conEvntDataDAO.selectConEvntDataList_D", searchVO);
    }

    /**
	 * CON_EVNT_DATA 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CON_EVNT_DATA 총 갯수
	 * @exception
	 */
    public int selectConEvntDataListTotCnt(ConEvntDataDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("conEvntDataDAO.selectConEvntDataListTotCnt_S", searchVO);
    }

}
