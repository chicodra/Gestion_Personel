package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.DetailFonctionDao;
import dtai.gp.model.DetailFonction;

@Stateless
@LocalBean
public class DetailFonctionServiceBean implements DetailFonctionService {
    @Inject
    private DetailFonctionDao detailfonctiondao = new DetailFonctionDao();
    
	public DetailFonctionDao getDetailfonctiondao() {
		return detailfonctiondao;
	}

	public void setDetailfonctiondao(DetailFonctionDao detailfonctiondao) {
		this.detailfonctiondao = detailfonctiondao;
	}

	public DetailFonctionServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveDetailFonction(DetailFonction dfonction) {
		// TODO Auto-generated method stub
		detailfonctiondao.save(dfonction);
	}

	@Override
	public void deleteDetailFonction(DetailFonction dfonction) {
		// TODO Auto-generated method stub
		detailfonctiondao.delete(dfonction);
	}

	@Override
	public void updateDetailFonction(DetailFonction dfonction) {
		// TODO Auto-generated method stub
		detailfonctiondao.update(dfonction);
	}

	@Override
	public DetailFonction findDetailFonction(Integer id) {
		// TODO Auto-generated method stub
		return detailfonctiondao.find(id);
	}

	
	@Override
	public DetailFonction finBycode(Integer code) {
		// TODO Auto-generated method stub
		return detailfonctiondao.findDetailFonction(code);
	}

	@Override
	public List<DetailFonction> FindAll() {
		// TODO Auto-generated method stub
		return detailfonctiondao.findAll();
	}

}
