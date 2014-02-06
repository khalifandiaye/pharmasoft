package fr.mmm.pharmaSoft.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import fr.mmm.pharmaSoft.commun.HibernateUtil;
import fr.mmm.pharmaSoft.dto.StockDTO;
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
	public List<StockDTO> findAll (){
		List<StockDTO> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Criteria criteria = s.createCriteria(Stock.class, "stock");
		criteria.createCriteria("medicament", "medicament");
		ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("stock.noStock"), "noStock")
                .add(Projections.property("medicament.libelle"), "libelleMedicament")
                .add(Projections.property("stock.quantite"), "quantite")
                .add(Projections.property("stock.datePeremption"), "datePeremption");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(StockDTO.class));
		results=criteria.list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
