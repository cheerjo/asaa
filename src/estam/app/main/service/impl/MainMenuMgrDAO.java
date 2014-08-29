package estam.app.main.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.main.service.MainMenuMgrVO;
/**
 * 메뉴관리, 메뉴생성, 사이트맵 생성에 대한 DAO 클래스를 정의한다.
 * @author 개발환경 개발팀 이용
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.20  이  용          최초 생성
 *   2011.07.01  서준식			자기 메뉴 정보를 상위메뉴 정보로 참조하는 메뉴정보가 있는지 조회하는 
 *   							selectUpperMenuNoByPk() 메서드 추가
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성 
 *
 * </pre>
 */

@Repository("mainMenuMgrDAO")
public class MainMenuMgrDAO extends EgovAbstractDAO{

	/*### 메뉴관련 프로세스 ###*/
	/**
	 * MainMenu Head Menu 조회
	 * @param vo MenuManageVO
	 * @return List
	 * @exception Exception
	 */
	public List selectMainMenuHead(MainMenuMgrVO vo) throws Exception{
		return list("mainMenuMgrDAO.selectMainMenuHead", vo);
	}    
 
	/**
	 * MainMenu Head Menu 조회 - Anonymous
	 * @param vo MenuManageVO
	 * @return List
	 * @exception Exception
	 */
	public List selectMainMenuHeadByAuthor(MainMenuMgrVO vo) throws Exception{
		return list("mainMenuMgrDAO.selectMainMenuHeadByAuthor", vo);
	}  
	
	/**
	 * left 시설물 종류별 계측소 갯수를 가지고 온다. 
	 * @param vo MenuManageVO
	 * @return List
	 * @exception Exception
	 */
	public List selectEstamIncMapLeft(MainMenuMgrVO vo) throws Exception {
		return list("mainMenuMgrDAO.selectEstamIncMapLeft", vo);
	}
 
	
}
 
