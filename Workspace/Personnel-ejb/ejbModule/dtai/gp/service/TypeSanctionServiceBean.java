package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.TypeSanctionDao;
import dtai.gp.model.TypeSanction;

@Stateless
@LocalBean
public class TypeSanctionServiceBean implements TypeSanctionService {
	@Inject
	private TypeSanctionDao typeSDao = new TypeSanctionDao();

	public TypeSanctionDao getTypeSDao() {
		return typeSDao;
	}

	public void setTypeSDao(TypeSanctionDao typeSDao) {
		this.typeSDao = typeSDao;
	}

	public TypeSanctionServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveTypeSanction(TypeSanction typeS) {
		// TODO Auto-generated method stub
		typeSDao.save(typeS);
	}

	@Override
	public void DeleteTypeSanction(TypeSanction typeS) {
		// TODO Auto-generated method stub
		typeSDao.delete(typeS);
	}

	@Override
	public void UpdateTypeSanction(TypeSanction typeS) {
		// TODO Auto-generated method stub
		typeSDao.update(typeS);
	}

	@Override
	public TypeSanction findTypeSanction(Integer id) {
		// TODO Auto-generated method stub
		return typeSDao.find(id);
	}

	@Override
	public List<TypeSanction> FindAll() {
		// TODO Auto-generated method stub
		return typeSDao.findAll();
	}

}
