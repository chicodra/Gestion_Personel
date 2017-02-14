package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Fonction;

@Local
public interface FonctionService {

	public void SaveFonction(Fonction fonction);

	public void deleteFonction(Fonction fonction);

	public void updateFonction(Fonction fonction);

	public Fonction findFonction(Integer id);

	public Fonction findByCode(Integer code);

	public List<Fonction> FindAll();

}
