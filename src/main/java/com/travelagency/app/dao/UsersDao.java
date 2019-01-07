package com.travelagency.app.dao;

import java.util.List;

import com.travelagency.app.entity.Users;

public interface UsersDao {
	public boolean saveOrUpdate(Users users);
	public List<Users> list();
	public boolean delete(Users users);
}
