package in.co.student.info.form;

import java.util.Date;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.student.info.dto.BaseDTO;
import in.co.student.info.dto.FeeDTO;
import in.co.student.info.util.DataUtility;

public class FeeForm extends BaseForm {

	@Min(value=1)
	private long studentId;
	@NotEmpty
	private String month;
	
	@NotEmpty
	private String amount;
	@NotEmpty
	private String date;
	
	private String name;
	
	
	
	
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	
	

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public BaseDTO getDto() {
		FeeDTO dto=new FeeDTO();
		
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);
		
		dto.setStudentId(studentId);
		dto.setMonth(month);
		dto.setAmount((amount==null)?0:Long.parseLong(amount));
		dto.setDate(DataUtility.getDate(date));
		
		dto.setName(name);
		
		
		return dto;
	}

	@Override
	public void populate(BaseDTO bDto) {
		FeeDTO dto=(FeeDTO) bDto;
		
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();
		studentId=dto.getStudentId();
		month=dto.getMonth();
		amount=String.valueOf(dto.getAmount());
		date=DataUtility.getStringDate(dto.getDate());
		name=dto.getName();
	}
 
}
