package com.example.jpaPractice003.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String title,content,writer;
    private LocalDateTime regDate,modDate;

    @Builder
    @QueryProjection
    public BoardDTO(Long id, String title, String content, String writer, LocalDateTime regDate, LocalDateTime modDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.modDate = modDate;
    }
}
