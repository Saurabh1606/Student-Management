package in.co.student.info.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.student.info.dto.MarksheetDTO;



/**
 * Hibernate implementation of Marksheet DAO.
 * 
 * @author Navigable Set
 * @version 1.0
 *
 */

@Repository
public class MarksheetDAOHibImpl implements MarksheetDAOInt {

	@Autowired
	private SessionFactory sessionFactory;

	/*@Autowired
	private StudentServiceInt studentservice;*/

	public long add(MarksheetDTO dto) {

	/*	StudentDTO sdto = studentservice.findByPK(dto.getStudentId());


		dto.setName(sdto.getFirstName() + " " + sdto.getLastName());*/

		long pk = (Long) sessionFactory.getCurrentSession().save(dto);
		return pk;
	}

	public void update(MarksheetDTO dto) {
		sessionFactory.getCurrentSession().merge(dto);

	}

	public void delete(MarksheetDTO dto) {
		sessionFactory.getCurrentSession().delete(dto);

	}

	public MarksheetDTO findByRollNo(String rollNo) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MarksheetDTO.class);
		criteria.add(Restrictions.eq("rollNo", rollNo));
		return (MarksheetDTO) criteria.uniqueResult();
	}

	public MarksheetDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		MarksheetDTO dto = (MarksheetDTO) session.get(MarksheetDTO.class, id);
		return dto;
	}

	public List<MarksheetDTO> search(MarksheetDTO dto, long pageNo, int pageSize) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(MarksheetDTO.class);

		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}

			if (dto.getStudentId() > 0) {
				criteria.add(Restrictions.eq("studentId", dto.getStudentId()));
			}
			if (dto.getRollNo() != null && dto.getRollNo().length() > 0) {
				criteria.add(Restrictions.eq("rollNo", dto.getRollNo()));
			}
			if (dto.getName() != null && dto.getName().length() > 0) {
				criteria.add(Restrictions.like("name", dto.getName() + "%"));
			}
			if (dto.getPhysics() != null && dto.getPhysics() > 0) {
				criteria.add(Restrictions.eq("physics", dto.getPhysics()));
			}
			if (dto.getChemistry() != null && dto.getChemistry() > 0) {
				criteria.add(Restrictions.eq("chemistry", dto.getChemistry()));
			}
			if (dto.getMaths() != null && dto.getMaths() > 0) {
				criteria.add(Restrictions.eq("maths", dto.getMaths()));
			}
		}
		// if page size is greater than zero the apply pagination
		if (pageSize > 0) {
			criteria.setFirstResult((int) ((pageNo - 1) * pageSize));
			criteria.setMaxResults(pageSize);
		}
		return criteria.list();
	}

	public List<MarksheetDTO> search(MarksheetDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	public List getMeritList(int pageNo, int pageSize) {
		Session session = sessionFactory.getCurrentSession();

		StringBuffer hql = new StringBuffer(
				"from MarksheetDTO where physics>35 and chemistry>35  and maths>35 order by (physics + chemistry + maths) desc");

		Query query = session.createQuery(hql.toString());

		// if page size is greater than zero then apply pagination
		if (pageSize > 0) {
			pageNo = ((pageNo - 1) * pageSize);
			query.setFirstResult(pageNo);
			query.setMaxResults(pageSize);

		}

		return query.list();
	}

	public MarksheetDTO getMarksheet(String rollNo) {
	
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(MarksheetDTO.class);
		
		criteria.add(Restrictions.eq("rollNo", rollNo));
		
		return (MarksheetDTO)criteria.uniqueResult();
	}

}
