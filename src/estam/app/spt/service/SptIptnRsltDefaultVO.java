package estam.app.spt.service;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : SptIptnRsltDefaultVO.java
 * @Description : SptIptnRslt Default VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class SptIptnRsltDefaultVO implements Serializable {

	/** 검색조건 */
	private String searchCondition = "";

	/** 검색Keyword */
	private String searchKeyword = "";

	/** 검색사용여부 */
	private String searchUseYn = "";

	/** 검색사용여부 */
	private String searchUseYn2 = "";

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

	/** CON_DA_GBCD */
	private java.lang.String conDaGbcd;

	/** FCTY_AREA_CD */
	private java.lang.String fctyAreaCd;

	/** FCTY_KND_CD */
	private java.lang.String fctyKndCd;

	/** 적합여부 */
	private java.lang.String fctyUseYn;

	private java.lang.String gvmtCd;

	private java.lang.String sptIptnSDt;
	private java.lang.String sptIptnEDt;

	private java.lang.String fctyCplnSDt;
	private java.lang.String fctyCplnEDt;

	private java.lang.String sptIptnRsltYn;

	private java.lang.String fctyCd;

	private java.lang.String sptInptDt;
	private java.lang.String sptIptnDt;

	private java.lang.String seq;

	public java.lang.String getSptInptDt() {
		return sptInptDt;
	}

	public void setSptInptDt(java.lang.String sptInptDt) {
		this.sptInptDt = sptInptDt;
	}

	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.lang.String getFctyCd() {
		return fctyCd;
	}

	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public java.lang.String getSptIptnRsltYn() {
		return sptIptnRsltYn;
	}

	public void setSptIptnRsltYn(java.lang.String sptIptnRsltYn) {
		this.sptIptnRsltYn = sptIptnRsltYn;
	}

	public java.lang.String getSptIptnSDt() {
		return sptIptnSDt;
	}

	public void setSptIptnSDt(java.lang.String sptIptnSDt) {
		this.sptIptnSDt = sptIptnSDt;
	}

	public java.lang.String getSptIptnEDt() {
		return sptIptnEDt;
	}

	public void setSptIptnEDt(java.lang.String sptIptnEDt) {
		this.sptIptnEDt = sptIptnEDt;
	}

	public java.lang.String getFctyCplnSDt() {
		return fctyCplnSDt;
	}

	public void setFctyCplnSDt(java.lang.String fctyCplnSDt) {
		this.fctyCplnSDt = fctyCplnSDt;
	}

	public java.lang.String getFctyCplnEDt() {
		return fctyCplnEDt;
	}

	public void setFctyCplnEDt(java.lang.String fctyCplnEDt) {
		this.fctyCplnEDt = fctyCplnEDt;
	}

	public java.lang.String getConDaGbcd() {
		return conDaGbcd;
	}

	public void setConDaGbcd(java.lang.String conDaGbcd) {
		this.conDaGbcd = conDaGbcd;
	}

	public java.lang.String getFctyAreaCd() {
		return fctyAreaCd;
	}

	public void setFctyAreaCd(java.lang.String fctyAreaCd) {
		this.fctyAreaCd = fctyAreaCd;
	}

	public java.lang.String getFctyKndCd() {
		return fctyKndCd;
	}

	public void setFctyKndCd(java.lang.String fctyKndCd) {
		this.fctyKndCd = fctyKndCd;
	}

	public java.lang.String getFctyUseYn() {
		return fctyUseYn;
	}

	public void setFctyUseYn(java.lang.String fctyUseYn) {
		this.fctyUseYn = fctyUseYn;
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

	public String getSearchUseYn2() {
		return searchUseYn2;
	}

	public void setSearchUseYn2(String searchUseYn2) {
		this.searchUseYn2 = searchUseYn2;
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

	/**
	 * @return the sptIptnDt
	 */
	public java.lang.String getSptIptnDt() {
		return sptIptnDt;
	}

	/**
	 * @param sptIptnDt
	 *            the sptIptnDt to set
	 */
	public void setSptIptnDt(java.lang.String sptIptnDt) {
		this.sptIptnDt = sptIptnDt;
	}

	/**
	 * @return the seq
	 */
	public java.lang.String getSeq() {
		return seq;
	}

	/**
	 * @param seq
	 *            the seq to set
	 */
	public void setSeq(java.lang.String seq) {
		this.seq = seq;
	}

}
