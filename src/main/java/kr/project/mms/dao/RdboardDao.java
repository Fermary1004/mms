package kr.project.mms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.project.mms.vo.RdboardVo;
import kr.project.mms.vo.RecommendationVo;

public interface RdboardDao {

	public List<RdboardVo> getBoards();
	
	public List<RdboardVo> searchBaords(@Param("key")String rkey, @Param("word")String word);

	public void setBoard(@Param("board")RdboardVo rdboardVo);

	public RdboardVo getDetail(@Param("recdboard_id")Integer recdboard_id);

	public void updateBoard(@Param("board")RdboardVo rdboardVo);

	public void recomendBoard(@Param("recdboard_id")Integer recdboard_id, @Param("user_id")Integer user_id);

	public List<RecommendationVo> getRecommend(@Param("recdboard_id")Integer recdboard_id);

	public void updateRecdBoard(@Param("recdboard_id")Integer recdboard_id, @Param("newrecd")Integer newrecd);

}
