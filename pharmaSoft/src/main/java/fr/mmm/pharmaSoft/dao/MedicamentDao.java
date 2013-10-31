package fr.mmm.pharmaSoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.mmm.pharmaSoft.commun.HibernateUtil;
import fr.mmm.pharmaSoft.entity.Medicament;

public class MedicamentDao {
	
	public Medicament create (Medicament medicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(medicament);
		tx.commit();
		s.close();
		return medicament;
		
	}
	
	public Medicament delete (Medicament medicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.delete(medicament);
		tx.commit();
		s.close();
		return medicament;
		
	}
	
	public Medicament update (Medicament medicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.update(medicament);
		tx.commit();
		s.close();
		return medicament;
		
	}
	
	public Medicament findByPk (Integer id){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		Medicament medicament=(Medicament) s.get(Medicament.class, id);
		tx.commit();
		s.close();
		
		return medicament;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Medicament> findAll (){
		List<Medicament> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		results=s.createCriteria(Medicament.class).list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
