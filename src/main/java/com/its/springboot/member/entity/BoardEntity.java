package com.its.springboot.member.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tbl_board")
public class BoardEntity extends BaseEntity {

    /*
    게시글데이터: 글번호(id), 제목(boardTitle), 작성자(boardWriter), 내용
(boardContents), 조회수(boardHits), 작성일자(boardCreatedDate), 첨부파일여
부(fileAttached)
     */
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Long id;

    @Column
    private String boardTitle;

    @Column
    private String boarWriter;

    @Column
    private String boardContents;

    @Column
    private int boardHits;

    @Column
    private int fileAttached;
}
