package example.service;

import example.domains.Member;
import example.repository.MemberRepository;
import example.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // Ctrl + Alt + M 메서드 추출
        // 중복 회원 이름 검증
        validateDuplicateMember(member);

        repository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findAllMember() {
        return repository.findAll();
    }

    /**
     * 단일회원 조회
     */
    public Optional<Member> findOne(Long memberId) {
        return repository.findById(memberId);
    }
}
