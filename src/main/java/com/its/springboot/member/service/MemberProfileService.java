package com.its.springboot.member.service;

import com.its.springboot.member.dto.MemberDTO;
import com.its.springboot.member.event.MemberRegistrationEvent;
import com.its.springboot.member.repository.IFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberProfileService {

    private final IFileRepository iFileRepository;

    @EventListener
    public void onMemberRegistrationEvent(MemberRegistrationEvent event){
        System.out.println("MemberProfileService.onMemberRegistrationEvent");
        System.out.println("event = " + event);

        MemberDTO dto = event.getMemberDTO();
    }

    private void saveProfile(){

    }
}
