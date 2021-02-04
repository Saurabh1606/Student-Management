package in.co.student.info.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.student.info.dao.AssignmentDAOInt;
import in.co.student.info.dao.SubjectDAOHibImpl;
import in.co.student.info.dao.SubjectDAOInt;
import in.co.student.info.dao.AssignmentDAOInt;
import in.co.student.info.dto.AssignmentDTO;
import in.co.student.info.dto.SubjectDTO;
import in.co.student.info.exception.DuplicateRecordException;

@Service
public class AssignmentServiceSpringImpl implements AssignmentServiceInt {

	
	@Autowired
	AssignmentDAOInt dao;
	
	@Autowired
	SubjectDAOInt sDao;

	private static Logger log = Logger.getLogger(AssignmentServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(AssignmentDTO dto) throws DuplicateRecordException {

		log.debug("Assignment spring add start");

		AssignmentDTO existdto = dao.findByNameDate(dto.getAssignmentTitle(), dto.getDueDate());

		if (existdto != null) {
			throw new DuplicateRecordException("Assignment is already exits");
		}
		
		SubjectDTO sDto=sDao.findByPk(dto.getSubjectId());
		dto.setSubjectName(sDto.getName());
		log.debug("Assignment spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(AssignmentDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(AssignmentDTO dto) throws DuplicateRecordException {
		log.debug("Assignment spring add start");

		AssignmentDTO existdto = dao.findByNameDate(dto.getAssignmentTitle(), dto.getDueDate());
		
		if (existdto != null && existdto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Assignment is already exits");
		}

		SubjectDTO sDto=sDao.findByPk(dto.getSubjectId());
		dto.setSubjectName(sDto.getName());
		
		log.debug("Assignment spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public AssignmentDTO findByPK(long pk) {
		return dao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public AssignmentDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<AssignmentDTO> search(AssignmentDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(AssignmentDTO dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, AssignmentDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return dao.getMapDTO(ids);
	}
	
}
