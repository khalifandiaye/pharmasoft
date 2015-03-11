package fr.mmm.pharmaware.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import fr.mmm.pharmaware.commun.HibernateUtil;
import fr.mmm.pharmaware.entity.Employe;

public class EmployeDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Employe create (Employe Employe){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(Employe);
		tx.commit();
		s.close();
		return Employe;
		
	}
	
	public Employe delete (Employe Employe){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.delete(Employe);
		tx.commit();
		s.close();
		return Employe;
		
	}
	
	public Employe update (Employe Employe){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.update(Employe);
		tx.commit();
		s.close();
		return Employe;
		
	}
	
	public Employe findByPk (Integer id){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		Employe Employe=(Employe) s.get(Employe.class, id);
		tx.commit();
		s.close();
		
		return Employe;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Employe> findAll (){
		List<Employe> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		results=s.createCriteria(Employe.class).list();
		tx.commit();
		s.close();
		
		return results;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public Employe findByIdentifiants (String username, String password){
		List<Employe> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		results=s.createCriteria(Employe.class)
				.add( Restrictions.like("username", username )) 
				.add( Restrictions.like("password", password ))
				.list();
		
		tx.commit();
		s.close();
		if((results==null || results.size()==0)) {
			return  null;
		} else {
			return results.get(0);
		}
		
		
	}

}
