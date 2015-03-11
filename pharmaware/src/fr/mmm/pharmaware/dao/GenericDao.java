package fr.mmm.pharmaware.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	
	T create(T type);
	
	T delete(T type);
	
	T update(T type);
	
	T findByPk(ID id);
	
	List<T> findAll();

}
