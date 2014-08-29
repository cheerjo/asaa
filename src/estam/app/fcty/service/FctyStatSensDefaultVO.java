package estam.app.fcty.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : FctyStatSensDefaultVO.java
 * @Description : FctyStatSens Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class FctyStatSensDefaultVO implements Serializable {
	
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
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** GVMT_CD */
    private java.lang.String gvmtCd;
    
    /** FCTY_STAT_SENS_GBCD */
    private java.lang.String fctyStatSensGbcd;
    
    
    
	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	/**
	 * @return the fctyCd
	 */
	public java.lang.String getFctyCd() {
		return fctyCd;
	}

	/**
	 * @param fctyCd the fctyCd to set
	 */
	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	/**
	 * @return the fctyStatSensGbcd
	 */
	public java.lang.String getFctyStatSensGbcd() {
		return fctyStatSensGbcd;
	}

	/**
	 * @param fctyStatSensGbcd the fctyStatSensGbcd to set
	 */
	public void setFctyStatSensGbcd(java.lang.String fctyStatSensGbcd) {
		this.fctyStatSensGbcd = fctyStatSensGbcd;
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
