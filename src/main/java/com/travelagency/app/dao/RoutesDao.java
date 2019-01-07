package com.travelagency.app.dao;

import java.util.List;

import com.travelagency.app.entity.Routes;

public interface RoutesDao {
	public boolean saveOrUpdate(Routes routes);
	public List<Routes> list();
	public boolean delete(Routes routes);
}
