package estam.app.iddl.service;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : IddlAassInfoDefaultVO.java
 * @Description : IddlAassInfo Default VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class IddlAassInfoDefaultVO implements Serializable {
	
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
    
    /** IDDL_AASS_NO */
    private java.math.BigDecimal iddlAassNo;
    
    /** EHQK_ORG_AREA */
    private java.lang.String ehqkOrgArea;
    
    /** NOK_PCNT */
    private java.lang.String nokPcnt;
    
    /** OK_PCNT */
    private java.lang.String okPcnt;
    
    private java.lang.String ehqkReqId;
    private java.lang.String ehqkTranGbcd;
    
    private java.lang.String winType;

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

	public java.lang.String getFctyCd() {
		return fctyCd;
	}

	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.math.BigDecimal getIddlAassNo() {
		return iddlAassNo;
	}

	public void setIddlAassNo(java.math.BigDecimal iddlAassNo) {
		this.iddlAassNo = iddlAassNo;
	}

	public java.lang.String getEhqkOrgArea() {
		return ehqkOrgArea;
	}

	public void setEhqkOrgArea(java.lang.String ehqkOrgArea) {
		this.ehqkOrgArea = ehqkOrgArea;
	}

	public java.lang.String getNokPcnt() {
		return nokPcnt;
	}

	public void setNokPcnt(java.lang.String nokPcnt) {
		this.nokPcnt = nokPcnt;
	}

	public java.lang.String getOkPcnt() {
		return okPcnt;
	}

	public void setOkPcnt(java.lang.String okPcnt) {
		this.okPcnt = okPcnt;
	}

	public java.lang.String getEhqkReqId() {
		return ehqkReqId;
	}

	public void setEhqkReqId(java.lang.String ehqkReqId) {
		this.ehqkReqId = ehqkReqId;
	}

	/**
	 * @return the winType
	 */
	public java.lang.String getWinType() {
		return winType;
	}

	/**
	 * @param winType the winType to set
	 */
	public void setWinType(java.lang.String winType) {
		this.winType = winType;
	}

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
    
    

}
