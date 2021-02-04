package in.co.student.info.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="S_Attendance")
public class AttendanceDTO extends BaseDTO{

	@Column(name="SubjectId")
	private long subjectId;
	
	@Column(name="subjectName",length=225)
	private String subjectName;
	
	@Column(name="StudentId")
	private long studentId;
	
	@Column(name="StudentName",length=225)
	private String studentName;
	
	@Column(name="LectureTitle",length=225)
	private String lectureTitle;
	
	@Column(name="Date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="Description",length=225)
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return id+" ";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return studentName;
	}

}
