package estam.app.spt.service;

/**
 * @Class Name : SptIptnFlorVO.java
 * @Description : SptIptnFlor VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class SptIptnFlorVO extends SptIptnFlorDefaultVO {
	private static final long serialVersionUID = 1L;

	/** FCTY_CD */
	private java.lang.String fctyCd;

	/** SPT_IPTN_DT */
	private java.lang.String sptIptnDt;

	/** SPT_IPTN_FLOR_SEQ */
	private java.lang.String sptIptnFlorSeq;

	/** SPT_IPTN_FLOR_SZ */
	private java.math.BigDecimal sptIptnFlorSz;

	/** SPT_IPTN_FLOR_FLNM */
	private java.lang.String sptIptnFlorFlnm;

	/** SPT_IPTN_FLOR_FLSV */
	private java.lang.String sptIptnFlorFlsv;

	/** INPT_USR_ID */
	private java.lang.String inptUsrId;

	/** INPT_DT */
	private java.sql.Date inptDt;

	/** UPDT_USR_ID */
	private java.lang.String updtUsrId;

	/** UPDT_DT */
	private java.sql.Date updtDt;

	/** SPT_IPTN_FLOR_ORG_FLNM */
	private java.lang.String sptIptnFlorOrgFlnm;

	private java.lang.String gvmtCd;

	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.lang.String getFctyCd() {
		return this.fctyCd;
	}

	public void setFctyCd(java.lang.String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public java.lang.String getSptIptnDt() {
		return this.sptIptnDt;
	}

	public void setSptIptnDt(java.lang.String sptIptnDt) {
		this.sptIptnDt = sptIptnDt;
	}

	public java.lang.String getSptIptnFlorSeq() {
		return this.sptIptnFlorSeq;
	}

	public void setSptIptnFlorSeq(java.lang.String sptIptnFlorSeq) {
		this.sptIptnFlorSeq = sptIptnFlorSeq;
	}

	public java.math.BigDecimal getSptIptnFlorSz() {
		return this.sptIptnFlorSz;
	}

	public void setSptIptnFlorSz(java.math.BigDecimal sptIptnFlorSz) {
		this.sptIptnFlorSz = sptIptnFlorSz;
	}

	public java.lang.String getSptIptnFlorFlnm() {
		return this.sptIptnFlorFlnm;
	}

	public void setSptIptnFlorFlnm(java.lang.String sptIptnFlorFlnm) {
		this.sptIptnFlorFlnm = sptIptnFlorFlnm;
	}

	public java.lang.String getSptIptnFlorFlsv() {
		return this.sptIptnFlorFlsv;
	}

	public void setSptIptnFlorFlsv(java.lang.String sptIptnFlorFlsv) {
		this.sptIptnFlorFlsv = sptIptnFlorFlsv;
	}

	public java.lang.String getInptUsrId() {
		return this.inptUsrId;
	}

	public void setInptUsrId(java.lang.String inptUsrId) {
		this.inptUsrId = inptUsrId;
	}

	public java.sql.Date getInptDt() {
		return this.inptDt;
	}

	public void setInptDt(java.sql.Date inptDt) {
		this.inptDt = inptDt;
	}

	public java.lang.String getUpdtUsrId() {
		return this.updtUsrId;
	}

	public void setUpdtUsrId(java.lang.String updtUsrId) {
		this.updtUsrId = updtUsrId;
	}

	public java.sql.Date getUpdtDt() {
		return this.updtDt;
	}

	public void setUpdtDt(java.sql.Date updtDt) {
		this.updtDt = updtDt;
	}

	public java.lang.String getSptIptnFlorOrgFlnm() {
		return sptIptnFlorOrgFlnm;
	}

	public void setSptIptnFlorOrgFlnm(java.lang.String sptIptnFlorOrgFlnm) {
		this.sptIptnFlorOrgFlnm = sptIptnFlorOrgFlnm;
	}

}
