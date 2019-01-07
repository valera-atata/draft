package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.daoapi.UsersDao;
import com.entities.Users;
import com.servicesapi.UsersService;

@Controller
@RequestMapping("users")
public class UsersController {
	
	@Autowired
	UsersService userServices;
	
	@Autowired
	UsersDao userDao;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		System.out.println(11111);
		System.out.println(userServices);
		System.out.println(userDao);
		ModelAndView view = new ModelAndView("users");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(Users users){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(22222);
		System.out.println(userServices);
		System.out.println(userDao);
		if(userDao.saveOrUpdate(users)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(Users users){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(33333);
		System.out.println(userServices);
		System.out.println(userDao);
		List<Users> list = userDao.list();
		if (list != null) {
			map.put("status","200");
			map.put("message","Data found");
			map.put("data", list);
		} else {
			map.put("status","404");
			map.put("message","Data not found");			
		}
		return map;
	}
	
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(Users users){
		System.out.println(44444);
		System.out.println(userServices);
		System.out.println(userDao);
		Map<String,Object> map = new HashMap<String,Object>();
		if(userDao.delete(users)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
}
