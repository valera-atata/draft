package com.travelagency.app.hibernatedao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travelagency.app.dao.Dao;
import com.travelagency.app.entity.Roles;


@Repository
@Transactional
public class RoleHibernateImpl implements Dao<Roles> {

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(Roles roles) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(roles);
		return true;
	}

	public List<Roles> list() {
		return session.getCurrentSession().createQuery("from roles").list();
	}

	public boolean delete(Roles roles) {
		try{
			session.getCurrentSession().delete(roles);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	
}
