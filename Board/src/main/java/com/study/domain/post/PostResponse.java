package com.study.domain.post;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostResponse {

    private Long id; //회원 아이디
    private String title; //게시판 제목
    private String content; //게시판 내용
    private String writer; //글쓴이
    private int viewCnt; //조회수
    private Boolean noticeYn; //공지사항으로 등록(체크)
    private Boolean deleteYn; //삭제 유무 0
    private LocalDate createdDate; //작성일
    private LocalDate modifiedDate; //수정일
}
