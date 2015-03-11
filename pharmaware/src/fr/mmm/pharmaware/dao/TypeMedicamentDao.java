package fr.mmm.pharmaware.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.mmm.pharmaware.commun.HibernateUtil;
import fr.mmm.pharmaware.entity.Commande;
import fr.mmm.pharmaware.entity.Medicament;
import fr.mmm.pharmaware.entity.TypeMedicament;

public class TypeMedicamentDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TypeMedicament create (TypeMedicament TypeMedicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(TypeMedicament);
		tx.commit();
		s.close();
		return TypeMedicament;
		
	}
	
	public TypeMedicament delete (TypeMedicament typeMedicament){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		TypeMedicament type=(TypeMedicament) s.load(TypeMedicament.class, typeMedicament.getNoTypeMedicament());
		Query query = s.createQuery("update Medicament set type = null" +
				" where type.noTypeMedicament = :stockCode");
		query.setParameter("stockCode", type.getNoTypeMedicament());
		int result = query.executeUpdate();
		s.delete(type);
		tx.commit();
		s.close();
		return typeMedicament;
		
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
