package estam.app.com.socket;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.service.Globals;
import estam.app.com.rev.EvntRevAjaxController;
import estam.app.com.rev.WaveRevAjaxController;
import estam.app.scn.mma.service.ConMmaDataVO;
import estam.app.scn.mma.service.impl.ConMmaDataDAO;
/**
 *
 * @author atres
 * 
 */ 
public class UdpSocketServer extends HttpServlet implements Runnable  {  
	
    public static int BUFFER_SIZE = 120;
      
    private static final Logger logger = LoggerFactory.getLogger(UdpSocketServer.class);
    private Thread daemon;
   
    private DatagramSocket dgsocket; 
    private boolean stop = false;
    private byte buffer[] = new byte[BUFFER_SIZE];
	private ByteBuffer byteBuffer ; 
	  
    public void init() throws ServletException
    {
        
    	daemon = new Thread(this);
    	//daemon.setPriority(Thread.MIN_PRIORITY);
    	daemon.start();
  	
    }
    
    public void destroy()
    {
  	daemon.interrupt();
    }

    //stop server
    public synchronized void setStop(boolean cr) {
        stop=cr;
        if(dgsocket!=null && cr==true) {
            try	{
                dgsocket.close();
            } catch (Exception e) {
                System.err.println("Error closing server : setStop : "+e);
            }
        }
    }
     
