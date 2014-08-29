package estam.app.sym.usr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.sym.usr.service.SymPrivGrpCboVO;
import estam.app.sym.usr.service.SymUserDefaultVO;
import estam.app.sym.usr.service.SymUserService;
import estam.app.sym.usr.service.SymUserVO;

/**
 * @Class Name : SymUserServiceImpl.java
 * @Description : SymUser Business Implement class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("symUserService")
public class SymUserServiceImpl extends AbstractServiceImpl implements
        SymUserService {

    @Resource(name="symUserDAO")
    private SymUserDAO symUserDAO;
   
    /** ID Generation */
    //@Resource(name="{egovSymUserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * SYM_USER을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymUserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymUser(SymUserVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	symUserDAO.insertSymUser(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * SYM_USER을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymUserVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymUser(SymUserVO vo) throws Exception {
        symUserDAO.updateSymUser(vo);
    }

    /**
	 * SYM_USER을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymUserVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymUser(SymUserVO vo) throws Exception {
        symUserDAO.deleteSymUser(vo);
    }

    /**
	 * SYM_USER을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymUserVO
	 * @return 조회한 SYM_USER
	 * @exception Exception
	 */
    public SymUserVO selectSymUser(SymUserVO vo) throws Exception {
        SymUserVO resultVO = symUserDAO.selectSymUser(vo);

        return resultVO;
    }

    /**
	 * SYM_USER 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_USER 목록
	 * @exception Exception
	 */
    public List  selectSymUserList(SymUserDefaultVO searchVO) throws Exception {
        return symUserDAO.selectSymUserList(searchVO);
    }

    /**
	 * SYM_USER 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SYM_USER 총 갯수
	 * @exception
	 */
    public int selectSymUserListTotCnt(SymUserDefaultVO searchVO) {
		return symUserDAO.selectSymUserListTotCnt(searchVO);
	}
    
    /**
 	 * SYM_PRIV_MENU 목록 콤보처리을 위해  코드/명을 구해 온다.  
 	 * @return SYM_PRIV_MENU 목록리스트
 	 * @exception Exception
 	 */
     public List<SymPrivGrpCboVO> listSymPrivGrp() throws Exception {
         return symUserDAO.listSymPrivGrp();
     } 
    
}
