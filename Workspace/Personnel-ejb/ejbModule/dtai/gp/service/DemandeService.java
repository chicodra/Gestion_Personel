package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Demande;

@Local
public interface DemandeService {
	
	public void SaveDemande(Demande demande);

	public void deleteVacation(Demande demande);
	
	public void deleteAbsence(Demande demande);

	public void updateDemande(Demande demande);

	public Demande findDemande(Integer id);

	public Demande findByCode(Integer code);

	public List<Demande> FindAllVacation();
	
	public List<Demande> FindAllAbsence();
	
	public List<Demande> FindAll();


}
