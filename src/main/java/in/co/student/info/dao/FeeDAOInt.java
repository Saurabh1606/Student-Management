package in.co.student.info.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.student.info.dto.FeeDTO;

public interface FeeDAOInt {

public long add(FeeDTO dto);

	
	public void update(FeeDTO dto);

	
	public void delete(FeeDTO dto);
	

  
	public FeeDTO findByName(String name);
	

	public FeeDTO findByStudentNameandMonth(long id,String month);
	
	
	public FeeDTO findByPk(long id);
	

	
	public List<FeeDTO> search(FeeDTO dto, long pageNo, int pageSize);

	
	public List<FeeDTO> search(FeeDTO dto);
	
	
	
	public Map<Long, FeeDTO> getMapDTO(Set<Long> ids);
}
