package kr.project.mms.service;

import java.util.List;

import kr.project.mms.vo.MemberVo;
import kr.project.mms.vo.BoardVo;

public interface BoardService {

	public List<BoardVo> getBoards();
	
	public List<BoardVo> searchBoards(String fkey, String word);

	public void registerBoard(BoardVo boardVo);

	public BoardVo getDetail(Integer freeboard_id);

	public boolean deleteBoard(Integer freeboard_id, MemberVo user);

	public boolean updateBoard(BoardVo boardVo, MemberVo user);
}
