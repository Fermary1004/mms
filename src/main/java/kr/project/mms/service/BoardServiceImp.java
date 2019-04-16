package kr.project.mms.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.project.mms.dao.BoardDao;
import kr.project.mms.vo.BoardVo;
import kr.project.mms.vo.MemberVo;
import kr.project.mms.vo.DateEditVo;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	DateEditVo dateEditVo;

	@Override
	public List<BoardVo> getBoards() {
		List<BoardVo> list = boardDao.getBoards();		
		for(BoardVo letter : list) {
			Date regdate = letter.getFreeboard_regdate();
			letter.setPrintdate(dateEditVo.printdate(regdate));
		}
		return list;
	}
	
	@Override
	public List<BoardVo> searchBoards(String fkey, String word) {
		List<BoardVo> list = boardDao.searchBaords(fkey, word);;		
		for(BoardVo letter : list) {
			Date regdate = letter.getFreeboard_regdate();
			letter.setPrintdate(dateEditVo.printdate(regdate));
		}
		return list;
	}

	@Override
	public void registerBoard(BoardVo boardVo) {
		boardDao.setBoard(boardVo);
	}

	@Override
	public BoardVo getDetail(Integer freeboard_id) {
		if (freeboard_id == null) {
			return null;
		} else {
			BoardVo detail = boardDao.getDetail(freeboard_id);
			Date regdate = detail.getFreeboard_regdate();
			Date eddate = detail.getFreeboard_editdate();
			detail.setPrintdate(dateEditVo.printfulldate(regdate));
			detail.setPrinteddate(dateEditVo.printfulldate(eddate));
			return detail;
		}
	}

	@Override
	public boolean deleteBoard(Integer freeboard_id, MemberVo user) {
		BoardVo board = boardDao.getDetail(freeboard_id);
		if(board == null || !board.getFreeboard_writer().equals(user.getMember_id())) {
			return false;
		} else {
			board.setFreeboard_state("true");
			boardDao.updateBoard(board);
			return true;
		}
	}

	@Override
	public boolean updateBoard(BoardVo update, MemberVo user) {
		BoardVo board = boardDao.getDetail(update.getFreeboard_id());
		if(board == null || !board.getFreeboard_writer().equals(user.getMember_id())) {
			return false;
		} else {
			board.setFreeboard_title(update.getFreeboard_title());
			board.setFreeboard_content(update.getFreeboard_content());
			board.setFreeboard_editdate(dateEditVo.regsiterdate());
			boardDao.updateBoard(board);
			return true;
		}
	}
}
