package example.service;

import example.exam.domains.Member;
import example.exam.repository.MemoryMemberRepository;
import example.exam.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

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