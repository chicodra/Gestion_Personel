package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Formation;

@Local
public interface FormationService {
	
	public void SaveFormation(Formation formation);

	public void deleteFormation(Formation formation);

	public void updateFormation(Formation formation);

	public Formation findFormation(Integer id);

	public Formation findByCode(Integer code);
	
    public Formation FindFormation(String form);
	
	public Formation FindByFormation(String form);

	public List<Formation> FindAll();

}
