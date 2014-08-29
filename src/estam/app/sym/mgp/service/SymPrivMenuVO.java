package estam.app.sym.mgp.service;

import java.io.Serializable;

/**
 * @Class Name : SymPrivMenuVO.java
 * @Description : SymPrivMenu VO class
 * @Modification Information
 *
 * @author ATRES
 * @since 2013.07.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class SymPrivMenuVO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /** MENU_CD */
    private java.lang.String menuCd;
    
    /** PRIV_GRP_NO */
    private java.math.BigDecimal privGrpNo;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    private java.lang.String menuNm;
    
    private java.lang.String dplyNo;
    
    private java.lang.String upMenuCd;
    
    public java.lang.String getMenuCd() {
        return this.menuCd;
    }
    
    public void setMenuCd(java.lang.String menuCd) {
        this.menuCd = menuCd;
    }
    
    public java.math.BigDecimal getPrivGrpNo() {
        return this.privGrpNo;
    }
    
    public void setPrivGrpNo(java.math.BigDecimal privGrpNo) {
        this.privGrpNo = privGrpNo;
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

	public java.lang.String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(java.lang.String menuNm) {
		this.menuNm = menuNm;
	}

	public java.lang.String getDplyNo() {
		return dplyNo;
	}

	public void setDplyNo(java.lang.String dplyNo) {
		this.dplyNo = dplyNo;
	}

	public java.lang.String getUpMenuCd() {
		return upMenuCd;
	}

	public void setUpMenuCd(java.lang.String upMenuCd) {
		this.upMenuCd = upMenuCd;
	}
    
}
