package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.DetailAbsence;

@Local

public interface DetailAbsenceService {
	
    public void SaveDetailAbsence(DetailAbsence dabsence);
	
	public void deleteDetailAbsence(DetailAbsence dabsence);
	
	public void updateDetailAbsence(DetailAbsence dabsence);
	
	public DetailAbsence findDetailAbsence(Integer id);
	
	public DetailAbsence finBycode(Integer code);
	
	public List<DetailAbsence> FindAll();

}
