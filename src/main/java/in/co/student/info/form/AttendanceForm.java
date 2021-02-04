package in.co.student.info.form;

import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.student.info.dto.AssignmentDTO;
import in.co.student.info.dto.AttendanceDTO;
import in.co.student.info.dto.BaseDTO;
import in.co.student.info.util.DataUtility;

public class AttendanceForm extends BaseForm {
 
	@Min(value = 1)
	private long subjectId;
	
	private String subjectName;
	
	@Min(value = 1)
	private long studentId;
	
	private String studentName;
	
	@NotEmpty
	private String lectureTitle;
	
	@NotEmpty
	private String date;
	
	@NotEmpty
	private String description;
	
	
	
	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getLectureTitle() {
		return lectureTitle;
	}

	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {
		
		AttendanceDTO dto=new AttendanceDTO();
		
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		
		
		dto.setSubjectId(subjectId);
		dto.setStudentId(studentId);
		dto.setLectureTitle(lectureTitle);
		dto.setDate(DataUtility.getDate(date));
		dto.setDescription(description);
		dto.setStudentName(studentName);
		
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		AttendanceDTO dto=(AttendanceDTO) bDto;
		
		
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		
		subjectId=dto.getStudentId();
		studentId=dto.getStudentId();
		lectureTitle=dto.getLectureTitle();
		date=DataUtility.getStringDate(dto.getDate());
		description=dto.getDescription();
		studentName=dto.getStudentName();
	}

}
