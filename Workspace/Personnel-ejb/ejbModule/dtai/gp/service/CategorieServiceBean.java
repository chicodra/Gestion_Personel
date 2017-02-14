package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.CategorieDao;
import dtai.gp.model.Categorie;

@Stateless
@LocalBean
public class CategorieServiceBean implements CategorieService {

	@Inject
	private CategorieDao categorieDao = new CategorieDao();

	public CategorieDao getCategorieDao() {
		return categorieDao;
	}

	public void setCategorieDao(CategorieDao categorieDao) {
		this.categorieDao = categorieDao;
	}

	public CategorieServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
        categorieDao.save(categorie);
	}

	@Override
	public void deleteCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
       categorieDao.delete(categorie);
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
      categorieDao.update(categorie);
	}

	@Override
	public Categorie FindCategorie(String categorie) {
		// TODO Auto-generated method stub
		return categorieDao.findcategorie(categorie);
	}

	@Override
	public Categorie FindByCategorie(String categorie) {
		// TODO Auto-generated method stub
		return categorieDao.findCategorie(categorie);
	}

	@Override
	public Categorie findCategorie(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie findByCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> FindAll() {
		// TODO Auto-generated method stub
		return categorieDao.findAll();
	}

}
