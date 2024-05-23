package com.example.todolist.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class welcomecontroller {
	private Authentication authentication;

	@RequestMapping(value = "/")
	public String welcomepage(ModelMap model) {
		model.put("name", getLoggedinUsername());
		return "welcome";
	}

	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

	/*
	 * public Logincontroller(Authentication authentication) { super();
	 * this.authentication = authentication; }
	 * 
	 * @RequestMapping(value="login",method=RequestMethod.GET) public String
	 * logininfo() { return "login"; }
	 * 
	 * @RequestMapping(value="login",method=RequestMethod.POST) public String
	 * welcomeinfo(@RequestParam String name,@RequestParam String password,ModelMap
	 * model) { if(authentication.authenticationService(name,password)) {
	 * model.put("name", name); model.put("password",password); return "welcome"; }
	 * model.put("errormsg","invalid credentials! please try again "); return
	 * "login"; }
	 */
}
