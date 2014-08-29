package estam.app.scn.evnt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.scn.evnt.service.EhqkOcurInfoDefaultVO;
import estam.app.scn.evnt.service.EhqkOcurInfoService;
import estam.app.scn.evnt.service.EhqkOcurInfoVO;

/**
 * @Class Name : EhqkOcurInfoServiceImpl.java
 * @Description : EhqkOcurInfo Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("ehqkOcurInfoService")
public class EhqkOcurInfoServiceImpl extends AbstractServiceImpl implements EhqkOcurInfoService {

	@Resource(name = "ehqkOcurInfoDAO")
	private EhqkOcurInfoDAO ehqkOcurInfoDAO;

	/** ID Generation */
	// @Resource(name="{egovEhqkOcurInfoIdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	/**
	 * EHQK_OCUR_INFO을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 EhqkOcurInfoVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		ehqkOcurInfoDAO.insertEhqkOcurInfo(vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}

	/**
	 * EHQK_OCUR_INFO을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 EhqkOcurInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		ehqkOcurInfoDAO.updateEhqkOcurInfo(vo);
	}

	/**
	 * EHQK_OCUR_INFO을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 EhqkOcurInfoVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		ehqkOcurInfoDAO.deleteEhqkOcurInfo(vo);
	}

	/**
	 * EHQK_OCUR_INFO을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 EhqkOcurInfoVO
	 * @return 조회한 EHQK_OCUR_INFO
	 * @exception Exception
	 */
	public EhqkOcurInfoVO selectEhqkOcurInfo(EhqkOcurInfoVO vo) throws Exception {
		EhqkOcurInfoVO resultVO = ehqkOcurInfoDAO.selectEhqkOcurInfo(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * EHQK_OCUR_INFO 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_OCUR_INFO 목록
	 * @exception Exception
	 */
	public List selectEhqkOcurInfoList(EhqkOcurInfoDefaultVO searchVO) throws Exception {
		return ehqkOcurInfoDAO.selectEhqkOcurInfoList(searchVO);
	}

	/**
	 * EHQK_OCUR_INFO 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return EHQK_OCUR_INFO 총 갯수
	 * @exception
	 */
	public int selectEhqkOcurInfoListTotCnt(EhqkOcurInfoDefaultVO searchVO) {
		return ehqkOcurInfoDAO.selectEhqkOcurInfoListTotCnt(searchVO);
	}

	/**
	 * EHQK_OCUR_INFO 최신 지진번호를 조회한다.
	 * 
	 * @param
	 * 
	 * @return EHQK_OCUR_INFO 의 EHQK_REQ_ID 최신번호
	 * @exception
	 */
	public String selectMaxEhqkReqId() throws Exception {
		return ehqkOcurInfoDAO.selectMaxEhqkReqId();
	}

}
