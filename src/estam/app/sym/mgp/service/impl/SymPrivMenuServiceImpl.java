package estam.app.sym.mgp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.mgp.service.SymPrivMenuDefaultVO;
import estam.app.sym.mgp.service.SymPrivMenuService;
import estam.app.sym.mgp.service.SymPrivMenuVO;

/**
 * @Class Name : SymPrivMenuServiceImpl.java
 * @Description : SymPrivMenu Business Implement class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("symPrivMenuService")
public class SymPrivMenuServiceImpl extends AbstractServiceImpl implements
        SymPrivMenuService {

    @Resource(name="symPrivMenuDAO")
    private SymPrivMenuDAO symPrivMenuDAO;
    
    /** ID Generation */
    //@Resource(name="{egovSymPrivMenuIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SYM_PRIV_MENU을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivMenuVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymPrivMenu(SymPrivMenuVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	symPrivMenuDAO.insertSymPrivMenu(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYM_PRIV_MENU을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivMenuVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymPrivMenu(SymPrivMenuVO vo) throws Exception {
        symPrivMenuDAO.updateSymPrivMenu(vo);
    }

    /**
	 * SYM_PRIV_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymPrivMenu(SymPrivMenuVO vo) throws Exception {
        symPrivMenuDAO.deleteSymPrivMenu(vo);
    }

    /**
	 * SYM_PRIV_MENU을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymPrivMenuVO
	 * @return 조회한 SYM_PRIV_MENU
	 * @exception Exception
	 */
    public SymPrivMenuVO selectSymPrivMenu(SymPrivMenuVO vo) throws Exception {
        SymPrivMenuVO resultVO = symPrivMenuDAO.selectSymPrivMenu(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * SYM_PRIV_MENU 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_MENU 목록
	 * @exception Exception
	 */
    public List selectSymPrivMenuList(SymPrivMenuDefaultVO searchVO) throws Exception {
        return symPrivMenuDAO.selectSymPrivMenuList(searchVO);
    }
     
    /**
	 * SYM_PRIV_MENU 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_MENU 총 갯수
	 * @exception
	 */
    public int selectSymPrivMenuListTotCnt(SymPrivMenuDefaultVO searchVO) {
		return symPrivMenuDAO.selectSymPrivMenuListTotCnt(searchVO);
	}
    
    
    /**
	 * SYM_PRIV_GRP 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_GRP 목록
	 * @exception Exception
	 */
    public List selectSymPrivMenuExria(SymPrivMenuVO searchVO) throws Exception {
        return symPrivMenuDAO.selectSymPrivMenuExria(searchVO);
    }
    
    /**
	 * SYM_PRIV_GRP 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_PRIV_GRP 목록
	 * @exception Exception
	 */
    public List selectSymNonPrivMenuExria(SymPrivMenuVO searchVO) throws Exception {
        return symPrivMenuDAO.selectSymNonPrivMenuExria(searchVO);
    }

    /**
	 * SYM_PRIV_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    public void savePrivMenuExria(SymPrivMenuVO vo) throws Exception {
        symPrivMenuDAO.savePrivMenuExria(vo);
    }

    /**
	 * SYM_PRIV_MENU을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivMenuVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePrivMenuExria(SymPrivMenuVO vo) throws Exception {
        symPrivMenuDAO.deletePrivMenuExria(vo);
    }   
    
    public List<Map<String, Object>> ListSymPrivGrpExria() throws Exception {
        return symPrivMenuDAO.ListSymPrivGrpExria();
    }  
}
