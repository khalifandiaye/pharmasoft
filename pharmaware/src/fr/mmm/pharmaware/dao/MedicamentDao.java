package fr.mmm.pharmaware.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import fr.mmm.pharmaware.commun.HibernateUtil;
import fr.mmm.pharmaware.dto.MedicamentDTO;
import fr.mmm.pharmaware.entity.Commande;
import fr.mmm.pharmaware.entity.Medicament;
import fr.mmm.pharmaware.entity.Stock;

public class MedicamentDao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		Medicament med=(Medicament) s.load(Medicament.class, medicament.getNoMedicament());
		for(Commande commande : med.getCommandes()) {
			commande.getMedicaments().remove(commande);
		}

		s.delete(med);
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
	
	
	public List<MedicamentDTO> findByLibelle (String query){
		List<MedicamentDTO> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Criteria criteria = s.createCriteria(Medicament.class, "medicament");
		criteria.createAlias("type", "typeMedicament",CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("formeMedicament", "formeMedicament",CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("categorie", "categorieMedicament",CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("modeAdministration", "modeAdministration", CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("modeConservation", "modeConservation", CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("liste", "liste", CriteriaSpecification.LEFT_JOIN);
		
		criteria.add(Restrictions.ilike("medicament.libelle", query, MatchMode.START));
		
		ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("medicament.noMedicament"), "noMedicament")
                .add(Projections.property("medicament.libelle"), "libelle")
                .add(Projections.property("medicament.code"), "code")
                .add(Projections.property("medicament.description"), "description")
                .add(Projections.property("medicament.prix"), "prix")
                .add(Projections.property("typeMedicament.libelle"), "libelleTypeMedicament")
                .add(Projections.property("categorieMedicament.libelle"), "categorie")
                .add(Projections.property("formeMedicament.libelle"), "forme")
                .add(Projections.property("modeAdministration.libelle"), "modeAdmin")
                .add(Projections.property("modeConservation.libelle"), "modeCons")
                .add(Projections.property("liste.libelle"), "liste");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(MedicamentDTO.class));
		results=criteria.list();
		tx.commit();
		s.close();
		
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicamentDTO> findAll (){
		List<MedicamentDTO> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		Criteria criteria = s.createCriteria(Medicament.class, "medicament");
		criteria.createAlias("type", "typeMedicament",CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("formeMedicament", "formeMedicament",CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("categorie", "categorieMedicament",CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("modeAdministration", "modeAdministration", CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("modeConservation", "modeConservation", CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("liste", "liste", CriteriaSpecification.LEFT_JOIN);
		
		
		
		ProjectionList projectionList = Projections.projectionList()
                .add(Projections.property("medicament.noMedicament"), "noMedicament")
                .add(Projections.property("medicament.libelle"), "libelle")
                .add(Projections.property("medicament.code"), "code")
                .add(Projections.property("medicament.description"), "description")
                .add(Projections.property("medicament.prix"), "prix")
                .add(Projections.property("typeMedicament.libelle"), "libelleTypeMedicament")
                .add(Projections.property("categorieMedicament.libelle"), "categorie")
                .add(Projections.property("formeMedicament.libelle"), "forme")
                .add(Projections.property("modeAdministration.libelle"), "modeAdmin")
                .add(Projections.property("modeConservation.libelle"), "modeCons")
                .add(Projections.property("liste.libelle"), "liste");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(MedicamentDTO.class));
		results=criteria.list();
		tx.commit();
		s.close();
		
		return results;
		
	}

}
