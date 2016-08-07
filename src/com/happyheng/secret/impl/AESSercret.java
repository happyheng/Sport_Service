package com.happyheng.secret.impl;

import com.happyheng.encrypt.AESUtils;
import com.happyheng.secret.VerifySecret;

public class AESSercret implements VerifySecret {

	@Override
	public String decryption(byte[] key, String encrypteString) {
		return AESUtils.decrypt(key, encrypteString);
	}

}
