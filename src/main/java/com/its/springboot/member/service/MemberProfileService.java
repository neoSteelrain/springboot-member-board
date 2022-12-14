package com.its.springboot.member.service;

import com.its.springboot.member.dto.MemberDTO;
import com.its.springboot.member.event.MemberRegistrationEvent;
import com.its.springboot.member.repository.IFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class MemberProfileService {

    private final IFileRepository iFileRepository;

    @EventListener
    public void onMemberRegistrationEvent(MemberRegistrationEvent event){
        System.out.println("MemberProfileService.onMemberRegistrationEvent");
        System.out.println("event = " + event);

        MemberDTO dto = event.getMemberDTO();
        saveProfile(dto);
    }

    private void saveProfile(MemberDTO dto){
        MultipartFile profile = dto.getMemberProfile();

    }


    /*
    public Long save(BoardDTO boardDTO) throws IOException {
//        if (boardDTO.getBoardFile().isEmpty()) {
        if (boardDTO.getBoardFile().size() == 0) {
            System.out.println("파일없음");
            BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
            return boardRepository.save(boardEntity).getId();
        } else {
            System.out.println("파일있음");
            // 게시글 정보를 먼저 저장하고 해당 게시글의 entity를 가져옴
            BoardEntity boardEntity = BoardEntity.toSaveFileEntity(boardDTO);
            Long savedId = boardRepository.save(boardEntity).getId();
            BoardEntity entity = boardRepository.findById(savedId).get();
            // 파일이 담긴 list를 반복문으로 접근하여 하나씩 이름 가져오고, 저장용 이름 만들고
            // 로컬 경로에 저장하고 board_file_table에 저장
            for (MultipartFile boardFile: boardDTO.getBoardFile()) {
//                MultipartFile boardFile = boardDTO.getBoardFile();
                String originalFileName = boardFile.getOriginalFilename();
                String storedFileName = System.currentTimeMillis() + "_" + originalFileName;
                String savePath = "D:\\springboot_img\\" + storedFileName;
                boardFile.transferTo(new File(savePath));
                BoardFileEntity boardFileEntity =
                        BoardFileEntity.toSaveBoardFileEntity(entity, originalFileName, storedFileName);
                boardFileRepository.save(boardFileEntity);
            }
            return savedId;
        }
    }
     */
}
