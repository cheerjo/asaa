package estam.app.com.rev.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import estam.app.com.rev.ConObsLogVO;
import estam.app.com.rev.ConObsMetaVO;
import estam.app.com.rev.service.ConObsMetaDAO;
import estam.app.com.rev.service.ConObsMetaService;

/**
 * @Class Name : ReportServiceImpl.java
 * @Description :
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Service("conObsMetaService")
public class ConObsMetaServiceImpl extends AbstractServiceImpl implements ConObsMetaService {

	@Resource(name = "conObsMetaDAO")
	private ConObsMetaDAO conObsMetaDAO;

	public List selectConObsMetaList(ConObsMetaVO vo) throws Exception {
		return conObsMetaDAO.selectConObsMetaList(vo);
	}

	public void insertConObsLog(ConObsLogVO vo) throws Exception {
		conObsMetaDAO.insertConObsLog(vo);
	}

}
