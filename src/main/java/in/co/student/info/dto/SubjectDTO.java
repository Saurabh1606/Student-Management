package in.co.student.info.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Subject JavaBean encapsulates Subject attributes
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */
@Entity
@Table(name="S_Subject")
public class SubjectDTO extends BaseDTO {

	/**
	 * Name of Subject
	 */
	@Column(name="Name",length=225)
	private String name;

	/**
	 * Description of Subject
	 */
	@Column(name="Description",length=225)
	private String description;
	/**
	 * Name of Course
	 */


	
	

	public SubjectDTO() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}

}
