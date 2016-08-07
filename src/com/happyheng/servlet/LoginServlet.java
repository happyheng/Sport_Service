package com.happyheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.happyheng.entity.result.LoginResult;
import com.happyheng.service.LoginService;
import com.happyheng.service.impl.LoginServiceImpl;

/**
 * 
 * @author liuheng
 */
@WebServlet("/Login")
public class LoginServlet extends BaseServlet {

	private static final long serialVersionUID = 7245361420327420429L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = (String) req.getAttribute("uname");
		String passWord = (String) req.getAttribute("upwd");

		System.out.println("请求的userName为" + userName + "\n请求的passWord为" + passWord);

		LoginService service = (LoginService)context.getBean("loginService");
		LoginResult loginResult = service.login(userName, passWord);

		Map<String, Object> map = new HashMap<>();
		map.put(RESULT_KEY, loginResult.getCode());
		//如果成功，还需要加上token
		if (loginResult.getCode() == 0) {
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("token", loginResult.getToken());
			
			map.put("data", dataMap);
		}
		
		String result = JSON.toJSONString(map);
		System.out.println("结果为"+result);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(result);
		printWriter.close();
	}

}
