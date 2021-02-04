package in.co.student.info.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.student.info.dao.SubjectDAOInt;
import in.co.student.info.dto.SubjectDTO;
import in.co.student.info.exception.DuplicateRecordException;

@Service
public class SubjectServiceSpringImpl  implements SubjectServiceInt{

	
	@Autowired
	SubjectDAOInt dao;

	private static Logger log = Logger.getLogger(SubjectServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(SubjectDTO dto) throws DuplicateRecordException {

		log.debug("Subject spring add start");

		SubjectDTO existdto = dao.findByName(dto.getName());

		if (existdto != null) {
			throw new DuplicateRecordException("Subject is already exits");
		}

		log.debug("Subject spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(SubjectDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(SubjectDTO dto) throws DuplicateRecordException {
		log.debug("Subject spring add start");

		SubjectDTO existdto = dao.findByName(dto.getName());
		
		if (existdto != null && existdto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Subject is already exits");
		}

		log.debug("Subject spring add end");

		dao.update(dto);
	}

	

	@Transactional(readOnly = true)
	public SubjectDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	

	@Transactional(readOnly = true)
	public Map<Long, SubjectDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return dao.getMapDTO(ids);
	}

	

	@Override
	@Transactional(readOnly = true)
	public SubjectDTO findByPK(long pk) {
		// TODO Auto-generated method stub
		return dao.findByPk(pk);
	}

	@Override
	@Transactional(readOnly = true)
	public List search(SubjectDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return dao.search(dto, pageNo, pageSize);
	}
	
}
