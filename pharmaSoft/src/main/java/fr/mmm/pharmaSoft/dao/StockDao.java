package fr.mmm.pharmaSoft.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.mmm.pharmaSoft.commun.HibernateUtil;
import fr.mmm.pharmaSoft.entity.Stock;

public class StockDao {
	
	public Stock create (Stock Stock){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(Stock);
		tx.commit();
		s.close();
		return Stock;
		
	}
	
	public Stock delete (Stock Stock){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.delete(Stock);
		tx.commit();
		s.close();
		return Stock;
		
	}
	
	public Stock update (Stock Stock){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.update(Stock);
		tx.commit();
		s.close();
		return Stock;
		
	}
	
	public Stock findByPk (Integer id){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		Stock Stock=(Stock) s.get(Stock.class, id);
		tx.commit();
		s.close();
		
		return Stock;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Stock> findAll (){
		List<Stock> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		results=s.createCriteria(Stock.class).list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
