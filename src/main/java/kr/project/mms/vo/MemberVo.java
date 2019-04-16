package kr.project.mms.vo;

import java.util.Date;

public class MemberVo {
	private Integer member_id;
	private String member_email;
	private String member_pw;
	private String member_name;
	private Date member_birth;
	private String member_nick;
	private String member_gender;
	private String member_image;
	private String member_msg;
	private String member_likes;
	private String member_grade;
	private Date member_regdate;
	private Date member_editeddate;
	private String member_state;
	private String authority;
	private String inputbirth;
	private String printeddate;
	
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public Date getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(Date member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getMember_gender() {
		return member_gender;
	}
	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}
	public String getMember_image() {
		return member_image;
	}
	public void setMember_image(String member_image) {
		this.member_image = member_image;
	}
	public String getMember_msg() {
		return member_msg;
	}
	public void setMember_msg(String member_msg) {
		this.member_msg = member_msg;
	}
	public String getMember_likes() {
		return member_likes;
	}
	public void setMember_likes(String member_likes) {
		this.member_likes = member_likes;
	}
	public String getMember_grade() {
		return member_grade;
	}
	public void setMember_grade(String member_grade) {
		this.member_grade = member_grade;
	}
	public Date getMember_regdate() {
		return member_regdate;
	}
	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}
	public Date getMember_editeddate() {
		return member_editeddate;
	}
	public void setMember_editeddate(Date member_editeddate) {
		this.member_editeddate = member_editeddate;
	}
	public String getMember_state() {
		return member_state;
	}
	public void setMember_state(String member_state) {
		this.member_state = member_state;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	@Override
	public String toString() {
		return "MemberVo [member_id=" + member_id + ", member_email=" + member_email + ", member_pw=" + member_pw + ", member_name="
				+ member_name + ", member_birth=" + member_birth + ", member_nick=" + member_nick + ", member_gender="
				+ member_gender + ", member_image=" + member_image + ", member_msg=" + member_msg + ", member_likes="
				+ member_likes + ", member_grade=" + member_grade + ", member_regdate=" + member_regdate + ", member_editeddate="
				+ member_editeddate + ", member_state=" + member_state + ", authority=" + authority + "]";
	}
	public String getInputbirth() {
		return inputbirth;
	}
	public void setInputbirth(String inputbirth) {
		this.inputbirth = inputbirth;
	}
	public String getPrinteddate() {
		return printeddate;
	}
	public void setPrinteddate(String printeddate) {
		this.printeddate = printeddate;
	}
}
