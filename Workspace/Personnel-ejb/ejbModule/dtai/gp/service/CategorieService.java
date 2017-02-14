package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Categorie;
@Local

public interface CategorieService {
	
	public void SaveCategorie(Categorie categorie);

	public void deleteCategorie(Categorie categorie);

	public void updateCategorie(Categorie categorie);
	
    public Categorie FindCategorie(String categorie);
	
	public Categorie FindByCategorie(String categorie);

	public Categorie findCategorie(Integer id);

	public Categorie findByCode(Integer code);

	public List<Categorie> FindAll();

}
