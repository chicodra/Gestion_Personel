package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.DetailFonction;

@Local
public interface DetailFonctionService {
	
	public void SaveDetailFonction(DetailFonction dfonction);
	
	public void deleteDetailFonction(DetailFonction dfonction);
	
	public void updateDetailFonction(DetailFonction dfonction);
	
	public DetailFonction findDetailFonction(Integer id);
	
	public DetailFonction finBycode(Integer code);
	
	public List<DetailFonction> FindAll();

}
