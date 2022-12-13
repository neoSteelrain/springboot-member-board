package com.its.springboot.member.event;

import com.its.springboot.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberRegistrationEvent {
    private MemberDTO memberDTO;

    public MemberRegistrationEvent(MemberDTO memberDTO){
        this.memberDTO = memberDTO;
    }
}
