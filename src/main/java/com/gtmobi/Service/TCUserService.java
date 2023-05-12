package com.gtmobi.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtmobi.Model.Ds_admin;
import com.gtmobi.Model.Ds_token;
import com.gtmobi.Model.tc_users;

@Service
@Transactional
public class TCUserService {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<tc_users> getAdminUser() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(tc_users.class);

			cr.add(Restrictions.eq("disabled", false));
			cr.add(Restrictions.eq("administrator", true));
			cr.addOrder(Order.desc("id"));

			return cr.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// for admin login
	@SuppressWarnings({ "deprecation" })
	public Ds_admin getBybusinessIdAndUserName(String user_name, String password) {
		Criteria cr = getSession().createCriteria(Ds_admin.class);
		cr.add(Restrictions.eq("userName", user_name));
		cr.add(Restrictions.eq("password", password));
		cr.setMaxResults(1);
		return (Ds_admin) cr.uniqueResult();
	}

	@SuppressWarnings({ "deprecation" })
	public tc_users findUserbyId(int userd_id) {
		Criteria cr = getSession().createCriteria(tc_users.class);
		cr.add(Restrictions.eq("id", userd_id));
		return (tc_users) cr.uniqueResult();
	}

	public void saveTCToken(Ds_token tc_data) {
		getSession().save(tc_data);
	}

}