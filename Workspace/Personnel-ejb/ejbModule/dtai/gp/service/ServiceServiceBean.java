package dtai.gp.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dtai.gp.dao.impl.ServiceDao;
import dtai.gp.model.Service;

@Stateless
@LocalBean
public class ServiceServiceBean implements ServiceService {
	@Inject
	private ServiceDao servicedao = new ServiceDao();

	public ServiceDao getServicedao() {
		return servicedao;
	}

	public void setServicedao(ServiceDao servicedao) {
		this.servicedao = servicedao;
	}

	public ServiceServiceBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void SaveService(Service service) {
		// TODO Auto-generated method stub
		servicedao.save(service);
	}

	@Override
	public void deleteService(Service service) {
		// TODO Auto-generated method stub
		servicedao.delete(service);
	}

	@Override
	public void updateService(Service service) {
		// TODO Auto-generated method stub
		servicedao.update(service);
	}

	@Override
	public Service findService(Integer id) {
		// TODO Auto-generated method stub
		return servicedao.find(id);
	}

	@Override
	public Service findByCode(Integer code) {
		// TODO Auto-generated method stub
		return servicedao.findService(code);
	}

	@Override
	public List<Service> FindAll() {
		// TODO Auto-generated method stub
		return servicedao.findAll();
	}

}
