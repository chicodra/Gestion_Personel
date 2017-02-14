package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.ClasseDao;
import dtai.gp.model.Classe;

@Stateless
@LocalBean
public class ClasseServiceBean implements ClasseService {

	@Inject
	private ClasseDao classedao = new ClasseDao();
	
	public ClasseDao getClassedao() {
		return classedao;
	}

	public void setClassedao(ClasseDao classedao) {
		this.classedao = classedao;
	}

	public ClasseServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveClasse(Classe classe) {
		// TODO Auto-generated method stub
		classedao.save(classe);
		}

	@Override
	public void deleteClasse(Classe classe) {
		// TODO Auto-generated method stub
		classedao.delete(classe);
	}

	@Override
	public void updateClasse(Classe classe) {
		// TODO Auto-generated method stub
		classedao.update(classe);
	}

	@Override
	public Classe findClasse(Integer id) {
		// TODO Auto-generated method stub
		return classedao.find(id);
	}

	@Override
	public Classe findByCode(Integer code) {
		// TODO Auto-generated method stub
		return classedao.findClasse(code);
	}

	@Override
	public List<Classe> FindAll() {
		// TODO Auto-generated method stub
		return classedao.findAll();
	}

	

	

}
