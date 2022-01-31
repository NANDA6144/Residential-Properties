package com.klef.demo;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class admin_controller {
	@Autowired
	admin_service adserv;
	@Autowired
	EntityManager entityManager;
	
	@GetMapping("/admin_signin")
	public ModelAndView admin_signin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("admin_signin");
		return mv;
	}
	
	@PostMapping("/admin_login")
	public String admin_login(@RequestParam("email")String email,@RequestParam("password")String password,HttpServletRequest req)
	{
		return "redirect:/admin_homepage";
	}
	
	@GetMapping("/admin_homepage")
	public ModelAndView admin_homepage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("admin_homepage");
		return mv;
	}
	@GetMapping("/adminhomepage")
	public ModelAndView adminhomepage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("adminhomepage");
		return mv;
	}
	
	
	@GetMapping("/get_customers_profile")
	public ModelAndView get_customers_profile()
	{
		List<customer_profile> cp=adserv.get_customers_profile();
		/*for(int i=0;i<fp.size();i++)
		{
			farmer_profile x=fp.get(i);
			System.out.println(x.getName()+""+x.getId());
		}*/
		ModelAndView mv=new ModelAndView();
		mv.setViewName("admin_customers_profile");
		mv.addObject("cp",cp);
		return mv;
	}
	
	@GetMapping("/get_CustomerPropertyReq")
	public ModelAndView get_CustomerPropertyReq()
	{
		List<customer_sellyourproperty> fcr=adserv.get_CustomerPropertyReq();
		for(int i=0;i<fcr.size();i++)
		{
			customer_sellyourproperty x=fcr.get(i);
			System.out.println(x.getCropname()+""+x.getId());
		}
		ModelAndView mv=new ModelAndView();
		mv.setViewName("admin_DisCustomerPropertyReq");
		mv.addObject("fcr",fcr);
		return mv;
	}
	
	@GetMapping("/updateFCR/{id}")
	public String updateFCR(@PathVariable("id")int id,HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		adserv.updateFCR(id);
		return "redirect:/get_CustomerPropertyReq";
	}
}
