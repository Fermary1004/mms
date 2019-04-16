package kr.project.mms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.project.mms.service.RdboardService;
import kr.project.mms.vo.MemberVo;
import kr.project.mms.vo.RdboardVo;

@Controller
public class RdboardController {
	
	@Autowired
	RdboardService rdboardService;
	
	@RequestMapping(value = "/bbs/rdlist")
	public String rdlist(Model model) {
		List<RdboardVo> list = rdboardService.getBoards();
		model.addAttribute("list", list);
		return "bbs/rdlist";
	}
	
	@RequestMapping(value = "/bbs/rdsearch", method=RequestMethod.GET)
	public String rdsearch(String key, String word, Model model) {
		if(word.length() == 0) {
			return "redirect:rdlist";
		}
		String rkey = null;
		if(key.equals("writer")) rkey = "member_nick";
		else rkey = "recdboard_" + key;
		List<RdboardVo> list = rdboardService.searchBoards(rkey, word);
		model.addAttribute("list", list);
		return "bbs/rdlist";
	}
	
	@RequestMapping(value = "/bbs/rddetail", method=RequestMethod.GET)
	public String rddetailGET(Integer recdboard_id, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		Integer user_id = user.getMember_id();
		RdboardVo detail = rdboardService.getDetail(recdboard_id, user_id);
		if(detail == null) {
			return "bbs/rdlist";
		} else {
			model.addAttribute("detail", detail);
			return "bbs/rddetail";
		}
	}	
	
	@RequestMapping(value = "/bbs/rdregister", method=RequestMethod.GET)
	public String rdregisterGET(RdboardVo rdboardVo) {
		return "bbs/rdregister";
	}	
	
	@RequestMapping(value = "/bbs/rdregister", method=RequestMethod.POST)
	public String rdregisterPOST(RdboardVo rdboardVo) {
		rdboardService.registerBoard(rdboardVo);
		return "redirect:/bbs/rdlist";
	}
	
	@RequestMapping(value = "/bbs/rdupdate", method=RequestMethod.GET)
	public String rdupdateGET(Integer recdboard_id, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		Integer user_id = user.getMember_id();
		RdboardVo detail = rdboardService.getDetail(recdboard_id, user_id);
		if(detail == null) {
			return "bbs/rdlist";
		} else {
			model.addAttribute("detail", detail);
			return "bbs/rdupdate";
		}
	}
	
	@RequestMapping(value = "/bbs/rdupdate", method=RequestMethod.POST)
	public String rdupdatePOST(RdboardVo update, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		if (!rdboardService.updateBoard(update, user)) {
			return "redirect:/bbs/rdlist";
		} else {
			model.addAttribute("recdboard_id", update.getRecdboard_id());
			return "redirect:/bbs/rddetail";
		}
	}
	
	@RequestMapping(value = "/bbs/rddelete")
	public String rddelete(Integer recdboard_id, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		if (!rdboardService.deleteBoard(recdboard_id, user)) {
			model.addAttribute("recdboard_id", recdboard_id);
			return "redirect:/bbs/rddetail";
		} else return "redirect:/bbs/rdlist";
	}
	
	@RequestMapping(value = "/bbs/recomend")
	public String recomend(Integer recdboard_id, Integer recdboard_recd, HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVo user = (MemberVo)session.getAttribute("user");
		Integer user_id = user.getMember_id();
		rdboardService.recomendBoard(recdboard_id, recdboard_recd, user_id);
		model.addAttribute("recdboard_id", recdboard_id);
		return "redirect:/bbs/rddetail";
	}	
}
