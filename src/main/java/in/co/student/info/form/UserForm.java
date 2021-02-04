package in.co.student.info.form;

import javax.validation.constraints.Min;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import in.co.student.info.dto.BaseDTO;
import in.co.student.info.dto.UserDTO;
import in.co.student.info.util.DataUtility;



public class UserForm extends BaseForm {

	@NotEmpty
	@Pattern(regexp = "(^[A-Za-z ]*)*$")
	private String firstName;
	
	
	@NotEmpty
	@Pattern(regexp = "(^[A-Za-z ]*)*$")
	private String lastName;

	@NotEmpty
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$")
	private String login;

	@NotEmpty
	@Pattern(regexp = "(^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\\S])[A-Za-z0-9\\S]{6,12})*$")
	private String password;

	@NotEmpty
	private String confirmPassword;

	@NotEmpty
	private String dob;

	@NotEmpty
	@Pattern(regexp = "(^[7-9][0-9]{9})*$")
	private String mobileNo;

	@NotEmpty
	private String gender;

	@Min(value = 1)
	private long roleId;
	
	
	@NotEmpty
	@Pattern(regexp = "(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))*$")
	private String emailId;
	
	@NotEmpty
	private String address1;
	@NotEmpty
	private String address2;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotEmpty
	private String country;
	
	
	

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public BaseDTO getDto() {
		UserDTO dto = new UserDTO();
		dto.setId(id);
		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);
		dto.setCreatedDatetime(createdDateTime);
		dto.setModifiedDatetime(modifiedDateTime);

		dto.setFirstName(firstName);
		dto.setLastName(lastName);

		dto.setDob(DataUtility.getDate(dob));

		dto.setLogin(login);
		dto.setPassword(password);
		dto.setMobileNo(mobileNo);
		dto.setGender(gender);
		dto.setRoleId(roleId);
		dto.setEmailId(emailId);
		dto.setAddress1(address1);
		dto.setAddress2(address2);
		dto.setState(state);
		dto.setCity(city);
		dto.setCountry(country);
		

		return dto;
	}

	public void populate(BaseDTO bDto) {
		UserDTO dto = (UserDTO) bDto;
		id = dto.getId();
		createdBy = dto.getCreatedBy();
		modifiedBy = dto.getModifiedBy();
		createdDateTime = dto.getCreatedDatetime();
		modifiedDateTime = dto.getModifiedDatetime();

		firstName = dto.getFirstName();
		lastName = dto.getLastName();
		dob = DataUtility.getStringDate(dto.getDob());
		login = dto.getLogin();
		password = dto.getPassword();
		confirmPassword = dto.getPassword();
		mobileNo = dto.getMobileNo();
		gender = dto.getGender();
		roleId = dto.getRoleId();
		emailId=dto.getEmailId();
		address1=dto.getAddress1();
		address2=dto.getAddress2();
		city=dto.getCity();
		state=dto.getState();
		country=dto.getCountry();

	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
