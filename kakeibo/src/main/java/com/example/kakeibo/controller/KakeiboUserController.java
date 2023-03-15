package com.example.kakeibo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.kakeibo.service.KakeiboUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class KakeiboUserController {

	private final KakeiboUserService kakeiboUserService;

	public KakeiboUserController(KakeiboUserService kakeiboUserService) {
		this.kakeiboUserService = kakeiboUserService;
	}

	@GetMapping("/kakeibouser")
	public String showKakeiboUser(Model model) throws JsonMappingException, JsonProcessingException {

		model.addAttribute("userlist", kakeiboUserService.getUsers(0).getUserList());

		return "kakeibouser";
	}
}