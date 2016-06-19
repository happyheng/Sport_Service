package com.happyheng.utils;

public class TextUtils {
	
	/**
	 * 判断一个String是否为空的方法
	 * @param text
	 * @return
	 */
	public static boolean isEmpty(String text) {
		if (text == null || text.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
