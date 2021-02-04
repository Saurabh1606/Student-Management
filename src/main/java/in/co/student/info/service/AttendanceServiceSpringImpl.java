package in.co.student.info.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.student.info.dao.AttendanceDAOInt;
import in.co.student.info.dao.SubjectDAOInt;
import in.co.student.info.dao.UserDAOInt;
import in.co.student.info.dto.AttendanceDTO;
import in.co.student.info.dto.SubjectDTO;
import in.co.student.info.dto.UserDTO;
import in.co.student.info.exception.DuplicateRecordException;

@Service
public class AttendanceServiceSpringImpl implements AttendanceServiceInt {
	
	@Autowired
	AttendanceDAOInt dao;
	
	@Autowired
	SubjectDAOInt SubDao;
	
	@Autowired
	UserDAOInt  userDao;

	private static Logger log = Logger.getLogger(AttendanceServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(AttendanceDTO dto) throws DuplicateRecordException {

		log.debug("Attendance spring add start");

		AttendanceDTO existdto = dao.findBySubNameDateTitle(dto.getSubjectId(),dto.getStudentId(),dto.getDate(), dto.getLectureTitle());

		if (existdto != null) {
			throw new DuplicateRecordException("Attendance is already exits");
		}
		
		SubjectDTO sDto=SubDao.findByPk(dto.getSubjectId());
		UserDTO uDto=userDao.findByPk(dto.getStudentId());
		dto.setSubjectName(sDto.getName());
		dto.setStudentName(uDto.getFirstName()+" "+uDto.getLastName());
		log.debug("Attendance spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(AttendanceDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(AttendanceDTO dto) throws DuplicateRecordException {
		log.debug("Attendance spring add start");

		AttendanceDTO existdto = dao.findBySubNameDateTitle(dto.getSubjectId(),dto.getStudentId(),dto.getDate(), dto.getLectureTitle());
		
		if (existdto != null && existdto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Attendance is already exits");
		}

		SubjectDTO sDto=SubDao.findByPk(dto.getSubjectId());
		UserDTO uDto=userDao.findByPk(dto.getStudentId());
		dto.setSubjectName(sDto.getName());
		dto.setStudentName(uDto.getFirstName()+" "+uDto.getLastName());
		log.debug("Attendance spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public AttendanceDTO findByPK(long pk) {

		return dao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public AttendanceDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<AttendanceDTO> search(AttendanceDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(AttendanceDTO dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, AttendanceDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return dao.getMapDTO(ids);
	}

}
