package estam.app.scn.mma.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.com.rev.BarRevTpPgaVO;
import estam.app.scn.mma.service.ConMmaDataVO;
import estam.app.scn.mma.service.ConMmaDataDefaultVO;

/**
 * @Class Name : ConMmaDataDAO.java
 * @Description : ConMmaData DAO Class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("conMmaDataDAO")
public class ConMmaDataDAO extends EgovAbstractDAO {

	/**
	 * CON_MMA_DATA을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ConMmaDataVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertConMmaData(ConMmaDataVO vo) throws Exception {
    	 
        return (String)insert("conMmaDataDAO.insertConMmaData_S", vo); 
    }

    /**
	 * CON_MMA_DATA을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ConMmaDataVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateConMmaData(ConMmaDataVO vo) throws Exception {
        update("conMmaDataDAO.updateConMmaData_S", vo);
    }

    /**
	 * CON_MMA_DATA을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ConMmaDataVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteConMmaData(ConMmaDataVO vo) throws Exception {
        delete("conMmaDataDAO.deleteConMmaData_S", vo);
    }

    /**
	 * CON_MMA_DATA을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ConMmaDataVO
	 * @return 조회한 CON_MMA_DATA
	 * @exception Exception
	 */
    public ConMmaDataVO selectConMmaData(ConMmaDataVO vo) throws Exception {
        return (ConMmaDataVO) selectByPk("conMmaDataDAO.selectConMmaData_S", vo);
    }

    /**
	 * CON_MMA_DATA 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CON_MMA_DATA 목록
	 * @exception Exception
	 */
    public List selectConMmaDataList(ConMmaDataDefaultVO searchVO) throws Exception {
        return list("conMmaDataDAO.selectConMmaDataList_D", searchVO);
    } 
    
    /**
	 * CON_MMA_DATA 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CON_MMA_DATA 총 갯수
	 * @exception
	 */
    public int selectConMmaDataListTotCnt(ConMmaDataDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("conMmaDataDAO.selectConMmaDataListTotCnt_S", searchVO);
    }
    
    public BarRevTpPgaVO selectBarRevPgaData(ConMmaDataDefaultVO searchVO) {
    	return (BarRevTpPgaVO) selectByPk("conMmaDataDAO.selectBarRevPgaData_D", searchVO);
	}

}