    @SuppressWarnings("deprecation")
	public void run() {
    	 
    	logger.info("===============================");
 		logger.info(" UdpSocketServer RUNNING       "); 		
 		logger.info("==============================="); 
 		setStop(false);
 		try { 
 			
 			dgsocket = new DatagramSocket(Globals.UDP_PORT,InetAddress.getByName(Globals.UDP_HOST)); 
	        DatagramPacket pack = new DatagramPacket(buffer,buffer.length,InetAddress.getByName(Globals.UDP_HOST),Globals.UDP_PORT);
            
	        while(!stop) {
	            try	{
	            	 // 데이터 수신 
	           	     // 데이터가 수신될 때까지 대기됨
	                dgsocket.receive(pack);  
	            	 // 수신된 데이터 출력
	             // logger.debug("received UdpSocketServer : " + pack.getLength() + ", received data : " 
	               //  	          + new String(pack.getData(), 0, pack.getLength()));
	                   
	                   
	                   String mmaStr = new String(pack.getData(), "UTF-8"); 
	                   String[] mmaPgaStr = new String[5];   
		               
	                   mmaPgaStr[0] = mmaStr.substring(0, 4);
	                   mmaPgaStr[1] = mmaStr.substring(5, 7);
	                   mmaPgaStr[2] = mmaStr.substring(8, 10);
	                   mmaPgaStr[3] = mmaStr.substring(11, 25);
	                   mmaPgaStr[4] = mmaStr.substring(26, 34); 
	                   
		              //  logger.debug("received UdpSocketServer02 : " +  mmaPgaStr[4]);
		               
		 			   if ("MMAS".equals(mmaPgaStr[0])) {
		 				 //  WaveRevAjaxController.setWaveFomBuffer(pack.getData(),true);  
		 				  WaveRevAjaxController.setWaveFomBuffer(mmaPgaStr);
		 				  EvntRevAjaxController.setWaveFomBuffer(mmaPgaStr);
		 			   }  
 	             //   BarRevAjaxController.setWaveFomBuffer(pack.getData(),true);    //상태확인
                 //   FlotFormController.setWaveFomBuffer(pack.getData(),true);
//	    		     
		         //	  BufferReader(pack.getData(),true);  
		          
		         //	  dbCommitData(); 
	               
	            } catch (Exception e) {
	                if(!stop) {
	                	logger.error(e.getMessage(),"Error acception connection");
	                    stop=true;
	                } 
	                continue;
	            }
	        }//end of while
	        logger.debug("run connection 01");
	    } catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 
		} catch(Exception e) {
		   logger.info("ServerSocket failed : "+e.getMessage());
		   return;
	    }
    }//end of run
  
  

    public void BufferReader(byte[] sckbyte) {

		// TODO Auto-generated constructor stub   --allocate
		byteBuffer = ByteBuffer.allocateDirect(sckbyte.length);
		
		byteBuffer.clear();

		byteBuffer.put(sckbyte);

		byteBuffer.order(ByteOrder.LITTLE_ENDIAN);

		byteBuffer.rewind();

	} 
    
    public void BufferReader(byte[] sckbyte, boolean isBigEndian) {
 
		byteBuffer = ByteBuffer.allocateDirect(sckbyte.length);

		byteBuffer.clear(); 
		
		byteBuffer.put(sckbyte);

		byteBuffer.order(isBigEndian == true ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);

		byteBuffer.rewind(); 
	} 

	public int getInt() { 
		return byteBuffer.getInt(); 
		
	} 

	public short getShort() { 
		return byteBuffer.getShort(); 
	} 

	public double getDouble() { 
		return byteBuffer.getDouble(); 
	} 

	public float getFloat() { 
		return byteBuffer.getFloat(); 
	}
 

	public long getLong() { 
		return byteBuffer.getLong(); 
	}
	
	public char getChar(int idx) {
  
		return (char)byteBuffer.get(idx); 

	}
	public String getIntToHex() {
	 
		return Integer.toHexString(byteBuffer.getInt());

	}
	
	public String getString(int length) {

		byte[] bt = new byte[length]; 
		byteBuffer.get(bt);  
		return new String(bt);

	}
	
	public void bufferClear() {
		byteBuffer.clear();
	}
	
	public void bufferFlip() {
		byteBuffer.flip();
	}

	public boolean isBufNull() {
		
		boolean boolBuff = false;
		
		if (byteBuffer != null) {
			boolBuff = true;
		}
		
		return boolBuff;
	}
	
	@SuppressWarnings("deprecation")
	private void  dbCommitData() throws Exception {

		         ConMmaDataDAO cmmMmaDaatDao = new ConMmaDataDAO();
				
			 //	try {
					
//					cmmMmaDaatDao.getSqlMapClient().startTransaction() ; 
//					cmmMmaDaatDao.getSqlMapClient().getCurrentConnection().setAutoCommit(false);
//					cmmMmaDaatDao.getSqlMapClient().startBatch() ;
	
	
					ConMmaDataVO tpMMaData = new ConMmaDataVO();   
	        	 
	        	 if (isBufNull()) {
	        		 
	        		 // bufferFlip();
	        		  
	        		 tpMMaData.setMmaCrc(getIntToHex());
	        		  
	    	    	 tpMMaData.setMmaQutyFlg(String.valueOf(getChar(4)));
	    	    	  
	    	    	 tpMMaData.setMmaDataType(String.valueOf(getChar(5) + getChar(6)));
	    	    	  
	    	    	 tpMMaData.setMmaGvmtCd(String.valueOf(getChar(7)) + String.valueOf(getChar(8)));
	    	    	 
	    	    	 tpMMaData.setMmaFctyLocVal(String.valueOf(getChar(9)) + String.valueOf(getChar(10)) + String.valueOf(getChar(11)));
	    	    	 
	    	    	 getInt();
	    	    	 
	    	    	 getInt();
	    	    	  
	    	    	 getInt();
	    		    	// tpMMaData.setMmaDatetime(DateTime.parse(String.valueOf(getInt())));
	    		    	 
	    		    	 tpMMaData.setMmaUdWndMinVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaUdWndMaxVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	   
	    		    	 tpMMaData.setMmaUdWndAvgVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaNsWndMinVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	 
	    		    	 tpMMaData.setMmaNsWndMaxVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaNsWndAvgVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaEwWndMinVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	 
	    		    	 tpMMaData.setMmaEwWndMaxVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaEwWndAvgVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	   
	    		    	 tpMMaData.setMmaUdTruMinVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	   
	    		    	 tpMMaData.setMmaUdTruMaxVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaNsTruMinVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaNsTruMaxVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaEwTruMinVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	   
	    		    	 tpMMaData.setMmaEwTruMaxVal(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaUdMax(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	   
	    		    	 tpMMaData.setMmaNsMax(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaEwMax(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaHrtlPga(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	   
	    		    	 tpMMaData.setMmaTotPga(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	   
	    		    	 tpMMaData.setMma32bUdSi(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	 
	    		    	 tpMMaData.setMma32bNsSi(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	 
	    		    	 tpMMaData.setMma32bEwSi(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaHrtlSi(new BigDecimal(getFloat()).setScale(6,RoundingMode.HALF_DOWN));
	    		    	  
	    		    	 tpMMaData.setMmaCrrn(String.valueOf(getChar(117) + getChar(118)));
	    		    	 
	    		    	 tpMMaData.setMmaLocCd(String.valueOf(getChar(119)));  
	    		    	  
	    		  	   String str = "";
		                str =   " [ 1 : "  + tpMMaData.getMmaCrc();
					    str = str + " ][ 2 : " +  tpMMaData.getMmaQutyFlg() ;
					    str = str	  + " ][ 3 : " +  tpMMaData.getMmaDataType() ;
					    str = str	  + " ][ 4 : " +  tpMMaData.getMmaGvmtCd() ;
					    str = str	  + " ][ 5 : " +  tpMMaData.getMmaFctyLocVal() ; 
					    str = str	  + " ][ 7 : "+   String.valueOf(   tpMMaData.getMmaUdWndMinVal());
					    str = str	  + " ][ 8 : "+   String.valueOf(   tpMMaData.getMmaUdWndMaxVal());
					    str = str	  + " ][ 9 : "+   String.valueOf(   tpMMaData.getMmaUdWndAvgVal());
					    str = str	  + " ][ 10 : "+   String.valueOf(  tpMMaData.getMmaNsWndMinVal());
					    str = str	  + " ][ 11 : "+   String.valueOf(  tpMMaData.getMmaNsWndMaxVal());
					    str = str	  + " ][ 12 : "+   String.valueOf(  tpMMaData.getMmaNsWndAvgVal());
					    str = str	  + " ][ 13 : "+   String.valueOf(  tpMMaData.getMmaEwWndMinVal());
					    str = str	  + " ][ 14 : "+   String.valueOf(  tpMMaData.getMmaEwWndMaxVal());
					    str = str	  + " ][ 15 : "+   String.valueOf(  tpMMaData.getMmaEwWndAvgVal());
					    str = str	  + " ][ 16 : "+   String.valueOf(  tpMMaData.getMmaUdTruMinVal());
					    str = str	  + " ][ 17 : "+   String.valueOf(  tpMMaData.getMmaUdTruMaxVal());
					    str = str	  + " ][ 18 : "+   String.valueOf(  tpMMaData.getMmaNsTruMinVal());
					    str = str	  + " ][ 19 : "+   String.valueOf(  tpMMaData.getMmaNsTruMaxVal());
					    str = str	  + " ][ 20 : "+   String.valueOf(  tpMMaData.getMmaEwTruMinVal());
					    str = str	  + " ][ 21 : "+   String.valueOf(  tpMMaData.getMmaEwTruMaxVal());
					    str = str	  + " ][ 22 : "+   String.valueOf(  tpMMaData.getMmaUdMax());
					    str = str	  + " ][ 23 : "+   String.valueOf(  tpMMaData.getMmaNsMax());
					    str = str	  + " ][ 24 : "+   String.valueOf(  tpMMaData.getMmaEwMax());
					    str = str	  + " ][ 25 : "+   String.valueOf(  tpMMaData.getMmaHrtlPga());
					    str = str	  + " ][ 26 : "+   String.valueOf(  tpMMaData.getMmaTotPga());
					    str = str	  + " ][ 27 : "+   String.valueOf(  tpMMaData.getMma32bUdSi());
					    str = str	  + " ][ 28 : "+   String.valueOf(  tpMMaData.getMma32bNsSi());
					    str = str	  + " ][ 29 : "+   String.valueOf(  tpMMaData.getMma32bEwSi());
					    str = str	  + " ][ 30 : "+   String.valueOf(  tpMMaData.getMmaHrtlSi());
					    str = str 	  + " ][ 31 : "+   tpMMaData.getMmaCrrn();
					    str = str 	  + " ][ 32 : "+   tpMMaData.getMmaLocCd();
					    
					    //logger.debug("mma-data : " + str);
	      	    	    //cmmMmaDaatDao.insertConMmaData(tpMMaData);
	      	    	    
//	    	        	  cmmMmaDaatDao.getSqlMapClient().executeBatch();
//  	        	         cmmMmaDaatDao.getSqlMapClient().getCurrentConnection().commit();
//	    	        	  cmmMmaDaatDao.getSqlMapClient().commitTransaction() ; 
	    	    	 }
			 //	} catch (SQLException e) {
					// TODO Auto-generated catch block
		 		//e.printStackTrace();
			 	//}   
	}

}
   