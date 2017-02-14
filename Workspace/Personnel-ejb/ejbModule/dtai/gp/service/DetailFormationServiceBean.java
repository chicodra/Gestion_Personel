package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DetailFormationDao;
import dtai.gp.model.DetailFormation;

@Stateless
@LocalBean
public class DetailFormationServiceBean implements DetailFormationService {
	@Inject
	private DetailFormationDao  detailformationDao = new DetailFormationDao();
	
	public DetailFormationDao getDetailformationDao() {
		return detailformationDao;
	}

	public void setDetailformationDao(DetailFormationDao detailformationDao) {
		this.detailformationDao = detailformationDao;
	}

	public DetailFormationServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveDetailFormation(DetailFormation dformation) {
		// TODO Auto-generated method stub
		detailformationDao.save(dformation);
	}

	@Override
	public void deleteDetailFormation(DetailFormation dformation) {
		// TODO Auto-generated method stub
		detailformationDao.delete(dformation);
	}

	@Override
	public void updateDetailFormation(DetailFormation dformation) {
		// TODO Auto-generated method stub
		detailformationDao.update(dformation);
	}

	@Override
	public DetailFormation findDetailFormation(Integer id) {
		// TODO Auto-generated method stub
		return detailformationDao.find(id);
	}

	@Override
	public DetailFormation findByCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetailFormation> FindAll() {
		// TODO Auto-generated method stub
		return detailformationDao.findAll();
	}

}
