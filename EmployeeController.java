package com.klef.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController 
{
  @Autowired
   EmployeeService empservice;
  
   @GetMapping("/adminhome")
   public ModelAndView adminhome()
   {
     ModelAndView mv = new ModelAndView();
     mv.setViewName("adminhome");
     return mv;
   }
   
   @GetMapping("/addemployee")
   public ModelAndView addemployee()
   {
     // emp - request object of type Employee
     return new ModelAndView("addemployee","emp",new Employee());
   }
   
   @PostMapping("/submitempdata")
   public ModelAndView submitempdata(@ModelAttribute("emp") Employee emp) // you can take any method name
   {
     empservice.addemployeerecord(emp);
     
     ModelAndView mv = new ModelAndView();
     mv.setViewName("addsuccess");
     mv.addObject("name",emp.getName());
     
     return mv;
   }
   @GetMapping("/viewemployees")
   public ModelAndView vieweployees()
   {
     List<Employee> employees = empservice.getallemployeerecords();
     ModelAndView mv = new ModelAndView();
     mv.setViewName("viewemployees");
     mv.addObject("empdata",employees);
     
     return mv;
   }
   /*@GetMapping("/deletemployee/{empid}")
   public ModelAndView deletemployee(@PathVariable("empid") int empid)
   {
     empservice.deleteemployeerecord(empid);
   
     ModelAndView mv = new ModelAndView();
     mv.setViewName("deletesuccess");
     
     return mv;
   }*/
   @GetMapping("/deletemployee/{empid}")
   public String deletemployee(@PathVariable("empid") int empid)
   {
     empservice.deleteemployeerecord(empid);
   
     return "redirect:/viewemployees";
  }
}