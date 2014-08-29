package estam.app.com.rev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import egovframework.com.cmm.service.EgovCmmUseService;
import estam.app.scn.mma.service.ConMmaDataService;
@Controller
public class BarRevAjaxController {
	    private static final Logger log = LoggerFactory.getLogger(BarRevAjaxController.class); 
		 
	    private static String[] bufferMMa = new String[36];
	    
        private static  List<BarRevDataVO> arrBarRev = new ArrayList<BarRevDataVO>();
	 
        
   	 private static String[] strGvmtCd = { "AC"
   		 ,"IC"
   		 ,"KA"
   		 ,"AC"
   		 ,"AC"
   		 ,"KA"
   		 ,"GK"
   		 ,"JE"
   		 ,"GK"
   		 ,"AC"
   		 ,"GN"
   		 ,"KA"
   		 ,"AC"
   		 ,"JP" 
   		 ,"CN"
   		 ,"CP" 
   		 ,"JE"};
   	 private static String[] strGvmtNm = { "서울특별시"
   		 ,"인천광역시"
   		 ,"대구광역시"
   		 ,"대전광역시"
   		 ,"부산광역시"
   		 ,"울산광역시"
   		 ,"광주광역시"
   		 ,"세종시"
   		 ,"경기도"
   		 ,"강원도"
   		 ,"경상남도"
   		 ,"경상북도"
   		 ,"전라북도"
   		 ,"전라남도"
   		 ,"충청남도"
   		 ,"충청북도"
   		 ,"제주특별자치도" };
   	 private static  String[] strFctyCd ={ "SL"
   		 ,"ND"
   		 ,"DG"
   		 ,"HB"
   		 ,"PS"
   		 ,"US"
   		 ,"GJ"
   		 ,"SJ" 
   		 ,"GG" 
   		 ,"GW"
   		 ,"TY"
   		 ,"PH" 
   		 ,"MA"
   		 ,"GJ" 
   		 ,"CN"
   		 ,"CD"
   		 ,"JF" };
   	 private static String[] strFctyNm = {  "서울과학기술대학교"
   		 , "남동구청"
   		 , "대구공항"
   		 , "한밭대학교"
   		 , "부산대학교"
   		 , "울산공항"
   		 , "광주시청"
   		 , "세종열병합발전소"
   		 , "경기도청"
   		 , "강원대학교"
   		 , "통영시청"
   		 , "포항공항"
   		 ,"목포대학교"
   		 ,"김제시청"
   		 ,"충남도청"
   		 ,"충북도청"
   		 ,"제주화력발전소" };
   	 private static String[] strFctyNo = {  "1","2","3","4","5","6","7","8","9","10","11","12" ,"13","14","15","16","17" };
     
        
        /** EgovCmmUseService */
		@Resource(name="EgovCmmUseService")
		private EgovCmmUseService cmmUseService;
		
	    @Resource(name = "conMmaDataService")
	    private ConMmaDataService conMmaDataService;
		
	    public BarRevAjaxController() {
	    	
	    	
	    }
	    
	    /**
	     * 소켓에서 값을 받아 오기 위한 처리 부
	     * @param sckbyte
	     * @return 
	     */
	     public static  void setBarFomBuffer(String[] sckString){ 
	    	   bufferMMa = sckString; 
	    	   
	    	 //  log.debug("received setBarFomBuffer : " + bufferMMa);
	  	 } 
	  
		@RequestMapping(value="/bar/BarFormRev.do")
		@ResponseBody
		public String getCurrentBar(@RequestParam(value="flag", required=false) String flag,Model model){
		 
			return DateProvider() ;
		} 
		
