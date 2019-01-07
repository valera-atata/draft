package com.travelagency.app.dao;

import java.util.List;

public interface BaseDao<T> {
	public boolean saveOrUpdate(T t);
	public List<T> list();
	public boolean delete(T t);
}
