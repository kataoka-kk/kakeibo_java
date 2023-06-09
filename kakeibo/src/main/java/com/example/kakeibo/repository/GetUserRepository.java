package com.example.kakeibo.repository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.kakeibo.data.KakeiboUserEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class GetUserRepository {

	public KakeiboUserEntity getUsers(int userId) throws JsonMappingException, JsonProcessingException {

		RestTemplate temp = new RestTemplate();

		String url = "https://1l9qmgyfm5.execute-api.ap-northeast-1.amazonaws.com/deafult"
				+ "/kakeibo/getusers?p1=" + userId;

		//APIアクセス
		ResponseEntity<String> res = temp.getForEntity(url, String.class);

		//レスポンスを受け取る
		String json = res.getBody();

		ObjectMapper mapper = new ObjectMapper();

		//Dataクラスを生成
		KakeiboUserEntity ent = new KakeiboUserEntity();

		//JSONデコード
		ent = mapper.readValue(json, KakeiboUserEntity.class);

		return ent;

	}

}