package com.util;

public class validators {

	public static boolean isBlank(String data) {
		
		if(data.trim().length()==0||data==null) {			
			return true;
		}
		else {
			return false;
		}
				
	}
	
	public static boolean isAlpha(String data) {
		String alphaRegEx = "[a-zA-Z]+";
		return data.matches(alphaRegEx);
	}
	
}
