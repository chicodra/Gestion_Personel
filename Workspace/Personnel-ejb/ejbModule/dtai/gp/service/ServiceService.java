package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.Service;


@Local
public interface ServiceService {
	
	public void SaveService(Service service);

	public void deleteService(Service service);

	public void updateService(Service service);

	public Service findService(Integer id);

	public Service findByCode(Integer code);

	public List<Service> FindAll();

}
