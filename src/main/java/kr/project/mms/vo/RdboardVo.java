package kr.project.mms.vo;

import java.util.ArrayList;
import java.util.Date;

public class RdboardVo {
	private Integer recdboard_id;
	private String recdboard_title;
	private Integer recdboard_writer;
	private String recdboard_content;
	private Date recdboard_regdate;
	private Date recdboard_editdate;
	private String recdboard_file;
	private String recdboard_state;
	private String recdboard_tags;
	private ArrayList<String> recdboard_tagsst;
	private Integer recdboard_recd;
	private boolean recommend;
	private Integer member_id;
	private String member_nick;
	private String member_image;
	private String printdate;
	private String printeddate;
	
	public Integer getRecdboard_id() {
		return recdboard_id;
	}
	public void setRecdboard_id(Integer recdboard_id) {
		this.recdboard_id = recdboard_id;
	}
	public String getRecdboard_title() {
		return recdboard_title;
	}
	public void setRecdboard_title(String recdboard_title) {
		this.recdboard_title = recdboard_title;
	}
	public Integer getRecdboard_writer() {
		return recdboard_writer;
	}
	public void setRecdboard_writer(Integer recdboard_writer) {
		this.recdboard_writer = recdboard_writer;
	}
	public String getRecdboard_content() {
		return recdboard_content;
	}
	public void setRecdboard_content(String recdboard_content) {
		this.recdboard_content = recdboard_content;
	}
	public Date getRecdboard_regdate() {
		return recdboard_regdate;
	}
	public void setRecdboard_regdate(Date recdboard_regdate) {
		this.recdboard_regdate = recdboard_regdate;
	}
	public Date getRecdboard_editdate() {
		return recdboard_editdate;
	}
	public void setRecdboard_editdate(Date recdboard_editdate) {
		this.recdboard_editdate = recdboard_editdate;
	}
	public String getRecdboard_file() {
		return recdboard_file;
	}
	public void setRecdboard_file(String recdboard_file) {
		this.recdboard_file = recdboard_file;
	}
	public String getRecdboard_state() {
		return recdboard_state;
	}
	public void setRecdboard_state(String recdboard_state) {
		this.recdboard_state = recdboard_state;
	}
	public String getRecdboard_tags() {
		return recdboard_tags;
	}
	public void setRecdboard_tags(String recdboard_tags) {
		this.recdboard_tags = recdboard_tags;
	}
	public Integer getRecdboard_recd() {
		return recdboard_recd;
	}
	public void setRecdboard_recd(Integer recdboard_recd) {
		this.recdboard_recd = recdboard_recd;
	}
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
	public String getMember_image() {
		return member_image;
	}
	public void setMember_image(String member_image) {
		this.member_image = member_image;
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
	public ArrayList<String> getRecdboard_tagsst() {
		return recdboard_tagsst;
	}
	public void setRecdboard_tagsst(ArrayList<String> recdboard_tagsst) {
		this.recdboard_tagsst = recdboard_tagsst;
	}
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
	
}