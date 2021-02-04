package in.co.student.info.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.student.info.dao.FeeDAOInt;
import in.co.student.info.dao.UserDAOInt;
import in.co.student.info.dto.FeeDTO;
import in.co.student.info.dto.UserDTO;
import in.co.student.info.exception.DuplicateRecordException;

@Service
public class FeeServiceSpringImpl implements FeeServiceInt {

	@Autowired
	FeeDAOInt dao;
	
	@Autowired
	UserDAOInt uDao;

	private static Logger log = Logger.getLogger(FeeServiceSpringImpl.class);

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public long add(FeeDTO dto) throws DuplicateRecordException {

		log.debug("Fee spring add start");

		
		UserDTO uDto= uDao.findByPk(dto.getStudentId());

		dto.setName(uDto.getFirstName()+" "+uDto.getLastName());
		
		FeeDTO existdto = dao.findByStudentNameandMonth(dto.getStudentId(), dto.getMonth());

		if (existdto != null) {
			throw new DuplicateRecordException("Fee is already exits");
		}
		
		log.debug("Fee spring add end");
		return dao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(FeeDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(FeeDTO dto) throws DuplicateRecordException {
		log.debug("Fee spring add start");

		
		UserDTO uDto= uDao.findByPk(dto.getStudentId());

		dto.setName(uDto.getFirstName()+" "+uDto.getLastName());
		
		FeeDTO existdto = dao.findByName(dto.getName());
		
		if (existdto != null && existdto.getId() != dto.getId()) {
			throw new DuplicateRecordException("Fee is already exits");
		}

		log.debug("Fee spring add end");

		dao.update(dto);
	}

	@Transactional(readOnly = true)
	public FeeDTO findByPK(long pk) {

		return dao.findByPk(pk);
	}

	@Transactional(readOnly = true)
	public FeeDTO findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

	@Transactional(readOnly = true)
	public List<FeeDTO> search(FeeDTO dto) {
		// TODO Auto-generated method stub
		return dao.search(dto);
	}

	@Transactional(readOnly = true)
	public List search(FeeDTO dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public Map<Long, FeeDTO> getMapDTO(Set<Long> ids) {
		// TODO Auto-generated method stub
		return dao.getMapDTO(ids);
	}
}
