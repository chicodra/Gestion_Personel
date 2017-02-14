package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Corps;


@Local
public  interface CorpsService {
	
	public void SaveCorps(Corps corps);

	public void deleteCorps(Corps corps);

	public void updateCorps(Corps corps);

	public Corps findCorps(Integer id);

	public Corps findByCode(Integer code);

	public List<Corps> FindAll();
}
