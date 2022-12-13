package com.its.springboot.member.dto;

import com.its.springboot.member.common.Builder;
import com.its.springboot.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
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

    /*public MemberDTO(){
    }

    public MemberDTO(MemberDTOBuilder memberDTOBuilder){
        this.id = memberDTOBuilder.id;
        this.memberEmail = memberDTOBuilder.memberEmail;
        this.memberPassword = memberDTOBuilder.memberPassword;
        this.memberName = memberDTOBuilder.memberEmail;
        this.memberMobile = memberDTOBuilder.memberEmail;
        this.originalProfileName = memberDTOBuilder.storedProfileName;
        this.storedProfileName = memberDTOBuilder.originalProfileName;
        this.profileAttached = memberDTOBuilder.profileAttached;

        this.memberCreatedDate = memberDTOBuilder.memberCreatedDate;
        this.memberUpdatedDate = memberDTOBuilder.memberUpdatedDate;
    }

    public static class MemberDTOBuilder implements Builder<MemberDTO>{

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

        public MemberDTOBuilder(MemberEntity entity){
            this.id = entity.getId();
            this.memberEmail = entity.getMemberEmail();
            this.memberPassword = entity.getMemberPassword();
            this.memberName = entity.getMemberName();
            this.memberMobile = entity.getMemberMobile();
            this.originalProfileName = entity.getOriginalProfileName();
            this.storedProfileName = entity.getStoredProfileName();
            this.profileAttached = entity.getProfileAttached();
            this.memberCreatedDate = entity.getCreatedDate();
            this.memberUpdatedDate = entity.getUpdatedDate();
        }

        @Override
        public MemberDTO build() {
            return new MemberDTO(this);
        }
    }*/
}
