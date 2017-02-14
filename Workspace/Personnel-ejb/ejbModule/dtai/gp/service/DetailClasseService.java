package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.DetailClasse;

@Local

public interface DetailClasseService {

public void SaveDetailClasse(DetailClasse dclasse);
	
	public void deleteDetailClasse(DetailClasse dclasse);
	
	public void updateDetailClasse(DetailClasse dclasse);
	
	public DetailClasse findDetailClasse(Integer id);
	
	public DetailClasse finBycode(Integer code);
	
	public List<DetailClasse> FindAll();
}
