package kr.project.mms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.project.mms.dao.MemberDao;
import kr.project.mms.vo.DateEditVo;
import kr.project.mms.vo.MemberVo;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	DateEditVo dateEditVo;
	
	@Override
	public MemberVo signin(MemberVo loginInfo) {
		MemberVo user = memberDao.getMember(loginInfo.getMember_email());
		if (user != null && passwordEncoder.matches(loginInfo.getMember_pw(), user.getMember_pw())) {
			return user;
		} else return null;
	}

	@Override
	public boolean signup(MemberVo joinInfo) {
		if (memberDao.getMember(joinInfo.getMember_email()) != null) {
			return false;
		} else {
			String encPw = passwordEncoder.encode(joinInfo.getMember_pw());
			String birth = joinInfo.getInputbirth() + " 09:00:00";
			joinInfo.setMember_birth(dateEditVo.regsiterdate(birth)); 
			joinInfo.setMember_pw(encPw);
			memberDao.joinMember(joinInfo);
			return true;
		}
	}

	@Override
	public boolean isDuplicated(String member_email) {
		if(memberDao.getMember(member_email) != null) {
			return true;	
		} else return false;
	}
	
	@Override
	public void updateMember(String savedName, Integer id) {
		memberDao.updateMemberImg(savedName, id);
	} 

	@Override
	public void updateMember(MemberVo memberVo) {
		if(memberVo.getMember_pw().equals("")) {
			MemberVo origin = memberDao.getMember(memberVo.getMember_email());
			System.out.println(origin);
			memberVo.setMember_pw(origin.getMember_pw());
		} else {
			String encPw = passwordEncoder.encode(memberVo.getMember_pw());
			memberVo.setMember_pw(encPw);
		}
		if(memberVo.getInputbirth().equals("")) {
			MemberVo origin = memberDao.getMember(memberVo.getMember_email());
			memberVo.setMember_birth(origin.getMember_birth());
		} else {
			String birth = memberVo.getInputbirth() + " 09:00:00";
			memberVo.setMember_birth(dateEditVo.regsiterdate(birth));
		}
		memberVo.setMember_editeddate(dateEditVo.regsiterdate());
		memberVo.setMember_grade("general");
		memberVo.setMember_state("true");
		memberVo.setAuthority("user");
		memberDao.updateMember(memberVo);
	} 

}
