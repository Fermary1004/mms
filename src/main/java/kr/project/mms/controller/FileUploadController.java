package kr.project.mms.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.project.mms.service.MemberService;
import kr.project.mms.vo.MemberVo;

@Controller
public class FileUploadController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="/profileimage", method=RequestMethod.GET)
	public String profileimageGET() {
		return "profileimage";
	}
	
	@RequestMapping(value="/profileimage", method=RequestMethod.POST)
	public String profileimagePOST(MultipartFile profileimage, HttpServletRequest request) throws Exception {
		
			HttpSession session = request.getSession();
			MemberVo memberVo = (MemberVo)session.getAttribute("user");
			Integer id = memberVo.getMember_id();
	
			String imageUploadPath = "C:\\spring\\workspace\\mms\\src\\main\\webapp\\resources\\images";
				// "C:\\spring\\sts-bundle\\pivotal-tc-server\\instances\\base-instance\\wtpwebapps\\mms\\resources\\images";
	
			String savedName = profileimage.getOriginalFilename();
			File target = new File(imageUploadPath, savedName);
			FileCopyUtils.copy(profileimage.getBytes(), target);
		
			memberService.updateMember(savedName, id);
			
			return "redirect:/bbs/list";
	}
}
