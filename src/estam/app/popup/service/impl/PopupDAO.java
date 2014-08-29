package estam.app.popup.service.impl;

 
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.popup.service.PopupDefaultVO;
import estam.app.popup.service.SymCommCdVO;
import estam.app.popup.service.SymMenuVO;
import estam.app.popup.service.ZipCodeVO;

/**
 * @Class Name : SymMenuDAO.java
 * @Description : SymMenu DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 20130703
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("popupDAO")
public class PopupDAO extends EgovAbstractDAO {
 
    /**
	 * SYM_MENU 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_MENU 목록
	 * @exception Exception
	 */
    public List<SymMenuVO> selectPopupSymMenu(PopupDefaultVO searchVO) throws Exception {
        return list("popupDAO.selectPopupSymMenu", searchVO);
    }
    
    /**
 	 * SYM_COMM_CD 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return SYM_COMM_CD 목록
 	 * @exception Exception
 	 */
     public List<SymCommCdVO> selectPopupSymCommCd(PopupDefaultVO searchVO) throws Exception {
         return list("popupDAO.selectPopupSymCommCd", searchVO);
     }
     
     /**
      * (구)우편번호 리스트를 조회한다.
      *
      * @param vo
      * @return 조회한 글
      * @throws Exception the exception
      */
     public List zipCodeList(ZipCodeVO vo) throws Exception {
         return list("zipCodeDAO.selectZipCodeList", vo);
     }
     
     /**
      * (신)우편번호 리스트를 조회한다.
      *
      * @param vo
      * @return 조회한 글
      * @throws Exception the exception
      */
     public List selectZipCodeDoroPageList(ZipCodeVO vo) throws Exception {
         return list("zipCodeDAO.selectZipCodeDoroPageList", vo);
     }
     
     /**
      * (신)우편번호 리스트 카운트.
      * @param bdUseVO
      * @return
      * @throws Exception
      */
     public int selectZipCodeDoroPageListCnt(ZipCodeVO vo) throws Exception {
     	return (Integer)getSqlMapClientTemplate().queryForObject("zipCodeDAO.selectZipCodeDoroPageListCnt", vo);
     }
 

}
