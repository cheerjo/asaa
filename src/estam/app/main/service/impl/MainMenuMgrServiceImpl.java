package estam.app.main.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.main.service.MainMenuMgrService;
import estam.app.main.service.MainMenuMgrVO;

/**
 * 메뉴목록관리, 생성, 사이트맵을 처리하는 비즈니스 구현 클래스를 정의한다.
 * 
 * @author 개발환경 개발팀 이용
 * @since 2009.06.01
 * @version 1.0
 * @see
 * 
 *      <pre>
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

@Service("mainMenuMgrService")
public class MainMenuMgrServiceImpl extends AbstractServiceImpl implements MainMenuMgrService {

	protected Log log = LogFactory.getLog(this.getClass());

	@Resource(name = "mainMenuMgrDAO")
	private MainMenuMgrDAO mainMenuMgrDAO;

	/* ### 메뉴관련 프로세스 ### */
	/**
	 * MainMenu Head Menu 조회
	 * 
	 * @param vo
	 *            MenuManageVO
	 * @return List
	 * @exception Exception
	 */
	public List selectMainMenuHead(MainMenuMgrVO vo) throws Exception {
		return mainMenuMgrDAO.selectMainMenuHead(vo);
	}

	/**
	 * MainMenu Head Menu 조회
	 * 
	 * @param vo
	 *            MenuManageVO
	 * @return List
	 * @exception Exception
	 */
	public List selectMainMenuHeadByAuthor(MainMenuMgrVO vo) throws Exception {
		return mainMenuMgrDAO.selectMainMenuHeadByAuthor(vo);
	}

	/**
	 * left 시설물 종류별 계측소 갯수를 가지고 온다.
	 * 
	 * @param vo
	 *            MenuManageVO
	 * @return List
	 * @exception Exception
	 */
	public List selectEstamIncMapLeft(MainMenuMgrVO vo) throws Exception {
		return mainMenuMgrDAO.selectEstamIncMapLeft(vo);
	}

}
