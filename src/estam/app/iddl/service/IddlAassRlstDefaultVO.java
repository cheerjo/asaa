package estam.app.iddl.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : IddlAassRlstDefaultVO.java
 * @Description : IddlAassRlst Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class IddlAassRlstDefaultVO implements Serializable {
	
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
    
    private String gvmtCd;
    
    private String modes;
    
    
	public String getModes() {
		return modes;
	}

	public void setModes(String modes) {
		this.modes = modes;
	}

	public String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(String gvmtCd) {
		this.gvmtCd = gvmtCd;
	} 

	/** FCTY_CD */
    private java.lang.String fctyCd;
     
    
    /** IDDL_AASS_NO */
    private java.math.BigDecimal iddlAassNo;
    
    private java.lang.String ehqkReqId;
    
    private java.lang.String ehqkTranGbcd; 
    
   	/**
	 * @return the ehqkTranGbcd
	 */
	public java.lang.String getEhqkTranGbcd() {
		return ehqkTranGbcd;
	}

	/**
	 * @param ehqkTranGbcd the ehqkTranGbcd to set
	 */
	public void setEhqkTranGbcd(java.lang.String ehqkTranGbcd) {
		this.ehqkTranGbcd = ehqkTranGbcd;
	}

	public java.lang.String getEhqkReqId() {
		return ehqkReqId;
	}

	public void setEhqkReqId(java.lang.String ehqkReqId) {
		this.ehqkReqId = ehqkReqId;
	}    
        
	/**
	 * @return the iddlAassNo
	 */
	public java.math.BigDecimal getIddlAassNo() {
		return iddlAassNo;
	}

	/**
	 * @param iddlAassNo the iddlAassNo to set
	 */
	public void setIddlAassNo(java.math.BigDecimal iddlAassNo) {
		this.iddlAassNo = iddlAassNo;
	}

	public java.lang.String getFctyCd() {
		return fctyCd;
	}

	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
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
