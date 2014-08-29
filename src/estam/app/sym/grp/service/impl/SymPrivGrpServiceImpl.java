package estam.app.sym.grp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.sym.grp.service.SymPrivGrpService;
import estam.app.sym.grp.service.SymPrivGrpDefaultVO;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.grp.service.impl.SymPrivGrpDAO;

/**
 * @Class Name : SymPrivGrpServiceImpl.java
 * @Description : SymPrivGrp Business Implement class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("symPrivGrpService")
public class SymPrivGrpServiceImpl extends AbstractServiceImpl implements
        SymPrivGrpService {

    @Resource(name="symPrivGrpDAO")
    private SymPrivGrpDAO symPrivGrpDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSymPrivGrpIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SYM_PRIV_GRP을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivGrpVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymPrivGrp(SymPrivGrpVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	symPrivGrpDAO.insertSymPrivGrp(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYM_PRIV_GRP을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivGrpVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymPrivGrp(SymPrivGrpVO vo) throws Exception {
        symPrivGrpDAO.updateSymPrivGrp(vo);
    }

    /**
	 * SYM_PRIV_GRP을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivGrpVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymPrivGrp(SymPrivGrpVO vo) throws Exception {
        symPrivGrpDAO.deleteSymPrivGrp(vo);
    }

    /**
	 * SYM_PRIV_GRP을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymPrivGrpVO
	 * @return 조회한 SYM_PRIV_GRP
	 * @exception Exception
	 */
    public SymPrivGrpVO selectSymPrivGrp(SymPrivGrpVO vo) throws Exception {
        SymPrivGrpVO resultVO = symPrivGrpDAO.selectSymPrivGrp(vo);

        return resultVO;
    }

    /**
	 * SYM_PRIV_GRP 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_GRP 목록
	 * @exception Exception
	 */
    public List selectSymPrivGrpList(SymPrivGrpDefaultVO searchVO) throws Exception {
        return symPrivGrpDAO.selectSymPrivGrpList(searchVO);
    }

    /**
	 * SYM_PRIV_GRP 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_GRP 총 갯수
	 * @exception
	 */
    public int selectSymPrivGrpListTotCnt(SymPrivGrpDefaultVO searchVO) {
		return symPrivGrpDAO.selectSymPrivGrpListTotCnt(searchVO);
	}
     
    /**
	 * SYM_PRIV_GRP 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_GRP 목록
	 * @exception Exception
	 */
    public List<SymPrivGrpVO> ListSymPrivGrp() throws Exception {
        return symPrivGrpDAO.ListSymPrivGrp();
    }

}
