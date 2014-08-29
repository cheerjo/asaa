package estam.app.com.rev;

import java.io.Serializable;

/**
 * @Class Name : ConObsMetaVO.java
 * @Description : CON_OBS_META VO class
 * @Modification Information
 * 
 * @author atres
 * @since 2014.02.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class ConObsMetaVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iptDt;
	private String fctyCd;
	private String conDaGbcd;
	private String gvmtCd;
	private String conDaFlSvch;
	private String conDaFlNm;
	private String conDaFlYn;
	private String inptUsrId;
	private String inptDt;
	private String updtUsrId;
	private String updtDt;

	public String getIptDt() {
		return iptDt;
	}

	public void setIptDt(String iptDt) {
		this.iptDt = iptDt;
	}

	public String getFctyCd() {
		return fctyCd;
	}

	public void setFctyCd(String fctyCd) {
		this.fctyCd = fctyCd;
	}

	public String getConDaGbcd() {
		return conDaGbcd;
	}

	public void setConDaGbcd(String conDaGbcd) {
		this.conDaGbcd = conDaGbcd;
	}

	public String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}

	public String getConDaFlSvch() {
		return conDaFlSvch;
	}

	public void setConDaFlSvch(String conDaFlSvch) {
		this.conDaFlSvch = conDaFlSvch;
	}

	public String getConDaFlNm() {
		return conDaFlNm;
	}

	public void setConDaFlNm(String conDaFlNm) {
		this.conDaFlNm = conDaFlNm;
	}

	public String getConDaFlYn() {
		return conDaFlYn;
	}

	public void setConDaFlYn(String conDaFlYn) {
		this.conDaFlYn = conDaFlYn;
	}

	public String getInptUsrId() {
		return inptUsrId;
	}

	public void setInptUsrId(String inptUsrId) {
		this.inptUsrId = inptUsrId;
	}

	public String getInptDt() {
		return inptDt;
	}

	public void setInptDt(String inptDt) {
		this.inptDt = inptDt;
	}

	public String getUpdtUsrId() {
		return updtUsrId;
	}

	public void setUpdtUsrId(String updtUsrId) {
		this.updtUsrId = updtUsrId;
	}

	public String getUpdtDt() {
		return updtDt;
	}

	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}

}
