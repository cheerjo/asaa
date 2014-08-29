package estam.app.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.com.cmm.LoginVO;
import egovframework.com.utl.fcc.service.EgovNumberUtil;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.com.utl.sim.service.EgovFileScrty;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.login.service.LoginService;

/**
 * 일반 로그인, 로그인을 처리하는 비즈니스 구현 클래스
 * @author atres
 * @since 2013.07.06
 * @version 1.0
 * @see
 *  
 * <pre>
 * << 개정이력(Modification Information) >>
 * 
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2013.07.06  atres      최초 생성  
 *  </pre>
 */
@Service("loginService")
public class LoginServiceImpl extends AbstractServiceImpl implements
        LoginService {

    @Resource(name="loginDAO")
    private LoginDAO loginDAO;
    
   
    
    /**
	 * 일반 로그인을 처리한다
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO actionLogin(LoginVO vo) throws Exception {
    	
    	// 1. 입력한 비밀번호를 암호화한다.
    	String enpassword = EgovFileScrty.encryptPassword(vo.getUsrPswd());
    	vo.setUsrPswd(enpassword);
    	
    	// 2. 아이디와 암호화된 비밀번호가 DB와 일치하는지 확인한다.
    	LoginVO loginVO = loginDAO.actionLogin(vo);
    	
    	// 3. 결과를 리턴한다.
    	if (loginVO != null && !loginVO.getUserId().equals("") && !loginVO.getUsrPswd().equals("")) {
    		return loginVO;
    	} else {
    		loginVO = new LoginVO();
    	}
    	
    	return loginVO;
    }
  
    /**
	 * 아이디를 찾는다.
	 * @param vo LoginVO
	 * @return LoginVO
	 * @exception Exception
	 */
    public LoginVO searchId(LoginVO vo) throws Exception {

    	// 1. 이름, 이메일주소가 DB와 일치하는 사용자 ID를 조회한다.
    	LoginVO loginVO = loginDAO.searchId(vo);
    	
    	// 2. 결과를 리턴한다.
    	if (loginVO != null && !loginVO.getUserId().equals("")) {
    		return loginVO;
    	} else {
    		loginVO = new LoginVO();
    	}
    	
    	return loginVO;
    }
    
    /**
	 * 비밀번호를 찾는다.
	 * @param vo LoginVO
	 * @return boolean
	 * @exception Exception
	 */
    public boolean searchPassword(LoginVO vo) throws Exception {
    	
    	boolean result = true;
    	
    	// 1. 아이디, 이름, 이메일주소, 비밀번호 힌트, 비밀번호 정답이 DB와 일치하는 사용자 Password를 조회한다.
    	LoginVO loginVO = loginDAO.searchPassword(vo);
    	if (loginVO == null || loginVO.getUsrPswd() == null || loginVO.getUsrPswd().equals("")) {
    		return false;
    	}
    	
    	// 2. 임시 비밀번호를 생성한다.(영+영+숫+영+영+숫=6자리)
    	String newpassword = "";
    	for (int i = 1; i <= 6; i++) {
    		// 영자
    		if (i % 3 != 0) {
    			newpassword += EgovStringUtil.getRandomStr('a', 'z');
    		// 숫자
    		} else {
    			newpassword += EgovNumberUtil.getRandomNum(0, 9);
    		}
    	}
    	
    	// 3. 임시 비밀번호를 암호화하여 DB에 저장한다.
    	LoginVO pwVO = new LoginVO();
    	String enpassword = EgovFileScrty.encryptPassword(newpassword);
    	pwVO.setUserId(vo.getUserId());
    	pwVO.setUsrPswd(enpassword);
    	pwVO.setOrgYn(vo.getOrgYn());
    	loginDAO.updatePassword(pwVO);
    	
    	// TODO - 4. 임시 비밀번호를 이메일 발송한다.(메일연동솔루션 활용)
//    	SndngMailVO sndngMailVO = new SndngMailVO();
//    	sndngMailVO.setDsptchPerson("webmaster");
//    	sndngMailVO.setRecptnPerson(vo.getEmail());
//    	sndngMailVO.setSj("[MOPAS] 임시 비밀번호를 발송했습니다.");
//    	sndngMailVO.setEmailCn("고객님의 임시 비밀번호는 " + newpassword + " 입니다.");
//    	sndngMailVO.setAtchFileId("");
//    	
//    	result = sndngMailRegistService.insertSndngMail(sndngMailVO);
    	
    	return result;
    }
}
