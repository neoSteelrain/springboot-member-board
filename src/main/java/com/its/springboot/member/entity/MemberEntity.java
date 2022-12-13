package com.its.springboot.member.entity;

import com.its.springboot.member.common.Builder;
import com.its.springboot.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="tbl_member")
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30 ,nullable = false)
    private String memberEmail;

    @Column(length = 20, nullable = false)
    private String memberPassword;

    @Column(length = 20, nullable = false)
    private String memberName;

    @Column(length = 20)
    private String memberMobile;

    @Column
    private int profileAttached;

    @Column
    private String originalProfileName;

    @Column
    private String storedProfileName;


    /*public MemberEntity(){

    }

    public MemberEntity(MemberEntityBuilder memberEntityBuilder){
        this.id = memberEntityBuilder.id;
        this.memberEmail = memberEntityBuilder.memberEmail;
        this.memberPassword = memberEntityBuilder.memberPassword;
        this.memberName = memberEntityBuilder.memberName;
        this.memberMobile = memberEntityBuilder.memberMobile;
        this.profileAttached = memberEntityBuilder.profileAttached;
        this.originalProfileName = memberEntityBuilder.originalProfileName;
        this.storedProfileName = memberEntityBuilder.storedProfileName;
    }

    public static class MemberEntityBuilder implements Builder<MemberEntity>{
        private final Long id;
        private final String memberEmail;
        private final String memberPassword;
        private final String memberName;
        private final String memberMobile;
        private final String originalProfileName;
        private final String storedProfileName;

        private final int profileAttached;
        //private MultipartFile memberProfile;

        private final LocalDateTime memberCreatedDate; // 가입일
        private final LocalDateTime memberUpdatedDate; // 회원정보 수정일

        public MemberEntityBuilder(MemberDTO memberDTO){
            this.id = memberDTO.getId();
            this.memberEmail = memberDTO.getMemberEmail();
            this.memberPassword = memberDTO.getMemberPassword();
            this.memberName = memberDTO.getMemberName();
            this.memberMobile = memberDTO.getMemberMobile();
            this.originalProfileName = memberDTO.getOriginalProfileName();
            this.storedProfileName = memberDTO.getStoredProfileName();
            this.profileAttached = memberDTO.getProfileAttached();
            this.memberCreatedDate = memberDTO.getMemberCreatedDate();
            this.memberUpdatedDate = memberDTO.getMemberUpdatedDate();
        }

        @Override
        public MemberEntity build() {
            return new MemberEntity(this);
        }
    }*/
}
