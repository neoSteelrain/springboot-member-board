package com.its.springboot.member.entity;

import com.its.springboot.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    public static MemberDTO toMemberDTO(MemberEntity entity){
        MemberDTO dto = new MemberDTO();
        dto.setId(entity.getId());
        dto.setMemberEmail(entity.memberEmail);
        dto.setMemberPassword(entity.getMemberPassword());
        dto.setMemberName(entity.memberName);
        dto.setMemberMobile(entity.memberMobile);
        dto.setProfileAttached(entity.getProfileAttached());
        dto.setOriginalProfileName(entity.getOriginalProfileName());
        dto.setStoredProfileName(entity.getStoredProfileName());
        return dto;
    }
}
