package com.its.springboot.member.dto;

import com.its.springboot.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class MemberDTO {

    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberMobile;
    private String originalProfileName;
    private String storedProfileName;

    private int profileAttached;
    private MultipartFile memberProfile;
    
    private LocalDateTime memberCreatedDate; // 가입일
    private LocalDateTime memberUpdatedDate; // 회원정보 수정일

    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity entity = new MemberEntity();
        entity.setId(memberDTO.getId());
        entity.setMemberEmail(memberDTO.getMemberEmail());
        entity.setMemberPassword(memberDTO.getMemberPassword());
        entity.setMemberName(memberDTO.getMemberName());
        entity.setMemberMobile(memberDTO.getMemberMobile());
        entity.setOriginalProfileName(memberDTO.getOriginalProfileName());
        entity.setStoredProfileName(memberDTO.getStoredProfileName());
        entity.setProfileAttached(memberDTO.getProfileAttached());
        return entity;
    }
}
