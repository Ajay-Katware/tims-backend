package com.tejovat.tims.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstname;
	private String lastname;
	private String useremail;
	private Integer userage;
	private String userpwd;
	private Byte userenabled;
	private String confirmationtoken;
	private String resettoken;
	private Date createdon;
	private Date lastlogin;
	
    private String contactno;
    private String filename;
    private String filetype;
	private byte[] picture;
    private Role userrole;
    private Short tempactive;
    private String username;
    private String streetno;
    private String streetname;
    private String city;
    private String postalcode;
    private String province;
    private String country;
    private String gender;

	public User() {
	
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String firstname, String lastname, String useremail, Integer userage, String userpwd,
			Byte userenabled, String confirmationtoken, String resettoken, Date createdon, Date lastlogin,
			String contactno, String filename, String filetype, byte[] picture, Role userrole, Short tempactive,
			String username, String streetno, String streetname, String city, String postalcode, String province,
			String country, String gender) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.useremail = useremail;
		this.userage = userage;
		this.userpwd = userpwd;
		this.userenabled = userenabled;
		this.confirmationtoken = confirmationtoken;
		this.resettoken = resettoken;
		this.createdon = createdon;
		this.lastlogin = lastlogin;
		this.contactno = contactno;
		this.filename = filename;
		this.filetype = filetype;
		this.picture = picture;
		this.userrole = userrole;
		this.tempactive = tempactive;
		this.username = username;
		this.streetno = streetno;
		this.streetname = streetname;
		this.city = city;
		this.postalcode = postalcode;
		this.province = province;
		this.country = country;
		this.gender = gender;
	}

	@Id @GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="firstname", length=50)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	@Column(name="lastname", length=50)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	@Column(name="useremail", length=50)
	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	@Column(name="userage")
	public Integer getUserage() {
		return this.userage;
	}

	public void setUserage(Integer userage) {
		this.userage = userage;
	}


	@Column(name="userpwd", length=50)
	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}


	@Column(name="userenabled")
	public Byte getUserenabled() {
		return this.userenabled;
	}

	public void setUserenabled(Byte userenabled) {
		this.userenabled = userenabled;
	}


	@Column(name="confirmationtoken", length=45)
	public String getConfirmationtoken() {
		return this.confirmationtoken;
	}

	public void setConfirmationtoken(String confirmationtoken) {
		this.confirmationtoken = confirmationtoken;
	}


	@Column(name="resettoken", length=45)
	public String getResettoken() {
		return this.resettoken;
	}

	public void setResettoken(String resettoken) {
		this.resettoken = resettoken;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdon", length=19)
	public Date getCreatedon() {
		return this.createdon;
	}

	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="lastlogin", length=19)
	public Date getLastlogin() {
		return this.lastlogin;
	}

	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
	}

	@Column(name = "contactno")
	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	@Lob
    @Column(name="picture")
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Column(name = "filename")
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "filetype")
	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@JoinColumn(name = "userrole", referencedColumnName = "id")
	@ManyToOne
	public Role getUserrole() {
		return userrole;
	}

	public void setUserrole(Role userrole) {
		this.userrole = userrole;
	}

	@Column(name="tempactive")
	public Short getTempactive() {
		return tempactive;
	}
	
	public void setTempactive(Short tempactive) {
		this.tempactive = tempactive;
	}

	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="streetno")
	public String getStreetno() {
		return streetno;
	}

	public void setStreetno(String streetno) {
		this.streetno = streetno;
	}

	@Column(name="streetname")
	public String getStreetname() {
		return streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="postalcode")
	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	@Column(name="province")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", useremail=" + useremail
				+ ", userage=" + userage + ", userpwd=" + userpwd + ", userenabled=" + userenabled
				+ ", confirmationtoken=" + confirmationtoken + ", resettoken=" + resettoken + ", createdon=" + createdon
				+ ", lastlogin=" + lastlogin + ", contactno=" + contactno + ", filename=" + filename + ", filetype="
				+ filetype + ", picture=" + Arrays.toString(picture) + ", userrole=" + userrole + ", tempactive="
				+ tempactive + ", username=" + username + ", streetno=" + streetno + ", streetname=" + streetname
				+ ", city=" + city + ", postalcode=" + postalcode + ", province=" + province + ", country=" + country
				+ ", gender=" + gender + "]";
	}

	
}



