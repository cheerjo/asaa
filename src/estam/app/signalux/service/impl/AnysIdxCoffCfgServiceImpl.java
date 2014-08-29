package estam.app.signalux.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.signalux.service.AnysIdxCoffCfgService;
import estam.app.signalux.service.AnysIdxCoffCfgDefaultVO;
import estam.app.signalux.service.AnysIdxCoffCfgVO;
import estam.app.signalux.service.impl.AnysIdxCoffCfgDAO;

/**
 * @Class Name : AnysIdxCoffCfgServiceImpl.java
 * @Description : AnysIdxCoffCfg Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.11.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("anysIdxCoffCfgService")
public class AnysIdxCoffCfgServiceImpl extends AbstractServiceImpl implements
        AnysIdxCoffCfgService {

    @Resource(name="anysIdxCoffCfgDAO")
    private AnysIdxCoffCfgDAO anysIdxCoffCfgDAO;
    
    /** ID Generation */
    //@Resource(name="{egovAnysIdxCoffCfgIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * ANYS_IDX_COFF_CFG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	anysIdxCoffCfgDAO.insertAnysIdxCoffCfg(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * ANYS_IDX_COFF_CFG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
        anysIdxCoffCfgDAO.updateAnysIdxCoffCfg(vo);
    }

    /**
	 * ANYS_IDX_COFF_CFG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
        anysIdxCoffCfgDAO.deleteAnysIdxCoffCfg(vo);
    }

    /**
	 * ANYS_IDX_COFF_CFG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 AnysIdxCoffCfgVO
	 * @return 조회한 ANYS_IDX_COFF_CFG
	 * @exception Exception
	 */
    public AnysIdxCoffCfgVO selectAnysIdxCoffCfg(AnysIdxCoffCfgVO vo) throws Exception {
        AnysIdxCoffCfgVO resultVO = anysIdxCoffCfgDAO.selectAnysIdxCoffCfg(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * ANYS_IDX_COFF_CFG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ANYS_IDX_COFF_CFG 목록
	 * @exception Exception
	 */
    public List selectAnysIdxCoffCfgList(AnysIdxCoffCfgDefaultVO searchVO) throws Exception {
        return anysIdxCoffCfgDAO.selectAnysIdxCoffCfgList(searchVO);
    }

    /**
	 * ANYS_IDX_COFF_CFG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return ANYS_IDX_COFF_CFG 총 갯수
	 * @exception
	 */
    public int selectAnysIdxCoffCfgListTotCnt(AnysIdxCoffCfgDefaultVO searchVO) {
		return anysIdxCoffCfgDAO.selectAnysIdxCoffCfgListTotCnt(searchVO);
	}
    
}
