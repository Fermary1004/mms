package kr.project.mms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.project.mms.service.MemberService;
import kr.project.mms.vo.MemberVo;

@Controller
public class MainController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet() {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(MemberVo loginInfo, Model model) {
		MemberVo user = memberService.signin(loginInfo);
		if (user == null) {
			return "redirect:/signup";
		} else {
			model.addAttribute("user", user);
			return "redirect:/bbs/list";
		}
	}
	
	@RequestMapping(value = "/signout")
	public String signout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet() {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(MemberVo joinInfo, Model model) {
		System.out.println(joinInfo.getInputbirth());
		boolean join = memberService.signup(joinInfo);
		if (join) {
			return "redirect:/";
		} else return "redirect:/signup";
	}
	
	@RequestMapping(value = "/signup/dup")
	@ResponseBody
	public Map<Object, Object> idcheck(@RequestBody String member_email){
		Map<Object, Object> map = new HashMap<Object, Object>();
		boolean dup = memberService.isDuplicated(member_email);
		map.put("dup", dup);
		return map;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profileGet() {
		return "profile";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String profilePost(MemberVo memberVo) {
		memberService.updateMember(memberVo);
		return "redirect:/bbs/list";
	}
}
