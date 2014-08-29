package estam.app.iddl.service;

/**
 * @Class Name : IddlAassRlstVO.java
 * @Description : IddlAassRlst VO class
 * @Modification Information
 *
 * @author atres
 * @since 2013.10.16
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class IddlAassRlstVO extends IddlAassRlstDefaultVO{
    private static final long serialVersionUID = 1L;
    
    /** FCTY_CD */
    private java.lang.String fctyCd;
    
    /** IDDL_AASS_NO */
    private java.math.BigDecimal iddlAassNo;
    
    /** RSLT_MAX_IDR_X */
    private java.lang.String rsltMaxIdrX;
    
    /** RSLT_MAX_IDR_Y */
    private java.lang.String rsltMaxIdrY;
    
    /** RSLT_OVR_ACC_X */
    private java.lang.String rsltOvrAccX;
    
    /** RSLT_OVR_ACC_Y */
    private java.lang.String rsltOvrAccY;
    
    /** RSLT_NAT_FRQ_MV_X */
    private java.lang.String rsltNatFrqMvX;
    
    /** RSLT_NAT_FRQ_MV_Y */
    private java.lang.String rsltNatFrqMvY;
    
    /** RSLT_STR_FREE_NAT_FRQ_X */
    private java.lang.String rsltStrFreeNatFrqX;
    
    /** RSLT_STR_FREE_NAT_FRQ_Y */
    private java.lang.String rsltStrFreeNatFrqY;
    
    /** SF_CHK_MAX_IDR_X_RSLT */
    private java.lang.String sfChkMaxIdrXRslt;
    
    /** SF_CHK_MAX_IDR_Y_RSLT */
    private java.lang.String sfChkMaxIdrYRslt;
    
    /** SF_CHK_NAT_FRQ_MV_X_RSLT */
    private java.lang.String sfChkNatFrqMvXRslt;
    
    /** SF_CHK_NAT_FRQ_MV_Y_RSLT */
    private java.lang.String sfChkNatFrqMvYRslt;
    
    /** SF_CHK_STR_FREE_NAT_FRQ_X */
    private java.lang.String sfChkStrFreeNatFrqX;
    
    /** SF_CHK_STR_FREE_NAT_FRQ_Y */
    private java.lang.String sfChkStrFreeNatFrqY;
    
    /** SF_CHK_OVR_ACC_X_RSLT */
    private java.lang.String sfChkOvrAccXRslt;
    
    /** SF_CHK_OVR_ACC_Y_RSLT */
    private java.lang.String sfChkOvrAccYRslt;
    
    /** DATA_FREE_MAX_DISP_X */
    private java.lang.String dataFreeMaxDispX;
    
    /** DATA_FREE_MAX_DISP_Y */
    private java.lang.String dataFreeMaxDispY;
    
    /** DATA_TOP_REL_MAX_SPED_X */
    private java.lang.String dataTopRelMaxSpedX;
    
    /** DATA_TOP_REL_MAX_SPED_Y */
    private java.lang.String dataTopRelMaxSpedY;
    
    /** DATA_TOP_REL_MAX_DISP_X */
    private java.lang.String dataTopRelMaxDispX;
    
    /** DATA_TOP_REL_MAX_DISP_Y */
    private java.lang.String dataTopRelMaxDispY;
    
    /** DATA_FREE_ACC_X */
    private java.lang.String dataFreeAccX;
    
    /** DATA_FREE_ACC_Y */
    private java.lang.String dataFreeAccY;
    
    /** DATA_FREE_ACC_Z */
    private java.lang.String dataFreeAccZ;
    
    /** DATA_STR_BOT_ACC_X */
    private java.lang.String dataStrBotAccX;
    
    /** DATA_STR_BOT_ACC_Y */
    private java.lang.String dataStrBotAccY;
    
    /** DATA_STR_BOT_ACC_Z */
    private java.lang.String dataStrBotAccZ;
    
    /** DATA_STR_MID_ACC_X */
    private java.lang.String dataStrMidAccX;
    
    /** DATA_STR_MID_ACC_Y1 */
    private java.lang.String dataStrMidAccY1;
    
    /** DATA_STR_MID_ACC_Y2 */
    private java.lang.String dataStrMidAccY2;
    
    /** DATA_STR_TOP_ACC_X */
    private java.lang.String dataStrTopAccX;
    
    /** DATA_STR_TOP_ACC_Y1 */
    private java.lang.String dataStrTopAccY1;
    
    /** DATA_STR_TOP_ACC_Y2 */
    private java.lang.String dataStrTopAccY2;
    
    /** DATA_STR_FRQ_X */
    private java.lang.String dataStrFrqX;
    
    /** DATA_STR_FRQ_Y */
    private java.lang.String dataStrFrqY;
    
    /** DATA_FREE_FRQ */
    private java.lang.String dataFreeFrq;
    
    /** INPT_USR_ID */
    private java.lang.String inptUsrId;
    
    /** INPT_DT */
    private java.sql.Date inptDt;
    
    /** UPDT_USR_ID */
    private java.lang.String updtUsrId;
    
    /** UPDT_DT */
    private java.sql.Date updtDt;
    
    private String gvmtCd;
    
    private java.lang.String rsltOvrAccVal;
    private java.lang.String dataFreeAccHorz;
    private java.lang.String dataFreeAccSpedX;
    private java.lang.String dataFreeAccSpedY;
    private java.lang.String dataFreeAccSpedZ;
    private java.lang.String dataFreeAccSpedHorz;
    private java.lang.String dataFreeAccDispX;
    private java.lang.String dataFreeAccDispY;
    private java.lang.String dataFreeAccDispZ;        		
    private java.lang.String dataFreeAccDispHorz;
    private java.lang.String dataStrBotSpedX;
    private java.lang.String dataStrBotSpedY;
    private java.lang.String dataStrBotDispX;
    private java.lang.String dataStrBotDispY;
    private java.lang.String dataStrMidSpedX;
    private java.lang.String dataStrMidSpedY;
    private java.lang.String dataStrMidDispX;
    private java.lang.String dataStrMidDispY;
    private java.lang.String dataStrTopSpedX;
    private java.lang.String dataStrTopSpedY;
    private java.lang.String dataStrTopDispX;
    private java.lang.String dataStrTopDispY;  
    
    private java.lang.String dataFreeAccDisp;
    private java.lang.String smfSf;
    private java.lang.String sefSf;
    private java.lang.String rcfSf;
    private java.lang.String rcswSf;
    private java.lang.String natFrqRng;
    private java.lang.String strFreeNatFrqRng;
    private java.lang.String ovrAccRng;
    private java.lang.String fctyNm;
    private java.lang.String fctyHt;
    private java.lang.String fctyStrTycd;
    private java.lang.String moniFreeNrfy;
    private java.lang.String moniMjNrfy;
    private java.lang.String moniShotNrfy;
    private java.lang.String iddlAassInfoSf;
    
    
    private java.lang.String maxDataFreeAcc;


    
    public java.lang.String getIddlAassInfoSf() {
		return iddlAassInfoSf;
	}

	public void setIddlAassInfoSf(java.lang.String iddlAassInfoSf) {
		this.iddlAassInfoSf = iddlAassInfoSf;
	}

	public java.lang.String getMoniMjNrfy() {
		return moniMjNrfy;
	}

	public void setMoniMjNrfy(java.lang.String moniMjNrfy) {
		this.moniMjNrfy = moniMjNrfy;
	}

	public java.lang.String getMoniShotNrfy() {
		return moniShotNrfy;
	}

	public void setMoniShotNrfy(java.lang.String moniShotNrfy) {
		this.moniShotNrfy = moniShotNrfy;
	}

	public java.lang.String getMoniFreeNrfy() {
		return moniFreeNrfy;
	}

	public void setMoniFreeNrfy(java.lang.String moniFreeNrfy) {
		this.moniFreeNrfy = moniFreeNrfy;
	}

	public java.lang.String getDataFreeAccDisp() {
		return dataFreeAccDisp;
	}

	public void setDataFreeAccDisp(java.lang.String dataFreeAccDisp) {
		this.dataFreeAccDisp = dataFreeAccDisp;
	}

	public java.lang.String getSmfSf() {
		return smfSf;
	}

	public void setSmfSf(java.lang.String smfSf) {
		this.smfSf = smfSf;
	}

	public java.lang.String getSefSf() {
		return sefSf;
	}

	public void setSefSf(java.lang.String sefSf) {
		this.sefSf = sefSf;
	}

	public java.lang.String getRcfSf() {
		return rcfSf;
	}

	public void setRcfSf(java.lang.String rcfSf) {
		this.rcfSf = rcfSf;
	}

	public java.lang.String getRcswSf() {
		return rcswSf;
	}

	public void setRcswSf(java.lang.String rcswSf) {
		this.rcswSf = rcswSf;
	}

	public java.lang.String getNatFrqRng() {
		return natFrqRng;
	}

	public void setNatFrqRng(java.lang.String natFrqRng) {
		this.natFrqRng = natFrqRng;
	}

	public java.lang.String getStrFreeNatFrqRng() {
		return strFreeNatFrqRng;
	}

	public void setStrFreeNatFrqRng(java.lang.String strFreeNatFrqRng) {
		this.strFreeNatFrqRng = strFreeNatFrqRng;
	}

	public java.lang.String getOvrAccRng() {
		return ovrAccRng;
	}

	public void setOvrAccRng(java.lang.String ovrAccRng) {
		this.ovrAccRng = ovrAccRng;
	}

	public java.lang.String getFctyNm() {
		return fctyNm;
	}

	public void setFctyNm(java.lang.String fctyNm) {
		this.fctyNm = fctyNm;
	}

	public java.lang.String getFctyHt() {
		return fctyHt;
	}

	public void setFctyHt(java.lang.String fctyHt) {
		this.fctyHt = fctyHt;
	}

	public java.lang.String getFctyStrTycd() {
		return fctyStrTycd;
	}

	public void setFctyStrTycd(java.lang.String fctyStrTycd) {
		this.fctyStrTycd = fctyStrTycd;
	}

	public java.lang.String getRsltOvrAccVal() {
		return rsltOvrAccVal;
	}

	public void setRsltOvrAccVal(java.lang.String rsltOvrAccVal) {
		this.rsltOvrAccVal = rsltOvrAccVal;
	}

	public java.lang.String getDataFreeAccHorz() {
		return dataFreeAccHorz;
	}

	public void setDataFreeAccHorz(java.lang.String dataFreeAccHorz) {
		this.dataFreeAccHorz = dataFreeAccHorz;
	}

	public java.lang.String getDataFreeAccSpedX() {
		return dataFreeAccSpedX;
	}

	public void setDataFreeAccSpedX(java.lang.String dataFreeAccSpedX) {
		this.dataFreeAccSpedX = dataFreeAccSpedX;
	}

	public java.lang.String getDataFreeAccSpedY() {
		return dataFreeAccSpedY;
	}

	public void setDataFreeAccSpedY(java.lang.String dataFreeAccSpedY) {
		this.dataFreeAccSpedY = dataFreeAccSpedY;
	}

	public java.lang.String getDataFreeAccSpedZ() {
		return dataFreeAccSpedZ;
	}

	public void setDataFreeAccSpedZ(java.lang.String dataFreeAccSpedZ) {
		this.dataFreeAccSpedZ = dataFreeAccSpedZ;
	}

	public java.lang.String getDataFreeAccSpedHorz() {
		return dataFreeAccSpedHorz;
	}

	public void setDataFreeAccSpedHorz(java.lang.String dataFreeAccSpedHorz) {
		this.dataFreeAccSpedHorz = dataFreeAccSpedHorz;
	}

	public java.lang.String getDataFreeAccDispX() {
		return dataFreeAccDispX;
	}

	public void setDataFreeAccDispX(java.lang.String dataFreeAccDispX) {
		this.dataFreeAccDispX = dataFreeAccDispX;
	}

	public java.lang.String getDataFreeAccDispY() {
		return dataFreeAccDispY;
	}

	public void setDataFreeAccDispY(java.lang.String dataFreeAccDispY) {
		this.dataFreeAccDispY = dataFreeAccDispY;
	}

	public java.lang.String getDataFreeAccDispZ() {
		return dataFreeAccDispZ;
	}

	public void setDataFreeAccDispZ(java.lang.String dataFreeAccDispZ) {
		this.dataFreeAccDispZ = dataFreeAccDispZ;
	}

	public java.lang.String getDataFreeAccDispHorz() {
		return dataFreeAccDispHorz;
	}

	public void setDataFreeAccDispHorz(java.lang.String dataFreeAccDispHorz) {
		this.dataFreeAccDispHorz = dataFreeAccDispHorz;
	}

	public java.lang.String getDataStrBotSpedX() {
		return dataStrBotSpedX;
	}

	public void setDataStrBotSpedX(java.lang.String dataStrBotSpedX) {
		this.dataStrBotSpedX = dataStrBotSpedX;
	}

	public java.lang.String getDataStrBotSpedY() {
		return dataStrBotSpedY;
	}

	public void setDataStrBotSpedY(java.lang.String dataStrBotSpedY) {
		this.dataStrBotSpedY = dataStrBotSpedY;
	}

	public java.lang.String getDataStrBotDispX() {
		return dataStrBotDispX;
	}

	public void setDataStrBotDispX(java.lang.String dataStrBotDispX) {
		this.dataStrBotDispX = dataStrBotDispX;
	}

	public java.lang.String getDataStrBotDispY() {
		return dataStrBotDispY;
	}

	public void setDataStrBotDispY(java.lang.String dataStrBotDispY) {
		this.dataStrBotDispY = dataStrBotDispY;
	}

	public java.lang.String getDataStrMidSpedX() {
		return dataStrMidSpedX;
	}

	public void setDataStrMidSpedX(java.lang.String dataStrMidSpedX) {
		this.dataStrMidSpedX = dataStrMidSpedX;
	}

	public java.lang.String getDataStrMidSpedY() {
		return dataStrMidSpedY;
	}

	public void setDataStrMidSpedY(java.lang.String dataStrMidSpedY) {
		this.dataStrMidSpedY = dataStrMidSpedY;
	}

	public java.lang.String getDataStrMidDispX() {
		return dataStrMidDispX;
	}

	public void setDataStrMidDispX(java.lang.String dataStrMidDispX) {
		this.dataStrMidDispX = dataStrMidDispX;
	}

	public java.lang.String getDataStrMidDispY() {
		return dataStrMidDispY;
	}

	public void setDataStrMidDispY(java.lang.String dataStrMidDispY) {
		this.dataStrMidDispY = dataStrMidDispY;
	}

	public java.lang.String getDataStrTopSpedX() {
		return dataStrTopSpedX;
	}

	public void setDataStrTopSpedX(java.lang.String dataStrTopSpedX) {
		this.dataStrTopSpedX = dataStrTopSpedX;
	}

	public java.lang.String getDataStrTopSpedY() {
		return dataStrTopSpedY;
	}

	public void setDataStrTopSpedY(java.lang.String dataStrTopSpedY) {
		this.dataStrTopSpedY = dataStrTopSpedY;
	}

	public java.lang.String getDataStrTopDispX() {
		return dataStrTopDispX;
	}

	public void setDataStrTopDispX(java.lang.String dataStrTopDispX) {
		this.dataStrTopDispX = dataStrTopDispX;
	}

	public java.lang.String getDataStrTopDispY() {
		return dataStrTopDispY;
	}

	public void setDataStrTopDispY(java.lang.String dataStrTopDispY) {
		this.dataStrTopDispY = dataStrTopDispY;
	}

	public String getGvmtCd() {
		return gvmtCd;
	}

	public void setGvmtCd(String gvmtCd) {
		this.gvmtCd = gvmtCd;
	}
    public java.lang.String getFctyCd() {
        return this.fctyCd;
    }
    
    public void setFctyCd(java.lang.String fctyCd) {
        this.fctyCd = fctyCd;
    }
    
    public java.math.BigDecimal getIddlAassNo() {
        return this.iddlAassNo;
    }
    
    public void setIddlAassNo(java.math.BigDecimal iddlAassNo) {
        this.iddlAassNo = iddlAassNo;
    }
    
    public java.lang.String getRsltMaxIdrX() {
        return this.rsltMaxIdrX;
    }
    
    public void setRsltMaxIdrX(java.lang.String rsltMaxIdrX) {
        this.rsltMaxIdrX = rsltMaxIdrX;
    }
    
    public java.lang.String getRsltMaxIdrY() {
        return this.rsltMaxIdrY;
    }
    
    public void setRsltMaxIdrY(java.lang.String rsltMaxIdrY) {
        this.rsltMaxIdrY = rsltMaxIdrY;
    }
    
    public java.lang.String getRsltOvrAccX() {
        return this.rsltOvrAccX;
    }
    
    public void setRsltOvrAccX(java.lang.String rsltOvrAccX) {
        this.rsltOvrAccX = rsltOvrAccX;
    }
    
    public java.lang.String getRsltOvrAccY() {
        return this.rsltOvrAccY;
    }
    
    public void setRsltOvrAccY(java.lang.String rsltOvrAccY) {
        this.rsltOvrAccY = rsltOvrAccY;
    }
    
    public java.lang.String getRsltNatFrqMvX() {
        return this.rsltNatFrqMvX;
    }
    
    public void setRsltNatFrqMvX(java.lang.String rsltNatFrqMvX) {
        this.rsltNatFrqMvX = rsltNatFrqMvX;
    }
    
    public java.lang.String getRsltNatFrqMvY() {
        return this.rsltNatFrqMvY;
    }
    
    public void setRsltNatFrqMvY(java.lang.String rsltNatFrqMvY) {
        this.rsltNatFrqMvY = rsltNatFrqMvY;
    }
    
    public java.lang.String getRsltStrFreeNatFrqX() {
        return this.rsltStrFreeNatFrqX;
    }
    
    public void setRsltStrFreeNatFrqX(java.lang.String rsltStrFreeNatFrqX) {
        this.rsltStrFreeNatFrqX = rsltStrFreeNatFrqX;
    }
    
    public java.lang.String getRsltStrFreeNatFrqY() {
        return this.rsltStrFreeNatFrqY;
    }
    
    public void setRsltStrFreeNatFrqY(java.lang.String rsltStrFreeNatFrqY) {
        this.rsltStrFreeNatFrqY = rsltStrFreeNatFrqY;
    }
    
    public java.lang.String getSfChkMaxIdrXRslt() {
        return this.sfChkMaxIdrXRslt;
    }
    
    public void setSfChkMaxIdrXRslt(java.lang.String sfChkMaxIdrXRslt) {
        this.sfChkMaxIdrXRslt = sfChkMaxIdrXRslt;
    }
    
    public java.lang.String getSfChkMaxIdrYRslt() {
        return this.sfChkMaxIdrYRslt;
    }
    
    public void setSfChkMaxIdrYRslt(java.lang.String sfChkMaxIdrYRslt) {
        this.sfChkMaxIdrYRslt = sfChkMaxIdrYRslt;
    }
    
    public java.lang.String getSfChkNatFrqMvXRslt() {
        return this.sfChkNatFrqMvXRslt;
    }
    
    public void setSfChkNatFrqMvXRslt(java.lang.String sfChkNatFrqMvXRslt) {
        this.sfChkNatFrqMvXRslt = sfChkNatFrqMvXRslt;
    }
    
    public java.lang.String getSfChkNatFrqMvYRslt() {
        return this.sfChkNatFrqMvYRslt;
    }
    
    public void setSfChkNatFrqMvYRslt(java.lang.String sfChkNatFrqMvYRslt) {
        this.sfChkNatFrqMvYRslt = sfChkNatFrqMvYRslt;
    }
    
    public java.lang.String getSfChkStrFreeNatFrqX() {
        return this.sfChkStrFreeNatFrqX;
    }
    
    public void setSfChkStrFreeNatFrqX(java.lang.String sfChkStrFreeNatFrqX) {
        this.sfChkStrFreeNatFrqX = sfChkStrFreeNatFrqX;
    }
    
    public java.lang.String getSfChkStrFreeNatFrqY() {
        return this.sfChkStrFreeNatFrqY;
    }
    
    public void setSfChkStrFreeNatFrqY(java.lang.String sfChkStrFreeNatFrqY) {
        this.sfChkStrFreeNatFrqY = sfChkStrFreeNatFrqY;
    }
    
    public java.lang.String getSfChkOvrAccXRslt() {
        return this.sfChkOvrAccXRslt;
    }
    
    public void setSfChkOvrAccXRslt(java.lang.String sfChkOvrAccXRslt) {
        this.sfChkOvrAccXRslt = sfChkOvrAccXRslt;
    }
    
    public java.lang.String getSfChkOvrAccYRslt() {
        return this.sfChkOvrAccYRslt;
    }
    
    public void setSfChkOvrAccYRslt(java.lang.String sfChkOvrAccYRslt) {
        this.sfChkOvrAccYRslt = sfChkOvrAccYRslt;
    }
    
    public java.lang.String getDataFreeMaxDispX() {
        return this.dataFreeMaxDispX;
    }
    
    public void setDataFreeMaxDispX(java.lang.String dataFreeMaxDispX) {
        this.dataFreeMaxDispX = dataFreeMaxDispX;
    }
    
    public java.lang.String getDataFreeMaxDispY() {
        return this.dataFreeMaxDispY;
    }
    
    public void setDataFreeMaxDispY(java.lang.String dataFreeMaxDispY) {
        this.dataFreeMaxDispY = dataFreeMaxDispY;
    }
    
    public java.lang.String getDataTopRelMaxSpedX() {
        return this.dataTopRelMaxSpedX;
    }
    
    public void setDataTopRelMaxSpedX(java.lang.String dataTopRelMaxSpedX) {
        this.dataTopRelMaxSpedX = dataTopRelMaxSpedX;
    }
    
    public java.lang.String getDataTopRelMaxSpedY() {
        return this.dataTopRelMaxSpedY;
    }
    
    public void setDataTopRelMaxSpedY(java.lang.String dataTopRelMaxSpedY) {
        this.dataTopRelMaxSpedY = dataTopRelMaxSpedY;
    }
    
    public java.lang.String getDataTopRelMaxDispX() {
        return this.dataTopRelMaxDispX;
    }
    
    public void setDataTopRelMaxDispX(java.lang.String dataTopRelMaxDispX) {
        this.dataTopRelMaxDispX = dataTopRelMaxDispX;
    }
    
    public java.lang.String getDataTopRelMaxDispY() {
        return this.dataTopRelMaxDispY;
    }
    
    public void setDataTopRelMaxDispY(java.lang.String dataTopRelMaxDispY) {
        this.dataTopRelMaxDispY = dataTopRelMaxDispY;
    }
    
    public java.lang.String getDataFreeAccX() {
        return this.dataFreeAccX;
    }
    
    public void setDataFreeAccX(java.lang.String dataFreeAccX) {
        this.dataFreeAccX = dataFreeAccX;
    }
    
    public java.lang.String getDataFreeAccY() {
        return this.dataFreeAccY;
    }
    
    public void setDataFreeAccY(java.lang.String dataFreeAccY) {
        this.dataFreeAccY = dataFreeAccY;
    }
    
    public java.lang.String getDataFreeAccZ() {
        return this.dataFreeAccZ;
    }
    
    public void setDataFreeAccZ(java.lang.String dataFreeAccZ) {
        this.dataFreeAccZ = dataFreeAccZ;
    }
    
    public java.lang.String getDataStrBotAccX() {
        return this.dataStrBotAccX;
    }
    
    public void setDataStrBotAccX(java.lang.String dataStrBotAccX) {
        this.dataStrBotAccX = dataStrBotAccX;
    }
    
    public java.lang.String getDataStrBotAccY() {
        return this.dataStrBotAccY;
    }
    
    public void setDataStrBotAccY(java.lang.String dataStrBotAccY) {
        this.dataStrBotAccY = dataStrBotAccY;
    }
    
    public java.lang.String getDataStrBotAccZ() {
        return this.dataStrBotAccZ;
    }
    
    public void setDataStrBotAccZ(java.lang.String dataStrBotAccZ) {
        this.dataStrBotAccZ = dataStrBotAccZ;
    }
    
    public java.lang.String getDataStrMidAccX() {
        return this.dataStrMidAccX;
    }
    
    public void setDataStrMidAccX(java.lang.String dataStrMidAccX) {
        this.dataStrMidAccX = dataStrMidAccX;
    }
    
    public java.lang.String getDataStrMidAccY1() {
        return this.dataStrMidAccY1;
    }
    
    public void setDataStrMidAccY1(java.lang.String dataStrMidAccY1) {
        this.dataStrMidAccY1 = dataStrMidAccY1;
    }
    
    public java.lang.String getDataStrMidAccY2() {
        return this.dataStrMidAccY2;
    }
    
    public void setDataStrMidAccY2(java.lang.String dataStrMidAccY2) {
        this.dataStrMidAccY2 = dataStrMidAccY2;
    }
    
    public java.lang.String getDataStrTopAccX() {
        return this.dataStrTopAccX;
    }
    
    public void setDataStrTopAccX(java.lang.String dataStrTopAccX) {
        this.dataStrTopAccX = dataStrTopAccX;
    }
    
    public java.lang.String getDataStrTopAccY1() {
        return this.dataStrTopAccY1;
    }
    
    public void setDataStrTopAccY1(java.lang.String dataStrTopAccY1) {
        this.dataStrTopAccY1 = dataStrTopAccY1;
    }
    
    public java.lang.String getDataStrTopAccY2() {
        return this.dataStrTopAccY2;
    }
    
    public void setDataStrTopAccY2(java.lang.String dataStrTopAccY2) {
        this.dataStrTopAccY2 = dataStrTopAccY2;
    }
    
    public java.lang.String getDataStrFrqX() {
        return this.dataStrFrqX;
    }
    
    public void setDataStrFrqX(java.lang.String dataStrFrqX) {
        this.dataStrFrqX = dataStrFrqX;
    }
    
    public java.lang.String getDataStrFrqY() {
        return this.dataStrFrqY;
    }
    
    public void setDataStrFrqY(java.lang.String dataStrFrqY) {
        this.dataStrFrqY = dataStrFrqY;
    }
    
    public java.lang.String getDataFreeFrq() {
        return this.dataFreeFrq;
    }
    
    public void setDataFreeFrq(java.lang.String dataFreeFrq) {
        this.dataFreeFrq = dataFreeFrq;
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

	public java.lang.String getMaxDataFreeAcc() {
		return maxDataFreeAcc;
	}

	public void setMaxDataFreeAcc(java.lang.String maxDataFreeAcc) {
		this.maxDataFreeAcc = maxDataFreeAcc;
	}

    
}
