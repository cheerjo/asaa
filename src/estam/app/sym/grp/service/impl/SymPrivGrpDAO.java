package estam.app.sym.grp.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.sym.grp.service.SymPrivGrpVO;
import estam.app.sym.grp.service.SymPrivGrpDefaultVO;
import estam.app.sym.mgp.service.SymPrivMenuVO;

/**
 * @Class Name : SymPrivGrpDAO.java
 * @Description : SymPrivGrp DAO Class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("symPrivGrpDAO")
public class SymPrivGrpDAO extends EgovAbstractDAO {

	/**
	 * SYM_PRIV_GRP을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SymPrivGrpVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertSymPrivGrp(SymPrivGrpVO vo) throws Exception {
        return (String)insert("symPrivGrpDAO.insertSymPrivGrp_S", vo);
    }

    /**
	 * SYM_PRIV_GRP을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SymPrivGrpVO
	 * @return void형
	 * @exception Exception
	 */
    public void updateSymPrivGrp(SymPrivGrpVO vo) throws Exception {
        update("symPrivGrpDAO.updateSymPrivGrp_S", vo);
    }

    /**
	 * SYM_PRIV_GRP을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SymPrivGrpVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteSymPrivGrp(SymPrivGrpVO vo) throws Exception {
        delete("symPrivGrpDAO.deleteSymPrivGrp_S", vo);
    }

    /**
	 * SYM_PRIV_GRP을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SymPrivGrpVO
	 * @return 조회한 SYM_PRIV_GRP
	 * @exception Exception
	 */
    public SymPrivGrpVO selectSymPrivGrp(SymPrivGrpVO vo) throws Exception {
        return (SymPrivGrpVO) selectByPk("symPrivGrpDAO.selectSymPrivGrp_S", vo);
    }

    /**
	 * SYM_PRIV_GRP 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_PRIV_GRP 목록
	 * @exception Exception
	 */
    public List selectSymPrivGrpList(SymPrivGrpDefaultVO searchVO) throws Exception {
        return list("symPrivGrpDAO.selectSymPrivGrpList_D", searchVO);
    }

    /**
	 * SYM_PRIV_GRP 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return SYM_PRIV_GRP 총 갯수
	 * @exception
	 */
    public int selectSymPrivGrpListTotCnt(SymPrivGrpDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("symPrivGrpDAO.selectSymPrivGrpListTotCnt_S", searchVO);
    }
    
    /**
  	 * SYM_PRIV_GRP 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return SYM_PRIV_GRP 목록
  	 * @exception Exception
  	 */
    @SuppressWarnings("unchecked")
      public List<SymPrivGrpVO> ListSymPrivGrp() throws Exception {
          return list("symPrivGrpDAO.ListSymPrivGrp", null);
      }


}
