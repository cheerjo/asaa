package estam.app.iddl.service;

/**
 * @Class Name : FctyListInspVO.java
 * @Description : FctyListInsp VO class
 * @Modification Information
 *
 * @author arjoona
 * @since 2013.12.1
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

public class FctyListInspVO extends IddlAassRlstDefaultVO {
	private static final long serialVersionUID = 1L;
	
	/** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** GVMT_CD */
    private java.lang.String gvmtCd;
    
    /** FCTY_NM */
    private java.lang.String fctyNm;
    
    /** COMM_DTL_NM */
    private java.lang.String commDtlNm;
    
    /** FCTY_AREA_CD */
    private java.lang.String fctyAreaCd;
    
    
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

	public java.lang.String getFctyNm() {
		return fctyNm;
	}

	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
	}

	public java.lang.String getCommDtlNm() {
		return commDtlNm;
	}

	public void setCommDtlNm(java.lang.String commDtlNm) {
		this.commDtlNm = commDtlNm;
	}

	public java.lang.String getFctyAreaCd() {
		return fctyAreaCd;
	}

	public void setFctyAreaCd(java.lang.String fctyAreaCd) {
		this.fctyAreaCd = fctyAreaCd;
	}    
    
}
