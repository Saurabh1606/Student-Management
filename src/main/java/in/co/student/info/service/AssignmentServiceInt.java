package in.co.student.info.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.student.info.dto.AssignmentDTO;
import in.co.student.info.exception.DuplicateRecordException;

public interface AssignmentServiceInt {

	
		
	 public long add(AssignmentDTO dto) throws DuplicateRecordException;
		
		
		public void delete(AssignmentDTO dto) ;
		
		
		public void update(AssignmentDTO dto) throws DuplicateRecordException;
		  
		
		public AssignmentDTO findByPK(long pk) ;
		
		
		
		public AssignmentDTO findByName(String name);
		
		
		
		public List<AssignmentDTO> search(AssignmentDTO dto);
		
		
		
		public List search(AssignmentDTO dto, int pageNo, int pageSize) ;
		
		
		public Map<Long, AssignmentDTO> getMapDTO(Set<Long> ids);
		
	

}
