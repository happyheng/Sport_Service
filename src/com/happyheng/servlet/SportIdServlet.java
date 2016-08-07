package com.happyheng.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.happyheng.entity.result.SportRecordResult;
import com.happyheng.service.SportIdService;
import com.happyheng.service.impl.BaseService;
import com.happyheng.service.impl.SportIdServiceImpl;

@WebServlet("/SportId")
public class SportIdServlet extends BaseServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5239059095796134366L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userKey = (String) req.getAttribute("ukey");
		
		//得到返回的结果
		SportIdService service = (SportIdService)context.getBean("sportIdService");
		SportRecordResult result = service.getSportId(userKey);
		
		Map<String, Object> responseMap = new HashMap<>();
		//说明插入成功
		if (result.getCode() == BaseService.RESULT_CODE_SUCCESS) {
			responseMap.put("id", result.getSportId());	
		}
		responseMap.put(RESULT_KEY, result.getCode());
		
		String JsonResult = JSON.toJSONString(responseMap);
		System.out.println("结果为"+JsonResult);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(JsonResult);
		printWriter.close();
	}
}
