package kr.project.mms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.mms.dao.RdboardDao;
import kr.project.mms.vo.DateEditVo;
import kr.project.mms.vo.MemberVo;
import kr.project.mms.vo.RdboardVo;
import kr.project.mms.vo.RecommendationVo;

@Service
public class RdboardServiceImp implements RdboardService {

	@Autowired
	RdboardDao rdboardDao;
	
	@Autowired
	DateEditVo dateEditVo;
	
	@Override
	public List<RdboardVo> getBoards() {
		List<RdboardVo> list = rdboardDao.getBoards();		
		for(RdboardVo letter : list) {
			Date regdate = letter.getRecdboard_regdate();
			letter.setPrintdate(dateEditVo.printdate(regdate));
		}
		return list;
	}

	@Override
	public List<RdboardVo> searchBoards(String rkey, String word) {
		List<RdboardVo> list = rdboardDao.searchBaords(rkey, word);;		
		for(RdboardVo letter : list) {
			Date regdate = letter.getRecdboard_regdate();
			letter.setPrintdate(dateEditVo.printdate(regdate));
		}
		return list;
	}

	@Override
	public void registerBoard(RdboardVo rdboardVo) {
		rdboardDao.setBoard(rdboardVo);
	}

	@Override
	public RdboardVo getDetail(Integer recdboard_id, Integer user_id) {
		if (recdboard_id == null) {
			return null;
		} else {
			RdboardVo detail = rdboardDao.getDetail(recdboard_id);
			List<RecommendationVo> recomend = rdboardDao.getRecommend(recdboard_id);
			for (RecommendationVo who : recomend) {
				if (who.getRecommender() == user_id) {
					detail.setRecommend(true);
				} else detail.setRecommend(false);
			}
			Date regdate = detail.getRecdboard_regdate();
			Date eddate = detail.getRecdboard_editdate();
			detail.setPrintdate(dateEditVo.printfulldate(regdate));
			detail.setPrinteddate(dateEditVo.printfulldate(eddate));
			return detail;
		}
	}

	@Override
	public boolean deleteBoard(Integer recdboard_id, MemberVo user) {
		RdboardVo board = rdboardDao.getDetail(recdboard_id);
		if(board == null || !board.getRecdboard_writer().equals(user.getMember_id())) {
			return false;
		} else {
			board.setRecdboard_state("true");
			rdboardDao.updateBoard(board);
			return true;
		}
	}

	@Override
	public boolean updateBoard(RdboardVo update, MemberVo user) {
		RdboardVo board = rdboardDao.getDetail(update.getRecdboard_id());
		if(board == null || !board.getRecdboard_writer().equals(user.getMember_id())) {
			return false;
		} else {
			board.setRecdboard_title(update.getRecdboard_title());
			board.setRecdboard_content(update.getRecdboard_content());
			board.setRecdboard_editdate(dateEditVo.regsiterdate());
			rdboardDao.updateBoard(board);
			return true;
		}
	}

	@Override
	public void recomendBoard(Integer recdboard_id, Integer recdboard_recd, Integer user_id) {
		rdboardDao.recomendBoard(recdboard_id, user_id);
		Integer newrecd = recdboard_recd + 1;
		rdboardDao.updateRecdBoard(recdboard_id, newrecd);
	}
}
