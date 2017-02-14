package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Classe;

@Local
public interface ClasseService {
	
	public void SaveClasse(Classe classe);

	public void deleteClasse(Classe classe);

	public void updateClasse(Classe classe);
	
	public Classe findClasse(Integer id);
	
	public Classe findByCode(Integer code);
	
	public List<Classe> FindAll();
}
