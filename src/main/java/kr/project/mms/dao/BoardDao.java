package kr.project.mms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.mms.vo.BoardVo;

public interface BoardDao {

	public List<BoardVo> getBoards();
	
	public List<BoardVo> searchBaords(@Param("key")String fkey, @Param("word")String word);

	public void setBoard(@Param("board")BoardVo boardVo);

	public BoardVo getDetail(@Param("freeboard_id")Integer freeboard_id);

	public void updateBoard(@Param("board")BoardVo boardVo);

}
