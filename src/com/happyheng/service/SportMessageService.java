package com.happyheng.service;

import com.happyheng.entity.result.SportMessageResult;

public interface SportMessageService {
	public SportMessageResult getSportMessage(String userKey,String sportId);
}
