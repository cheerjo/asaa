package estam.app.com.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;


public class ShellScriptUtil {  
	
    public static Vector<Object> exec_cmd(String cmd) throws Exception {
    	
    	Vector<Object> result = new Vector<Object>();  //  Object for DB , DATA
    	ArrayList<String> output_from_cmd = new ArrayList<String>();  // output from running cmd = s[]
    	String s = null; // tmp output value
    	
    	boolean excute = true;
    	
    	try {
            
    	    // run the Unix "ps -ef" command
            // using the Runtime exec method:
            Process p = Runtime.getRuntime().exec(cmd);
            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream())); 

            // read the output from the command
            System.out.println("Here is the standardW output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                //System.out.println(s);
                output_from_cmd.add(s);
            }
            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
           
            	excute = false;
                //System.out.println(s);
                output_from_cmd.add(s);
            }
            
            System.exit(0);
        }
        catch (IOException e) {
        
        	System.out.println("exception happened - here's what I know: ");
            e.printStackTrace();
            System.exit(-1);
        
        }finally{
        	
           /**
        	* reuslt {cmd_array, output, exute_time, excute_success}
        	*/
        	result.addElement(cmd);
        	result.addElement(output_from_cmd);
        	//result.addElement(Tools.getDateBasis());
        	result.addElement(excute);
        
        }
        return result;
    }
  
}
