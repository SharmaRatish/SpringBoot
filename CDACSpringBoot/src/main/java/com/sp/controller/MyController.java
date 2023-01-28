package com.sp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.sp.model.Employee;
import com.sp.model.UserData;
import com.sp.repo.EmployeeRepo;

@Controller
public class MyController {
	@Autowired
	EmployeeRepo employeeRepo;
	@GetMapping
	public String empForm() {   // will display empform
		return "empform";
	}
	
	@RequestMapping(value="/empdata",method = RequestMethod.POST)
	public ModelAndView empData(Employee employee) {
		ModelAndView mv = new ModelAndView("/welcomepage");
		Employee cr=employeeRepo.save(employee);
		if(cr!=null)
		{
			String msg="<font color=green>Record Added successfully</font>";
			mv.addObject("msg",msg);
		}
		else {
			String msg="<font color=red>Record Not Added successfully</font>";
			mv.addObject("msg",msg);
		}
		return mv;
	}
	/*
	 * @GetMapping("/getemployee") public ModelAndView getAllEmployee() {
	 * ModelAndView mv = new ModelAndView("/showemployee"); Iterable<Employee>
	 * list=employeeRepo.findAll(); mv.addObject("list",list); return mv;
	 * 
	 * @RequestMapping(value = "/empdata", method = RequestMethod.POST) public
	 * ModelAndView empData(Employee employee) { ModelAndView mv=new
	 * ModelAndView("/wellcomehome"); Employee e=employeeRepo.save(employee);
	 * 
	 * if (e!=null) { String msg="<font color=green>Record Added</font>";
	 * mv.addObject("msg",msg); } else { String
	 * msg="<font color=red>Record not Added</font>"; mv.addObject("msg",msg); }
	 * return mv; }
	 */
		
		
		//show All employee
		@GetMapping("/getemployee")
		public ModelAndView getAllEmployee() {
			
			ModelAndView mv=new ModelAndView("/showemployee");
			Iterable<Employee> list=employeeRepo.findAll();
			
			mv.addObject("list", list);
			return mv;		
		}
		
		//search Employee byId
		@RequestMapping(value = "/searchemployee" , method = RequestMethod.POST)
		public ModelAndView getSearchById(@RequestParam int id) {
			ModelAndView mv=new ModelAndView("/wellcomehome");
			Optional<Employee> list=employeeRepo.findById(id);
			if (list.isPresent()) {
				Employee emp=list.get();
				mv.addObject("emp", emp);
				mv.addObject("msg", "<a href=showemp?emp="+id+">Record Found</a>");
			}else {
				mv.addObject("msg", "Record Not Found");
			}
			return mv;
		}
		
		//Show Employee By Id
		@GetMapping("/showemp")
		public ModelAndView showemp(@RequestParam int emp)
		{
			ModelAndView mv=new ModelAndView("/showemp");
			Optional<Employee> list=employeeRepo.findById(emp);
			Employee employee=list.get();
			mv.addObject("emp", employee);
			return mv;
		
		
		
	}
	
	
	//17/Jan/2023
	@GetMapping("/")
public String myController() 
{
	return "welcomepage";
	
}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/contactus")
	public String contactUs() {
		return "contactus";
	}
	@RequestMapping("/userform")
	public String userfrom() 
	{
		return "userform";
	}
	@RequestMapping(value = "/UserData",method = RequestMethod.POST)
	public ModelAndView  getUserData(UserData userdata) {
		
		ModelAndView mv=new ModelAndView("/UserDetails");
		mv.addObject("userdata",userdata);
		return mv;		
	}
	
	
	@RequestMapping(value = "/userdata",method = RequestMethod.GET)
	public ModelAndView  getData(@RequestParam String user) {
		
		ModelAndView mv=new ModelAndView("/user");
		mv.addObject("user",user);
		return mv;		
	}
	
	
	@GetMapping("/user/{uname}")
	public ModelAndView  getUser(@PathVariable String uname) {
		
		ModelAndView mv=new ModelAndView("/user");
		mv.addObject("user",uname);
		return mv;		
	}
}
