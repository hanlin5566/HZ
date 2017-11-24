package com.hzcf.operation.base.util;
/**
 * Create by hanlin on 2017年11月8日
 **/
public class StringUtils {
	public static String toUpperFristChar(String string) {  
	    char[] charArray = string.toCharArray();  
	    charArray[0] -= 32;  
	    return String.valueOf(charArray);  
	}

	public static boolean isNotNull(String args){
		if(args==null||args.equals("")||args.trim().equals("")){
			return false;
		}
		return true;
	}
	public static String getStringValue(Object args){
		if(args==null){
			return "";
		}else{
			return args.toString().trim();
		}

	}

	//强转
	public static Integer strToInt( String str) {
		try
		{
			return Integer.parseInt(str) ;
		}catch(Exception e)
		{
		}
		return -1;
	}
}
