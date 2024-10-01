package hello.hellespring.controller;

import hello.hellespring.MyComponent;
import hello.hellespring.domain.Member;
import hello.hellespring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    //private final MyComponent myComponent;

    @Autowired
    public MemberController(MemberService memberService, MyComponent myComponent) {
        this.memberService = memberService;
        //this.myComponent = myComponent;
    }

//    @GetMapping("/beans")
//    public String showBeans() {
//        myComponent.displayBeanNames();  // 여기서 메서드를 호출
//        return "빈 목록 출력 완료!";
//    }

    @GetMapping(value= "members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";

    }

    @GetMapping("members")
    public String list(Model model) {
        List<Member> list = memberService.findMembers();
        model.addAttribute("members", list);
        return "members/memberList";
    }
}
