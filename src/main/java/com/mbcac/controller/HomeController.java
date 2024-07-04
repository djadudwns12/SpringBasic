package com.mbcac.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller // 아래의 클래스가 컨트롤러 객체임을 명시
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); // 로그를 남길 수있는 객체
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET) // uri에 "/"가 get 방식으로 요청이 되면 아래의 메서드가 동작하도록 지정
	public String home(Locale locale, Model model) { // Model은 view로 보내주는 객채 (바인딩하는 것)
		logger.info("Welcome home! The client locale is {}.", locale);
		
		System.out.println("Home 메서드 실행됨");
		
		Date date = new Date(); // 현재 날짜 객체 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date); // 날짜시간을 문자열로 변경
		
		
		// Model : 뷰단으로 전송할 데이터를 감쌀 전용객체
		model.addAttribute("serverTime", formattedDate ); // model객체에 바인딩
		 
		return "home"; // forwarding 될 뷰단의 주소
	}
	@RequestMapping("/ex1") // /ex1이 get 방식으로 요청되면 아래의 메서드가 동작하도록 ...
	public String examView(Model model) 
	{
		System.out.println("examView 메서드가 동작함");
		model.addAttribute("name","둘리");
		return "ex1"; // 포워딩될 view단의 주소(WEB-INF/view/ex1.jsp)
	}
	@RequestMapping(value="/ex2",method = RequestMethod.GET)
	public void examView2(Model model) {
		System.out.println("ex2View()");
		
		// void를 반환하면 mapping된 주소.jsp파일을 찾게 된다.(/web-inf/view/하위에서)
		
	}
	@RequestMapping("/ex3")
	public String examRedirect() {
		System.out.println("examRedirect...");
		
		
		return "redirect:/"; // 로그인후 다시 돌아갈때
		
		
	}
	// ex4를 get 방식으로 요청하면 examView()가 호출 되도록 리다이렉트 되는 메서드를 examRedirect2라는 메서드로 작성해보세요
	@RequestMapping("/ex4")
	public String examRedirect4() {
		System.out.println("examRedirect...");
		
		
		return "redirect:/ex1"; // 로그인후 다시 돌아갈때
		
		
	}
	// 
	@RequestMapping("/ex5")
	public ModelAndView exModelAndView() {
		// ModelAndView 객체 : 출력될 view와 보내줄 model을 정의 하는 객체
		System.out.println("exModelAndView.............");
		
		Map model = new HashMap<String, String>();
		
		model.put("name", "둘리");
		model.put("name1", "도우너");
		model.put("name2", "고길동");
		model.put("name3", "팬더");
		
		
		ModelAndView mav = new ModelAndView("ex5",model);
		
		
		/*
		 * ModelAndView mav = new ModelAndView();
		 * mav.setView("ex5");
		 * 	mav.addObject("name", model);
		 * 로 표현가능
		 * 
		 * */
		
		
		return mav;
	}
}
