package in.co.student.info.form;

import javax.validation.constraints.Pattern;


import org.hibernate.validator.constraints.NotEmpty;

import in.co.student.info.dto.BaseDTO;
import in.co.student.info.dto.MarksheetDTO;


public class GetMarksheetform extends BaseForm {

	@NotEmpty
	private String rollNo;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	@Override
	public BaseDTO getDto() {
		MarksheetDTO dto= new MarksheetDTO();
		dto.setRollNo(rollNo);
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		MarksheetDTO dto= new MarksheetDTO();
		
		rollNo=dto.getRollNo();
		
		
	}
}
