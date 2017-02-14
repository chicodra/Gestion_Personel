package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.DetailSanction;

@Local
public interface SanctionService {
	
	public void SaveSanction(DetailSanction sanction);

	public void delete(DetailSanction sanction);

	public void updateSanction(DetailSanction sanction);
	
	public DetailSanction findSanction(Integer id);
	
	public DetailSanction findByCode(Integer code);
	
	public List<DetailSanction> FindAll();

}
