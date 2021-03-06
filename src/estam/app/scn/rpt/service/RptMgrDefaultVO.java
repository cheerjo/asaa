package estam.app.scn.rpt.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : RptMgrDefaultVO.java
 * @Description : RptMgr Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.1016
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class RptMgrDefaultVO implements Serializable {
	
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
    
    /** IPT_DT */
    private java.lang.String iptDt;
     
    /** CON_DA_GBCD */
    private java.lang.String conDaGbcd;
    
    /** GVMT_CD */
    private java.lang.String gvmtCd;

    /** FCTY_AREA_CD */
    private java.lang.String fctyAreaCd;
    
    /** FCTY_KND_CD */
    private java.lang.String fctyKndCd;
    
    /** 적합여부 */
    private java.lang.String fctyUseYn;
      
    
    
	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	/**
	 * @return the iptDt
	 */
	public java.lang.String getIptDt() {
		return iptDt;
	}

	/**
	 * @param iptDt the iptDt to set
	 */
	public void setIptDt(java.lang.String iptDt) {
		this.iptDt = iptDt;
	}

	/**
	 * @return the conDaGbcd
	 */
	public java.lang.String getConDaGbcd() {
		return conDaGbcd;
	}

	/**
	 * @param conDaGbcd the conDaGbcd to set
	 */
	public void setConDaGbcd(java.lang.String conDaGbcd) {
		this.conDaGbcd = conDaGbcd;
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
	 * @return the fctyUseYn
	 */
	public java.lang.String getFctyUseYn() {
		return fctyUseYn;
	}

	/**
	 * @param fctyUseYn the fctyUseYn to set
	 */
	public void setFctyUseYn(java.lang.String fctyUseYn) {
		this.fctyUseYn = fctyUseYn;
	}

	/**
	 * @return the fctyAreaCd
	 */
	public java.lang.String getFctyAreaCd() {
		return fctyAreaCd;
	}

	/**
	 * @param fctyAreaCd the fctyAreaCd to set
	 */
	public void setFctyAreaCd(java.lang.String fctyAreaCd) {
		this.fctyAreaCd = fctyAreaCd;
	}

	/**
	 * @return the fctyKndCd
	 */
	public java.lang.String getFctyKndCd() {
		return fctyKndCd;
	}

	/**
	 * @param fctyKndCd the fctyKndCd to set
	 */
	public void setFctyKndCd(java.lang.String fctyKndCd) {
		this.fctyKndCd = fctyKndCd;
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
