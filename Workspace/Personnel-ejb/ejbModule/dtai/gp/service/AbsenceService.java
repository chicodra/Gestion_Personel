package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Absence;

@Local

public interface AbsenceService {
	
	public void SaveAbsence(Absence absence);

	public void deleteAbsence(Absence absence);

	public void updateAbsence(Absence absence);

	public Absence findAbsence(Integer id);

	public Absence findByCode(Integer code);
	
    public Absence FindAbsence(String abs);
	
	public Absence FindByAbsence(String abs);

	public List<Absence> FindAll();

}
