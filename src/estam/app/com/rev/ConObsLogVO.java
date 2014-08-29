package estam.app.com.rev;

import java.io.Serializable;

/**
 * @Class Name : ConObsMetaVO.java
 * @Description : CON_OBS_META VO class
 * @Modification Information
 * 
 * @author kmg
 * @since 2014.02.14
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */
public class ConObsLogVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String iptDt;
	private String fctyCd;
	private String conDaGbcd;
	private String gvmtCd;
	private String executeDt;
	private String successYn;
	private String fileExistYn;

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

	public String getExecuteDt() {
		return executeDt;
	}

	public void setExecuteDt(String executeDt) {
		this.executeDt = executeDt;
	}

	public String getSuccessYn() {
		return successYn;
	}

	public void setSuccessYn(String successYn) {
		this.successYn = successYn;
	}

	public String getFileExistYn() {
		return fileExistYn;
	}

	public void setFileExistYn(String fileExistYn) {
		this.fileExistYn = fileExistYn;
	}

}
