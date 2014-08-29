package estam.app.fcty.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.fcty.service.RccDefaultVO;
import estam.app.fcty.service.RccService;
import estam.app.fcty.service.RccVO;

/**
 * @Class Name : RccServiceImpl.java
 * @Description : Rcc Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("rccService")
public class RccServiceImpl extends AbstractServiceImpl implements RccService {

	@Resource(name = "rccDAO")
	private RccDAO rccDAO;

	/** ID Generation */
	// @Resource(name="{egovRccIdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	/**
	 * RCC을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 RccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertRcc(RccVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		rccDAO.insertRcc(vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}

	/**
	 * RCC을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 RccVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateRcc(RccVO vo) throws Exception {
		rccDAO.updateRcc(vo);
	}

	/**
	 * RCC을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 RccVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteRcc(RccVO vo) throws Exception {
		rccDAO.deleteRcc(vo);
	}

	/**
	 * RCC을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 RccVO
	 * @return 조회한 RCC
	 * @exception Exception
	 */
	public RccVO selectRcc(RccVO vo) throws Exception {
		RccVO resultVO = rccDAO.selectRcc(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * RCC 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return RCC 목록
	 * @exception Exception
	 */
	public List selectRccList(RccDefaultVO searchVO) throws Exception {
		return rccDAO.selectRccList(searchVO);
	}

	/**
	 * RCC 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return RCC 총 갯수
	 * @exception
	 */
	public int selectRccListTotCnt(RccDefaultVO searchVO) {
		return rccDAO.selectRccListTotCnt(searchVO);
	}

	@SuppressWarnings("unchecked")
	public List<RccVO> selectRccListByKey(RccVO rccVO) throws Exception {
		return rccDAO.selectRccListByKey(rccVO);
	}

}
