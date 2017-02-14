package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DetailClasseDao;
import dtai.gp.model.DetailClasse;

@Stateless
@LocalBean
public class DetailClasseServiceBean implements DetailClasseService {
	@Inject
	private DetailClasseDao detailclassedao = new DetailClasseDao();

	public DetailClasseDao getDetailclassedao() {
		return detailclassedao;
	}

	public void setDetailclassedao(DetailClasseDao detailclassedao) {
		this.detailclassedao = detailclassedao;
	}

	public DetailClasseServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveDetailClasse(DetailClasse dclasse) {
		// TODO Auto-generated method stub
detailclassedao.save(dclasse);
	}

	@Override
	public void deleteDetailClasse(DetailClasse dclasse) {
		// TODO Auto-generated method stub
detailclassedao.delete(dclasse);
	}

	@Override
	public void updateDetailClasse(DetailClasse dclasse) {
		// TODO Auto-generated method stub
detailclassedao.update(dclasse);
	}

	@Override
	public DetailClasse findDetailClasse(Integer id) {
		// TODO Auto-generated method stub
		return detailclassedao.find(id);
	}

	@Override
	public DetailClasse finBycode(Integer code) {
		// TODO Auto-generated method stub
		return detailclassedao.findDetailClasse(code);
	}

	@Override
	public List<DetailClasse> FindAll() {
		// TODO Auto-generated method stub
		return detailclassedao.findAll();
	}

}
