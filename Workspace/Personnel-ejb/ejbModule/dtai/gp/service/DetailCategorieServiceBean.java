package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DetailCategorieDao;
import dtai.gp.model.DetailCategorie;
@Stateless
@LocalBean
public class DetailCategorieServiceBean implements DetailCategorieService {
    @Inject
    private DetailCategorieDao detailcategorieDao = new DetailCategorieDao();
    
    
	public DetailCategorieDao getDetailcategorieDao() {
		return detailcategorieDao;
	}

	public void setDetailcategorieDao(DetailCategorieDao detailcategorieDao) {
		this.detailcategorieDao = detailcategorieDao;
	}
	

	public DetailCategorieServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveDetailCategorie(DetailCategorie dcategorie) {
		// TODO Auto-generated method stub
		detailcategorieDao.save(dcategorie);
	}

	@Override
	public void deleteDetailCategorie(DetailCategorie dcategorie) {
		// TODO Auto-generated method stub
		detailcategorieDao.delete(dcategorie);
	}

	@Override
	public void updateDetailCategorie(DetailCategorie dcategorie) {
		// TODO Auto-generated method stub
		detailcategorieDao.update(dcategorie);
	}

	@Override
	public DetailCategorie findDetailCategorie(Integer id) {
		// TODO Auto-generated method stub
		return detailcategorieDao.find(id);
	}

	@Override
	public DetailCategorie findByCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetailCategorie> FindAll() {
		// TODO Auto-generated method stub
		return detailcategorieDao.findAll();
	}

}
