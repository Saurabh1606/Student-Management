package in.co.student.info.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="S_Assignment")
public class AssignmentDTO extends BaseDTO {

	@Column(name="SubjectId")
	private long subjectId;
	
	@Column(name="SubjectName",length=225)
	private String subjectName;
	
	@Column(name="AssignmentTitle",length=225)
	private String assignmentTitle;
	
	@Column(name="DueDate")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@Column(name="AssignmentFile",length=225)
	private String assignmentFile;
	
	@Column(name="Decription",length=225)
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

	public String getAssignmentTitle() {
		return assignmentTitle;
	}

	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getAssignmentFile() {
		return assignmentFile;
	}

	public void setAssignmentFile(String assignmentFile) {
		this.assignmentFile = assignmentFile;
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
		return id+"";
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return assignmentTitle;
	}
	
	
	

}
