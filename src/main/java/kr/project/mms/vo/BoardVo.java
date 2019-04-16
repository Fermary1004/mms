package kr.project.mms.vo;

import java.util.Date;

public class BoardVo {
	private Integer freeboard_id;
	private String freeboard_title;
	private Integer freeboard_writer;
	private String freeboard_content;
	private Date freeboard_regdate;
	private Date freeboard_editdate;
	private String freeboard_file;
	private String freeboard_state;
	private Integer member_id;
	private String member_nick;
	private String member_image;
	private String printdate;
	private String printeddate;
	
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public Integer getFreeboard_id() {
		return freeboard_id;
	}
	public void setFreeboard_id(Integer freeboard_id) {
		this.freeboard_id = freeboard_id;
	}
	public String getFreeboard_title() {
		return freeboard_title;
	}
	public void setFreeboard_title(String freeboard_title) {
		this.freeboard_title = freeboard_title;
	}
	public Integer getFreeboard_writer() {
		return freeboard_writer;
	}
	public void setFreeboard_writer(Integer freeboard_writer) {
		this.freeboard_writer = freeboard_writer;
	}
	public String getFreeboard_content() {
		return freeboard_content;
	}
	public void setFreeboard_content(String freeboard_content) {
		this.freeboard_content = freeboard_content;
	}
	public Date getFreeboard_regdate() {
		return freeboard_regdate;
	}
	public void setFreeboard_regdate(Date freeboard_regdate) {
		this.freeboard_regdate = freeboard_regdate;
	}
	public Date getFreeboard_editdate() {
		return freeboard_editdate;
	}
	public void setFreeboard_editdate(Date freeboard_editdate) {
		this.freeboard_editdate = freeboard_editdate;
	}
	public String getFreeboard_file() {
		return freeboard_file;
	}
	public void setFreeboard_file(String freeboard_file) {
		this.freeboard_file = freeboard_file;
	}
	public String getFreeboard_state() {
		return freeboard_state;
	}
	public void setFreeboard_state(String freeboard_state) {
		this.freeboard_state = freeboard_state;
	}
	
	@Override
	public String toString() {
		return "BoardVo [freeboard_id=" + freeboard_id + ", freeboard_title=" + freeboard_title + ", freeboard_writer="
				+ freeboard_writer + ", freeboard_content=" + freeboard_content + ", freeboard_regdate=" + freeboard_regdate
				+ ", freeboard_editdate=" + freeboard_editdate + ", freeboard_file=" + freeboard_file + ", freeboard_state="
				+ freeboard_state + "]";
	}
	public String getPrintdate() {
		return printdate;
	}
	public void setPrintdate(String printdate) {
		this.printdate = printdate;
	}
	public String getPrinteddate() {
		return printeddate;
	}
	public void setPrinteddate(String printeddate) {
		this.printeddate = printeddate;
	}
	public String getMember_image() {
		return member_image;
	}
	public void setMember_image(String member_image) {
		this.member_image = member_image;
	}
}
