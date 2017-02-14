package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.DetailDiplome;


@Local

public interface DetailDiplomeService {
	
	public void SaveDetailDiplome(DetailDiplome ddiplome);

	public void deleteDetailDiplome(DetailDiplome dddiplome);

	public void updateDetailDiplome(DetailDiplome ddiplome);

	public DetailDiplome findDetailDiplome(Integer id);

	public DetailDiplome findByCode(Integer code);

	public List<DetailDiplome> FindAll();

}
