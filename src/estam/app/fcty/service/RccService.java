package estam.app.fcty.service;

import java.util.List;

/**
 * @Class Name : RccService.java
 * @Description : Rcc Business class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public interface RccService {

	/**
	 * RCC을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 RccVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertRcc(RccVO vo) throws Exception;

	/**
	 * RCC을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 RccVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateRcc(RccVO vo) throws Exception;

	/**
	 * RCC을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 RccVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteRcc(RccVO vo) throws Exception;

	/**
	 * RCC을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 RccVO
	 * @return 조회한 RCC
	 * @exception Exception
	 */
	public RccVO selectRcc(RccVO vo) throws Exception;

	/**
	 * RCC 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return RCC 목록
	 * @exception Exception
	 */
	public List selectRccList(RccDefaultVO searchVO) throws Exception;

	/**
	 * RCC 총 갯수를 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return RCC 총 갯수
	 * @exception
	 */
	public int selectRccListTotCnt(RccDefaultVO searchVO);

	/**
	 * RCC을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 RccVO
	 * @return 조회한 RCC
	 * @exception Exception
	 */
	public List<RccVO> selectRccListByKey(RccVO rccVO) throws Exception;

}
