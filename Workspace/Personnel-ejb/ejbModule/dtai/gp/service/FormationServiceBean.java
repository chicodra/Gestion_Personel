package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.FormationDao;
import dtai.gp.model.Formation;

@Stateless
@LocalBean
public class FormationServiceBean implements FormationService {

	@Inject
	private FormationDao formationDao = new FormationDao();
	
	public FormationDao getFormationDao() {
		return formationDao;
	}

	public void setFormationDao(FormationDao formationDao) {
		this.formationDao = formationDao;
	}
	

	@Override
	public void SaveFormation(Formation formation) {
		// TODO Auto-generated method stub
		formationDao.save(formation);
	}

	@Override
	public void deleteFormation(Formation formation) {
		// TODO Auto-generated method stub
		formationDao.delete(formation);
	}

	@Override
	public void updateFormation(Formation formation) {
		// TODO Auto-generated method stub
		formationDao.update(formation);
	}

	@Override
	public Formation findFormation(Integer id) {
		// TODO Auto-generated method stub
		return formationDao.find(id);
	}

	@Override
	public Formation findByCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation FindFormation(String form) {
		// TODO Auto-generated method stub
		return formationDao.findformation(form);
	}

	@Override
	public Formation FindByFormation(String form) {
		// TODO Auto-generated method stub
		return formationDao.findFormation(form);
	}

	@Override
	public List<Formation> FindAll() {
		// TODO Auto-generated method stub
		return formationDao.findAll();
	}

}
