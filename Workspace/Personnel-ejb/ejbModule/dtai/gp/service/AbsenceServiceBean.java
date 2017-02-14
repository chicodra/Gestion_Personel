package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.AbsenceDao;
import dtai.gp.model.Absence;

@Stateless
@LocalBean
public class AbsenceServiceBean implements AbsenceService{
	@Inject
	private AbsenceDao absenceDao = new AbsenceDao();

	public AbsenceDao getAbsenceDao() {
		return absenceDao;
	}

	public void setAbsenceDao(AbsenceDao absenceDao) {
		this.absenceDao = absenceDao;
	}

	@Override
	public void SaveAbsence(Absence absence) {
		// TODO Auto-generated method stub
		absenceDao.save(absence);
	}

	@Override
	public void deleteAbsence(Absence absence) {
		// TODO Auto-generated method stub
		absenceDao.delete(absence);
	}

	@Override
	public void updateAbsence(Absence absence) {
		// TODO Auto-generated method stub
		absenceDao.update(absence);
	}

	@Override
	public Absence findAbsence(Integer id) {
		// TODO Auto-generated method stub
		return absenceDao.find(id);
	}

	@Override
	public Absence findByCode(Integer code) {
		// TODO Auto-generated method stub
		return absenceDao.findAbsence(code);
	}

	@Override
	public Absence FindAbsence(String abs) {
		// TODO Auto-generated method stub
		return absenceDao.findabsence(abs);
	}

	@Override
	public Absence FindByAbsence(String abs) {
		// TODO Auto-generated method stub
		return absenceDao.findAbsence(abs);
	}
	
	@Override
	public List<Absence> FindAll() {
		// TODO Auto-generated method stub
		return absenceDao.findAll();
	}

	




}
