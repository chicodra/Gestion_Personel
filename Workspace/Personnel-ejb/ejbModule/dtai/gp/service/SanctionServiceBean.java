package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.SanctionDao;
import dtai.gp.model.DetailSanction;

@Stateless
@LocalBean
public class SanctionServiceBean implements SanctionService {
	@Inject
	private SanctionDao sanctiondao = new SanctionDao();

	public SanctionDao getSanctiondao() {
		return sanctiondao;
	}

	public void setSanctiondao(SanctionDao sanctiondao) {
		this.sanctiondao = sanctiondao;
	}

	public SanctionServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveSanction(DetailSanction sanction) {
		// TODO Auto-generated method stub
		sanctiondao.save(sanction);
	}

	@Override
	public void delete(DetailSanction sanction) {
		// TODO Auto-generated method stub
		sanctiondao.delete(sanction);
	}

	@Override
	public void updateSanction(DetailSanction sanction) {
		// TODO Auto-generated method stub
		sanctiondao.update(sanction);
	}

	@Override
	public DetailSanction findSanction(Integer id) {
		// TODO Auto-generated method stub
		return sanctiondao.find(id);
	}

	@Override
	public DetailSanction findByCode(Integer code) {
		// TODO Auto-generated method stub
		return sanctiondao.findSanction(code);
	}

	@Override
	public List<DetailSanction> FindAll() {
		// TODO Auto-generated method stub
		return sanctiondao.findAll();
	}

}
