package com.its.springboot.member.service;

import com.its.springboot.member.dto.MemberDTO;
import com.its.springboot.member.entity.MemberEntity;
import com.its.springboot.member.event.MemberRegistrationEvent;
import com.its.springboot.member.repository.IFileRepository;
import com.its.springboot.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements ApplicationEventPublisherAware {

    private final MemberRepository memberRepository;
    private ApplicationEventPublisher applicationEventPublisher;

    /*public MemberService(MemberRepository memberRepository, IFileRepository iFileRepository){
        this.memberRepository = memberRepository;
        this.iFileRepository = iFileRepository;
    }*/
    /*
    회원가입
    로그인
    로그아웃
     */

    // 이메일, 비밀번호, 이름, 전화번호, 프로필사진
    public MemberDTO login(MemberDTO memberDTO){
        Optional<MemberEntity> entity = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if(entity.isPresent()){
            return MemberEntity.toMemberDTO(entity.get());
        }
        return null;
    }

    public Long registerMember(MemberDTO memberDTO){
        MemberEntity entity = memberRepository.save(MemberDTO.toMemberEntity(memberDTO));
        if(!memberDTO.getMemberProfile().isEmpty()){
            memberDTO.setId(entity.getId());
            memberDTO.setProfileAttached(1);
            applicationEventPublisher.publishEvent(new MemberRegistrationEvent(memberDTO));
        }

        return entity.getId();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public boolean checkDuplicatedEmail(String email) {
        Optional<MemberEntity> entity = memberRepository.findByMemberEmail(email);
        return entity.isPresent();
    }
}
