package com.example.jpaPractice003.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class PageRequestDTO {
    private String type, keyword;
    private Integer page, size;
    private BoardSearchSort sort;

    public void setType(String type) {
        this.type = type;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setPage(Integer page) {
        if (page == null) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }

    public void setSize(Integer size) {
        if (size == null) {
            this.size = 15;
        } else {
            this.size = size;
        }
    }

    public void setSort(BoardSearchSort sort) {
        if(sort==null){
            this.sort= BoardSearchSort.CREATE_DATE_DESC;
        }else {
            this.sort = sort;
        }
    }
}
