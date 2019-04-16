package kr.project.mms.service;

import java.util.List;

import kr.project.mms.vo.MemberVo;
import kr.project.mms.vo.RdboardVo;

public interface RdboardService {
	
	public List<RdboardVo> getBoards();
	
	public List<RdboardVo> searchBoards(String fkey, String word);

	public void registerBoard(RdboardVo rdboardVo);

	public RdboardVo getDetail(Integer recdboard_id, Integer user_id);

	public boolean deleteBoard(Integer recdboard_id, MemberVo user);

	public boolean updateBoard(RdboardVo rdboardVo, MemberVo user);

	public void recomendBoard(Integer recdboard_id, Integer recdboard_recd, Integer user_id);
}

