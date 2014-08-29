package estam.app.sym.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.sym.cmm.service.SymCommCdService;
import estam.app.sym.cmm.service.SymCommCdDefaultVO;
import estam.app.sym.cmm.service.SymCommCdVO;
import estam.app.sym.cmm.service.impl.SymCommCdDAO;

/**
 * @Class Name : SymCommCdServiceImpl.java
 * @Description : SymCommCd Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("symCommCdService")
public class SymCommCdServiceImpl extends AbstractServiceImpl implements
        SymCommCdService {

    @Resource(name="symCommCdDAO")
    private SymCommCdDAO symCommCdDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSymCommCdIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SYM_COMM_CD을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymCommCdVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymCommCd(SymCommCdVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	symCommCdDAO.insertSymCommCd(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYM_COMM_CD을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymCommCdVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymCommCd(SymCommCdVO vo) throws Exception {
        symCommCdDAO.updateSymCommCd(vo);
    }

    /**
	 * SYM_COMM_CD을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymCommCdVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymCommCd(SymCommCdVO vo) throws Exception {
        symCommCdDAO.deleteSymCommCd(vo);
    }

    /**
	 * SYM_COMM_CD을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymCommCdVO
	 * @return 조회한 SYM_COMM_CD
	 * @exception Exception
	 */
    public SymCommCdVO selectSymCommCd(SymCommCdVO vo) throws Exception {
        SymCommCdVO resultVO = symCommCdDAO.selectSymCommCd(vo);
        
        return resultVO;
    }

    /**
	 * SYM_COMM_CD 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD 목록
	 * @exception Exception
	 */
    public List selectSymCommCdList(SymCommCdDefaultVO searchVO) throws Exception {
        return symCommCdDAO.selectSymCommCdList(searchVO);
    }

    /**
	 * SYM_COMM_CD 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD 총 갯수
	 * @exception
	 */
    public int selectSymCommCdListTotCnt(SymCommCdDefaultVO searchVO) {
		return symCommCdDAO.selectSymCommCdListTotCnt(searchVO);
	}
    
}
