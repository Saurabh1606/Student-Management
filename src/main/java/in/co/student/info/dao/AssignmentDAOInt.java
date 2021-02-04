package in.co.student.info.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.student.info.dto.AssignmentDTO;

public interface AssignmentDAOInt {

public long add(AssignmentDTO dto);

	
	public void update(AssignmentDTO dto);

	
	public void delete(AssignmentDTO dto);
	

  
	public AssignmentDTO findByName(String name);
	
	public AssignmentDTO findByNameDate(String name,Date Date);
	
	public AssignmentDTO findByPk(long id);

	
	public List<AssignmentDTO> search(AssignmentDTO dto, long pageNo, int pageSize);

	
	public List<AssignmentDTO> search(AssignmentDTO dto);
	
	
	
	public Map<Long, AssignmentDTO> getMapDTO(Set<Long> ids);
	
}
