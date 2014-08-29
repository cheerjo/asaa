package estam.app.rpt.service;

import java.io.Serializable;
import java.util.ArrayList;

public class OverallAnalyRptDefaultVO implements Serializable {
	
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
	private java.lang.String modes;
	
	private java.lang.String chkRult;
	private java.lang.String fctyList;
	private java.lang.String dataList;
	
	private java.util.ArrayList fctyListAL;

	/**
	 * @return the searchCondition
	 */
	public String getSearchCondition() {
		return searchCondition;
	}

	/**
	 * @param searchCondition the searchCondition to set
	 */
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	/**
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}

	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	/**
	 * @return the searchUseYn
	 */
	public String getSearchUseYn() {
		return searchUseYn;
	}

	/**
	 * @param searchUseYn the searchUseYn to set
	 */
	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	/**
	 * @return the pageIndex
	 */
	public int getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the pageUnit
	 */
	public int getPageUnit() {
		return pageUnit;
	}

	/**
	 * @param pageUnit the pageUnit to set
	 */
	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the firstIndex
	 */
	public int getFirstIndex() {
		return firstIndex;
	}

	/**
	 * @param firstIndex the firstIndex to set
	 */
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	/**
	 * @return the lastIndex
	 */
	public int getLastIndex() {
		return lastIndex;
	}

	/**
	 * @param lastIndex the lastIndex to set
	 */
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	/**
	 * @return the recordCountPerPage
	 */
	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	/**
	 * @param recordCountPerPage the recordCountPerPage to set
	 */
	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
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

	/**
	 * @return the ehqkOrgArea
	 */
	public java.lang.String getEhqkOrgArea() {
		return ehqkOrgArea;
	}

	/**
	 * @param ehqkOrgArea the ehqkOrgArea to set
	 */
	public void setEhqkOrgArea(java.lang.String ehqkOrgArea) {
		this.ehqkOrgArea = ehqkOrgArea;
	}

	/**
	 * @return the nokPcnt
	 */
	public java.lang.String getNokPcnt() {
		return nokPcnt;
	}

	/**
	 * @param nokPcnt the nokPcnt to set
	 */
	public void setNokPcnt(java.lang.String nokPcnt) {
		this.nokPcnt = nokPcnt;
	}

	/**
	 * @return the okPcnt
	 */
	public java.lang.String getOkPcnt() {
		return okPcnt;
	}

	/**
	 * @param okPcnt the okPcnt to set
	 */
	public void setOkPcnt(java.lang.String okPcnt) {
		this.okPcnt = okPcnt;
	}

	/**
	 * @return the ehqkReqId
	 */
	public java.lang.String getEhqkReqId() {
		return ehqkReqId;
	}

	/**
	 * @param ehqkReqId the ehqkReqId to set
	 */
	public void setEhqkReqId(java.lang.String ehqkReqId) {
		this.ehqkReqId = ehqkReqId;
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

	/**
	 * @return the modes
	 */
	public java.lang.String getModes() {
		return modes;
	}

	/**
	 * @param modes the modes to set
	 */
	public void setModes(java.lang.String modes) {
		this.modes = modes;
	}

	/**
	 * @return the chkRult
	 */
	public java.lang.String getChkRult() {
		return chkRult;
	}

	/**
	 * @param chkRult the chkRult to set
	 */
	public void setChkRult(java.lang.String chkRult) {
		this.chkRult = chkRult;
	}

	/**
	 * @return the dataList
	 */
	public java.lang.String getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(java.lang.String dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the fctyList
	 */
	public java.lang.String getFctyList() {
		return fctyList;
	}

	/**
	 * @param fctyList the fctyList to set
	 */
	public void setFctyList(java.lang.String fctyList) {
		this.fctyList = fctyList;
	}

	/**
	 * @return the fctyListAL
	 */
	public java.util.ArrayList getFctyListAL() {
		return fctyListAL;
	}

	/**
	 * @param fctyListAL the fctyListAL to set
	 */
	public void setFctyListAL(java.util.ArrayList fctyListAL) {
		this.fctyListAL = fctyListAL;
	}
}
