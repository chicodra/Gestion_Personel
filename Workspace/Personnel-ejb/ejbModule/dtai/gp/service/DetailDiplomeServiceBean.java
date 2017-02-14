package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DetailDiplomeDao;
import dtai.gp.model.DetailDiplome;

@Stateless
@LocalBean
public class DetailDiplomeServiceBean implements DetailDiplomeService{
	 @Inject
	 private DetailDiplomeDao detaildiplomeDao = new DetailDiplomeDao();

	public DetailDiplomeDao getDetaildiplomeDao() {
		return detaildiplomeDao;
	}

	public void setDetaildiplomeDao(DetailDiplomeDao detaildiplomeDao) {
		this.detaildiplomeDao = detaildiplomeDao;
	}

	public DetailDiplomeServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveDetailDiplome(DetailDiplome ddiplome) {
		// TODO Auto-generated method stub
		detaildiplomeDao.save(ddiplome);
	}

	@Override
	public void deleteDetailDiplome(DetailDiplome dddiplome) {
		// TODO Auto-generated method stub
		detaildiplomeDao.delete(dddiplome);
	}

	@Override
	public void updateDetailDiplome(DetailDiplome ddiplome) {
		// TODO Auto-generated method stub
		detaildiplomeDao.update(ddiplome);
	}

	@Override
	public DetailDiplome findDetailDiplome(Integer id) {
		// TODO Auto-generated method stub
		return detaildiplomeDao.find(id);
	}

	@Override
	public DetailDiplome findByCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetailDiplome> FindAll() {
		// TODO Auto-generated method stub
		return detaildiplomeDao.findAll();
	}
	 
}
