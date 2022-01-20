package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value="/guest")
public class GuestbookController{
	
	//필드
	@Autowired 
	private GuestbookDao guestbookDao;
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) { 
		System.out.println("list");
		
		List<GuestbookVo> gvo = guestbookDao.getList();
		//System.out.println(gvo.toString());
		
		model.addAttribute("gbList", gvo);
		
		//포워드 경로
		return "list"; //  /web-inf/list.jsp
		
	}
	
	
	@RequestMapping(value="/addList", method= {RequestMethod.GET, RequestMethod.POST})
	public String addList(@ModelAttribute GuestbookVo gVo) {
		System.out.println("addList");
		guestbookDao.addGuest(gVo);
		
		return "redirect:/guest/list";
	}

	
	@RequestMapping(value="/deleteForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(Model model, @RequestParam("no")int no) {
		System.out.println("deleteForm");
		
		model.addAttribute("dno", no);
		return "deleteForm"; //  /web-inf/views/deleteForm.jsp
	}

	
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no,
						 @RequestParam("password") String password) {
		
		guestbookDao.deleteGuest(no,password);
		
		return "redirect:/guest/list";
	}
}
