package in.co.student.info.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.student.info.dao.MarksheetDAOInt;
import in.co.student.info.dto.MarksheetDTO;
import in.co.student.info.dto.UserDTO;
import in.co.student.info.exception.DuplicateRecordException;



/**
 * Marksheet service Spring Implementation
 * 
 * @author Navigable Set
 * @copywrite Navigable Set
 */

@Service
public class MarksheetServiceSpringImpl implements MarksheetServiceInt {

	@Autowired
	MarksheetDAOInt dao;
	
	@Autowired
	UserServiceInt studentservice;

	private static Logger log = Logger.getLogger(UserServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(MarksheetDTO dto) throws DuplicateRecordException {

		log.debug("Spring marksheet add Service start");

		MarksheetDTO existdto = dao.findByRollNo(dto.getRollNo());
		if (existdto != null) {
			throw new DuplicateRecordException("Marksheet is already add");
		}
		
	UserDTO studentDTO=studentservice.findByPK(dto.getStudentId());
	dto.setName(studentDTO.getFirstName()+" "+studentDTO.getLastName());
	
		log.debug("Spring marksheet add Service End");

		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(MarksheetDTO dto) {
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(MarksheetDTO dto) throws DuplicateRecordException {
		log.debug("Spring marksheet update Service start");

		MarksheetDTO existdto = dao.findByRollNo(dto.getRollNo());
		if (existdto != null && existdto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Marksheet is already add");
		}

		UserDTO studentDTO=studentservice.findByPK(dto.getStudentId());
		dto.setName(studentDTO.getFirstName()+" "+studentDTO.getLastName());
		log.debug("Spring marksheet update Service End");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public MarksheetDTO findByPK(long pk) {
		// TODO Auto-generated method stub
		return dao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public MarksheetDTO findByRollNo(String rollNo) {
		// TODO Auto-generated method stub
		return dao.findByRollNo(rollNo);
	}

	@Transactional(readOnly = true)
	public List<MarksheetDTO> search(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(MarksheetDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public List getMeritList(int pageNo, int pageSize){
		
	return dao.getMeritList(pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public MarksheetDTO getMarkshet(String rollNo){
		return dao.getMarksheet(rollNo);
	}
	
}
