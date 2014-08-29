package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.fcty.service.EhqkScnImgDefaultVO;
import estam.app.fcty.service.EhqkScnImgService;
import estam.app.fcty.service.EhqkScnImgVO;
import estam.app.fcty.service.impl.EhqkScnImgDAO;

/**
 * @Class Name : EhqkScnImgServiceImpl.java
 * @Description : EhqkScnImg Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("ehqkScnImgService")
public class EhqkScnImgServiceImpl extends AbstractServiceImpl implements
        EhqkScnImgService {

    @Resource(name="ehqkScnImgDAO")
    private EhqkScnImgDAO ehqkScnImgDAO;
    
    /** ID Generation */
    //@Resource(name="{egovEhqkScnImgIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * EHQK_SCN_IMG을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EhqkScnImgVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertEhqkScnImg(EhqkScnImgVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	ehqkScnImgDAO.insertEhqkScnImg(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * EHQK_SCN_IMG을 수정한다.
	 * @param vo - 수정할 정보가 담긴 EhqkScnImgVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateEhqkScnImg(EhqkScnImgVO vo) throws Exception {
        ehqkScnImgDAO.updateEhqkScnImg(vo);
    }

    /**
	 * EHQK_SCN_IMG을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 EhqkScnImgVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteEhqkScnImg(EhqkScnImgVO vo) throws Exception {
        ehqkScnImgDAO.deleteEhqkScnImg(vo);
    }

    /**
	 * EHQK_SCN_IMG을 조회한다.
	 * @param vo - 조회할 정보가 담긴 EhqkScnImgVO
	 * @return 조회한 EHQK_SCN_IMG
	 * @exception Exception
	 */
    public EhqkScnImgVO selectEhqkScnImg(EhqkScnImgVO vo) throws Exception {
        EhqkScnImgVO resultVO = ehqkScnImgDAO.selectEhqkScnImg(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * EHQK_SCN_IMG 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN_IMG 목록
	 * @exception Exception
	 */
    public List selectEhqkScnImgList(EhqkScnImgDefaultVO searchVO) throws Exception {
        return ehqkScnImgDAO.selectEhqkScnImgList(searchVO);
    }

    /**
	 * EHQK_SCN_IMG 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return EHQK_SCN_IMG 총 갯수
	 * @exception
	 */
    public int selectEhqkScnImgListTotCnt(EhqkScnImgDefaultVO searchVO) {
		return ehqkScnImgDAO.selectEhqkScnImgListTotCnt(searchVO);
	}
    
}
