package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.RouteEntity;


@Repository
@Transactional
public abstract class AbstractRouteHibernateDao implements BaseDao<RouteEntity> {

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(RouteEntity routeEntity) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(routeEntity);
		return true;
	}

	public List<RouteEntity> list() {
		return session.getCurrentSession().createQuery("from RouteEntity").list();
	}

	public boolean delete(RouteEntity routeEntity) {
		try{
			session.getCurrentSession().delete(routeEntity);
		}catch(Exception ex){
			return false;
		}
		return true;
	}
	
	
}
