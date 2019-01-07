package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.RoleEntity;


@Repository
@Transactional
public abstract class AbstractRoleHibernateDao implements BaseDao<RoleEntity> {

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(RoleEntity roleEntity) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(roleEntity);
		return true;
	}

	public List<RoleEntity> list() {
		return session.getCurrentSession().createQuery("from RoleEntity").list();
	}

	public boolean delete(RoleEntity roleEntity) {
		try{
			session.getCurrentSession().delete(roleEntity);
		}catch(Exception ex){
			return false;
		}
		return true;
	}
	
	
}
