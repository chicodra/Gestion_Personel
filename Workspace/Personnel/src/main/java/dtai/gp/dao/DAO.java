package dtai.gp.dao;

import java.util.List;

public interface DAO<T, K> {
	
	  /**
	  * M�thode de cr�ation
	  * @return boolean 
	  */
	  public  void save(T obj);

	  /**
	  * M�thode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	  public  void delete(T obj);

	  /**
	  * M�thode de mise � jour
	  * @param obj
	  * @return boolean
	  */
	  public  void update(T obj);

	  /**
	  * M�thode de recherche des informations
	  * @param id
	  * @return T
	  */
	  public  T find(K id);
	  
	  public  List<T>  findAll();
	}

