package com.study.VueApplication.Board.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 게시글 저장 요청 Dto
 */
@Getter
@NoArgsConstructor
public class BoardSaveRequestDto extends BaseTimeEntity {
    private String title;
    private String contents;
    private String reg_id;
    private String reg_dt;

    @Builder
    public BoardSaveRequestDto(String title, String contents, String reg_id){
        this.title = title;
        this.contents = contents;
        this.reg_id = reg_id;
        this.reg_dt = getCreatedDate().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .contents(contents)
                .reg_id(reg_id)
                .build();
    }
}
