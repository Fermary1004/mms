package kr.project.mms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.project.mms.service.BoardService;
import kr.project.mms.vo.MemberVo;
import kr.project.mms.vo.BoardVo;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/bbs/list")
	public String list(Model model) {
		List<BoardVo> list = boardService.getBoards();
		model.addAttribute("list", list);
		return "bbs/list";
	}
	
	@RequestMapping(value = "/bbs/search", method=RequestMethod.GET)
	public String searchPOST(String key, String word, Model model) {
		if(word.length() == 0) {
			return "redirect:list";
		}
		String fkey = null;
		if(key.equals("writer")) fkey = "member_nick";
		else fkey = "freeboard_" + key;
		List<BoardVo> list = boardService.searchBoards(fkey, word);
		model.addAttribute("list", list);
		return "bbs/list";
	}
	
	@RequestMapping(value = "/bbs/detail", method=RequestMethod.GET)
	public String detailGET(Integer freeboard_id, Model model) {
		BoardVo detail = boardService.getDetail(freeboard_id);
		if(detail == null) {
			return "bbs/list";
		} else {
			model.addAttribute("detail", detail);
			return "bbs/detail";
		}
	}	
	
	@RequestMapping(value = "/bbs/register", method=RequestMethod.GET)
	public String registerGET(BoardVo boardVo) {
		return "bbs/register";
	}	
	
	@RequestMapping(value = "/bbs/register", method=RequestMethod.POST)
	public String registerPOST(BoardVo boardVo) {
		boardService.registerBoard(boardVo);
		return "redirect:/bbs/list";
	}
	
	@RequestMapping(value = "/bbs/update", method=RequestMethod.GET)
	public String updateGET(Integer freeboard_id, Model model) {
		BoardVo detail = boardService.getDetail(freeboard_id);
		if(detail == null) {
			return "bbs/list";
		} else {
			model.addAttribute("detail", detail);
			return "bbs/update";
		}
	}
	
	@RequestMapping(value = "/bbs/update", method=RequestMethod.POST)
	public String updatePOST(BoardVo update, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		if (!boardService.updateBoard(update, user)) {
			return "redirect:/bbs/list";
		} else {
			model.addAttribute("freeboard_id", update.getFreeboard_id());
			return "redirect:/bbs/detail";
		}
	}
	
	@RequestMapping(value = "/bbs/delete")
	public String delete(Integer freeboard_id, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		if (!boardService.deleteBoard(freeboard_id, user)) {
			model.addAttribute("freeboard_id", freeboard_id);
			return "redirect:/bbs/detail";
		} else return "redirect:/bbs/list";
	}	
}
