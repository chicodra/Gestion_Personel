package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.VacationDao;
import dtai.gp.model.Vacation;

@Stateless
@LocalBean
public class VacationServiceBean implements VacationService {

	@Inject
    private VacationDao vacationDao = new VacationDao();
	
	
	public VacationDao getVacationDao() {
		return vacationDao;
	}

	public void setVacationDao(VacationDao vacationDao) {
		this.vacationDao = vacationDao;
	}
	

	@Override
	public void SaveVacation(Vacation vacation) {
		// TODO Auto-generated method stub
		vacationDao.save(vacation);
	}

	@Override
	public void deleteVacation(Vacation vacation) {
		// TODO Auto-generated method stub
		vacationDao.delete(vacation);
	}

	@Override
	public void updateVacation(Vacation vacation) {
		// TODO Auto-generated method stub
		vacationDao.update(vacation);
	}

	@Override
	public Vacation findVacation(Integer id) {
		// TODO Auto-generated method stub
		return vacationDao.find(id);
	}

	@Override
	public Vacation findByCode(Integer code) {
		// TODO Auto-generated method stub
		return vacationDao.findVacation(code);
	}

	@Override
	public List<Vacation> FindAll() {
		// TODO Auto-generated method stub
		return vacationDao.findAll();
	}

}
