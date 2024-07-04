package com.mbcac.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbcac.model.ProductVO;


@Controller
@RequestMapping("/exam") // exam uri가 호출되면 현재의 컨트롤러가 동작하도록 
public class ExamController 
{
	@RequestMapping("outputProduct")
	public String outputProduct(Model model) 
	{
		System.out.println("outputProduct..............");
	
		ProductVO exProductVO = new ProductVO("240704_1","새우깡",5,2000,"손이가요 손이가~~");
		
		System.out.println(exProductVO.toString());
		
		
		
		 model.addAttribute("product",new ProductVO("240704_1","새우깡",5,2000,"손이가요 손이가~~")) ;
		 
		 return "/exam/outputProduct"; // 
		
		
	}
	@RequestMapping("/inputProduct")
	public void inputProduct()  // /exam/inputProduct가 get방식으로 호출되었을때
	{
		// 아래의 view페이지 (제품입력 페이지 ) 출력
		System.out.println("inputProduct");
	}
	// requestParam을 이용한 매개변수 수집방법
//	@RequestMapping(value = "/inputProduct" , method = RequestMethod.POST)
//	public void savaProduct(@RequestParam("productNo") String productNo,
//							@RequestParam("productName") String productName,
//							@RequestParam("qty") int qty,
//							@RequestParam("price") int price,
//							@RequestParam("productNickName") String productNickName,
//							ProductVO p
//							)  // /exam/inputProduct가 get방식으로 호출되었을때
//	{
//		//  /exam/inputProduct가 post방식으로 호출될때 현재메서드 매핑되도록 
//		System.out.println("savaProduct......");
//		
//		
////		System.out.println("productNo :"+productNo);
//		
//		ProductVO product = new ProductVO(productNo, productName, qty, price, productNickName);
//		System.out.println(product.toString());
//		System.out.println("p : "+p);
//	
//	
//	}
	// 파라미터를 Spring Framework가 자동으로 객체로 수집하여 준다.
	@RequestMapping(value = "/inputProduct" , method = RequestMethod.POST)
	public String savaProduct(ProductVO p,HashMap<String, Object> map,RedirectAttributes redirectattributes)  // 매개변수를 자동으로 수집하여 준다. vo에 한꺼번에 담아주는 것이 가능하다.
	{
		//  /exam/inputProduct가 post방식으로 호출될때 현재메서드 매핑되도록 
		System.out.println("savaProduct......");
		
		
//		System.out.println("productNo :"+productNo);
		
		System.out.println("p : "+p.toString());
		System.out.println(map);
		
		
		// p를 서비스단 -> dao단  -> db에 잘 저장했다 치자~~
		
		String msg = null;
		
		if(p != null) {
			msg = "success";
		}
	
//		redirectattributes.addAttribute("status",msg); // status 라는 변수의 값이 msg로...( 쿼리 스트링에 변수의 값이 보임)
		// status 라는 변수의 값이 msg로...( 쿼리 스트링에 추가되지않고 그냥바인딩)
		redirectattributes.addFlashAttribute("status",msg); // 바인딩은 되나 쿼리스트링으로는 안보임(그냥 바인딩 됨) / 
		
		return "redirect:/";
	}
	
}
