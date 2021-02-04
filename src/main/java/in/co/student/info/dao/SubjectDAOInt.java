package in.co.student.info.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.student.info.dto.SubjectDTO;
import in.co.student.info.exception.DuplicateRecordException;


public interface SubjectDAOInt {
	
   public long add(SubjectDTO dto) throws DuplicateRecordException;

	
	public void update(SubjectDTO dto) throws DuplicateRecordException;

	
	public void delete(SubjectDTO dto);
	

  
	public SubjectDTO findByName(String name);
	

	
	public SubjectDTO findByPk(long id);

	
	public List<SubjectDTO> search(SubjectDTO dto, long pageNo, int pageSize);

	
	public List<SubjectDTO> search(SubjectDTO dto);
	
	
	
	public Map<Long, SubjectDTO> getMapDTO(Set<Long> ids);

}
