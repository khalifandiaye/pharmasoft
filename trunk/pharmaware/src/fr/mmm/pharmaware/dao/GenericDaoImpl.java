package fr.mmm.pharmaware.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.mmm.pharmaware.commun.HibernateUtil;
import fr.mmm.pharmaware.entity.CategorieMedicament;
import fr.mmm.pharmaware.entity.FormeMedicament;
import fr.mmm.pharmaware.entity.ListeMedicament;
import fr.mmm.pharmaware.entity.ModeAdminMedicament;
import fr.mmm.pharmaware.entity.ModeConsMedicament;
import fr.mmm.pharmaware.entity.TypeMedicament;

public class GenericDaoImpl<T, ID extends Serializable>  implements GenericDao<T, ID>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Class< T > clazz;
	
	
	
	public GenericDaoImpl(Class<T> clazz) {
		super();
		this.clazz = clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T create (T type){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(type);
		tx.commit();
		s.close();
		return type;
		
	}
	
	@Override
	public T delete (T type){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		String entity=null, column = null;
		Integer value = null;
		if (type instanceof ListeMedicament){
			entity="liste";
			column="noListeMedicament";
			value=((ListeMedicament) type).getNoListeMedicament();
		}else if (type instanceof CategorieMedicament){
			entity="categorie";
			column="noCategorieMedicament";
			value=((CategorieMedicament) type).getNoCategorieMedicament();
		} else if (type instanceof FormeMedicament){
			entity="formeMedicament";
			column="noFormeMedicament";
			value=((FormeMedicament) type).getNoFormeMedicament();
		} else if (type instanceof ModeAdminMedicament){
			entity="modeAdministration";
			column="noModeAdminMedicament";
			value=((ModeAdminMedicament) type).getNoModeAdminMedicament();
		} else if (type instanceof ModeConsMedicament){
			entity="modeConservation";
			column="noModeConsMedicament";
			value=((ModeConsMedicament) type).getNoModeConsMedicament();
		} else if (type instanceof TypeMedicament){
			entity="type";
			column="noTypeMedicamentt";
			value=((TypeMedicament) type).getNoTypeMedicament();
		} 
		if(entity!=null && column!=null && value!=null) {
			Query query = s.createQuery("update Medicament set "+entity +" = null" +
					" where "+entity+"."+column+" = :stockCode");
			query.setParameter("stockCode", value);
			int result = query.executeUpdate();
		}
		s.delete(type);
		tx.commit();
		s.close();
		return type;
		
	}
	
	@Override
	public T update (T type){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.update(type);
		tx.commit();
		s.close();
		return type;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findByPk (ID id){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		T type=(T) s.get(this.clazz.getName(), id);
		tx.commit();
		s.close();
		
		return type;
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findAll (){
		List<T> results=null;
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		results=s.createCriteria(this.clazz.getName()).list();
		tx.commit();
		s.close();
		
		return results;
		
	}
	
	
}
