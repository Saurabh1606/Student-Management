package in.co.student.info.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.student.info.dto.FeeDTO;
import in.co.student.info.exception.DuplicateRecordException;

public interface FeeServiceInt {
	
	
	
public long add(FeeDTO dto) throws DuplicateRecordException;
	
	
	public void delete(FeeDTO dto) ;
	
	
	public void update(FeeDTO dto) throws DuplicateRecordException;
	  
	
	public FeeDTO findByPK(long pk) ;
	
	
	
	public FeeDTO findByName(String name);
	
	
	
	public List<FeeDTO> search(FeeDTO dto);
	
	
	
	public List search(FeeDTO dto, int pageNo, int pageSize) ;
	
	
	public Map<Long, FeeDTO> getMapDTO(Set<Long> ids);
}
