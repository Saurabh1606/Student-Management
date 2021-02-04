package in.co.student.info.form;

import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.student.info.dto.AssignmentDTO;
import in.co.student.info.dto.BaseDTO;
import in.co.student.info.util.DataUtility;

public class AssignmentForm extends BaseForm {

	@Min(value = 1)
	private long subjectId;
	
	@NotEmpty
	private String assignmentTitle;
	
	@NotEmpty
	private String dueDate;
	
	@NotEmpty
	private String assignmentFile;
	
	@NotEmpty
	private String description;
	
	private String subjectName;
	
	
	
	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getAssignmentTitle() {
		return assignmentTitle;
	}

	public void setAssignmentTitle(String assignmentTitle) {
		this.assignmentTitle = assignmentTitle;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public BaseDTO getDto() {
		AssignmentDTO dto=new AssignmentDTO();
		
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		
		dto.setSubjectId(subjectId);
		dto.setAssignmentTitle(assignmentTitle);
		dto.setDueDate(DataUtility.getDate(dueDate));
		dto.setAssignmentFile(assignmentFile);
		dto.setDescription(description);
		
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		AssignmentDTO dto=(AssignmentDTO) bDto;
		
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		
		subjectId = dto.getSubjectId();
		assignmentTitle=dto.getAssignmentTitle();
		assignmentFile=dto.getAssignmentFile();
		dueDate=DataUtility.getStringDate(dto.getDueDate());
		description=dto.getDescription();
		
	}

}
