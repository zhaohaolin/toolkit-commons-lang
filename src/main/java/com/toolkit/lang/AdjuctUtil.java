package com.toolkit.lang;

public abstract class AdjuctUtil {
	
	private AdjuctUtil() {
		//
	}
	
	public static String getAdjuct(String string, int width) {
		try {
			if (string == null) {
				string = "null";
			} else {
				int length = string.length();
				
				if (length > width) {
					string = string.substring(0, width - 1) + "...";
				}
			}
		} catch (Exception e) {
			//
		}
		
		return string;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
