package estam.app.com.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tomatosystem.adaptor.exria.RequestData;
 

/**
 * Exria 관련 공통 컴포넌트  
 * @author cyberlhs
 *
 */
public class ExriaUdtoMapUtil { 
	
	public static Object getMapToBean(RequestData reqData, String strClass) throws SecurityException, ClassNotFoundException {
		Method[] methods = Class.forName(strClass).getMethods();
		int size = methods.length;
		String strMethod;
		for(int i = 0; i < size; i++) {
			strMethod = methods[i].getName();
			if(strMethod.indexOf("get") == 0) {
				strMethod = strMethod.substring(3);
				strMethod = strMethod.substring(0, 1).toLowerCase() + strMethod.substring(1);
				if(reqData.getString(strMethod) != null && reqData.getString(strMethod).equals("")) {
					reqData.setObject(strMethod, null);
				} else if(methods[i].getReturnType() == Class.forName("java.util.Date")) {
					String vsDate = reqData.getString(strMethod);
					Calendar cal = Calendar.getInstance();
					cal.set(Integer.parseInt(vsDate.substring(0, 4)), Integer.parseInt(vsDate.substring(4, 6)) - 1,
							Integer.parseInt(vsDate.substring(6, 8)));
					reqData.setObject(strMethod, cal.getTime());
				}
			}
		}
		return reqData.getMapToBean(reqData.getRequestMap(), Class.forName(strClass));
	}
	
	public static Object getMapToBean(RequestData reqData, Map<String, Object> cudMap, String strClass) throws SecurityException, ClassNotFoundException {
		Method[] methods = Class.forName(strClass).getMethods();
		int size = methods.length;
		String strMethod;
		for(int i = 0; i < size; i++) {
			strMethod = methods[i].getName();
			if(strMethod.indexOf("get") == 0) {
				strMethod = strMethod.substring(3);
				strMethod = strMethod.substring(0, 1).toLowerCase() + strMethod.substring(1);
				if(cudMap.get(strMethod) != null && cudMap.get(strMethod).equals("")) {
					cudMap.put(strMethod, null);
				} else if(methods[i].getReturnType() == Class.forName("java.util.Date")) {
					String vsDate = (String)cudMap.get(strMethod);
					Calendar cal = Calendar.getInstance();
					cal.set(Integer.parseInt(vsDate.substring(0, 4)), Integer.parseInt(vsDate.substring(4, 6)) - 1,
							Integer.parseInt(vsDate.substring(6, 8)));
					cudMap.put(strMethod, cal.getTime());
				}
			}
		}
		return reqData.getMapToBean(cudMap, Class.forName(strClass));
	}
	
	public static void addListToResponseMap(RequestData reqData, String nodeName, Object beanList, Map containerMap) {
		List store = new ArrayList();
		Map uv = null;
		if(beanList instanceof List) {
			List list = (List)beanList;
			int size = list.size();
			try {
				for (int i = 0; i < size; i++) { 
					uv = reqData.getBeanToMap(list.get(i));
					store.add(uv);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				uv = reqData.getBeanToMap(beanList);
				store.add(uv);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		containerMap.put(nodeName, store);
	}
	
	private class MyException extends Exception { // exception의 정의

        public MyException (String message) {

                         super (message);

        }

        public MyException() {

                          this ("My Exception Error");

         }

	}
}
