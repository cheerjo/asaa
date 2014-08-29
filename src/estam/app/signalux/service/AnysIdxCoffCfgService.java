package estam.app.signalux.service;

import java.util.List;
import estam.app.signalux.service.AnysIdxCoffCfgDefaultVO;
import estam.app.signalux.service.AnysIdxCoffCfgVO;

/**
 * @Class Name : AnysIdxCoffCfgService.java
 * @Description : AnysIdxCoffCfg Business class
 * @Modification Information
 *
 * @author atres
 * @since 2013.11.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface AnysIdxCoffCfgService {
	
	/**
	 * ANYS_IDX_COFF_CFG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception;
    
    /**
	 * ANYS_IDX_COFF_CFG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return void형
	 * @exception Exception
	 */
    void updateAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception;
    
    /**
	 * ANYS_IDX_COFF_CFG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception;
    
    /**
	 * ANYS_IDX_COFF_CFG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return 조회한 ANYS_IDX_COFF_CFG
	 * @exception Exception
	 */
    AnysIdxCoffCfgVO selectAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception;
    
    /**
	 * ANYS_IDX_COFF_CFG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ANYS_IDX_COFF_CFG 목록
	 * @exception Exception
	 */
    List selectAnysIdxCoffCfgList(AnysIdxCoffCfgDefaultVO searchVO) throws Exception;
    
    /**
	 * ANYS_IDX_COFF_CFG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ANYS_IDX_COFF_CFG 총 갯수
	 * @exception
	 */
    int selectAnysIdxCoffCfgListTotCnt(AnysIdxCoffCfgDefaultVO searchVO);
    
}
