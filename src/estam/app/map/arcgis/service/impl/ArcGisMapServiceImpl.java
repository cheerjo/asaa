package estam.app.map.arcgis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.map.arcgis.service.ArcGisMapService;
import estam.app.map.arcgis.service.ArcGisMapDefaultVO;
import estam.app.map.arcgis.service.ArcGisMapVO;

/**
 * @Class Name : ArcGisMapServiceImpl.java
 * @Description : ArcGisMap Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("arcGisMapService")
public class ArcGisMapServiceImpl extends AbstractServiceImpl implements
        ArcGisMapService {

    @Resource(name="arcGisMapDAO")
    private ArcGisMapDAO arcGisMapDAO;
    
    /** ID Generation */
    //@Resource(name="{egovArcGisMapIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * FCTY_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ArcGisMapVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertArcGisMap(ArcGisMapVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	arcGisMapDAO.insertArcGisMap(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * FCTY_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ArcGisMapVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateArcGisMap(ArcGisMapVO vo) throws Exception {
        arcGisMapDAO.updateArcGisMap(vo);
    }

    /**
	 * FCTY_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ArcGisMapVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteArcGisMap(ArcGisMapVO vo) throws Exception {
        arcGisMapDAO.deleteArcGisMap(vo);
    }

    /**
	 * FCTY_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ArcGisMapVO
	 * @return 조회한 FCTY_MGR
	 * @exception Exception
	 */
    public ArcGisMapVO selectArcGisMap(ArcGisMapVO vo) throws Exception {
        ArcGisMapVO resultVO = arcGisMapDAO.selectArcGisMap(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * FCTY_MGR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 목록
	 * @exception Exception
	 */
    public List selectArcGisMapList(ArcGisMapDefaultVO searchVO) throws Exception {
        return arcGisMapDAO.selectArcGisMapList(searchVO);
    }

    /**
	 * FCTY_MGR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 총 갯수
	 * @exception
	 */
    public int selectArcGisMapListTotCnt(ArcGisMapDefaultVO searchVO) {
		return arcGisMapDAO.selectArcGisMapListTotCnt(searchVO);
	}
    
}
