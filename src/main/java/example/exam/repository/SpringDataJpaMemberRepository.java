package example.exam.repository;

import example.exam.domains.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // findByName 이외에 save(), findById() 등 공통 메서드를 제공한다.
    @Override
    Optional<Member> findByName(String name);
}
