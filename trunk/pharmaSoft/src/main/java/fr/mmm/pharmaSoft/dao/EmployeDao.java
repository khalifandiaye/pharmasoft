package fr.mmm.pharmaSoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.mmm.pharmaSoft.commun.HibernateUtil;
import fr.mmm.pharmaSoft.entity.Employe;

public class EmployeDao {
	
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

}
