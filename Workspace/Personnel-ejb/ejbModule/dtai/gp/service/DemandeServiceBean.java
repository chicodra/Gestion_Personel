package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DemandeDao;
import dtai.gp.model.Demande;

@Stateless
@LocalBean
public class DemandeServiceBean implements DemandeService {
	@Inject
	private DemandeDao demandeDao = new DemandeDao();

	public DemandeDao getDemandeDao() {
		return demandeDao;
	}

	public void setDemandeDao(DemandeDao demandeDao) {
		this.demandeDao = demandeDao;
	}

	@Override
	public void SaveDemande(Demande demande) {
		// TODO Auto-generated method stub
		demandeDao.save(demande);
	}

	@Override
	public void deleteVacation(Demande demande) {
		// TODO Auto-generated method stub
		demandeDao.deleteVacation(demande);
	}

	@Override
	public void deleteAbsence(Demande demande) {
		// TODO Auto-generated method stub
		demandeDao.deleteAbsence(demande);
	}

	@Override
	public void updateDemande(Demande demande) {
		// TODO Auto-generated method stub
		demandeDao.update(demande);
	}

	@Override
	public Demande findDemande(Integer id) {
		// TODO Auto-generated method stub
		return demandeDao.find(id);
	}

	@Override
	public Demande findByCode(Integer code) {
		// TODO Auto-generated method stub
		return demandeDao.findDemande(code);
	}

	@Override
	public List<Demande> FindAllVacation() {
		// TODO Auto-generated method stub
		return demandeDao.findAllVacation();
	}

	@Override
	public List<Demande> FindAllAbsence() {
		// TODO Auto-generated method stub
		return demandeDao.findAllAbsence();
	}

	@Override
	public List<Demande> FindAll() {
		// TODO Auto-generated method stub
		return demandeDao.findAll();
	}

	

}
