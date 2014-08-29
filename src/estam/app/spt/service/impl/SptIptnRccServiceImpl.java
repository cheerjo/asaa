package estam.app.spt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.spt.service.SptIptnRccDefaultVO;
import estam.app.spt.service.SptIptnRccService;
import estam.app.spt.service.SptIptnRccVO;

/**
 * @Class Name : SptIptnRccServiceImpl.java
 * @Description : SptIptnRcc Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("sptIptnRccService")
public class SptIptnRccServiceImpl extends AbstractServiceImpl implements SptIptnRccService {

	@Resource(name = "sptIptnRccDAO")
	private SptIptnRccDAO sptIptnRccDAO;

	/** ID Generation */
	// @Resource(name="{egovSptIptnRccIdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	/**
	 * SPT_IPTN_RCC을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertSptIptnRcc(SptIptnRccVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		sptIptnRccDAO.insertSptIptnRcc(vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}

	/**
	 * SPT_IPTN_RCC을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnRccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertSptIptnRccList(List<SptIptnRccVO> sirvList, String sptIptnDt) throws Exception {

		for (SptIptnRccVO vo : sirvList) {

			vo.setSptIptnDt(sptIptnDt);
			sptIptnRccDAO.insertSptIptnRcc(vo);
		}
	}

	/**
	 * SPT_IPTN_RCC을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SptIptnRccVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnRcc(SptIptnRccVO vo) throws Exception {
		sptIptnRccDAO.updateSptIptnRcc(vo);
	}

	/**
	 * SPT_IPTN_RCC을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SptIptnRccVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSptIptnRcc(SptIptnRccVO vo) throws Exception {
		sptIptnRccDAO.deleteSptIptnRcc(vo);
	}

	/**
	 * SPT_IPTN_RCC을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnRccVO
	 * @return 조회한 SPT_IPTN_RCC
	 * @exception Exception
	 */
	public SptIptnRccVO selectSptIptnRcc(SptIptnRccVO vo) throws Exception {
		SptIptnRccVO resultVO = sptIptnRccDAO.selectSptIptnRcc(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * SPT_IPTN_RCC 검색목록을 조회한다.(팝업용)
	 * 
	 * @param vo
	 *            - SptIptnRccVO - 조회할 정보가 담긴 VO
	 * @return 조회한 SPT_IPTN_RCC
	 * @exception Exception
	 */
	public List selectSptIptnRccSearchList(SptIptnRccVO vo) throws Exception {
		return sptIptnRccDAO.selectSptIptnRccSearchList(vo);
	}

	/**
	 * SPT_IPTN_RCC 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RCC 목록
	 * @exception Exception
	 */
	public List selectSptIptnRccList(SptIptnRccDefaultVO searchVO) throws Exception {
		return sptIptnRccDAO.selectSptIptnRccList(searchVO);
	}

	/**
	 * SPT_IPTN_RCC 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_RCC 총 갯수
	 * @exception
	 */
	public int selectSptIptnRccListTotCnt(SptIptnRccDefaultVO searchVO) {
		return sptIptnRccDAO.selectSptIptnRccListTotCnt(searchVO);
	}

}
