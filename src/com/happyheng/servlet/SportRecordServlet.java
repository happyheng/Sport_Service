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
import com.happyheng.service.SportRecordService;
import com.happyheng.utils.TextUtils;

@WebServlet("/Record")
public class SportRecordServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4140428449352995911L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userKey = requestJson.getString("ukey");
		int sportId = requestJson.getIntValue("id");
		float posx = requestJson.getFloatValue("posx");
		float posy = requestJson.getFloatValue("posy");
		String location = requestJson.getString("location");
		
		SportRecordService service = new SportRecordService();
		
		Map<String, Object> responseMap = new HashMap<>();
		//不为空，则说明是来插入信息并获取sportId的
		if (!TextUtils.isEmpty(userKey)) {
			SportRecordResult result = service.record(userKey, posx, posy, location);
			
			//说明插入成功
			if (result.getCode() == 0) {
				responseMap.put("id", result.getSportId());	
			}
			responseMap.put("return", result.getCode());
			
		} else {
			int resultCode = service.record(sportId, posx, posy, location);
			
			responseMap.put("return", resultCode);
		}
		
		String result = JSON.toJSONString(responseMap);
		System.out.println("结果为"+result);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.write(result);
		printWriter.close();
	}

}
