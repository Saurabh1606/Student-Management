package in.co.student.info.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * MarkSheet JavaBean encapsulates MarkSheet attributes
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */
@Entity
@Table(name="S_Marksheet")
public class MarksheetDTO extends BaseDTO {
	
	@Column(name="RollNo",length=225)
	private String rollNo;
	/**
	 * ID of Student
	 */
	@Column(name="StudentId")
	private long studentId;
	/**
	 * Name of Student
	 */
	@Column(name="Name",length=225)
	private String name;
	/**
	 * Physics marks of Student
	 */
	@Column(name="Physics")
	private Integer physics;
	/**
	 * Chemistry marks of Student
	 */
	@Column(name="Chemistry")
	private Integer chemistry;
	/**
	 * Mathematics marks of Student
	 */
	@Column(name="Maths")
	private Integer maths;

	/**
	 * accessor
	 */

	/**
	 * @return Roll No Of MarkSheet
	 */
	public String getRollNo() {
		return rollNo;
	}

	/**
	 * @param Roll
	 *            No to set Roll No Of MarkSheet
	 */
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return Name of Student Regarding Roll No
	 */
	public String getName() {
		return name;
	}

	/**
	 * @Param Name Of Student to set Student Name Of MarkSheet
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Marks of Physics
	 */
	public Integer getPhysics() {
		return physics;
	}

	/**
	 * @param Physics
	 *            Marks to set Physics Marks in MarkSheet
	 */
	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	/**
	 * @return Marks of Chemistry
	 */
	public Integer getChemistry() {
		return chemistry;
	}

	/**
	 * @param Chemistry
	 *            Marks to set Chemistry Marks in MarkSheet
	 */
	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	/**
	 * @return Marks of Maths
	 */
	public Integer getMaths() {
		return maths;
	}

	/**
	 * @param Maths
	 *            Marks to set Maths Marks in MarkSheet
	 */
	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return rollNo;
	}
}
