package com.happyheng.filter;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.happyheng.secret.VerifySecret;
import com.happyheng.secret.impl.AESSercret;
import com.happyheng.utils.HexUtils;
import com.happyheng.utils.PropertiesUtils;

public class VerifyFilter implements Filter {

	public static final String KEY_ENCRYPT = "s";

	private byte[] key;
	private VerifySecret secret;

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {

		PropertiesUtils propertiesUtils = new PropertiesUtils("key.properties");
		String hexKey = propertiesUtils.getProperties("key");
		key = HexUtils.hexStringToBytes(hexKey);
		
		secret = new AESSercret();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String securityString = request.getParameter(KEY_ENCRYPT);
		if (securityString == null) {
			chain.doFilter(request, response);
		} else {
			String decryptString = secret.decryption(key, securityString);

			if (decryptString != null) {
				System.out.println("获取的加密String为" + decryptString);

				//JSONObject requestJson = JSON.parseObject(URLDecoder.decode(securityString, "UTF8"));
				JSONObject requestJson = JSON.parseObject(decryptString);
				for (String key : requestJson.keySet()) {
					request.setAttribute(key, requestJson.get(key));
					System.out.println("取得的数据key----"+key+"----value为"+ requestJson.get(key));
				}

				// 验证通过
				chain.doFilter(request, response);
			} else {
				response.getWriter().println("验证失败");
			}

		}
		
	}

	@Override
	public void destroy() {

	}

}
