package example.exam.service;

import example.exam.domains.Member;
import example.exam.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// 스프링 컨테이너와 함께 테스트한다.
@SpringBootTest
// 테스트 완료 후 항상 롤백한다.
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        Member member1 = new Member();
        member1.setName("spring1");
        Long memberId = memberService.join(member1);

        Member findMember = memberService.findOne(memberId).get();
        // Alt + Enter static import
        assertThat(member1.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 회원가입_중복체크() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("spring1");

        // Ctrl + Alt static import
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
            memberService.join(member2);
        });

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


    @Test
    void findOne() {
        Member member1 = new Member();
        member1.setName("spring1");
        memberService.join(member1);

        Member findMember1 = memberService.findOne(member1.getId()).get();
        Optional<Member> findMember2 = memberService.findOne(33L);

        assertThat(member1.getName()).isEqualTo(findMember1.getName());
        assertThat(findMember2).isEmpty();
    }
}