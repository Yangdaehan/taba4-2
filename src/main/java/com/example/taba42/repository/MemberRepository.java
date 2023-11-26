package com.example.taba42.repository;

import com.example.taba42.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMidAndPassword(String mid, String password);

    boolean existsByMid(String mid);
}
