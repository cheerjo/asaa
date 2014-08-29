package estam.app.scn.mma.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : ConMmaDataDefaultVO.java
 * @Description : ConMmaData Default VO class
 * @Modification Information
 *
 * @author ates
 * @since 2013.10.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ConMmaDataDefaultVO implements Serializable {
	
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
    
    /** 기관코드 */
    private java.lang.String gvmtCd;
     
    /** 계측소자유장 */
    private java.lang.String mmaFctyLocVal;
       
    /** 시작시간 */
    private java.lang.String startDataTime; 
    
    /** 종료시간 */
    private java.lang.String endDataTime;  
        
    private java.lang.String  mmaFctyCd;
    
    
	/**
	 * @return the mmaFctyCd
	 */
	public java.lang.String getMmaFctyCd() {
		return mmaFctyCd;
	}

	/**
	 * @param mmaFctyCd the mmaFctyCd to set
	 */
	public void setMmaFctyCd(java.lang.String mmaFctyCd) {
		this.mmaFctyCd = mmaFctyCd;
	}

	/**
	 * @return the gvmtCd
	 */
	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	/**
	 * @param gvmtCd the gvmtCd to set
	 */
	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	/**
	 * @return the mmaFctyLocVal
	 */
	public java.lang.String getMmaFctyLocVal() {
		return mmaFctyLocVal;
	}

	/**
	 * @param mmaFctyLocVal the mmaFctyLocVal to set
	 */
	public void setMmaFctyLocVal(java.lang.String mmaFctyLocVal) {
		this.mmaFctyLocVal = mmaFctyLocVal;
	}

	/**
	 * @return the startDataTime
	 */
	public java.lang.String getStartDataTime() {
		return startDataTime;
	}

	/**
	 * @param startDataTime the startDataTime to set
	 */
	public void setStartDataTime(java.lang.String startDataTime) {
		this.startDataTime = startDataTime;
	}

	/**
	 * @return the endDataTime
	 */
	public java.lang.String getEndDataTime() {
		return endDataTime;
	}

	/**
	 * @param endDataTime the endDataTime to set
	 */
	public void setEndDataTime(java.lang.String endDataTime) {
		this.endDataTime = endDataTime;
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
