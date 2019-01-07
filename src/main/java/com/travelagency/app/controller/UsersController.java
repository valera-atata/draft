package com.travelagency.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.RoleEntity;
import com.travelagency.app.entity.RouteEntity;
import com.travelagency.app.entity.UserEntity;

@Controller
@RequestMapping("users")
public class UsersController {
	
	@Autowired
	BaseDao<UserEntity> userDao;
	
	@Autowired
	BaseDao<RouteEntity> routeDao;
	
	@Autowired
	BaseDao<RoleEntity> roleDao;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage(){
		System.out.println(11111);
//		System.out.println(userServices);
		System.out.println(routeDao);

		
		System.out.println(userDao);
		System.out.println(roleDao);
		ModelAndView view = new ModelAndView("users");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(UserEntity userEntity){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(22222);
//		System.out.println(userServices);
		System.out.println(userDao);
		if(userDao.saveOrUpdate(userEntity)){
			map.put("status","200");
			map.put("message","Your record have been saved successfully");
		}
		return map;
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(UserEntity userEntity){
		Map<String,Object> map = new HashMap<String,Object>();
		System.out.println(33333);
//		System.out.println(userServices);
		System.out.println(userDao);
		List<UserEntity> list = userDao.list();
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
	public @ResponseBody Map<String,Object> delete(UserEntity userEntity){
		System.out.println(44444);
//		System.out.println(userServices);
		System.out.println(userDao);
		Map<String,Object> map = new HashMap<String,Object>();
		if(userDao.delete(userEntity)){
			map.put("status","200");
			map.put("message","Your record have been deleted successfully");
		}
		
		return map;
	}
}
