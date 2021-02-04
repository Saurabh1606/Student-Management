package in.co.student.info.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import in.co.student.info.dto.AttendanceDTO;

public interface AttendanceDAOInt {

	
public long add(AttendanceDTO dto);

	
	public void update(AttendanceDTO dto);

	
	public void delete(AttendanceDTO dto);
	

  
	public AttendanceDTO findByName(String name);
	
	public AttendanceDTO findBySubNameDateTitle(long subId,long StuId,Date date,String Title);
	

	
	public AttendanceDTO findByPk(long id);

	
	public List<AttendanceDTO> search(AttendanceDTO dto, long pageNo, int pageSize);

	
	public List<AttendanceDTO> search(AttendanceDTO dto);
	
	
	
	public Map<Long, AttendanceDTO> getMapDTO(Set<Long> ids);
	
}
