package estam.app.com.rev;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @Class Name : SymCommCdDtlVO.java
 * @Description : SymCommCdDtl VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.07.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class BarRevTpPgaVO  implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 기관코드 */
    private java.lang.String gvmtCd;
     
    /** 계측소자유장 */
    private java.lang.String mmaFctyCd; 
    
    /** 10분PGA값 */
    private java.lang.String fctyPga10;  
    
    /** 1초PGA값 */
    private java.lang.String fctyTotPga; 
    
    private java.lang.String  fctyPga;
    
    /** 10분PGA값 */
    private java.lang.String fctyTotPga10;

	/**
	 * @return the fctyPga
	 */
	public java.lang.String getFctyPga() {
		return fctyPga;
	}

	/**
	 * @param fctyPga the fctyPga to set
	 */
	public void setFctyPga(java.lang.String fctyPga) {
		this.fctyPga = fctyPga;
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
	 * @return the mmaFctyCd
	 */
	public java.lang.String getMmaFctyCd() {
		return mmaFctyCd;
	}

	/**
	 * @param mmaFctyCd the mmaFctyCd to set
	 */
	public void setMmaFctyCd(java.lang.String mmaFctyCd) {
		this.mmaFctyCd = mmaFctyCd;
	}

	/**
	 * @return the fctyPga10
	 */
	public java.lang.String getFctyPga10() {
		return fctyPga10;
	}

	/**
	 * @param fctyPga10 the fctyPga10 to set
	 */
	public void setFctyPga10(java.lang.String fctyPga10) {
		this.fctyPga10 = fctyPga10;
	}

	/**
	 * @return the fctyTotPga
	 */
	public java.lang.String getFctyTotPga() {
		return fctyTotPga;
	}

	/**
	 * @param fctyTotPga the fctyTotPga to set
	 */
	public void setFctyTotPga(java.lang.String fctyTotPga) {
		this.fctyTotPga = fctyTotPga;
	}

	/**
	 * @return the fctyTotPga10
	 */
	public java.lang.String getFctyTotPga10() {
		return fctyTotPga10;
	}

	/**
	 * @param fctyTotPga10 the fctyTotPga10 to set
	 */
	public void setFctyTotPga10(java.lang.String fctyTotPga10) {
		this.fctyTotPga10 = fctyTotPga10;
	} 
    
    
      
}
