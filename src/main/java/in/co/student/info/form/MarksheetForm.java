package in.co.student.info.form;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.student.info.dto.BaseDTO;
import in.co.student.info.dto.MarksheetDTO;




public class MarksheetForm extends BaseForm {

	@NotEmpty(message = "NotEmpty.form.rollNo")
	private String rollNo;
	
	

	private String name;


	@Min(value = 1, message = "Min.form.studentId")
	private long studentId;

	@NotNull(message="NotNull.form.physics")
	@Min(value=0, message="Min.form.physics")
	@Max(value=100, message="Max.form.physics")
	private Integer physics;
	
	
	@NotNull(message="NotNull.form.maths")
	@Min(value=0, message="Min.form.maths")
	@Max(value=100, message="Max.form.maths")
	private Integer maths;
	
	
	@NotNull (message="NotNull.form.chemistry")
	@Min(value=0, message="Min.form.chemistry")
	@Max(value=100, message="Max.form.chemistry")
	private Integer chemistry;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChimistry(Integer chimistry) {
		this.chemistry = chimistry;
	}

	@Override
	public BaseDTO getDto() {
		MarksheetDTO dto = new MarksheetDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setRollNo(rollNo);
		dto.setChemistry(chemistry);
		dto.setMaths(maths);
		dto.setPhysics(physics);
		dto.setStudentId(studentId);
		dto.setName(name);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		MarksheetDTO dto =  (MarksheetDTO) bDto;
		id=dto.getId();
		createdBy=dto.getCreatedBy();
		modifiedBy=dto.getModifiedBy();
		createdDateTime=dto.getCreatedDatetime();
		modifiedDateTime=dto.getModifiedDatetime();
		chemistry=dto.getChemistry();
		maths=dto.getMaths();
		physics=dto.getPhysics();
		studentId=dto.getStudentId();
		rollNo=dto.getRollNo();
		name=dto.getName();
	}
}
