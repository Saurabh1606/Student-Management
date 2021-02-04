package in.co.student.info.dao;

import java.util.Date;
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

import in.co.student.info.dto.AssignmentDTO;

@Repository
public class AssignmentDAOHibImpl implements AssignmentDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	public long add(AssignmentDTO dto) {

		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(AssignmentDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);

	}

	public void delete(AssignmentDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public AssignmentDTO findByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(AssignmentDTO.class);

		criteria.add(Restrictions.eq("assignmentTitle", name));

		return (AssignmentDTO) criteria.uniqueResult();
	}
	
	public AssignmentDTO findByNameDate(String name,Date Date) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(AssignmentDTO.class);

		criteria.add(Restrictions.eq("assignmentTitle", name));
		criteria.add(Restrictions.eq("dueDate", Date));

		return (AssignmentDTO) criteria.uniqueResult();
	}

	public AssignmentDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		AssignmentDTO dto = (AssignmentDTO) session.get(AssignmentDTO.class, id);
		
		return dto;
	}

	public List<AssignmentDTO> search(AssignmentDTO dto, long pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(AssignmentDTO.class);

		if (dto != null) {
		
			if (dto.getId() > 0) {

				criteria.add(Restrictions.eq("id", dto.getId()));

			}
			if (dto.getSubjectName() != null && dto.getSubjectName().length() > 0) {
				criteria.add(Restrictions.like("subjectName", dto.getSubjectName() + "%"));
			}
			
			if (dto.getAssignmentTitle() != null && dto.getAssignmentTitle().length() > 0) {
				criteria.add(Restrictions.like("assignmentTitle", dto.getAssignmentTitle() + "%"));
			}
			
			if (dto.getDueDate() != null && dto.getDueDate().getDate() > 0) {
				criteria.add(Restrictions.like("dueDate", dto.getDueDate() + "%"));
			}

			if (pageSize > 0) {

				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}

		return criteria.list();
	}

	public List<AssignmentDTO> search(AssignmentDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public Map<Long, AssignmentDTO> getMapDTO(Set<Long> ids) {
		Session session = sessionFactory.getCurrentSession();
		Map<Long, AssignmentDTO> map = new HashMap<Long, AssignmentDTO>();	
		
		for (Long id : ids) {
			map.put(id,  (AssignmentDTO) session.get(AssignmentDTO.class, id));
		}	
		return map;
		
		
	}
	
}
