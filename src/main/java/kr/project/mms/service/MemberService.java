package kr.project.mms.service;

import kr.project.mms.vo.MemberVo;

public interface MemberService {

	public MemberVo signin(MemberVo loginInfo);

	public boolean signup(MemberVo joinInfo);

	public boolean isDuplicated(String member_email);
	
	public void updateMember(String savedName, Integer id);

	public void updateMember(MemberVo memberVo);
}
