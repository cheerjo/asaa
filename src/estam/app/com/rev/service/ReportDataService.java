package estam.app.com.rev.service;

import java.util.List;

import org.springframework.stereotype.Component;

import estam.app.com.rev.ConObsMetaVO;

/**
 * 리포트 데이타를 파싱하여 등록한다.
 * 
 * @author 개발환경 개발팀 이용
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
public interface ReportDataService {

	/* ### 메뉴관련 프로세스 ### */
	/**
	 * 리포트 등록
	 * 
	 * @param conObsMetaVO
	 * 
	 * @param List
	 * 
	 * @return
	 * @exception Exception
	 */
	public abstract void loadReport(List<String[]> strList, ConObsMetaVO conObsMetaVO) throws Exception;

}
