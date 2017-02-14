package dtai.gp.dao;

import java.util.List;

public interface DAOGeneric<T, K> {
	
	  /**
	  * M�thode de cr�ation
	  * @return boolean 
	  */
	  public abstract void create(T obj);

	  /**
	  * M�thode pour effacer
	  * @param obj
	  * @return boolean 
	  */
	  public abstract void delete(T obj);

	  /**
	  * M�thode de mise � jour
	  * @param obj
	  * @return boolean
	  */
	  public abstract void update(T obj);

	  /**
	  * M�thode de recherche des informations
	  * @param id
	  * @return T
	  */
	  public abstract T find(K id);
	  
	  public abstract List<T>  findAll();
	}

