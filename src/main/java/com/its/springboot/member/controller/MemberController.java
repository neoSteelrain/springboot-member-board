package com.its.springboot.member.controller;

import com.its.springboot.member.dto.MemberDTO;
import com.its.springboot.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;


    @GetMapping("/reg-member")
    public String registrationForm(){
        return "member/reg-member";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "member/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/board/";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session){
        System.out.println("memberDTO = " + memberDTO);
        MemberDTO dto = memberService.login(memberDTO);
        if(dto == null){
            return "redirect:/member/login";
        }
        session.setAttribute("member", dto);
        return "redirect:/board/";
    }


    @PostMapping("/reg-member")
    public String registerMember(@ModelAttribute MemberDTO memberDTO){
        Long id = memberService.registerMember(memberDTO);
        return "redirect:/member/login";
    }

    @GetMapping("/check-duplicatedemail/{email}")
    public ResponseEntity<String> checkDuplicatedEmail(@PathVariable("email") String email){
        return memberService.checkDuplicatedEmail(email) ?
                new ResponseEntity<>(HttpStatus.CONFLICT):
                new ResponseEntity<>(HttpStatus.OK) ;
    }
}
