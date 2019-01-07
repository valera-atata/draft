package com.travelagency.app.dao.abstracthibernatedao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelagency.app.dao.BaseDao;
import com.travelagency.app.entity.UserEntity;

@Repository
@Transactional
public abstract class AbstractUserHhibernate implements BaseDao<UserEntity> {

	@Autowired
	SessionFactory session;
	
	public boolean saveOrUpdate(UserEntity userEntity) {
		session.getCurrentSession().saveOrUpdate(userEntity);
		return true;
	}

	public List<UserEntity> list() {
		return session.getCurrentSession().createQuery("from UserEntity").list();
	}

	public boolean delete(UserEntity userEntity) {
		try{
			session.getCurrentSession().delete(userEntity);
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
	
	
}
