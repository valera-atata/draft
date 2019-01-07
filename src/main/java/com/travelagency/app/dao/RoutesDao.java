package com.travelagency.app.dao;

import java.util.List;

import com.travelagency.app.entity.RouteEntity;

public interface RoutesDao {
	public boolean saveOrUpdate(RouteEntity routeEntity);
	public List<RouteEntity> list();
	public boolean delete(RouteEntity routeEntity);
}
