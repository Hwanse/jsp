package kr.or.ddit.util;

public class PartUtil {

	/**
	* Method : getFileName
	* 작성자 : PC14
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다.
	*/
	public static String getFileName(String contentDisposition) {
		//  form-data; name="profile"; filename="sally.png"
		String[] tags = contentDisposition.split(";");

		String fileName = null;
		for(String tag : tags){
			if(tag.contains("filename")){
				int startIdx = tag.indexOf("\"");
				int endIdx = tag.lastIndexOf("\"");

				fileName = tag.substring(startIdx+1, endIdx); 
				break;
			}
		}
		return fileName;
	}

	/**
	* Method : getExt
	* 작성자 : PC14
	* 변경이력 :
	 * @param fileName 
	* @return
	* Method 설명 : 파일명으로부터 파일 확장자를 반환
	*/
	public static String getExt(String fileName) {
		
		int idx = fileName.lastIndexOf(".");
		String ext  = "";
		if(idx == -1){
			return ext;
		}
		ext = fileName.substring(idx+1);
		
		return ext;
		
		// 방법2
//		String[] splited = fileName.split("\\.");
//		if(splited.length == 1){
//			return "";
//		} else{
//			return splited[splited.length-1];
//		}
	
	}

	
}
