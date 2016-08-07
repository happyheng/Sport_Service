package com.happyheng.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import com.happyheng.utils.HexUtils;

/**
 * AES进行加解密的工具类
 * @author liuheng
 *
 */
public class AESUtils {
	
	/**
	 * AES加密的方法
	 * @param byteskey AES的key
	 * @param text  待加密的字符串
	 * @return 返回转换成16进制的加密字符串，如果加密失败，返回null
	 */
	public static String encrypt(byte[] byteskey,String text) {
		try {
			//转换key
			Key convertSecretKey = new SecretKeySpec(byteskey, "AES");
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] encryptResult = cipher.doFinal(text.getBytes());
			String encryptString = HexUtils.bytesToHexString(encryptResult);
			
			System.out.println("jdk des encrypt:" + encryptString);
			return encryptString;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * AES解密的方法
	 * @param byteskey AES的key
	 * @param encryptString 加密并转换成16进制的字符串
	 * @return 返回解密的字符串，如果失败，返回null
	 */
	public static String decrypt(byte[] byteskey,String encryptString) {
		try {
			//转换key
			Key convertSecretKey = new SecretKeySpec(byteskey, "AES");
			// 解密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			byte[] decryptResult = cipher.doFinal(HexUtils.hexStringToBytes(encryptString));
			String decryptString = new String(decryptResult);
			System.out.println("jdk des decrypt:" + decryptString);
			return decryptString;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
