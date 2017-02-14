package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.DetailFormation;


@Local

public interface DetailFormationService {
	
	public void SaveDetailFormation(DetailFormation dformation);

	public void deleteDetailFormation(DetailFormation dformation);

	public void updateDetailFormation(DetailFormation dformation);

	public DetailFormation findDetailFormation(Integer id);

	public DetailFormation findByCode(Integer code);

	public List<DetailFormation> FindAll();

}
