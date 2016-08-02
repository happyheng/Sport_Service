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
import com.happyheng.service.RegisterService;

@WebServlet("/Register")
public class RegisterServlet extends BaseServlet {

	private static final long serialVersionUID = -7216554493323498738L;

	/**
	 * 注册只接受post请求
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = (String) req.getAttribute("uname");
		String passWord = (String) req.getAttribute("upwd");
		String nickName = (String) req.getAttribute("nkname");

		System.out.println("请求的userName为" + userName + "\n请求的passWord为" + passWord + "\nnickName为" + nickName);

		RegisterService service = new RegisterService();
		int code = service.register(userName, passWord, nickName);
		System.out.println("插入的code为" + code);
		
		//将结果序列化成json
		Map<String, Object> map = new HashMap<>();
		map.put(RESULT_KEY, code);
		String result = JSON.toJSONString(map);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(result);
		printWriter.close();
	}
}
