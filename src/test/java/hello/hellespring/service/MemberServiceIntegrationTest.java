package hello.hellespring.service;

import hello.hellespring.domain.Member;
import hello.hellespring.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    //필드주입
    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository storage;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring3");

        //when
        Long memberId = memberService.join(member);

        //then
        Member findMember= memberService.findOne(memberId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    }

}