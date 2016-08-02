package com.happyheng.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class VerifyFilter implements Filter {

	public static final String KEY_ENCRYPT = "s";

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String securityString = request.getParameter(KEY_ENCRYPT);
		if (securityString != null) {
			System.out.println("获取的加密String为" + securityString);

			JSONObject requestJson = JSON.parseObject(URLDecoder.decode(securityString, "UTF8"));
			for (String key : requestJson.keySet()) {
				request.setAttribute(key, requestJson.get(key));
			}

			// 验证通过
			chain.doFilter(request, response);
		} else {
			response.getWriter().println("验证失败");
		}

	}

	@Override
	public void destroy() {

	}

}
