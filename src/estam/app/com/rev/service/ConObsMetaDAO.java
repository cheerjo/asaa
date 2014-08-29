package estam.app.com.rev.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import estam.app.com.rev.ConObsLogVO;
import estam.app.com.rev.ConObsMetaVO;

/**
 * @Class Name : ConObsMetaDAO.java
 * @Description : ConObsMetaDAO DAO Class
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Repository("conObsMetaDAO")
public class ConObsMetaDAO extends EgovAbstractDAO {

	public List selectConObsMetaList(ConObsMetaVO vo) {
		return (List) list("conObsMetaDAO.selectConObsMetaList", vo);
	}

	public void insertConObsLog(ConObsLogVO vo) {
		insert("conObsMetaDAO.insertConObsLog", vo);
	}

}
