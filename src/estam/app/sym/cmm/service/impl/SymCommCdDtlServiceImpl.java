package estam.app.sym.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.sym.cmm.service.SymCommCdDtlService;
import estam.app.sym.cmm.service.SymCommCdDtlDefaultVO;
import estam.app.sym.cmm.service.SymCommCdDtlVO;
import estam.app.sym.cmm.service.impl.SymCommCdDtlDAO;

/**
 * @Class Name : SymCommCdDtlServiceImpl.java
 * @Description : SymCommCdDtl Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("symCommCdDtlService")
public class SymCommCdDtlServiceImpl extends AbstractServiceImpl implements
        SymCommCdDtlService {

    @Resource(name="symCommCdDtlDAO")
    private SymCommCdDtlDAO symCommCdDtlDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSymCommCdDtlIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SYM_COMM_CD_DTL을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymCommCdDtlVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	symCommCdDtlDAO.insertSymCommCdDtl(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYM_COMM_CD_DTL을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymCommCdDtlVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
        symCommCdDtlDAO.updateSymCommCdDtl(vo);
    }

    /**
	 * SYM_COMM_CD_DTL을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymCommCdDtlVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
        symCommCdDtlDAO.deleteSymCommCdDtl(vo);
    }

    /**
	 * SYM_COMM_CD_DTL을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymCommCdDtlVO
	 * @return 조회한 SYM_COMM_CD_DTL
	 * @exception Exception
	 */
    public SymCommCdDtlVO selectSymCommCdDtl(SymCommCdDtlVO vo) throws Exception {
    	SymCommCdDtlVO resultVO = symCommCdDtlDAO.selectSymCommCdDtl(vo);
       
        return resultVO;
    }

    /**
	 * SYM_COMM_CD_DTL 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD_DTL 목록
	 * @exception Exception
	 */
    public List selectSymCommCdDtlList(SymCommCdDtlDefaultVO searchVO) throws Exception {
        return symCommCdDtlDAO.selectSymCommCdDtlList(searchVO);
    }

    /**
	 * SYM_COMM_CD_DTL 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_COMM_CD_DTL 총 갯수
	 * @exception
	 */
    public int selectSymCommCdDtlListTotCnt(SymCommCdDtlDefaultVO searchVO) {
		return symCommCdDtlDAO.selectSymCommCdDtlListTotCnt(searchVO);
	}
    
}
