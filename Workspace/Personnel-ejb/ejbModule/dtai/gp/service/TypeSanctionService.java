package dtai.gp.service;

import java.util.List;

import javax.ejb.Local;

import dtai.gp.model.TypeSanction;

@Local
public interface TypeSanctionService {
	
	public void SaveTypeSanction(TypeSanction typeS);

	public void DeleteTypeSanction(TypeSanction typeS);

	public void UpdateTypeSanction(TypeSanction typeS);

	public TypeSanction findTypeSanction(Integer id);

	public List<TypeSanction> FindAll();
}
