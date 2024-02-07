package example.exam.controller;

import example.exam.domains.Member;
import example.exam.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/join")
    public String joinForm() {
        return "member/joinForm";
    }

    @PostMapping("member/join")
    public String join(MemberVO memberVO) {
        Member member = new Member();
        member.setName(memberVO.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/member/list")
    public String memberList(Model model) {
        List<Member> memberList = memberService.findAllMember();

        model.addAttribute("members", memberList);

        return "member/list";
    }
}
