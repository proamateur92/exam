package example.exam.repository;

import example.exam.domains.Member;
import example.exam.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 모든 테스트 실행은 순서가 보장되지 않은 채 테스트가 진행된다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("test name");

        repository.save(member);

        // Optional은 get() 메서드로 꺼낸다.
        Member result = repository.findById(member.getId()).get();

        // 테스트 결과를 일일이 print를 찍을 수 없다.
        // System.out.println("result = " + (result == member));

        // jupiter
        // 비교대상, 기준
        // Assertions.assertEquals(result, member);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // Ctrl + Alt + v : 타입 변수명 자동 완성
        Member result1 = repository.findByName(member1.getName()).get();
        Member result2 = repository.findByName(member2.getName()).get();

        assertThat(member1).isEqualTo(result1);
        assertThat(member2).isEqualTo(result2);
        assertThat(member1).isNotEqualTo(result2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        // Shift + F6 변수명 일괄 변경
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> list = repository.findAll();

        assertThat(list.size()).isEqualTo(2);
    }


}
