package com.me.TripPlanning.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.boot.model.source.spi.PluralAttributeElementNature;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;

import com.me.TripPlanning.pojo.Plan;
import com.me.TripPlanning.pojo.User;

public class PlanDAO extends DAO{
	
	public void save(Plan plan) throws Exception{
		try {
			begin();
			getSession().save(plan);
			commit();
			getSession().close();
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while reigster user: " + e.getMessage());
		}
	}
	
	public List<Plan> getAllPlans() throws Exception{
		try {
			begin();
			Query query = getSession().createQuery("from Plan");
			List<Plan> plans = query.list();
			commit();
			return plans;
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while reigster user: " + e.getMessage());
		}
	}
	
	public Plan likePlan(int id) throws Exception{
		try {
			begin();
			Query query = getSession().createQuery("from Plan where planId=:id");
			query.setInteger("id", id);
			Plan plan = (Plan)query.uniqueResult();
			int num = plan.getLikeNum();
			num+=1;
			plan.setLikeNum(num);
			getSession().update(plan);
			commit();
			return plan;
			
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while reigster user: " + e.getMessage());
		}
	}
	
	public Plan getPlan(int id) throws Exception{
		try {
			begin();
			Query query = getSession().createQuery("from Plan where planId=:id");
			query.setInteger("id", id);
			Plan plan = (Plan)query.uniqueResult();
			commit();
			return plan;
			
		} catch (HibernateException e) {
			rollback();
			throw new Exception("Exception while reigster user: " + e.getMessage());
		}
	}
	
	
	
	


}
