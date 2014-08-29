package estam.app.scn.evnt.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : EhqkOcurInfoDefaultVO.java
 * @Description : EhqkOcurInfo Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class EhqkOcurInfoDefaultVO implements Serializable {
	
	/** 검색조건 */
    private String searchCondition = "";
    
    /** 검색Keyword */
    private String searchKeyword = "";
    
    /** 검색사용여부 */
    private String searchUseYn = "";
    
    /** 현재페이지 */
    private int pageIndex = 1;
    
    /** 페이지갯수 */
    private int pageUnit = 10;
    
    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;
    
    private String fctyCd = "";
    private String gvmtCd = "";
    private String iddlAassNo = "";
    private String ehqkReqId = "";
    private String ehqkTranGbcd = "";
     
        
	/**
	 * @return the fctyCd
	 */
	public String getFctyCd() {
		return fctyCd;
	}

	/**
	 * @param fctyCd the fctyCd to set
	 */
	public void setFctyCd(String fctyCd) {
		this.fctyCd = fctyCd;
	}

	/**
	 * @return the gvmtCd
	 */
	public String getGvmtCd() {
		return gvmtCd;
	}

	/**
	 * @param gvmtCd the gvmtCd to set
	 */
	public void setGvmtCd(String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	/**
	 * @return the iddlAassNo
	 */
	public String getIddlAassNo() {
		return iddlAassNo;
	}

	/**
	 * @param iddlAassNo the iddlAassNo to set
	 */
	public void setIddlAassNo(String iddlAassNo) {
		this.iddlAassNo = iddlAassNo;
	}

	/**
	 * @return the ehqkReqId
	 */
	public String getEhqkReqId() {
		return ehqkReqId;
	}

	/**
	 * @param ehqkReqId the ehqkReqId to set
	 */
	public void setEhqkReqId(String ehqkReqId) {
		this.ehqkReqId = ehqkReqId;
	}

	/**
	 * @return the ehqkTranGbcd
	 */
	public String getEhqkTranGbcd() {
		return ehqkTranGbcd;
	}

	/**
	 * @param ehqkTranGbcd the ehqkTranGbcd to set
	 */
	public void setEhqkTranGbcd(String ehqkTranGbcd) {
		this.ehqkTranGbcd = ehqkTranGbcd;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public String getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(String searchCondition) {
        this.searchCondition = searchCondition;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchUseYn() {
        return searchUseYn;
    }

    public void setSearchUseYn(String searchUseYn) {
        this.searchUseYn = searchUseYn;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageUnit() {
        return pageUnit;
    }

    public void setPageUnit(int pageUnit) {
        this.pageUnit = pageUnit;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
