package com.happyheng.secret;

public interface ServletSecret {
	
	/**
	 * 将传入的String解密的方法
	 * @param encrypteString
	 * @return
	 */
	public String decryption(String encrypteString);
	
}
