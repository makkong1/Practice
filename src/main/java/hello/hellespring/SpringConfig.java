package hello.hellespring;

import hello.hellespring.repository.MemberRepository;
import hello.hellespring.repository.MemoryMemberRepository;
import hello.hellespring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
