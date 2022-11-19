package com.health.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.health.domain.HealthProVO;
import com.health.service.ProgramService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/program")
@Log4j
public class ProgramController {
	@Autowired
	private ProgramService programSVC;
	
	@RequestMapping("/create")
	public String createProgram() {
		return "program/create";
	}
	
	@RequestMapping("/createForm")
	public String insertProgram(HealthProVO vo, RedirectAttributes RA) {
		boolean rs = false;
		
		rs = programSVC.createProgram(vo);
		
		if(rs) {
			log.info("등록 성공");
			return "redirect:/program/pList";
		} else {
			RA.addFlashAttribute("msg","등록 실패");
			return "redirect:/program/create";
		}
	}
	
	@RequestMapping("/pList")
	public void getList(Model model) {
		// 프로그램 정보를 저장할 공간...
		ArrayList<HealthProVO> list = programSVC.getList();
		
		model.addAttribute("programList", list);
	}
	
	@RequestMapping("/programDelete")
	public String programDelete(@RequestParam("num") String pid) {
		programSVC.removeProgram(Integer.parseInt(pid));
		return "redirect:/program/pList";
	}
}
