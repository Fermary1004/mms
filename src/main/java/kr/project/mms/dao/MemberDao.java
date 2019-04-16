package kr.project.mms.dao;

import org.apache.ibatis.annotations.Param;

import kr.project.mms.vo.MemberVo;

public interface MemberDao {

	public MemberVo getMember(@Param("member_email")String member_email);

	public void joinMember(@Param("join")MemberVo joinInfo);

	public void updateMember(@Param("update")MemberVo memberVo);
	
	public void updateMemberImg(@Param("image")String savedName, @Param("id")Integer id);

}
