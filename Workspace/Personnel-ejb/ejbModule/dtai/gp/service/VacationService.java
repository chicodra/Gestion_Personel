package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Vacation;

@Local
public interface VacationService {
	
	public void SaveVacation(Vacation vacation);

	public void deleteVacation(Vacation vacation);

	public void updateVacation(Vacation vacation);

	public Vacation findVacation(Integer id);

	public Vacation findByCode(Integer code);

	public List<Vacation> FindAll();
}
