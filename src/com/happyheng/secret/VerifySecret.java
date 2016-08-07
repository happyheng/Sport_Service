package com.happyheng.secret;

public interface VerifySecret {
	
	/**
	 * 将传入的String解密的方法
	 * @param encrypteString
	 * @return
	 */
	public String decryption(byte[] key,String encrypteString);
	
}
