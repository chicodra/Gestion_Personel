package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.CorpsDao;
import dtai.gp.model.Corps;
@Stateless
@LocalBean
public class CorpsServiceBean implements CorpsService {
@Inject
	private CorpsDao corpsDao = new CorpsDao();
	
	
	public CorpsDao getCorpsDao() {
	return corpsDao;
}

public void setCorpsDao(CorpsDao corpsDao) {
	this.corpsDao = corpsDao;
}


	public CorpsServiceBean() {
	// TODO Auto-generated constructor stub
}

	@Override
	public void SaveCorps(Corps corps) {
		// TODO Auto-generated method stub
		corpsDao.save(corps);
	}

	@Override
	public void deleteCorps(Corps corps) {
		// TODO Auto-generated method stub
		corpsDao.delete(corps);
	}

	@Override
	public void updateCorps(Corps corps) {
		// TODO Auto-generated method stub
		corpsDao.update(corps);
	}

	@Override
	public Corps findCorps(Integer id) {
		// TODO Auto-generated method stub
		return corpsDao.find(id);
	}

	@Override
	public Corps findByCode(Integer code) {
		// TODO Auto-generated method stub
		return corpsDao.findCorps(code) ;
	}

	@Override
	public List<Corps> FindAll() {
		// TODO Auto-generated method stub
		return corpsDao.findAll();
	}

}
