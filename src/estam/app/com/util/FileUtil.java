package estam.app.com.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.web.multipart.MultipartFile;

import egovframework.com.cmm.service.EgovProperties;

public class FileUtil {
	private static long SERIAL = -1;
	public static String IMAGE_PATH = "upimages";

	/**
	 * 파일명 가져오기
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName) {
		System.out.println("fileName:" + fileName);
		int posExt = fileName.lastIndexOf(".");
		String ext = "";
		if (posExt > 0) {
			ext = fileName.substring(posExt + 1);
		}
		if (SERIAL < 0) {
			SERIAL = System.currentTimeMillis();
		}
		SERIAL++;
		String tmp = Long.toHexString(SERIAL) + "." + ext;
		return tmp;
	}

	/**
	 * 파일명 가져오기
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName, String fctyCd, String gvmtCd) {
		System.out.println("fileName:" + fileName);
		int posExt = fileName.lastIndexOf(".");
		String ext = "";
		if (posExt > 0) {
			ext = fileName.substring(posExt + 1);
		}
		String sDate = getStringByPattern("yyyyMMdd_HHmmss");
		String tmp = gvmtCd + "_" + fctyCd + "_" + sDate + "." + ext;
		return tmp;
	}

	/**
	 * 이미지 경로 생성
	 * 
	 * @param rootPath
	 * @return
	 */
	public static String getImagePath(String rootPath) {

		String sYear = getStringByPattern("yyyy");
		String sMonthDay = getStringByPattern("MMdd");
		StringBuffer sbImagePath = new StringBuffer();

		File filePath = null;
		sbImagePath.append(IMAGE_PATH);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();

		sbImagePath.append("/" + sYear);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();

		sbImagePath.append("/" + sMonthDay);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();

		return sbImagePath.toString();
	}

	/**
	 * 이미지 경로 생성
	 * 
	 * @param rootPath
	 * @return
	 */
	public static String getFilePath(String rootPath) {

		String sYear = getStringByPattern("yyyy");
		String sMonthDay = getStringByPattern("MMdd");
		StringBuffer sbImagePath = new StringBuffer();

		File filePath = null;

		sbImagePath.append("/" + sYear);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();

		sbImagePath.append("/" + sMonthDay);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();

		return sbImagePath.toString();
	}

	/**
	 * 이미지 경로 생성
	 * 
	 * @param rootPath
	 * @return
	 */
	public static String getFilePath(String rootPath, String fctyCd, String gvmtCd, String type) {

		StringBuffer sbImagePath = new StringBuffer();

		File filePath = null;

		// 이미지 경로일 경우
		// if(type=="img") {
		String sImgPath = EgovProperties.getProperty("Globals.imgFileStorePath");
		sbImagePath.append(sImgPath);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();
		// }

		sbImagePath.append("/" + gvmtCd);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();

		sbImagePath.append("/" + fctyCd);
		filePath = new File(rootPath + sbImagePath.toString());
		if (!filePath.exists())
			filePath.mkdir();

		sbImagePath.append("/");

		return sbImagePath.toString();
	}

	/**
	 * 파일 업로드
	 * 
	 * @param formFile
	 * @param svrFile
	 * @return
	 */
	public static boolean uploadFormFile(MultipartFile formFile, File svrFile) throws FileNotFoundException, IOException {
		boolean returnValue = false;

		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			if (!svrFile.exists()) {
				svrFile.createNewFile();
			}

			inStream = formFile.getInputStream();

			outStream = new FileOutputStream(svrFile);
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inStream.read(bytes)) != -1) {
				outStream.write(bytes, 0, read);
			}
			returnValue = true;
		} catch (FileNotFoundException ex) {
			throw ex;
		} catch (IOException ex) {
			throw ex;
		} finally {
			try {
				if (inStream != null)
					inStream.close();
			} catch (Exception ex) {
			}
			try {
				if (outStream != null)
					outStream.close();
			} catch (Exception ex) {
			}
		}
		return returnValue;
	}

	/**
	 * 파일 삭제
	 * 
	 * @param path
	 * @param fileName
	 */
	public static boolean deleteFile(File file) throws Exception {
		boolean returnValue = false;
		try {
			if (file.exists()) {
				if (file.delete()) {
					returnValue = true;
				} else {
					throw new Exception("File delete Error");
				}

			} else {
				throw new FileNotFoundException(file.getPath());
			}
		} catch (Exception ex) {
			throw ex;
		}
		return returnValue;
	}

	public static String getDateString() {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
		return formatter.format(new java.util.Date());
	}

	public static int getNumberByPattern(String pattern) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern, java.util.Locale.KOREA);
		String dateString = formatter.format(new java.util.Date());
		return Integer.parseInt(dateString);
	}

	public static String getStringByPattern(String pattern) {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(pattern, java.util.Locale.KOREA);
		return formatter.format(new java.util.Date());
	}

	public static String getCurrentTimeToString() {
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.KOREA);
		return formatter.format(new java.util.Date());
	}

	// 파일을 변환한다
	public static String convertKorToUTF(String str) {
		try {
			return new String(str.getBytes("8859_1"), "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			// logger.error(ex.getMessage(), ex);
		}
		return "";
	}

	// 파일을 변환한다
	public static String convertUTFToKor(String str) {
		try {
			return new String(str.getBytes("UTF-8"), "8859_1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}