		private String DateProvider() { 
		      
			 
//		        ConMmaDataDefaultVO searchMMAVO = new ConMmaDataDefaultVO(); 
//		        BarRevTpPgaVO barRevTpPga =  new BarRevTpPgaVO();
		        ObjectMapper m = new ObjectMapper(); 
		        String reqDataJson =  "";
		        Map<String, Object> barFctyDataMap = new HashMap<String, Object>();
//		        double pga10 = 0.0;
		         
		        //TODO 계측 최대값 1초간 PGA값 출
		        //TODO 10분간 저장된 PGA 값 저장된 내용으로 값 가지고 올것.
//		        ComDefaultCodeVO vo = new ComDefaultCodeVO();
//		        ComDefaultCodeVO comCode = new ComDefaultCodeVO(); 
		    	try {
			   		try {
			   		 
			   			if ((arrBarRev == null) || arrBarRev.isEmpty() ) {
				   		 
							BarRevDataVO barRev     = new BarRevDataVO();
							
							barRev.setGvmtCd("0"); //기관코드
							barRev.setGvmtNm("전국"); //기관명
							barRev.setFctyCd("0"); //게측소코드 기관코드와동일함 
							barRev.setFctyNm("");    //계측소명 -- 코드아이템5에서관리
	                        barRev.setFctyNo("0");
	                        barRev.setSysDataTime(DateTime.now().toString("yyyyMMddhhmmss"));
	                        barRev.setFctyPga10("0");
	                        barRev.setFctyPga("0");
	                        arrBarRev.add(barRev);
	                      
	                    	for(int iCnt = 0; iCnt < strGvmtCd.length;iCnt++) {
								
								BarRevDataVO barRev01     = new BarRevDataVO();
							 
								barRev01.setGvmtCd(strGvmtCd[iCnt]); //기관코드
								barRev01.setGvmtNm(strGvmtNm[iCnt]); //기관명
								barRev01.setFctyCd(strFctyCd[iCnt]); //게측소코드 기관코드와동일함 
								barRev01.setFctyNm(strFctyNm[iCnt]);    //계측소명 -- 코드아이템5에서관리
								barRev01.setFctyNo(strFctyNo[iCnt]);
								barRev01.setSysDataTime(DateTime.now().toString("yyyyMMddhhmmss"));
								barRev01.setFctyPga10("0");
								barRev01.setFctyPga("0");
		                        arrBarRev.add(barRev01);
							}  
			   			}
			   		 
			   			for(int iCnt = 0; iCnt < arrBarRev.size();iCnt++) { 
			   				
			   				BarRevDataVO arrBarRvData     = new BarRevDataVO();
			   				arrBarRvData = (BarRevDataVO)arrBarRev.get(iCnt);  
			   				
			   				if ("0".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[1]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[19]);
	    	            	    arrBarRev.set(0, arrBarRvData);
			   				} else if ("1".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[2]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[20]); 
	    	            	    arrBarRev.set(1, arrBarRvData);
			   				} else if ("2".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[3]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[21]); 
	    	            	    arrBarRev.set(2, arrBarRvData);
			   				}else if ("3".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[4]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[22]); 
	    	            	    arrBarRev.set(3, arrBarRvData);
			   				}else if ("4".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[5]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[23]); 
	    	            	    arrBarRev.set(4, arrBarRvData);
			   				}else if ("5".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[6]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[24]);
	    	            	    arrBarRev.set(5, arrBarRvData);
			   				}else if ("6".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[7]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[25]); 
	    	            	    arrBarRev.set(6, arrBarRvData);
			   				}else if ("7".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[8]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[26]); 
	    	            	    arrBarRev.set(7, arrBarRvData);
			   				}else if ("8".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[9]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[27]); 
	    	            	    arrBarRev.set(8, arrBarRvData);
			   				}else if ("9".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[10]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[28]); 
	    	            	    arrBarRev.set(9, arrBarRvData);
			   				}else if ("10".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[11]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[29]); 
	    	            	    arrBarRev.set(10, arrBarRvData);
			   				}else if ("11".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[12]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[30]); 
	    	            	    arrBarRev.set(11, arrBarRvData);
			   				}else if ("12".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[13]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[31]); 
	    	            	    arrBarRev.set(12, arrBarRvData);
			   				}else if ("13".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[14]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[32]); 
	    	            	    arrBarRev.set(13, arrBarRvData);
			   				}else if ("14".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[15]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[33]); 
	    	            	    arrBarRev.set(14, arrBarRvData);
			   				}else if ("15".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[16]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[34]); 
	    	            	    arrBarRev.set(15, arrBarRvData);
			   				}else if ("16".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[17]);
	    	            	    arrBarRvData.setFctyPga(bufferMMa[35]); 
	    	            	    arrBarRev.set(16, arrBarRvData);
			   				}else if ("17".equals(arrBarRvData.getFctyNo())) {
			   					arrBarRvData.setFctyPga10(bufferMMa[18]);
	    	            	    arrBarRvData.setFctyPga("0"); //bufferMMa[36]
	    	            	    arrBarRev.set(17, arrBarRvData);
			   				}   
			   				
			   			}
			   		 
