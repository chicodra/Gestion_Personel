package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.DetailCategorie;

@Local

public interface DetailCategorieService {
	
	public void SaveDetailCategorie(DetailCategorie dcategorie);

	public void deleteDetailCategorie(DetailCategorie dcategorie);

	public void updateDetailCategorie(DetailCategorie dcategorie);

	public DetailCategorie findDetailCategorie(Integer id);

	public DetailCategorie findByCode(Integer code);

	public List<DetailCategorie> FindAll();

}
