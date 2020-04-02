package com.wellsfargo.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(value={"/index"},produces="application/json")
	public String index(){
		return "index";
	}
	

	@GetMapping(value={"/login"},produces="application/json")
	//@ResponseBody
	public String login(Model model, String error, String logout){
		if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        
        return "login";
	}
	
	//------------start of pages code----
	
	@RequestMapping(value="/admin/contactus",method=RequestMethod.GET)
	public ModelAndView contactus(){
		ModelAndView modelAndView=new ModelAndView();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		UserDTO user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("welcomeMessage", user.getName() + " "+ user.getRoles());
		for(RoleDTO role : user.getRoles()){
			if(role.getRole_id()==1){
				modelAndView.addObject("userRole", "ADMIN");
				break;
			}else if(role.getRole_id()==2){
				modelAndView.addObject("userRole", "SUPER_ADMIN");
				break;
			}
		}
		
		modelAndView.setViewName("/contactus");
		return modelAndView;
		
	}
	
	@RequestMapping(value="/admin/category",method=RequestMethod.GET)
	public ModelAndView categoryPage(){
		ModelAndView modelAndView=new ModelAndView();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		UserDTO user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("welcomeMessage", user.getName() + " Email-"+ user.getEmail());
		for(RoleDTO role : user.getRoles()){
			System.out.println("role--> "+role.getRoleName());
			if(role.getRole_id()==1){
				modelAndView.addObject("userRole", "ADMIN");
				break;
			}else if(role.getRole_id()==2){
				modelAndView.addObject("userRole", "SUPER_ADMIN");
				break;
			}
		}
		
		modelAndView.setViewName("/category");
		return modelAndView;
		
	}
	
	//------------end of page code-------------- nb
	
	@PostMapping(value="/login1",produces="application/json")
	@ResponseBody
    public String login1() {
        return "success1";
    }
	
	
	@GetMapping({"/contactus"})
	    public String welcome(Model model) {
	        return "contactus";
	  }
	
	@RequestMapping(value="/save",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String save(@RequestBody UserDTO userDTO){
		userService.saveUser(userDTO);
		return "success";
	}
 }
