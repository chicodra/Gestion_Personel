package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.FonctionDao;
import dtai.gp.model.Fonction;

@Stateless
@LocalBean
public class FonctionServiceBean implements FonctionService {

	@Inject
	private FonctionDao fonctionDao = new FonctionDao();

	public FonctionDao getFonctionDao() {
		return fonctionDao;
	}

	public void setFonctionDao(FonctionDao fonctionDao) {
		this.fonctionDao = fonctionDao;
	}

	public FonctionServiceBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveFonction(Fonction fonction) {
		// TODO Auto-generated method stub
		fonctionDao.save(fonction);

	}

	@Override
	public void deleteFonction(Fonction fonction) {
		// TODO Auto-generated method stub
		fonctionDao.delete(fonction);
	}

	@Override
	public void updateFonction(Fonction fonction) {
		// TODO Auto-generated method stub
		fonctionDao.update(fonction);
	}

	@Override
	public Fonction findFonction(Integer id) {
		// TODO Auto-generated method stub
		return fonctionDao.find(id);
	}

	@Override
	public List<Fonction> FindAll() {
		// TODO Auto-generated method stub
		return fonctionDao.findAll();
	}

	@Override
	public Fonction findByCode(Integer code) {
		// TODO Auto-generated method stub
		return fonctionDao.findFonction(code);
	}

}
