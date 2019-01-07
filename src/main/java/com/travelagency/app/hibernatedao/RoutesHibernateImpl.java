package com.travelagency.app.hibernatedao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelagency.app.dao.RoutesDao;
import com.travelagency.app.entity.Routes;


@Repository
@Transactional
public class RoutesHibernateImpl implements RoutesDao {

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Routes routes) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(routes);
		return true;
	}

	public List<Routes> list() {
		return session.getCurrentSession().createQuery("from Routes").list();
	}

	public boolean delete(Routes routes) {
		try{
			session.getCurrentSession().delete(routes);
		}catch(Exception ex){
			return false;
		}
		return true;
	}
	
	
}
