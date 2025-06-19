package com.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome() {
		System.out.println("WelcomeController.welcome");
		return "home";
	}
	
	@GetMapping("/welcome")
	//in bracket in double quotes end point is mentioned
	@ResponseBody
	//anything that is returned is not treated as a view but will be treated as a string/response
	public String requestparam(@RequestParam(name="myname",defaultValue="GUEST")String name) {
		//defaultValue =>generally,if myname parameter not found in url then it will give 400 bad request error
		//bt by giving defaultValue as second parameter if myname variable is not found in url then it will still
		//run by assigning default value to the variable name
		System.out.println("WelcomeController.requestParam()");
		return "Hello!! Mr. "+name+" how are you..?";
	}
	
	//MOSTLY USED IN REST API'S
	
	@GetMapping("/path/{id}")
	@ResponseBody
//	public String pathVar(@PathVariable("id")Long id) {
		public String pathVar(@PathVariable(value="id")Long id) {
		System.out.println("WelcomeController.pathvar()");
		return "Hello!! Mr. "+id+" how are you..?";
	
	}
	
	@GetMapping("/cookie")
	@ResponseBody
public String cookie(@CookieValue("JSESSIONID")String cookieVal) {
		//public String pathVar(@CookieValue("JSEESIONId")String cookieVal) {
	 //JSESSIONID SHOULD BE SAME NOT A SINGLE WORD SHOULD BE CHANGED
		System.out.println("WelcomeController.cookieVal()");
		return "Hello!! Your JSESSIONID is "+cookieVal ;
	
	}
	
	@GetMapping("/secondCookie")
	//making cookie by own customization
	@ResponseBody
public String secondCookie(@CookieValue("NewCookie")String cookieVal) {
		//public String pathVar(@CookieValue("JSEESIONId")String cookieVal) {
	 //JSESSIONID SHOULD BE SAME NOT A SINGLE WORD SHOULD BE CHANGED
		System.out.println("WelcomeController.secondCookie()");
		return "Hello!! Your JSESSIONID is "+cookieVal;
	
	}
	
	
	
	@GetMapping("/setCookie")
public String setCookie(HttpServletResponse response) {
		//public String pathVar(@CookieValue("JSEESIONId")String cookieVal) {
	 //JSESSIONID SHOULD BE SAME NOT A SINGLE WORD SHOULD BE CHANGED
		System.out.println("WelcomeController.setCookie()");
		
		Cookie  cookie=new Cookie("NewCookie","FirstCookieObj");
		cookie.setMaxAge(30);
		//time in seconds 
		response.addCookie(cookie);
		return  "redirect:/secondCookie";
	
	}
	
	

}
