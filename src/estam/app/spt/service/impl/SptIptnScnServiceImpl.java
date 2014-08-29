package estam.app.spt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.spt.service.SptIptnScnDefaultVO;
import estam.app.spt.service.SptIptnScnService;
import estam.app.spt.service.SptIptnScnVO;

/**
 * @Class Name : SptIptnScnServiceImpl.java
 * @Description : SptIptnScn Business Implement class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("sptIptnScnService")
public class SptIptnScnServiceImpl extends AbstractServiceImpl implements SptIptnScnService {

	@Resource(name = "sptIptnScnDAO")
	private SptIptnScnDAO sptIptnScnDAO;

	/** ID Generation */
	// @Resource(name="{egovSptIptnScnIdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	/**
	 * SPT_IPTN_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnScnVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertSptIptnScn(SptIptnScnVO vo) throws Exception {
		log.debug(vo.toString());

		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		log.debug(vo.toString());

		sptIptnScnDAO.insertSptIptnScn(vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}

	/**
	 * SPT_IPTN_SCN을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SptIptnScnVO List
	 * @return 등록 결과
	 * @exception Exception
	 */
	public void insertSptIptnScnVOList(List<SptIptnScnVO> sisvList, String sptIptnDt) throws Exception {

		for (SptIptnScnVO vo : sisvList) {

			vo.setSptIptnDt(sptIptnDt);
			sptIptnScnDAO.insertSptIptnScn(vo);
		}
	}

	/**
	 * SPT_IPTN_SCN을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SptIptnScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSptIptnScn(SptIptnScnVO vo) throws Exception {
		sptIptnScnDAO.updateSptIptnScn(vo);
	}

	/**
	 * SPT_IPTN_SCN을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SptIptnScnVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSptIptnScn(SptIptnScnVO vo) throws Exception {
		sptIptnScnDAO.deleteSptIptnScn(vo);
	}

	/**
	 * SPT_IPTN_SCN을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SptIptnScnVO
	 * @return 조회한 SPT_IPTN_SCN
	 * @exception Exception
	 */
	public SptIptnScnVO selectSptIptnScn(SptIptnScnVO vo) throws Exception {
		SptIptnScnVO resultVO = sptIptnScnDAO.selectSptIptnScn(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * SPT_IPTN_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnList(SptIptnScnVO vo) throws Exception {
		return sptIptnScnDAO.selectSptIptnScnList(vo);
	}

	/**
	 * SPT_IPTN_SCN 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnListForView(SptIptnScnVO vo) throws Exception {
		return sptIptnScnDAO.selectSptIptnScnListForView(vo);
	}

	/**
	 * SPT_IPTN_SCN 검색목록을 조회한다.(팝업용)
	 * 
	 * @param SptIptnScnVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 목록
	 * @exception Exception
	 */
	public List selectSptIptnScnSearchList(SptIptnScnVO vo) throws Exception {
		return sptIptnScnDAO.selectSptIptnScnSearchList(vo);
	}

	/**
	 * SPT_IPTN_SCN 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return SPT_IPTN_SCN 총 갯수
	 * @exception
	 */
	public int selectSptIptnScnListTotCnt(SptIptnScnDefaultVO searchVO) {
		return sptIptnScnDAO.selectSptIptnScnListTotCnt(searchVO);
	}

}
