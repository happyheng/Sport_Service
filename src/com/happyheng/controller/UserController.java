package com.happyheng.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.happyheng.entity.result.LoginResult;
import com.happyheng.service.LoginService;
import com.happyheng.service.RegisterService;
import com.happyheng.utils.ContextUtils;

@Controller
public class UserController extends BaseController {

//	public UserController() {
//		super();
//	}

	@RequestMapping(value="/Register",method=RequestMethod.POST)
	public void register(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String userName = (String) req.getAttribute("uname");
		String passWord = (String) req.getAttribute("upwd");
		String nickName = (String) req.getAttribute("nkname");

		System.out.println("请求的userName为" + userName + "\n请求的passWord为" + passWord + "\nnickName为" + nickName);

		RegisterService service = (RegisterService) ContextUtils.getContext().getBean("registerService");
		int code = service.register(userName, passWord, nickName);
		System.out.println("插入的code为" + code);

		// 将结果序列化成json
		Map<String, Object> map = new HashMap<>();
		map.put(RESULT_KEY, code);
		String result = JSON.toJSONString(map);

		PrintWriter printWriter = resp.getWriter();
		printWriter.write(result);
		printWriter.close();
	}

	@RequestMapping(value = "/Login",method=RequestMethod.POST)
	public void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		String userName = (String) req.getAttribute("uname");
		String passWord = (String) req.getAttribute("upwd");

		System.out.println("请求的userName为" + userName + "\n请求的passWord为" + passWord);

		LoginService service = (LoginService) ContextUtils.getContext().getBean("loginService");
		LoginResult loginResult = service.login(userName, passWord);

		Map<String, Object> map = new HashMap<>();
		map.put(RESULT_KEY, loginResult.getCode());
		// 如果成功，还需要加上token
		if (loginResult.getCode() == 0) {
			Map<String, Object> dataMap = new HashMap<>();
			dataMap.put("token", loginResult.getToken());

			map.put("data", dataMap);
		}

		String result = JSON.toJSONString(map);
		System.out.println("结果为" + result);

		PrintWriter printWriter = resp.getWriter();
		printWriter.write(result);
		printWriter.close();

	}
}
