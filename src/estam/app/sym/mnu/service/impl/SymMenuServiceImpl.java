package estam.app.sym.mnu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import estam.app.sym.mnu.service.SymMenuService;
import estam.app.sym.mnu.service.SymMenuDefaultVO;
import estam.app.sym.mnu.service.SymMenuVO;
import estam.app.sym.mnu.service.impl.SymMenuDAO;

/**
 * @Class Name : SymMenuServiceImpl.java
 * @Description : SymMenu Business Implement class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("symMenuService")
public class SymMenuServiceImpl extends AbstractServiceImpl implements
        SymMenuService {

    @Resource(name="symMenuDAO")
    private SymMenuDAO symMenuDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSymMenuIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SYM_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymMenu(SymMenuVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	symMenuDAO.insertSymMenu(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYM_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymMenuVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymMenu(SymMenuVO vo) throws Exception {
        symMenuDAO.updateSymMenu(vo);
    }

    /**
	 * SYM_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymMenu(SymMenuVO vo) throws Exception {
        symMenuDAO.deleteSymMenu(vo);
    }

    /**
	 * SYM_MENU을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymMenuVO
	 * @return 조회한 SYM_MENU
	 * @exception Exception
	 */
    public SymMenuVO selectSymMenu(SymMenuVO vo) throws Exception {
        SymMenuVO resultVO = symMenuDAO.selectSymMenu(vo);
        
        return resultVO;
    }

    /**
	 * SYM_MENU 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_MENU 목록
	 * @exception Exception
	 */
    public List selectSymMenuList(SymMenuDefaultVO searchVO) throws Exception {
        return symMenuDAO.selectSymMenuList(searchVO);
    }

    /**
	 * SYM_MENU 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_MENU 총 갯수
	 * @exception
	 */
    public int selectSymMenuListTotCnt(SymMenuDefaultVO searchVO) {
		return symMenuDAO.selectSymMenuListTotCnt(searchVO);
	}
    
}
