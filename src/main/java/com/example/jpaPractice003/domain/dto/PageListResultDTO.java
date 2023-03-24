package com.example.jpaPractice003.domain.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class PageListResultDTO<DTO> {
    private int page;
    private int totalPage;
    private int size;
    private int start;
    private int end;
    private boolean prev,next;

    private List<DTO> dtoList;
    private List<Integer> pageList;

    public PageListResultDTO(Page<DTO> result) {
        this.dtoList = result.toList();
        this.totalPage = result.getTotalPages();
        makePageList(result.getPageable());
    }

    private void makePageList(Pageable pageable){
        this.page = pageable.getPageNumber()+1;
        this.size = pageable.getPageSize();
        int tempEnd = (int)(Math.ceil(page/10.0))*10;
        this.start = tempEnd-9;
        this.end = totalPage>tempEnd ? tempEnd : totalPage;
        this.prev = page>1;
        this.next = totalPage>tempEnd;
        this.pageList = IntStream.rangeClosed(start,end).boxed().collect(Collectors.toList());
    }
}
