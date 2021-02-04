package in.co.student.info.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.student.info.dto.FeeDTO;
@Repository
public class FeeDAOHibImpl implements FeeDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(FeeDTO dto) {

		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(FeeDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);

	}

	public void delete(FeeDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public FeeDTO findByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(FeeDTO.class);

		criteria.add(Restrictions.eq("name", name));

		return (FeeDTO) criteria.uniqueResult();
	}
	
	public FeeDTO findByStudentNameandMonth(long studentId,String month) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(FeeDTO.class);

		criteria.add(Restrictions.eq("studentId", studentId));
		criteria.add(Restrictions.eq("month", month));

		return (FeeDTO) criteria.uniqueResult();
	}
	

	public FeeDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		FeeDTO dto = (FeeDTO) session.get(FeeDTO.class, id);
		
		return dto;
	}

	public List<FeeDTO> search(FeeDTO dto, long pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(FeeDTO.class);

		if (dto != null) {
		
			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getMonth() != null && dto.getMonth().length() > 0) {
				criteria.add(Restrictions.like("month", dto.getMonth() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}

		return criteria.list();
	}

	public List<FeeDTO> search(FeeDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, FeeDTO> getMapDTO(Set<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		Map<Long, FeeDTO> map = new HashMap<Long, FeeDTO>();	
		
		for (Long id : ids) {
			map.put(id,  (FeeDTO) session.get(FeeDTO.class, id));
		}	
		return map;
		
		
	}
}
