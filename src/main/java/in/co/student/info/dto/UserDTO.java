package in.co.student.info.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User JavaBean encapsulates TimeTable attributes
 * 
 * @author Navigable Set
 * @version 1.0
 * @Copyright (c) Navigable Set
 * 
 */
@Entity
@Embeddable
@Table(name="S_User")
public class UserDTO extends BaseDTO  implements DropdownListBean {

	
	/**
	 * First Name of User
	 */
	@Column(name ="First_Name",length=225)
	private String firstName;
	/**
	 * Last Name of User
	 */
	@Column(name ="Last_Name" , length=225)
	private String lastName;
	/**
	 * Login of User
	 */
	@Column(name ="Login" , length=225)
	private String login;
	/**
	 * Password of User
	 */
	@Column(name ="Password" , length=225)
	private String password;
	/**
	 * Confirm Password of User
	 */
	
	private String confirmPassword;
	/**
	 * Date of Birth of User
	 */
	@Column(name="Dob")
	@Temporal(TemporalType.DATE)
	private Date dob;
	/**
	 * MobielNo of User
	 */
	@Column(name ="Mobile_No" , length=225)
	private String mobileNo;
	/**
	 * Role of User
	 */
	@Column(name="Role_Id")
	private long roleId;
	/**
	 * Number of unsuccessful login attempt
	 */
	/**
	 * Gender of User
	 */
	@Column(name ="Gender" , length=225)
	private String gender;
	@Column(name ="Email_Id" , length=225)
	private String emailId;
	@Column(name ="Address_1" , length=225)
	private String address1;
	@Column(name ="Address_2" , length=225)
	private String address2;
	@Column(name ="City" , length=225)
	private String city;
	@Column(name ="State" , length=225)
	private String state;
	@Column(name ="Country" , length=225)
	private String country;
	@Column(name ="Image" , length=225)
	private String image;
	
	
	
	


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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return FirstName Of User
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param FirstName
	 *            To set User FirstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return LastName Of User
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param LastName
	 *            To set User LastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return Login id Of User
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param Login
	 *            Id To set User Login ID
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return Password Of User
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param Password
	 *            To set User Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Confirm Password Of User
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param Confirm
	 *            PAssword To set User Confirm Password
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * @return Date Of Birth Of User
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param Date
	 *            Of Birth To set User Date Of Birth
	 */

	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return Mobile No Of User
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param Mobile
	 *            No To set User Mobile No
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return ROle Id Of User
	 */
	public long getRoleId() {
		return roleId;
	}

	/**
	 * @param Role
	 *            Id To set User ROle Id
	 */
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	
	

	/**
	 * @return unSuccessfulLogin Of User
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param Gender
	 *            To set User Gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String getKey() {
		return String.valueOf(id);
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName +" "+lastName;
	}

}
