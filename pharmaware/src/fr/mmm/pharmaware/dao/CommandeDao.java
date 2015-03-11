package fr.mmm.pharmaware.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;

import fr.mmm.pharmaware.commun.HibernateUtil;
import fr.mmm.pharmaware.dto.CommandeDTO;
import fr.mmm.pharmaware.entity.Commande;

public class CommandeDao implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	public List<CommandeDTO> findAll (){
		List<CommandeDTO> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Criteria criteria = s.createCriteria(Commande.class, "commande");
		//criteria.createCriteria("medicament", "medicament");
		ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("commande.noCommande"), "noCommande")
                .add(Projections.property("commande.dateCommande"), "dateCommande")
                .add(Projections.property("commande.montantTotal"), "montantCommande");
                
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(CommandeDTO.class));
		results=criteria.list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
