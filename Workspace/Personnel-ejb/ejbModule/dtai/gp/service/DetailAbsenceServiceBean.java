package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DetailAbsenceDao;
import dtai.gp.model.DetailAbsence;

@Stateless
@LocalBean
public class DetailAbsenceServiceBean implements DetailAbsenceService {
	 @Inject
	 private DetailAbsenceDao detailabsenceDao = new DetailAbsenceDao();
	 
	 
	public DetailAbsenceDao getDetailabsenceDao() {
		return detailabsenceDao;
	}

	public void setDetailabsenceDao(DetailAbsenceDao detailabsenceDao) {
		this.detailabsenceDao = detailabsenceDao;
	}

	
	public DetailAbsenceServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveDetailAbsence(DetailAbsence dabsence) {
		// TODO Auto-generated method stub
		detailabsenceDao.save(dabsence);
	}

	@Override
	public void deleteDetailAbsence(DetailAbsence dabsence) {
		// TODO Auto-generated method stub
		detailabsenceDao.delete(dabsence);
	}

	@Override
	public void updateDetailAbsence(DetailAbsence dabsence) {
		// TODO Auto-generated method stub
		detailabsenceDao.update(dabsence);
	}

	@Override
	public DetailAbsence findDetailAbsence(Integer id) {
		// TODO Auto-generated method stub
		return detailabsenceDao.find(id);
	}

	@Override
	public DetailAbsence finBycode(Integer code) {
		// TODO Auto-generated method stub
		return detailabsenceDao.findDetailAbsence(code);
	}

	@Override
	public List<DetailAbsence> FindAll() {
		// TODO Auto-generated method stub
		return detailabsenceDao.findAll();
	}
	
}
