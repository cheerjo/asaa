package estam.app.signalux.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.signalux.service.AnysIdxCoffCfgVO;
import estam.app.signalux.service.AnysIdxCoffCfgDefaultVO;

/**
 * @Class Name : AnysIdxCoffCfgDAO.java
 * @Description : AnysIdxCoffCfg DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.11.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("anysIdxCoffCfgDAO")
public class AnysIdxCoffCfgDAO extends EgovAbstractDAO {

	/**
	 * ANYS_IDX_COFF_CFG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
        return (String)insert("anysIdxCoffCfgDAO.insertAnysIdxCoffCfg_S", vo);
    }

    /**
	 * ANYS_IDX_COFF_CFG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
        update("anysIdxCoffCfgDAO.updateAnysIdxCoffCfg_S", vo);
    }

    /**
	 * ANYS_IDX_COFF_CFG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
        delete("anysIdxCoffCfgDAO.deleteAnysIdxCoffCfg_S", vo);
    }

    /**
	 * ANYS_IDX_COFF_CFG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return 조회한 ANYS_IDX_COFF_CFG
	 * @exception Exception
	 */
    public AnysIdxCoffCfgVO selectAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
        return (AnysIdxCoffCfgVO) selectByPk("anysIdxCoffCfgDAO.selectAnysIdxCoffCfg_S", vo);
    }

    /**
	 * ANYS_IDX_COFF_CFG 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ANYS_IDX_COFF_CFG 목록
	 * @exception Exception
	 */
    public List selectAnysIdxCoffCfgList(AnysIdxCoffCfgDefaultVO searchVO) throws Exception {
        return list("anysIdxCoffCfgDAO.selectAnysIdxCoffCfgList_D", searchVO);
    }

    /**
	 * ANYS_IDX_COFF_CFG 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return ANYS_IDX_COFF_CFG 총 갯수
	 * @exception
	 */
    public int selectAnysIdxCoffCfgListTotCnt(AnysIdxCoffCfgDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("anysIdxCoffCfgDAO.selectAnysIdxCoffCfgListTotCnt_S", searchVO);
    }

}
