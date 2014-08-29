package estam.app.map.arcgis.service;

import java.util.List;
import estam.app.map.arcgis.service.ArcGisMapDefaultVO;
import estam.app.map.arcgis.service.ArcGisMapVO;

/**
 * @Class Name : ArcGisMapService.java
 * @Description : ArcGisMap Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface ArcGisMapService {
	
	/**
	 * FCTY_MGR을 등록한다.
	 * @param vo - 등록할 정보가 담긴 ArcGisMapVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertArcGisMap(ArcGisMapVO vo) throws Exception;
    
    /**
	 * FCTY_MGR을 수정한다.
	 * @param vo - 수정할 정보가 담긴 ArcGisMapVO
	 * @return void형
	 * @exception Exception
	 */
    void updateArcGisMap(ArcGisMapVO vo) throws Exception;
    
    /**
	 * FCTY_MGR을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 ArcGisMapVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteArcGisMap(ArcGisMapVO vo) throws Exception;
    
    /**
	 * FCTY_MGR을 조회한다.
	 * @param vo - 조회할 정보가 담긴 ArcGisMapVO
	 * @return 조회한 FCTY_MGR
	 * @exception Exception
	 */
    ArcGisMapVO selectArcGisMap(ArcGisMapVO vo) throws Exception;
    
    /**
	 * FCTY_MGR 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 목록
	 * @exception Exception
	 */
    List selectArcGisMapList(ArcGisMapDefaultVO searchVO) throws Exception;
    
    /**
	 * FCTY_MGR 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return FCTY_MGR 총 갯수
	 * @exception
	 */
    int selectArcGisMapListTotCnt(ArcGisMapDefaultVO searchVO);
    
}
