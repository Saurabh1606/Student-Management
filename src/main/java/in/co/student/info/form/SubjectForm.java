package in.co.student.info.form;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.student.info.dto.BaseDTO;
import in.co.student.info.dto.SubjectDTO;

public class SubjectForm extends BaseForm {

	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {
		
		SubjectDTO dto=new SubjectDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		dto.setName(name);
		dto.setDescription(description);
		
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		
		SubjectDTO dto=(SubjectDTO) bDto;
		
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		name=dto.getName();
		description=dto.getDescription();
		
	}

	
}
