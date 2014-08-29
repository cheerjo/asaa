package estam.app.iddl.service;

/**
 * @Class Name : IddlAassRlstStatsVO.java
 * @Description :IddlAassRlstStats VO class
 * @Modification Information
 *
 * @author arjoona
 * @since 2013.12.1
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

public class IddlAassRlstStatsVO extends IddlAassRlstDefaultVO {
	private static final long serialVersionUID = 1L;
	
	/** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** GVMT_CD */
    private java.lang.String gvmtCd;
    
    /** LRG_GB */
    private java.lang.String lrgGb;
    
    /** MID_GB */
    private java.lang.String midGb;
    
    /** OKS_RATE */
    private java.lang.Float oksRate;
    
    /** CHK_RATE */
    private java.lang.Float chkRate;
    
    /** OKS_CNT */
    private int oksCnt;
    
    /** CHK_CNT */
    private int chkCnt;
    
    /** TOT_CNT */
    private int totCnt;
    
    /** FCTY_AREA_CD */
    private java.lang.String fctyAreaCd;
    
    private java.lang.String iddlAassDt;
    private java.lang.String ehqkOrgTm;

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

	public java.lang.String getLrgGb() {
		return lrgGb;
	}

	public void setLrgGb(java.lang.String lrgGb) {
		this.lrgGb = lrgGb;
	}

	public java.lang.String getMidGb() {
		return midGb;
	}

	public void setMidGb(java.lang.String midGb) {
		this.midGb = midGb;
	}

	public java.lang.Float getOksRate() {
		return oksRate;
	}

	public void setOksRate(java.lang.Float oksRate) {
		this.oksRate = oksRate;
	}

	public java.lang.Float getChkRate() {
		return chkRate;
	}

	public void setChkRate(java.lang.Float chkRate) {
		this.chkRate = chkRate;
	}

	public int getOksCnt() {
		return oksCnt;
	}

	public void setOksCnt(int oksCnt) {
		this.oksCnt = oksCnt;
	}

	public int getChkCnt() {
		return chkCnt;
	}

	public void setChkCnt(int chkCnt) {
		this.chkCnt = chkCnt;
	}

	public int getTotCnt() {
		return totCnt;
	}

	public void setTotCnt(int totCnt) {
		this.totCnt = totCnt;
	}

	public java.lang.String getFctyAreaCd() {
		return fctyAreaCd;
	}

	public void setFctyAreaCd(java.lang.String fctyAreaCd) {
		this.fctyAreaCd = fctyAreaCd;
	}

	/**
	 * @return the iddlAassDt
	 */
	public java.lang.String getIddlAassDt() {
		return iddlAassDt;
	}

	/**
	 * @param iddlAassDt the iddlAassDt to set
	 */
	public void setIddlAassDt(java.lang.String iddlAassDt) {
		this.iddlAassDt = iddlAassDt;
	}

	/**
	 * @return the ehqkOrgTm
	 */
	public java.lang.String getEhqkOrgTm() {
		return ehqkOrgTm;
	}

	/**
	 * @param ehqkOrgTm the ehqkOrgTm to set
	 */
	public void setEhqkOrgTm(java.lang.String ehqkOrgTm) {
		this.ehqkOrgTm = ehqkOrgTm;
	}
    
}
