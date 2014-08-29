package estam.app.spt.service;

import java.util.List;

/**
 * @Class Name : SptIptnRccVO.java
 * @Description : SptIptnRcc VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class SptIptnRccVO extends SptIptnRccDefaultVO {
	private static final long serialVersionUID = 1L;

	/** FCTY_CD */
	private java.lang.String fctyCd;

	/** RCC_ID */
	private java.lang.String rccId;

	/** SPT_IPTN_DT */
	private java.lang.String sptIptnDt;

	/** RCC_CMPY */
	private java.lang.String rccCmpy;

	/** RCC_MDL */
	private java.lang.String rccMdl;

	/** RCC_ISTL_POS */
	private java.lang.String rccIstlPos;

	/** RCC_SCN_NM */
	private java.lang.String rccScnNm;

	/** RCC_AUTH_INTT */
	private java.lang.String rccAuthIntt;

	/** EHQK_RCC_AUTH_DT */
	private java.lang.String ehqkRccAuthDt;

	/** EHQK_RCC_TERM */
	private java.lang.String ehqkRccTerm;

	/** EHQK_RCC_DELI_DT */
	private java.lang.String ehqkRccDeliDt;

	/** INPT_USR_ID */
	private java.lang.String inptUsrId;

	/** INPT_DT */
	private java.sql.Date inptDt;

	/** UPDT_USR_ID */
	private java.lang.String updtUsrId;

	/** UPDT_DT */
	private java.sql.Date updtDt;

	private java.lang.String gvmtCd;

	private List<SptIptnRccVO> sirvList;

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

	public java.lang.String getRccId() {
		return this.rccId;
	}

	public void setRccId(java.lang.String rccId) {
		this.rccId = rccId;
	}

	public java.lang.String getSptIptnDt() {
		return this.sptIptnDt;
	}

	public void setSptIptnDt(java.lang.String sptIptnDt) {
		this.sptIptnDt = sptIptnDt;
	}

	public java.lang.String getRccCmpy() {
		return this.rccCmpy;
	}

	public void setRccCmpy(java.lang.String rccCmpy) {
		this.rccCmpy = rccCmpy;
	}

	public java.lang.String getRccMdl() {
		return this.rccMdl;
	}

	public void setRccMdl(java.lang.String rccMdl) {
		this.rccMdl = rccMdl;
	}

	public java.lang.String getRccIstlPos() {
		return this.rccIstlPos;
	}

	public void setRccIstlPos(java.lang.String rccIstlPos) {
		this.rccIstlPos = rccIstlPos;
	}

	public java.lang.String getRccScnNm() {
		return this.rccScnNm;
	}

	public void setRccScnNm(java.lang.String rccScnNm) {
		this.rccScnNm = rccScnNm;
	}

	public java.lang.String getRccAuthIntt() {
		return this.rccAuthIntt;
	}

	public void setRccAuthIntt(java.lang.String rccAuthIntt) {
		this.rccAuthIntt = rccAuthIntt;
	}

	public java.lang.String getEhqkRccAuthDt() {
		return this.ehqkRccAuthDt;
	}

	public void setEhqkRccAuthDt(java.lang.String ehqkRccAuthDt) {
		this.ehqkRccAuthDt = ehqkRccAuthDt;
	}

	public java.lang.String getEhqkRccTerm() {
		return this.ehqkRccTerm;
	}

	public void setEhqkRccTerm(java.lang.String ehqkRccTerm) {
		this.ehqkRccTerm = ehqkRccTerm;
	}

	public java.lang.String getEhqkRccDeliDt() {
		return this.ehqkRccDeliDt;
	}

	public void setEhqkRccDeliDt(java.lang.String ehqkRccDeliDt) {
		this.ehqkRccDeliDt = ehqkRccDeliDt;
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

	public List<SptIptnRccVO> getSirvList() {
		return sirvList;
	}

	public void setSirvList(List<SptIptnRccVO> sirvList) {
		this.sirvList = sirvList;
	}

}
