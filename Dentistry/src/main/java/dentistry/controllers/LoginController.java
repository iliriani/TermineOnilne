package dentistry.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dentistry.model.User;
//import org.springframework.web.bind.annotation.RestController;
import dentistry.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/log", method=RequestMethod.GET)
	public String getLogin() {
		return "login";
	}	

	
	@RequestMapping(value="/intro", method=RequestMethod.POST)
	public String intro(HttpServletRequest request, Model model) {
		String user= request.getParameter("user");
		String pass= request.getParameter("pass");
		if(checkUser(user, pass)) {
		model.addAttribute("loged_user",user);
		model.addAttribute("user_pass", pass);
		return "terminView";
		}
		
		else {return "login";}
	}
	
	
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String newUser(@RequestParam String idNew, @RequestParam String emriNew, 
			@RequestParam String passNew,@RequestParam String rolNew, Model model) {
		
		User u = new User();
		u.setId(idNew);
		u.setName(emriNew);
		u.setRole(rolNew);
		u.setPass(passNew);
		loginService.addUser(u);
		model.addAttribute("newU",u.getName());
		return "intro";
	}
	
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newUser() {
		
		return "newUser";
	}
	
	
	public boolean checkUser(String user, String pass) {
		List<User> users = loginService.getAllUser();
		
		for(User u:users) {
			if(user.equals(u.getName()) && pass.equals(u.getPass())) {
				return true;
			}
		}
		
		return false;

		
//		if(user.equals("lili") && pass.equals("123")) {
//			return true;
//		}return false;
//		
	}
	
	
}
