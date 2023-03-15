package com.example.kakeibo.service;

import org.springframework.stereotype.Service;

import com.example.kakeibo.data.KakeiboUserEntity;
import com.example.kakeibo.repository.GetUserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class KakeiboUserService {

	private GetUserRepository getUserRepository;

	public KakeiboUserService(GetUserRepository getUserRepository) {
		this.getUserRepository = getUserRepository;
	}

	public KakeiboUserEntity getUsers(int userId) throws JsonMappingException, JsonProcessingException {
		KakeiboUserEntity kakeiboUserEntity = new KakeiboUserEntity();
		kakeiboUserEntity = getUserRepository.getUsers(userId);
		return kakeiboUserEntity;
	}

}