package com.its.springboot.member.service;

import com.its.springboot.member.dto.MemberDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;


    @Test
    @Transactional
    @Rollback
    @DisplayName("회원가입 테스트")
    public void memberRegTes(){
        MemberDTO dto = new MemberDTO();
        dto.setMemberEmail("test@test.com");
        dto.setMemberPassword("123456");
        dto.setMemberName("테스트이름1");
        dto.setMemberMobile("010-1111-2222");

        Long id = memberService.registerMember(dto);

        assertThat(id != null && id.longValue() > 0);
    }
}
