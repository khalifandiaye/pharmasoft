package fr.mmm.pharmaSoft.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.mmm.pharmaSoft.commun.HibernateUtil;
import fr.mmm.pharmaSoft.entity.TypeMedicament;

public class TypeMedicamentDao {
	
	public TypeMedicament create (TypeMedicament TypeMedicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(TypeMedicament);
		tx.commit();
		s.close();
		return TypeMedicament;
		
	}
	
	public TypeMedicament delete (TypeMedicament TypeMedicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.delete(TypeMedicament);
		tx.commit();
		s.close();
		return TypeMedicament;
		
	}
	
	public TypeMedicament update (TypeMedicament TypeMedicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.update(TypeMedicament);
		tx.commit();
		s.close();
		return TypeMedicament;
		
	}
	
	public TypeMedicament findByPk (Integer id){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		TypeMedicament TypeMedicament=(TypeMedicament) s.get(TypeMedicament.class, id);
		tx.commit();
		s.close();
		
		return TypeMedicament;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<TypeMedicament> findAll (){
		List<TypeMedicament> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		results=s.createCriteria(TypeMedicament.class).list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
