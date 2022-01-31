package com.klef.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	@Autowired
	customer_service serv;
	@Autowired
	EntityManager entityManager;
	
	
	@GetMapping("/home")
	public ModelAndView home()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("home");
	  return mv;
	}

	@GetMapping("/customer_index")
	public ModelAndView customer_index()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_index");
		return mv;
	}
	
	@GetMapping("/customer_signin")
	public ModelAndView customer_signin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_signin");
		return mv;
	}
	
	@GetMapping("/customer_signup")
	public ModelAndView customer_signup()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_signup");
		return mv;
	}
	
	@PostMapping("/customer_signup_register")
	public ModelAndView submituser(@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("phonenumber")String phonenumber,@RequestParam("address")String address,@RequestParam("password")String password)
	{
		customer_profile cp=new customer_profile();
		cp.setName(name);
		cp.setEmail(email);
		cp.setPhonenumber(phonenumber);
		cp.setAddress(address);
		cp.setPassword(password);
		serv.add_customer_profile(cp);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_homepage");
		mv.addObject(cp);
		return mv;
	}
	
	@PostMapping("/customer_login")
	public String userlogin(@RequestParam("email")String email,@RequestParam("password")String password,HttpServletRequest req)
	{  
		ModelAndView mv=new ModelAndView();
	    List<customer_profile> users = serv.customerlogin(email, password);
	    if(users.isEmpty())
	    {
	    	mv.setViewName("error");
	        return "error";
	    }
	    HttpSession sess=req.getSession();
	    sess.setAttribute("email",email);
	    sess.setAttribute("id",users.get(0).getId());
	    
		return "redirect:/customer_homepage";
	}
	
	@GetMapping("/customer_homepage")
	public ModelAndView customer_homepage()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("customer_homepage");
	  return mv;
	}
	
	@GetMapping("/customer_sellyourproperty")
	public ModelAndView customer_sellyourproperty()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("customer_sellyourproperty");
	  return mv;
	}
	@GetMapping("/properties1")
	public ModelAndView properties1()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("properties1");
	  return mv;
	}
	@GetMapping("/aboutus")
	public ModelAndView aboutus()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("aboutus");
	  return mv;
	}
	@GetMapping("/contact")
	public ModelAndView contact()
	{
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("contact");
	  return mv;
	}
	
	@PostMapping("/customer_sellyourproperty_register")
	public String customer_sellyourproperty_register(@RequestParam("cropname")String cropname,@RequestParam("quantity")String quantity,@RequestParam("cost")int cost,HttpServletRequest req)
	{
		HttpSession sess=req.getSession(false);
		customer_sellyourproperty csyp=new customer_sellyourproperty();
		csyp.setEmail((String)sess.getAttribute("email"));
		csyp.setCropname(cropname);
		csyp.setQuantity(quantity);
		csyp.setCost(cost);
		csyp.setStatus("Not Accepted");
		
		serv.add_customer_sellyourproperty(csyp);
		return "redirect:/customer_homepage";
	}
	
	@GetMapping("/get_PropertyYouSold")
	public ModelAndView get_PropertyYouSold()
	{
		List<customer_sellyourproperty> csyp=serv.get_PropertyYouSold();
		for(int i=0;i<csyp.size();i++)
		{
			customer_sellyourproperty x=csyp.get(i);
			System.out.println(x.getCropname()+""+x.getId());
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("customer_PropertyYouSold");
		mv.addObject("csyp",csyp);
		return mv;
	}
	
	
	@GetMapping("/customer_logout")
	public String userlogout(HttpServletRequest req)
	{
	    HttpSession sess=req.getSession(false);
		System.out.println(sess.getAttribute("email"));
		sess.removeAttribute("email");
		System.out.println(sess.getAttribute("id"));
		sess.removeAttribute("id");
		return "redirect:/home";
	}
}
