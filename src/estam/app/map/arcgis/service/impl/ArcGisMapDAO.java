package estam.app.map.arcgis.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.map.arcgis.service.ArcGisMapVO;
import estam.app.map.arcgis.service.ArcGisMapDefaultVO;

/**
 * @Class Name : ArcGisMapDAO.java
 * @Description : ArcGisMap DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("arcGisMapDAO")
public class ArcGisMapDAO extends EgovAbstractDAO {

	/**
	 * FCTY_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ArcGisMapVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertArcGisMap(ArcGisMapVO vo) throws Exception {
        return (String)insert("arcGisMapDAO.insertArcGisMap_S", vo);
    }

    /**
	 * FCTY_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ArcGisMapVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateArcGisMap(ArcGisMapVO vo) throws Exception {
        update("arcGisMapDAO.updateArcGisMap_S", vo);
    }

    /**
	 * FCTY_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ArcGisMapVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteArcGisMap(ArcGisMapVO vo) throws Exception {
        delete("arcGisMapDAO.deleteArcGisMap_S", vo);
    }

    /**
	 * FCTY_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ArcGisMapVO
	 * @return 조회한 FCTY_MGR
	 * @exception Exception
	 */
    public ArcGisMapVO selectArcGisMap(ArcGisMapVO vo) throws Exception {
        return (ArcGisMapVO) selectByPk("arcGisMapDAO.selectArcGisMap_S", vo);
    }

    /**
	 * FCTY_MGR 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_MGR 목록
	 * @exception Exception
	 */
    public List selectArcGisMapList(ArcGisMapDefaultVO searchVO) throws Exception {
        return list("arcGisMapDAO.selectArcGisMapList_D", searchVO);
    }

    /**
	 * FCTY_MGR 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return FCTY_MGR 총 갯수
	 * @exception
	 */
    public int selectArcGisMapListTotCnt(ArcGisMapDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("arcGisMapDAO.selectArcGisMapListTotCnt_S", searchVO);
    }

}
