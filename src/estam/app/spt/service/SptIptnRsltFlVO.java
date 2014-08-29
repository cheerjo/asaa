package estam.app.spt.service;

/**
 * @Class Name : SptIptnRsltFlVO.java
 * @Description : SptIptnRsltFl VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class SptIptnRsltFlVO extends SptIptnRsltFlDefaultVO {
	private static final long serialVersionUID = 1L;

	/** FCTY_CD */
	private java.lang.String fctyCd;

	/** SPT_IPTN_DT */
	private java.lang.String sptIptnDt;

	/** SPT_IPTN_SEQ */
	private java.math.BigDecimal sptIptnSeq;

	/** SPT_IPTN_FS_SZ */
	private java.math.BigDecimal sptIptnFsSz;

	/** SPT_IPTN_FLNM */
	private java.lang.String sptIptnFlnm;

	/** SPT_IPTN_FLSV */
	private java.lang.String sptIptnFlsv;

	/** INPT_USR_ID */
	private java.lang.String inptUsrId;

	/** INPT_DT */
	private java.sql.Date inptDt;

	/** UPDT_USR_ID */
	private java.lang.String updtUsrId;

	/** UPDT_DT */
	private java.sql.Date updtDt;

	/** SPT_IPTN_ORG_FLNM */
	private java.lang.String sptIptnOrgFlnm;

	private java.lang.String sptIptnReqtDt;

	private java.lang.String sptIptnRsltYn;

	private java.lang.String gvmtCd;
	private java.lang.String sptIptnRsltDt;

	public java.lang.String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(java.lang.String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public java.lang.String getSptIptnRsltDt() {
		return sptIptnRsltDt;
	}

	public void setSptIptnRsltDt(java.lang.String sptIptnRsltDt) {
		this.sptIptnRsltDt = sptIptnRsltDt;
	}

	public java.lang.String getSptIptnReqtDt() {
		return sptIptnReqtDt;
	}

	public void setSptIptnReqtDt(java.lang.String sptIptnReqtDt) {
		this.sptIptnReqtDt = sptIptnReqtDt;
	}

	public java.lang.String getSptIptnRsltYn() {
		return sptIptnRsltYn;
	}

	public void setSptIptnRsltYn(java.lang.String sptIptnRsltYn) {
		this.sptIptnRsltYn = sptIptnRsltYn;
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

	public java.math.BigDecimal getSptIptnSeq() {
		return this.sptIptnSeq;
	}

	public void setSptIptnSeq(java.math.BigDecimal sptIptnSeq) {
		this.sptIptnSeq = sptIptnSeq;
	}

	public java.math.BigDecimal getSptIptnFsSz() {
		return this.sptIptnFsSz;
	}

	public void setSptIptnFsSz(java.math.BigDecimal sptIptnFsSz) {
		this.sptIptnFsSz = sptIptnFsSz;
	}

	public java.lang.String getSptIptnFlnm() {
		return this.sptIptnFlnm;
	}

	public void setSptIptnFlnm(java.lang.String sptIptnFlnm) {
		this.sptIptnFlnm = sptIptnFlnm;
	}

	public java.lang.String getSptIptnFlsv() {
		return this.sptIptnFlsv;
	}

	public void setSptIptnFlsv(java.lang.String sptIptnFlsv) {
		this.sptIptnFlsv = sptIptnFlsv;
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

	public java.lang.String getSptIptnOrgFlnm() {
		return sptIptnOrgFlnm;
	}

	public void setSptIptnOrgFlnm(java.lang.String sptIptnOrgFlnm) {
		this.sptIptnOrgFlnm = sptIptnOrgFlnm;
	}

}
