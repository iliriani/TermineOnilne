package dentistry.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import dentistry.model.User;
import dentistry.service.LoginService;
import dentistry.service.TerminService;

@Controller
public class RegisterController implements WebMvcConfigurer{
	
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
//    }

	@Autowired
	LoginService loginService;
//	@Autowired
//	TerminService terminService;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		
		model.addAttribute("user", new User());
		return "newUser";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid User useri, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {return "newUser";}
		
		
		if(loginService.isUserPresent(useri.getId())){
			model.addAttribute("exist", true);
			return "newUser";
		}
		
//		User u=initUser();
		
		loginService.addUser(useri);
		model.addAttribute("loged_user",useri.getName());
//		model.addAttribute("termins",terminService.getAllTermins());
		model.addAttribute("users",loginService.getAllUser());
		return "terminView";
	}
	
	public User initUser(String id, String name, String pass, String role) {
		User u= new User(id,name,pass,role);
		return u;
	}
	
}
