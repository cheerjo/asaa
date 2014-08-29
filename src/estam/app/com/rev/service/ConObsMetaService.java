package estam.app.com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;

import estam.app.com.rev.ConObsLogVO;
import estam.app.com.rev.ConObsMetaVO;

/**
 * 연계_지진계측기_메타데이타 클래스를 정의한다.
 * 
 * @author
 * @since 2014.02.14
 * @version 1.0
 * @see
 * 
 *      <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2014.02.14  KMG          최초 생성
 * 
 * </pre>
 */
@Component
public interface ConObsMetaService {

	/**
	 * CON_OBS_META 조회
	 * 
	 * @param vo
	 *            ConObsMetaVO
	 * @return List
	 * @exception Exception
	 */
	public List selectConObsMetaList(ConObsMetaVO vo) throws Exception;

	/**
	 * CON_OBS_LOG 등록
	 * 
	 * @param vo
	 *            ConObsLogVO
	 * @return
	 * @exception Exception
	 */
	public void insertConObsLog(ConObsLogVO conObsLogVO) throws Exception;

}
