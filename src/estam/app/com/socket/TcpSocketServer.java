package estam.app.com.socket;
 
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egovframework.com.cmm.service.Globals;

//
public class TcpSocketServer extends HttpServlet implements Runnable  {
  
  private static final Logger logger = LoggerFactory.getLogger(TcpSocketServer.class);
  private Thread daemon;
  
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
  public void run() {
	try {
		 logger.info("===============================");
		 logger.info(" SocketServer RUN ");
		 logger.info("===============================");
		 tcpSocketRun();
	} catch(Exception e) {
		logger.info("ServerSocket failed : "+e.getMessage());
		return;
	}
  }
  public void tcpSocketRun()
  {
	  try{
		  ServerSocket tcpSckServer = new ServerSocket(Globals.TCP_PORT);
		  while(true){
				try{
				   logger.info("Traffic Client Request Waiting!");
				   Socket tcpSocket = tcpSckServer.accept(); // 클라이언트 접속때까지 대기
				   logger.info("Traffic Socket Client Access IP :  "+tcpSckServer.getInetAddress() );
				   BufferedReader inFromClient= new BufferedReader(new InputStreamReader(tcpSocket.getInputStream()));
				   DataOutputStream outToClient = new DataOutputStream(tcpSocket.getOutputStream());
				   //PrintWriter outToPClient= new PrintWriter(new OutputStreamWriter(tcpSocket.getOutputStream()));
				   // 클라이언트 소켓으로부터 받은 메시지를 화면에 출력
				   String clientSentence  = inFromClient.readLine();
				   //System.out.println("클라이언트로부터 받은 메시지: "+ in.readLine());
				   logger.debug("Client Request Message : "+ clientSentence);
				   //TO-DO 받은 xml전문을 파싱하여 디비에 저장하는 루틴 추가
				   
				  // String[] mmaPga = clientSentence.split("|"); 
				   
				   //if ("MMAPGA".equals(mmaPga[0])) {
					//   BarRevAjaxController.setBarFomBuffer(mmaPga);
				  // }
				   
				  // inertRptData() //repoert insert
				   
				   //inertEhqkOcurInfoData(Map xmlMapData) //지진정보 인서트  
				   
				   
				   //out.println(reqMsg);
				   //out.flush();
				   tcpSocket.close();
			   }catch(IOException ie){
				ie.printStackTrace();
			   }
			}
	}catch(MalformedURLException e){
		logger.info(e.toString());
	}catch(IOException e){
		logger.info(e.toString());
	}
  }
}