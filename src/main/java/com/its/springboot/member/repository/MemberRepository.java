package com.its.springboot.member.repository;

import com.its.springboot.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity>  findByMemberEmail(String email);
}
