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

import com.gtmobi.Model.Ds_share_data;

@Service
@Transactional
public class TCSharedService {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveTCShareData(Ds_share_data tc_data) {
		getSession().save(tc_data);
	}

	public void updateTCShareData(Ds_share_data tc_data) {
		getSession().update(tc_data);
	}

	@SuppressWarnings("deprecation")
	public Ds_share_data getByUserId(Integer userd_id) {
		Criteria cr = getSession().createCriteria(Ds_share_data.class);
		cr.add(Restrictions.eq("user_id", userd_id));
		cr.add(Restrictions.eq("is_active", true));
		cr.add(Restrictions.eq("is_deleted", false));
		cr.setMaxResults(1);
		return (Ds_share_data) cr.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	public Ds_share_data getById(Integer share_data_id) {
		Criteria cr = getSession().createCriteria(Ds_share_data.class);
		cr.add(Restrictions.eq("share_data_id", share_data_id));
		cr.add(Restrictions.eq("is_active", true));
		cr.add(Restrictions.eq("is_deleted", false));
		return (Ds_share_data) cr.uniqueResult();
	}

	@SuppressWarnings("deprecation")
	public Ds_share_data getByIdAll(Integer share_data_id) {
		Criteria cr = getSession().createCriteria(Ds_share_data.class);
		cr.add(Restrictions.eq("share_data_id", share_data_id));
		return (Ds_share_data) cr.uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Ds_share_data> getShareDataList() {
		Criteria cr = getSession().createCriteria(Ds_share_data.class);
		cr.addOrder(Order.desc("created_time"));
		return cr.list();
	}

	@SuppressWarnings("deprecation")
	public Ds_share_data getBySaltAndUserId(String salt, Integer userd_id) {
		Criteria cr = getSession().createCriteria(Ds_share_data.class);
		cr.add(Restrictions.eq("salt", salt));
		cr.add(Restrictions.eq("user_id", userd_id));
		cr.add(Restrictions.eq("is_active", true));
		cr.add(Restrictions.eq("is_deleted", false));
		cr.setMaxResults(1);
		return (Ds_share_data) cr.uniqueResult();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object> getDevicePostionData(Integer userd_id) {
		List<Object> data = getSession().createSQLQuery(
				"SELECT tcud.userid,tcud.deviceid,tcd.name,tcd.uniqueid,tcd.positionid,tcp.servertime,tcp.devicetime,"
						+ "tcp.fixtime,tcp.latitude,tcp.longitude,tcp.altitude,tcp.speed,tcp.course,tcp.address "
						+ "FROM public.tc_user_device tcud inner join tc_devices tcd on tcd.id=tcud.deviceid left outer join tc_positions tcp on tcp.id=tcd.positionid "
						+ "where tcud.userid=" + userd_id)
				.list();
		return data;
	}
}