//			   			BarRevDataVO arrBarRvTotData     = new BarRevDataVO();
//			   			
//			   			for(int iCnt = 0; iCnt < arrBarRev.size();iCnt++) { 
//							arrBarRvTotData = (BarRevDataVO)arrBarRev.get(iCnt); 
//							if (arrBarRvTotData.getFctyCd().equals("0")) {
//								break;
//							} 
//			   			}
//			   			
//			   			for(int iCnt = 0; iCnt < arrBarRev.size();iCnt++) {
//							BarRevDataVO arrBarRvData     = new BarRevDataVO();
//						 
//							      arrBarRvData = (BarRevDataVO)arrBarRev.get(iCnt); 
//						 
//									//10분후 데이터 가지고 오기.. 
//									  String strDbDate = arrBarRvData.getSysDataTime(); 
//						              String strCurrDate = DateTime.now().toString("yyyyMMddhhmmss");
//						              DateFormat df = DateFormat.getDateTimeInstance();
//						              Date dateDb = null;
//						              Date dateCurr = null;
//						              SimpleDateFormat sdf = new SimpleDateFormat();
//						              sdf.applyPattern("yyyyMMddhhmmss");
//						              try {
//						            	  dateDb = sdf.parse(strDbDate);
//						            	  dateCurr = sdf.parse(strCurrDate);
//						                  log.debug("Date1 : " + df.format(dateDb) 
//						                              + "\n" + "Date2 : " 
//						                              + df.format(dateCurr));
//						              } catch (Exception e) {
//						                  e.printStackTrace();
//						              }
//						              
//						              Calendar c1 = Calendar.getInstance(); 
//						              Calendar c2 = Calendar.getInstance();
//						              c1.setTime(dateDb);
//						              c2.setTime(dateCurr);
//						              
//						              log.debug("c1 : " + df.format(c1.getTime()) 
//						                      + ", " + c1.getTimeInMillis());
//						              log.debug("c2 : " + df.format(c2.getTime()) 
//						                      + ", " + c2.getTimeInMillis());
//						              
//						              log.debug("c2 - c1 : " 
//						                      + (c2.getTimeInMillis() - c1.getTimeInMillis())); 
//						               
//						              long minute = 1000 * 60; 
//						             
//						              long intervalMilli = (c2.getTimeInMillis() - c1.getTimeInMillis()) / minute ; 
//						              
//						              if (intervalMilli >= 10) {  
//						            	  
//						            	  searchMMAVO.setGvmtCd(arrBarRvData.getGvmtCd());
//						            	  searchMMAVO.setMmaFctyLocVal(arrBarRvData.getFctyCd());
//						            	  searchMMAVO.setStartDataTime(strDbDate);
//						            	  searchMMAVO.setEndDataTime(strCurrDate);
//						            	  
//						            	  barRevTpPga = conMmaDataService.selectBarRevPgaData(searchMMAVO);
//						            	  
//						            	  arrBarRvData.setFctyPga(barRevTpPga.getFctyPga());
//						            	  arrBarRvData.setFctyPga10(barRevTpPga.getFctyPga10()); 
//						            	  arrBarRvTotData.setFctyPga(barRevTpPga.getFctyTotPga());
//						            	  arrBarRvTotData.setFctyPga10(barRevTpPga.getFctyTotPga10());
//						            	  arrBarRev.set(iCnt, arrBarRvData);  
//						            	  arrBarRev.set(0, arrBarRvTotData);  
//						            	  
//						              } else {
//						            	  
//						            	  searchMMAVO.setGvmtCd(arrBarRvData.getGvmtCd());
//						            	  searchMMAVO.setMmaFctyLocVal(arrBarRvData.getFctyCd());
//						            	  searchMMAVO.setStartDataTime(strCurrDate);
//						            	  searchMMAVO.setEndDataTime(strCurrDate);
//						            	  
//						            	  barRevTpPga = conMmaDataService.selectBarRevPgaData(searchMMAVO);
//						            	  
//						            	  arrBarRvData.setFctyPga(barRevTpPga.getFctyPga());
//						            	  arrBarRvData.setFctyPga10(barRevTpPga.getFctyPga10()); 
//						            	  arrBarRvTotData.setFctyPga(barRevTpPga.getFctyTotPga()); 
//						            	  
//						            	  arrBarRev.set(iCnt, arrBarRvData); 
//						            	  arrBarRev.set(0, arrBarRvTotData); 
//						              }
//							         
//								}
							 
			   		
			   			barFctyDataMap.put("barRevData", arrBarRev);
			   		
			   		} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   		
			   		reqDataJson = m.writeValueAsString(barFctyDataMap);
			   		
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		     log.debug("BarRevAjaxController  : " + reqDataJson);
	    	 return reqDataJson; 
	  }
	
     
}
