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

import in.co.student.info.dto.SubjectDTO;

@Repository
public class SubjectDAOHibImpl implements SubjectDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(SubjectDTO dto) {

		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(SubjectDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);

	}

	public void delete(SubjectDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public SubjectDTO findByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(SubjectDTO.class);

		criteria.add(Restrictions.eq("name", name));

		return (SubjectDTO) criteria.uniqueResult();
	}

	public SubjectDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		SubjectDTO dto = (SubjectDTO) session.get(SubjectDTO.class, id);
		
		return dto;
	}

	public List<SubjectDTO> search(SubjectDTO dto, long pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(SubjectDTO.class);

		if (dto != null) {
		
			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}

		return criteria.list();
	}

	public List<SubjectDTO> search(SubjectDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, SubjectDTO> getMapDTO(Set<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		Map<Long, SubjectDTO> map = new HashMap<Long, SubjectDTO>();	
		
		for (Long id : ids) {
			map.put(id,  (SubjectDTO) session.get(SubjectDTO.class, id));
		}	
		return map;
		
		
	}
}
