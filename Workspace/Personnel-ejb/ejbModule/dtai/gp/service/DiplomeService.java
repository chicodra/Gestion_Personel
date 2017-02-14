package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Diplome;


@Local

public interface DiplomeService {
	
	public void SaveDiplome(Diplome diplome);

	public void deleteDiplome(Diplome diplome);

	public void updateDiplome(Diplome diplome);
	
    public Diplome FindDiplome(String diplome);
	
	public Diplome FindByDiplome(String diplome);

	public Diplome findDiplome(Integer id);

	public Diplome findByCode(Integer code);

	public List<Diplome> FindAll();

}
