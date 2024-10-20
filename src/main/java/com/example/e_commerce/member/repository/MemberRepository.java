package com.example.e_commerce.member.repository;

import com.example.e_commerce.member.domain.Member;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("SELECT m FROM Member WHERE m.uuid = :uuid")
    Optional<Member> findMemberByUuidWithLock(@Param("uuid") UUID uuid);
}
