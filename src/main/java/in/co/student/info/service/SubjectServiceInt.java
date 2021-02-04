package in.co.student.info.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.student.info.dto.SubjectDTO;
import in.co.student.info.exception.DuplicateRecordException;

public interface SubjectServiceInt {
	
	

    public long add(SubjectDTO dto) throws DuplicateRecordException;
	
	
	public void delete(SubjectDTO dto) ;
	
	
	public void update(SubjectDTO dto) throws DuplicateRecordException;
	  
	
	public SubjectDTO findByPK(long pk) ;
	
	
	
	public SubjectDTO findByName(String name);
	
	
	
	public List<SubjectDTO> search(SubjectDTO dto);
	
	
	
	public List search(SubjectDTO dto, int pageNo, int pageSize) ;
	
	
	public Map<Long, SubjectDTO> getMapDTO(Set<Long> ids);
	
}
