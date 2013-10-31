package fr.mmm.pharmaSoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.mmm.pharmaSoft.commun.HibernateUtil;
import fr.mmm.pharmaSoft.entity.Commande;

public class CommandeDao {
	
	public Commande create (Commande Commande){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(Commande);
		tx.commit();
		s.close();
		return Commande;
		
	}
	
	public Commande delete (Commande Commande){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.delete(Commande);
		tx.commit();
		s.close();
		return Commande;
		
	}
	
	public Commande update (Commande Commande){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.update(Commande);
		tx.commit();
		s.close();
		return Commande;
		
	}
	
	public Commande findByPk (Integer id){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		Commande Commande=(Commande) s.get(Commande.class, id);
		tx.commit();
		s.close();
		
		return Commande;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Commande> findAll (){
		List<Commande> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		results=s.createCriteria(Commande.class).list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
