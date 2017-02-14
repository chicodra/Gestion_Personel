package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DiplomeDao;
import dtai.gp.model.Diplome;

@Stateless
@LocalBean
public class DiplomeServiceBean implements DiplomeService {

	@Inject
	private DiplomeDao diplomeDao = new DiplomeDao();
	
	
	public DiplomeDao getDiplomeDao() {
		return diplomeDao;
	}

	public void setDiplomeDao(DiplomeDao diplomeDao) {
		this.diplomeDao = diplomeDao;
	}
	

	public DiplomeServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		diplomeDao.save(diplome);
	}

	@Override
	public void deleteDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		diplomeDao.delete(diplome);
	}

	@Override
	public void updateDiplome(Diplome diplome) {
		// TODO Auto-generated method stub
		diplomeDao.update(diplome);
	}

	@Override
	public Diplome FindDiplome(String diplome) {
		// TODO Auto-generated method stub
		return diplomeDao.finddiplome(diplome);
	}

	@Override
	public Diplome FindByDiplome(String diplome) {
		// TODO Auto-generated method stub
		return diplomeDao.findDiplome(diplome);
	}

	@Override
	public Diplome findDiplome(Integer id) {
		// TODO Auto-generated method stub
		return null ;
	}

	@Override
	public Diplome findByCode(Integer code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diplome> FindAll() {
		// TODO Auto-generated method stub
		return diplomeDao.findAll();
	}

}
