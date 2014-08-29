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
public class BarRevDataVO  implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 기관코드 */
    private java.lang.String gvmtCd;
    
    /** 기관명 */
    private java.lang.String gvmtNm;
    
    /** 계측소코드 */
    private java.lang.String fctyCd;
    
    /** 계측소명 */
    private java.lang.String fctyNm;
    
    /** 우선순위 */
    private java.lang.String fctyNo;
    
    /** 10분PGA값 */
    private java.lang.String fctyPga10;  
    
    /** 1초PGA값 */
    private java.lang.String fctyPga;
    
    /** 출력시스템시간 */
    private java.lang.String sysDataTime;
     
     
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
	 * @return the gvmtNm
	 */
	public java.lang.String getGvmtNm() {
		return gvmtNm;
	}


	/**
	 * @param gvmtNm the gvmtNm to set
	 */
	public void setGvmtNm(java.lang.String gvmtNm) {
		this.gvmtNm = gvmtNm;
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
	 * @return the fctyNm
	 */
	public java.lang.String getFctyNm() {
		return fctyNm;
	}


	/**
	 * @param fctyNm the fctyNm to set
	 */
	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
	}


	/**
	 * @return the fctyNo
	 */
	public java.lang.String getFctyNo() {
		return fctyNo;
	}


	/**
	 * @param fctyNo the fctyNo to set
	 */
	public void setFctyNo(java.lang.String fctyNo) {
		this.fctyNo = fctyNo;
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
	 * @return the sysDataTime
	 */
	public java.lang.String getSysDataTime() {
		return sysDataTime;
	}


	/**
	 * @param sysDataTime the sysDataTime to set
	 */
	public void setSysDataTime(java.lang.String sysDataTime) {
		this.sysDataTime = sysDataTime;
	}


	/**
     * toString 메소드를 대치한다.
     */
    public String toString() {
	return ToStringBuilder.reflectionToString(this);
    }
}
