package estam.app.spt.service;

import java.util.List;

/**
 * @Class Name : SptIptnScnVO.java
 * @Description : SptIptnScn VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2013.10.17
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class SptIptnScnVO extends SptIptnScnDefaultVO {
	private static final long serialVersionUID = 1L;

	/** FCTY_CD */
	private java.lang.String fctyCd;

	/** GVMT_CD */
	private java.lang.String gvmtCd;

	/** EHQK_SCN_ID */
	private java.lang.String ehqkScnId;

	/** SPT_IPTN_DT */
	private java.lang.String sptIptnDt;

	/** EHQK_SCN_CMPY */
	private java.lang.String ehqkScnCmpy;

	/** EHQK_SCN_MDL */
	private java.lang.String ehqkScnMdl;

	/** EHQK_SCN_ISTL_POS */
	private java.lang.String ehqkScnIstlPos;

	/** EHQK_SCN_CHL */
	private java.lang.String ehqkScnChl;

	/** EHQK_SCN_AUTH_INTT */
	private java.lang.String ehqkScnAuthIntt;

	/** EHQK_SCN_AUTH_DT */
	private java.lang.String ehqkScnAuthDt;

	/** EHQK_SCN_TERM */
	private java.lang.String ehqkScnTerm;

	/** EHQK_DELI_DT */
	private java.lang.String ehqkDeliDt;

	/** INPT_USR_ID */
	private java.lang.String inptUsrId;

	/** INPT_DT */
	private java.sql.Date inptDt;

	/** UPDT_USR_ID */
	private java.lang.String updtUsrId;

	/** UPDT_DT */
	private java.sql.Date updtDt;

	private java.lang.String ehqkScnMdlList;
	private java.lang.String ehqkScnIstlPosList;
	private java.lang.String ehqkScnChlList;
	private java.lang.String ehqkScnCmpyList;
	private java.lang.String ehqkScnAuthInttList;

	private List<SptIptnScnVO> sisvList;

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

	public java.lang.String getEhqkScnId() {
		return this.ehqkScnId;
	}

	public void setEhqkScnId(java.lang.String ehqkScnId) {
		this.ehqkScnId = ehqkScnId;
	}

	public java.lang.String getSptIptnDt() {
		return this.sptIptnDt;
	}

	public void setSptIptnDt(java.lang.String sptIptnDt) {
		this.sptIptnDt = sptIptnDt;
	}

	public java.lang.String getEhqkScnCmpy() {
		return this.ehqkScnCmpy;
	}

	public void setEhqkScnCmpy(java.lang.String ehqkScnCmpy) {
		this.ehqkScnCmpy = ehqkScnCmpy;
	}

	public java.lang.String getEhqkScnMdl() {
		return this.ehqkScnMdl;
	}

	public void setEhqkScnMdl(java.lang.String ehqkScnMdl) {
		this.ehqkScnMdl = ehqkScnMdl;
	}

	public java.lang.String getEhqkScnIstlPos() {
		return this.ehqkScnIstlPos;
	}

	public void setEhqkScnIstlPos(java.lang.String ehqkScnIstlPos) {
		this.ehqkScnIstlPos = ehqkScnIstlPos;
	}

	public java.lang.String getEhqkScnChl() {
		return this.ehqkScnChl;
	}

	public void setEhqkScnChl(java.lang.String ehqkScnChl) {
		this.ehqkScnChl = ehqkScnChl;
	}

	public java.lang.String getEhqkScnAuthIntt() {
		return this.ehqkScnAuthIntt;
	}

	public void setEhqkScnAuthIntt(java.lang.String ehqkScnAuthIntt) {
		this.ehqkScnAuthIntt = ehqkScnAuthIntt;
	}

	public java.lang.String getEhqkScnAuthDt() {
		return this.ehqkScnAuthDt;
	}

	public void setEhqkScnAuthDt(java.lang.String ehqkScnAuthDt) {
		this.ehqkScnAuthDt = ehqkScnAuthDt;
	}

	public java.lang.String getEhqkScnTerm() {
		return this.ehqkScnTerm;
	}

	public void setEhqkScnTerm(java.lang.String ehqkScnTerm) {
		this.ehqkScnTerm = ehqkScnTerm;
	}

	public java.lang.String getEhqkDeliDt() {
		return this.ehqkDeliDt;
	}

	public void setEhqkDeliDt(java.lang.String ehqkDeliDt) {
		this.ehqkDeliDt = ehqkDeliDt;
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

	public java.lang.String getEhqkScnMdlList() {
		return ehqkScnMdlList;
	}

	public void setEhqkScnMdlList(java.lang.String ehqkScnMdlList) {
		this.ehqkScnMdlList = ehqkScnMdlList;
	}

	public java.lang.String getEhqkScnIstlPosList() {
		return ehqkScnIstlPosList;
	}

	public void setEhqkScnIstlPosList(java.lang.String ehqkScnIstlPosList) {
		this.ehqkScnIstlPosList = ehqkScnIstlPosList;
	}

	public java.lang.String getEhqkScnChlList() {
		return ehqkScnChlList;
	}

	public void setEhqkScnChlList(java.lang.String ehqkScnChlList) {
		this.ehqkScnChlList = ehqkScnChlList;
	}

	public java.lang.String getEhqkScnCmpyList() {
		return ehqkScnCmpyList;
	}

	public void setEhqkScnCmpyList(java.lang.String ehqkScnCmpyList) {
		this.ehqkScnCmpyList = ehqkScnCmpyList;
	}

	public java.lang.String getEhqkScnAuthInttList() {
		return ehqkScnAuthInttList;
	}

	public void setEhqkScnAuthInttList(java.lang.String ehqkScnAuthInttList) {
		this.ehqkScnAuthInttList = ehqkScnAuthInttList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<SptIptnScnVO> getSisvList() {
		return sisvList;
	}

	public void setSisvList(List<SptIptnScnVO> sisvList) {
		this.sisvList = sisvList;
	}

}
