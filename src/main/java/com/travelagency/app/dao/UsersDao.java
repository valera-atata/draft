package com.travelagency.app.dao;

import java.util.List;

import com.travelagency.app.entity.UserEntity;

public interface UsersDao {
	public boolean saveOrUpdate(UserEntity userEntity);
	public List<UserEntity> list();
	public boolean delete(UserEntity userEntity);
}
